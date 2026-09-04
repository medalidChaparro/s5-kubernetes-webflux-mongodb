package vallegrande.edu.pe.agroTecno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.agroTecno.model.Formula;
import vallegrande.edu.pe.agroTecno.repository.FormulaRepository;
import vallegrande.edu.pe.agroTecno.service.FormulaService;

import java.time.LocalDateTime;

@Service
public class FormulaServiceImpl implements FormulaService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FormulaServiceImpl.class);

    private final FormulaRepository formulaRepository;

    @Autowired
    public FormulaServiceImpl(FormulaRepository formulaRepository) {
        this.formulaRepository = formulaRepository;
    }

    @Override
    public Flux<Formula> findAll() {
        log.info("Listando todas las formulas");
        return formulaRepository.findAll();
    }

    @Override
    public Flux<Formula> findByEstado(String estado) {
        log.info("Listando formulas por estado: {}", estado);
        return formulaRepository.findByEstado(estado);
    }

    @Override
    public Mono<Formula> findById(String id) {
        log.info("Buscando formula por ID: {}", id);
        return formulaRepository.findById(id);
    }

    @Override
    public Mono<Formula> save(Formula formula) {
        log.info("Registrando formula: {}", formula);
        formula.setEstado("A");
        formula.setCreatedAt(LocalDateTime.now());
        return formulaRepository.save(formula);
    }

    @Override
    public Mono<Formula> update(String id, Formula formula) {
        log.info("Actualizando formula con ID: {}", id);
        return formulaRepository.findById(id)
                .flatMap(existing -> {
                    existing.setName(formula.getName());
                    existing.setDescription(formula.getDescription());
                    existing.setStandardBatch(formula.getStandardBatch());
                    existing.setUnit(formula.getUnit());
                    existing.setProductionTime(formula.getProductionTime());
                    existing.setPreparationCost(formula.getPreparationCost());
                    existing.setSuggestedPrice(formula.getSuggestedPrice());
                    // estado se preserva del registro existente (no se cambia con update)
                    existing.setUpdatedAt(LocalDateTime.now());
                    return formulaRepository.save(existing);
                });
    }

    @Override
    public Mono<Formula> delete(String id) {
        log.info("Eliminando (logico) formula con ID: {}", id);
        return formulaRepository.findById(id)
                .flatMap(existing -> {
                    existing.setEstado("I");
                    existing.setDeletedAt(LocalDateTime.now());
                    return formulaRepository.save(existing);
                });
    }

    @Override
    public Mono<Formula> restore(String id) {
        log.info("Restaurando formula con ID: {}", id);
        return formulaRepository.findById(id)
                .flatMap(existing -> {
                    existing.setEstado("A");
                    existing.setRestoredAt(LocalDateTime.now());
                    return formulaRepository.save(existing);
                });
    }

}