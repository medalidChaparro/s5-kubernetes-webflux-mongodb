package vallegrande.edu.pe.agroTecno.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.agroTecno.model.Insumo;

public interface InsumoService {

    // Listar todos - FLUX
    Flux<Insumo> findAll();

    // Listar por estado (A/I) - FLUX
    Flux<Insumo> findByEstado(String estado);

    // Listar por ID - MONO
    Mono<Insumo> findById(String id);

    // Crear - MONO
    Mono<Insumo> save(Insumo insumo);

    // Editar - MONO
    Mono<Insumo> update(String id, Insumo insumo);

    // Eliminar logico - MONO
    Mono<Insumo> delete(String id);

    // Restaurar logico - MONO
    Mono<Insumo> restore(String id);

}