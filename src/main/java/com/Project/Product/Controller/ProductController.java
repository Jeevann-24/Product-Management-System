package com.Project.Product.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Product.Entity.Product;
import com.Project.Product.Service.ProductService;
import com.Project.Product.Utility.ErrorStructure;
import com.Project.Product.Utility.ResponseStructure;
import com.Project.Product.dto.ProductRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class ProductController {
	

	private ProductService productservice;
	
	public ProductController(ProductService productservice) {
		super();
		this.productservice = productservice;
	}

//	@RequestMapping(value = "/products/saveProduct",method = RequestMethod.POST)
//  ResponseEntity<ResponseStructure<Product>> save(@RequestBody Product product) {
//		return productservice.saveProduct(product);
//	}
	
	@Operation(description = "Please provide folllowing product details you want to add" ,responses = {
	@ApiResponse(responseCode = "200",description = "Product Saved Succesfully") ,
	@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")}) //To add extra description  
	@PostMapping("/products")
  public ResponseEntity<ResponseStructure<Product>> save(@RequestBody ProductRequestDTO productRequestDTO ) {
//		SAVING DTO OBJECT
		return productservice.saveProduct(productRequestDTO);
	}
	
	@Operation(description = "The Endpoint ID is used to find ID" ,responses = {
			@ApiResponse(responseCode = "200",description = "Product Found Succesfully"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", 
			content = {@Content(schema = @Schema(implementation = ErrorStructure.class))})})  //To add extra description  
	@GetMapping("/products/{productId}")
  public ResponseEntity<ResponseStructure<Product>> findProductById(@PathVariable int productId) {
		return productservice.findProductById(productId);
}
	@Operation(description = "The Endpoint ID is used to Update ID" ,responses = {
			@ApiResponse(responseCode = "200",description = "Product Updated Succesfully") ,
			@ApiResponse(responseCode = "501", description = "NOT IMPLEMENTED")})
	@PutMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@PathVariable int productId,@RequestBody Product product) {
		return productservice.updateByProductId(productId, product);
	}
	@Operation(description = "The Endpoint ID is used to find ID" ,responses = {
			@ApiResponse(responseCode = "200",description = "Product Deleted Succesfully") ,
			@ApiResponse(responseCode = "503", description = "SERVICE UNAVAILABLE")})
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable int productId,@RequestBody Product product) {
		return productservice.deleteByProductId(productId, product);
	}
	@Operation(description = "The Endpoint ID is used to find ID" ,responses = {
			@ApiResponse(responseCode = "200",description = "All Product Found Succesfully") ,
			@ApiResponse(responseCode = "504", description = "GATEWAY TIMEOUT")})
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts(){
		return productservice.findAllProducts();
		
	}


}
