package com.udayHacks.E_comProject.service;

import com.udayHacks.E_comProject.model.Products;
import com.udayHacks.E_comProject.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo ;

    public Products addProduct  (Products product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);


    }


    public List<Products> getProducts(){
        return productRepo.findAll();
    }

    public Products getProductById(BigInteger id) {
        return productRepo.findById(BigInteger.valueOf(id.longValue())).orElse(null);
    }
}
