package vallegrande.edu.pe.agroTecno.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import vallegrande.edu.pe.agroTecno.model.Client;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

    // Listar por estado (A = activo, I = inactivo)
    Flux<Client> findByEstado(String estado);

}
