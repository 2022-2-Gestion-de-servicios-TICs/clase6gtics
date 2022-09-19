package com.example.clase6gtics.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int id;

    @Column(nullable = false)
    @Size(max = 40, message = "El tamaño máximo es 40 caracteres")
    @NotBlank
    private String productname;

    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    private String quantityperunit;

    @Digits(integer = 10, fraction = 4)
    @Positive
    private BigDecimal unitprice;

    @Digits(integer = 10,fraction = 0)
    @Max(value = 32767)
    @Min(value = 0)
    private int unitsinstock;

    @Digits(integer = 10,fraction = 0)
    @Max(value = 32767)
    @Positive(message = "Tiene que ser mayor a 0")
    private int unitsonorder;

    private int reorderlevel;
    @Column(nullable = false)
    private boolean discontinued;

}
