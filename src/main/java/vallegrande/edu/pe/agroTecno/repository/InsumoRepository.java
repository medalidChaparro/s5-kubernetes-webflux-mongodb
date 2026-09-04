package vallegrande.edu.pe.agroTecno.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import vallegrande.edu.pe.agroTecno.model.Insumo;

public interface InsumoRepository extends ReactiveMongoRepository<Insumo, String> {

    // Listar por estado (A = activo, I = inactivo)
    Flux<Insumo> findByEstado(String estado);

}