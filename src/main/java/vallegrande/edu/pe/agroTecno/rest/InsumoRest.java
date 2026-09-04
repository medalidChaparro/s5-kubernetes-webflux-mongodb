package vallegrande.edu.pe.agroTecno.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.agroTecno.model.Insumo;
import vallegrande.edu.pe.agroTecno.service.InsumoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/insumo")
public class InsumoRest {

    private final InsumoService insumoService;

    @Autowired
    public InsumoRest(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    // GET - Listar todos los insumos (FLUX)
    @GetMapping
    public Flux<Insumo> findAll() {
        return insumoService.findAll();
    }

    // GET - Listar por estado: A (activo) o I (inactivo) (FLUX)
    @GetMapping("/estado/{estado}")
    public Flux<Insumo> findByEstado(@PathVariable String estado) {
        return insumoService.findByEstado(estado);
    }

    // GET - Listar por ID (MONO)
    @GetMapping("/{id}")
    public Mono<Insumo> findById(@PathVariable String id) {
        return insumoService.findById(id);
    }

    // POST - Crear insumo (MONO)
    @PostMapping
    public Mono<Insumo> save(@RequestBody Insumo insumo) {
        return insumoService.save(insumo);
    }

    // PUT - Editar insumo (MONO)
    @PutMapping("/{id}")
    public Mono<Insumo> update(@PathVariable String id, @RequestBody Insumo insumo) {
        return insumoService.update(id, insumo);
    }

    // PATCH - Eliminar logico (MONO)
    @PatchMapping("/delete/{id}")
    public Mono<Insumo> delete(@PathVariable String id) {
        return insumoService.delete(id);
    }

    // PATCH - Restaurar logico (MONO)
    @PatchMapping("/restore/{id}")
    public Mono<Insumo> restore(@PathVariable String id) {
        return insumoService.restore(id);
    }

}