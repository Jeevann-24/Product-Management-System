package com.Project.Product.ServiceIMPL;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.Product.Entity.Product;
import com.Project.Product.Entity.User;
import com.Project.Product.Exception.ProductNotFoundById;
import com.Project.Product.Repository.ProductRepository;
import com.Project.Product.Service.ProductService;
import com.Project.Product.Utility.ResponseStructure;
import com.Project.Product.dto.ProductRequestDTO;

@Service
public  class ServiceImplimentation implements ProductService {

	//	CONSTRUCTOR INJECTION INSTAED OF @Autowire
	private ProductRepository productRepository;
	private ResponseStructure<Product> structure;
	private ResponseStructure<List<Product>> structureList;


	public ServiceImplimentation(ProductRepository productRepository, ResponseStructure<Product> structure,
			ResponseStructure<List<Product>> structureList) {
		super();
		this.productRepository = productRepository;
		this.structure = structure;
		this.structureList = structureList;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		Product product2=productRepository.save(product);

		ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Product Object Created Successfully !!");
		responseStructure.setData(product2);

		return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);
	}
	 
	
	

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	//FIND BY ID  // Here i will directly return instead of creating ResponseStructure Object --> Using Optional map
	@Override
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId) {

		return productRepository.findById(productId).map(p->{ResponseStructure<Product> rs=new ResponseStructure<Product>();
		return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value())
				.setMessage("Product found!!!! ")
				.setData(p));})
				.orElseThrow(()->new ProductNotFoundById("Product Not Available"));


		//		Optional<Product> optional = productRepository.findById(productId);
		//		if (optional.isPresent()) {
		//			Product product=optional.get();
		//			ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		//			responseStructure.setStatuscode(HttpStatus.FOUND.value());
		//			responseStructure.setMessage("Product Object Found Successfully !!");
		//			responseStructure.setData(product);
		//
		//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);
		//		}else {
		////               throw new ProductNotFoundById("Product Not Found Try Again Later");
		//			return null;
		//		}
	}

	//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	//	UPDATE BY ID
	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId,Product updateProduct) {

		return productRepository.findById(productId).map(exProduct -> {
			updateProduct.setProductId(exProduct.getProductId());
			exProduct=productRepository.save(updateProduct);
			return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value())
		   .setMessage("Product Updated")
		   .setData(exProduct));})
		   .orElseThrow(()->new ProductNotFoundById("PRODUCT NOT FOUND "));



		//		Optional<Product> optional = productRepository.findById(productId);
		//		ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		//		responseStructure.setStatuscode(HttpStatus.OK.value());
		//		responseStructure.setMessage("Product Object Updated Successfully !!");
		//		responseStructure.setData(updateProduct);
		//
		//
		//		if (optional.isPresent()) {
		//			Product existingProduct=optional.get();
		//			updateProduct.setProductId(existingProduct.getProductId());
		//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		//		}
		//		else{
		//			return null;
		//		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	//	DELETE BY ID
	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId, Product deleteProduct ) {


//		DO MAP METHOD FOR DELETE 
		
		
				Optional<Product> optional = productRepository.findById(productId);
		
				ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
				responseStructure.setStatuscode(HttpStatus.OK.value());
				responseStructure.setMessage("Product Object Deleted Successfully !!");
				responseStructure.setData(deleteProduct);

		if(optional.isPresent()) {
			deleteProduct=optional.get();
			productRepository.delete(deleteProduct);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		}else {
			return null;
		}
	}

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		List<Product> products = productRepository.findAll();

		if(!products.isEmpty()) {

			return ResponseEntity.ok(structureList.setStatuscode(HttpStatus.OK.value())
					.setMessage("Found")
					.setData(products));	
		}
		else throw new ProductNotFoundById("Product Not Available ");

	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequestDTO productRequestDTO) {
//		MAPPING TO DTO OBJECT
		Product product =productRepository.save(mapToPrduct(productRequestDTO, new Product()));
		return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Product Saved")
				.setData(product));
		        
	}

	private Product mapToPrduct(ProductRequestDTO productRequestDTO, Product product) {
		product.setProductName(productRequestDTO.getProductName());
		return product;
	}

	

	
}




