package com.Project.Product.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.Product.Entity.Product;
import com.Project.Product.Entity.User;
import com.Project.Product.Utility.ResponseStructure;
import com.Project.Product.dto.ProductRequestDTO;

public interface ProductService {

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product);

	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId);

	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId,Product updateProduct); 

	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId,Product deleteProduct );

	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts();

	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequestDTO productRequestDTO);




}
