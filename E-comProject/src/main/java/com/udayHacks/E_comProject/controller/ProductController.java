package com.udayHacks.E_comProject.controller;

import com.udayHacks.E_comProject.model.Products;
import com.udayHacks.E_comProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/greeting")
    public String greet() {
        return ("hello World ..1");
    }

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable BigInteger id) {
        Products products = productService.getProductById(id);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }

    @PostMapping(
            value = "/product",
            consumes = "multipart/form-data"
    )
    public ResponseEntity<?> addData(
            @RequestPart("product") Products product,
            @RequestPart("imageFile") MultipartFile imageFile
    ) {
        try {
            Products product1 = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable BigInteger id) {

        Products product = productService.getProductById(id);
        byte[] imageFile = product.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);

    }

    @PutMapping(
            value = "/products/{id}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<String> updateDat(@PathVariable BigInteger id,
                                            @RequestPart("products") Products products,
                                            @RequestPart("imageFile") MultipartFile imageFile
    ) throws IOException {
        try {
            Products Product = productService.updateProduct(id, products, imageFile);
            return new ResponseEntity<>("updated", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/products/id")
    public ResponseEntity<String> deleteProduct(@PathVariable BigInteger id){

        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted " ,HttpStatus.OK);
    }

}