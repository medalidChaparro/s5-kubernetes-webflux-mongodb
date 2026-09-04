package vallegrande.edu.pe.agroTecno.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "supply")
public class Insumo {

    @Id
    private String id;

    @Field("name")
    private String nombre;

    @Field("description")
    private String descripcion;

    @Field("current_stock")
    private BigDecimal stockActual;

    @Field("minimum_stock")
    private BigDecimal stockMinimo;

    @Field("unit")
    private String medida;

    @Field("expiration_date")
    private LocalDate fechaCaducidad;

    @Field("location")
    private String ubicacion;

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
    public Insumo() {}

    public Insumo(String id, String nombre, String descripcion, BigDecimal stockActual, BigDecimal stockMinimo, String medida, LocalDate fechaCaducidad, String ubicacion, String estado, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, LocalDateTime restoredAt) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.medida = medida;
        this.fechaCaducidad = fechaCaducidad;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.restoredAt = restoredAt;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getStockActual() { return stockActual; }
    public void setStockActual(BigDecimal stockActual) { this.stockActual = stockActual; }

    public BigDecimal getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(BigDecimal stockMinimo) { this.stockMinimo = stockMinimo; }

    public String getMedida() { return medida; }
    public void setMedida(String medida) { this.medida = medida; }

    public LocalDate getFechaCaducidad() { return fechaCaducidad; }
    public void setFechaCaducidad(LocalDate fechaCaducidad) { this.fechaCaducidad = fechaCaducidad; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

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