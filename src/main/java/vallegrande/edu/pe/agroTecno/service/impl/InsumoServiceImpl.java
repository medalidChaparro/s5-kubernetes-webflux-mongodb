package vallegrande.edu.pe.agroTecno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.agroTecno.model.Insumo;
import vallegrande.edu.pe.agroTecno.repository.InsumoRepository;
import vallegrande.edu.pe.agroTecno.service.InsumoService;

import java.time.LocalDateTime;

@Service
public class InsumoServiceImpl implements InsumoService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(InsumoServiceImpl.class);

    private final InsumoRepository insumoRepository;

    @Autowired
    public InsumoServiceImpl(InsumoRepository insumoRepository) {
        this.insumoRepository = insumoRepository;
    }

    @Override
    public Flux<Insumo> findAll() {
        log.info("Listando todos los insumos");
        return insumoRepository.findAll();
    }

    @Override
    public Flux<Insumo> findByEstado(String estado) {
        log.info("Listando insumos por estado: {}", estado);
        return insumoRepository.findByEstado(estado);
    }

    @Override
    public Mono<Insumo> findById(String id) {
        log.info("Buscando insumo por ID: {}", id);
        return insumoRepository.findById(id);
    }

    @Override
    public Mono<Insumo> save(Insumo insumo) {
        log.info("Registrando insumo: {}", insumo);
        insumo.setEstado("A");
        insumo.setCreatedAt(LocalDateTime.now());
        return insumoRepository.save(insumo);
    }

    @Override
    public Mono<Insumo> update(String id, Insumo insumo) {
        log.info("Actualizando insumo con ID: {}", id);
        return insumoRepository.findById(id)
                .flatMap(existing -> {
                    existing.setNombre(insumo.getNombre());
                    existing.setDescripcion(insumo.getDescripcion());
                    existing.setStockActual(insumo.getStockActual());
                    existing.setStockMinimo(insumo.getStockMinimo());
                    existing.setMedida(insumo.getMedida());
                    existing.setFechaCaducidad(insumo.getFechaCaducidad());
                    existing.setUbicacion(insumo.getUbicacion());
                    // estado se preserva del registro existente (no se cambia con update)
                    existing.setUpdatedAt(LocalDateTime.now());
                    return insumoRepository.save(existing);
                });
    }

    @Override
    public Mono<Insumo> delete(String id) {
        log.info("Eliminando (logico) insumo con ID: {}", id);
        return insumoRepository.findById(id)
                .flatMap(existing -> {
                    existing.setEstado("I");
                    existing.setDeletedAt(LocalDateTime.now());
                    return insumoRepository.save(existing);
                });
    }

    @Override
    public Mono<Insumo> restore(String id) {
        log.info("Restaurando insumo con ID: {}", id);
        return insumoRepository.findById(id)
                .flatMap(existing -> {
                    existing.setEstado("A");
                    existing.setRestoredAt(LocalDateTime.now());
                    return insumoRepository.save(existing);
                });
    }

}