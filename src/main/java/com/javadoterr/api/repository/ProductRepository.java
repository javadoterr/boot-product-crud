package com.javadoterr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javadoterr.api.enitity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
