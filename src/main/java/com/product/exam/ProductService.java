package com.product.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	private  final ProductRepository productRepository;  // inyeccion de dependencia 
	HashMap<String, Object> datos ;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
		
	}
	public List<Product> getProduct() {
		   
		   return this.productRepository.findAll();
		   
	   }
	public ResponseEntity<Object> saveProduct(Product product) {
		datos = new HashMap<>();
		// TODO Auto-generated method stub
	 Optional<Product> res = productRepository.findProductByElaboradoMano(product.getElaboradoMano());
	 if(res.isPresent() && product.getId() ==null) {
		 datos.put("Error", true);
		 datos.put("Message", "Ya Existe el producto con esa Elaboracion");
		 return new ResponseEntity<>(
				 datos,HttpStatus.CONFLICT
				 );
	 }
	 
	 datos.put("message", "Se GUardo con Exito el producto ");
	 if(product.getId()!=null) {
		 datos.put("message", "Se Actualizo con Exito el producto");
	 }
	 productRepository.save(product);
	 datos.put("data", product);
	 
	 return new ResponseEntity<>(
			datos, HttpStatus.CREATED
			 );
		
	}
	
	public ResponseEntity<Object> deleteProduct(Long id) {
		datos = new HashMap<>();
		
	boolean  existe =this.productRepository.existsById(id);
    	if(!existe) {
    		 datos.put("Error", true);
    		 datos.put("Message", "No Existe el Producto a Eliminar");
    		 return new ResponseEntity<>(
    				 datos,HttpStatus.CONFLICT
    				 );
    		
    	}
		
    	 datos.put("date", id);
    	 this.productRepository.deleteById(id);
		 datos.put("Message", " El producto fue  Eliminado");
		 return new ResponseEntity<>(
				 datos,HttpStatus.ACCEPTED
				 );
		
	}

}
