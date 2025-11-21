package com.udayHacks.E_comProject.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udayHacks.E_comProject.model.Products;
import com.udayHacks.E_comProject.repo.ProductRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final ProductRepo productRepo;
    private final ObjectMapper objectMapper;

    @PostConstruct
    public void loadData() {
        try {
            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream("products_1000.json");

            if (inputStream == null) {
                System.out.println("File not found!");
                return;
            }

            List<Products> productsList =
                    objectMapper.readValue(inputStream, new TypeReference<>() {});

            productRepo.saveAll(productsList);
            System.out.println("Successfully Added Records ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
