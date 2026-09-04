package vallegrande.edu.pe.agroTecno.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "formula")
public class Formula {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("description")
    private String description;

    @Field("standardBatch")
    private BigDecimal standardBatch;

    @Field("unit")
    private String unit;

    @Field("productionTime")
    private Integer productionTime;

    @Field("preparationCost")
    private BigDecimal preparationCost;

    @Field("suggestedPrice")
    private BigDecimal suggestedPrice;

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
    public Formula() {}

    public Formula(String id, String name, String description, BigDecimal standardBatch, BigDecimal preparationCost, String unit, Integer productionTime, BigDecimal suggestedPrice, String estado, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, LocalDateTime restoredAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.standardBatch = standardBatch;
        this.preparationCost = preparationCost;
        this.unit = unit;
        this.productionTime = productionTime;
        this.suggestedPrice = suggestedPrice;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.restoredAt = restoredAt;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getStandardBatch() { return standardBatch; }
    public void setStandardBatch(BigDecimal standardBatch) { this.standardBatch = standardBatch; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    
    public Integer getProductionTime() { return productionTime; }
    public void setProductionTime(Integer productionTime) { this.productionTime = productionTime; }

    public BigDecimal getPreparationCost() { return preparationCost; }
    public void setPreparationCost(BigDecimal preparationCost) { this.preparationCost = preparationCost; }

    public BigDecimal getSuggestedPrice() { return suggestedPrice; }
    public void setSuggestedPrice(BigDecimal suggestedPrice) { this.suggestedPrice = suggestedPrice; }

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