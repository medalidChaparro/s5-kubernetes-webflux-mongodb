package vallegrande.edu.pe.agroTecno.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.agroTecno.model.Client;
import vallegrande.edu.pe.agroTecno.service.ClientService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/client")
public class ClientRest {

    private final ClientService clientService;

    @Autowired
    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    // GET - Listar todos los clientes (FLUX)
    @GetMapping
    public Flux<Client> findAll() {
        return clientService.findAll();
    }

    // GET - Listar por estado: A (activo) o I (inactivo) (FLUX)
    @GetMapping("/estado/{estado}")
    public Flux<Client> findByEstado(@PathVariable String estado) {
        return clientService.findByEstado(estado);
    }

    // GET - Listar por ID (MONO)
    @GetMapping("/{id}")
    public Mono<Client> findById(@PathVariable String id) {
        return clientService.findById(id);
    }

    // POST - Crear cliente (MONO)
    @PostMapping
    public Mono<Client> save(@RequestBody Client client) {
        return clientService.save(client);
    }

    // PUT - Editar cliente (MONO)
    @PutMapping("/{id}")
    public Mono<Client> update(@PathVariable String id, @RequestBody Client client) {
        return clientService.update(id, client);
    }

    // PATCH - Eliminar logico (MONO)
    @PatchMapping("/delete/{id}")
    public Mono<Client> delete(@PathVariable String id) {
        return clientService.delete(id);
    }

    // PATCH - Restaurar logico (MONO)
    @PatchMapping("/restore/{id}")
    public Mono<Client> restore(@PathVariable String id) {
        return clientService.restore(id);
    }

}
