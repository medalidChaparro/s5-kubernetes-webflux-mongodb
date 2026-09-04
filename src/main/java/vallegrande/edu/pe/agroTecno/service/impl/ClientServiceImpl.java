package vallegrande.edu.pe.agroTecno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.agroTecno.model.Client;
import vallegrande.edu.pe.agroTecno.repository.ClientRepository;
import vallegrande.edu.pe.agroTecno.service.ClientService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ClientServiceImpl implements ClientService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Flux<Client> findAll() {
        log.info("Listando todos los clientes");
        return clientRepository.findAll();
    }

    @Override
    public Flux<Client> findByEstado(String estado) {
        log.info("Listando clientes por estado: {}", estado);
        return clientRepository.findByEstado(estado);
    }

    @Override
    public Mono<Client> findById(String id) {
        log.info("Buscando cliente por ID: {}", id);
        return clientRepository.findById(id);
    }

    @Override
    public Mono<Client> save(Client client) {
        log.info("Registrando cliente: {}", client);
        client.setEstado("A");
        client.setCreatedAt(LocalDateTime.now());
        if (client.getRegistrationDate() == null) {
            client.setRegistrationDate(LocalDate.now());
        }
        return clientRepository.save(client);
    }

    @Override
    public Mono<Client> update(String id, Client client) {
        log.info("Actualizando cliente con ID: {}", id);
        return clientRepository.findById(id)
                .flatMap(existing -> {
                    existing.setFirstName(client.getFirstName());
                    existing.setLastName(client.getLastName());
                    existing.setDocumentType(client.getDocumentType());
                    existing.setDocumentNumber(client.getDocumentNumber());
                    existing.setPhone(client.getPhone());
                    existing.setEmail(client.getEmail());
                    if (client.getRegistrationDate() != null) {
                        existing.setRegistrationDate(client.getRegistrationDate());
                    }
                    // estado se preserva del registro existente (no se cambia con update)
                    existing.setUpdatedAt(LocalDateTime.now());
                    return clientRepository.save(existing);
                });
    }

    @Override
    public Mono<Client> delete(String id) {
        log.info("Eliminando (logico) cliente con ID: {}", id);
        return clientRepository.findById(id)
                .flatMap(existing -> {
                    existing.setEstado("I");
                    existing.setDeletedAt(LocalDateTime.now());
                    return clientRepository.save(existing);
                });
    }

    @Override
    public Mono<Client> restore(String id) {
        log.info("Restaurando cliente con ID: {}", id);
        return clientRepository.findById(id)
                .flatMap(existing -> {
                    existing.setEstado("A");
                    existing.setRestoredAt(LocalDateTime.now());
                    return clientRepository.save(existing);
                });
    }

}
