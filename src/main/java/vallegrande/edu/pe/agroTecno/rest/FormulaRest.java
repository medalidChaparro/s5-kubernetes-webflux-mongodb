package vallegrande.edu.pe.agroTecno.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.agroTecno.model.Formula;
import vallegrande.edu.pe.agroTecno.service.FormulaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/formula")
public class FormulaRest {

    private final FormulaService formulaService;

    @Autowired
    public FormulaRest(FormulaService formulaService) {
        this.formulaService = formulaService;
    }

    // GET - Listar todos los formulas (FLUX)
    @GetMapping
    public Flux<Formula> findAll() {
        return formulaService.findAll();
    }

    // GET - Listar por estado: A (activo) o I (inactivo) (FLUX)
    @GetMapping("/estado/{estado}")
    public Flux<Formula> findByEstado(@PathVariable String estado) {
        return formulaService.findByEstado(estado);
    }

    // GET - Listar por ID (MONO)
    @GetMapping("/{id}")
    public Mono<Formula> findById(@PathVariable String id) {
        return formulaService.findById(id);
    }

    // POST - Crear formula (MONO)
    @PostMapping
    public Mono<Formula> save(@RequestBody Formula formula) {
        return formulaService.save(formula);
    }

    // PUT - Editar formula (MONO)
    @PutMapping("/{id}")
    public Mono<Formula> update(@PathVariable String id, @RequestBody Formula formula) {
        return formulaService.update(id, formula);
    }

    // PATCH - Eliminar logico (MONO)
    @PatchMapping("/delete/{id}")
    public Mono<Formula> delete(@PathVariable String id) {
        return formulaService.delete(id);
    }

    // PATCH - Restaurar logico (MONO)
    @PatchMapping("/restore/{id}")
    public Mono<Formula> restore(@PathVariable String id) {
        return formulaService.restore(id);
    }

}