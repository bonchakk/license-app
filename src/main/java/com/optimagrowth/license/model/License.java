package com.optimagrowth.license.model;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@Table(name="license")
public class License extends RepresentationModel<License> {

    @Id
    @Column(name="license_id", nullable=false)
    private String licenseId;
    
    @NotBlank
    private String description;

    @NotBlank
    @Column(name="organization_id", nullable=false)
    private String organizationId;

    @NotBlank
    @Column(name="product_name", nullable=false)
    private String productName;

    @NotBlank
    @Column(name="license_type", nullable=false)
    private String licenseType;

    private String comment;

    public License withComment(String comment) {
        this.setComment(comment);
        return this;
    }
}
