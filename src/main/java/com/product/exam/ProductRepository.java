package com.product.exam;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findProductByElaboradoMano(String elaboradoMano );

}
