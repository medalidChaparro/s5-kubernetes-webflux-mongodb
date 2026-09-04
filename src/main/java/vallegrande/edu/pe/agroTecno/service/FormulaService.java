package vallegrande.edu.pe.agroTecno.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.agroTecno.model.Formula;

public interface FormulaService {

    // Listar todos - FLUX
    Flux<Formula> findAll();

    // Listar por estado (A/I) - FLUX
    Flux<Formula> findByEstado(String estado);

    // Listar por ID - MONO
    Mono<Formula> findById(String id);

    // Crear - MONO
    Mono<Formula> save(Formula formula);

    // Editar - MONO
    Mono<Formula> update(String id, Formula formula);

    // Eliminar logico - MONO
    Mono<Formula> delete(String id);

    // Restaurar logico - MONO
    Mono<Formula> restore(String id);

}