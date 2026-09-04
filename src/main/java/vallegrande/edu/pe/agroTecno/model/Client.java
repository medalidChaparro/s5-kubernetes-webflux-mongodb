package vallegrande.edu.pe.agroTecno.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "client")
public class Client {

    @Id
    private String id;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("document_type")
    private String documentType;

    @Field("document_number")
    private String documentNumber;

    @Field("phone")
    private String phone;

    @Field("email")
    private String email;

    @Field("registration_date")
    private LocalDate registrationDate;

    @Field("status")
    private String estado;

    // Auditoria
    @Field("created_at")
    private LocalDateTime createdAt;

    @Field("updated_at")
    private LocalDateTime updatedAt;

    @Field("deleted_at")
    private LocalDateTime deletedAt;

    @Field("restored_at")
    private LocalDateTime restoredAt;

    // Constructors
    public Client() {}

    public Client(String id, String firstName, String lastName, String documentType, String documentNumber, String phone, String email, LocalDate registrationDate, String estado, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, LocalDateTime restoredAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.phone = phone;
        this.email = email;
        this.registrationDate = registrationDate;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.restoredAt = restoredAt;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getClientId() { return id; }
    public void setClientId(String clientId) { this.id = clientId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public LocalDateTime getDeletedAt() { return deletedAt; }
    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }

    public LocalDateTime getRestoredAt() { return restoredAt; }
    public void setRestoredAt(LocalDateTime restoredAt) { this.restoredAt = restoredAt; }
}
