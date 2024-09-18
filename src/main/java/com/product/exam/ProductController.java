package com.product.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping (path = "api/v1/product")
public class ProductController {
	
	private final ProductService productService; // inyeccion de dependencia 
	 
	 @Autowired
	 public ProductController(ProductService productService) {
		 this.productService = productService;
		 
	 }
	 @GetMapping
	 public List<Product> getClients(){
		 return this.productService.getProduct();
	 }
	 
	 @PostMapping
	 
	  public ResponseEntity<Object> saveClient(@RequestBody Product product) {
		 
		return  this.productService.saveProduct(product);
		 
	 }
	 
	 @PutMapping
	 
	 public ResponseEntity<Object> updateClient(@RequestBody Product product) {
		 
		return  this.productService.saveProduct(product);
		 
	}
	 
	 @DeleteMapping(path = "{productId}")
	 
	 public ResponseEntity<Object> deleteProduct(@PathVariable ("productId")Long id ) {
		 
		return  this.productService.deleteProduct(id);
		 
	}

}
