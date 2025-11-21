package com.udayHacks.E_comProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    private BigInteger id;
    private String productName ;
    private String description;
    private String brand;
    private String category ;
    private BigDecimal price;
    private Date releaseDate;
    private boolean available;
    private long quantity ;
    private  String ImageName;
    private String ImageType;
    @Lob
    private  byte[] ImageData;



}
