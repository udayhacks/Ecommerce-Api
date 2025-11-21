package com.udayHacks.E_comProject.repo;

import com.udayHacks.E_comProject.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProductRepo extends JpaRepository<Products, BigInteger> {
}
