package vallegrande.edu.pe.agroTecno.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.agroTecno.model.Client;

public interface ClientService {

    // Listar todos - FLUX
    Flux<Client> findAll();

    // Listar por estado (A/I) - FLUX
    Flux<Client> findByEstado(String estado);

    // Listar por ID - MONO
    Mono<Client> findById(String id);

    // Crear - MONO
    Mono<Client> save(Client client);

    // Editar - MONO
    Mono<Client> update(String id, Client client);

    // Eliminar logico - MONO
    Mono<Client> delete(String id);

    // Restaurar logico - MONO
    Mono<Client> restore(String id);

}
