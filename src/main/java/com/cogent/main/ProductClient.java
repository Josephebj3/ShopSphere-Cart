package com.cogent.main;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Product", url = "localhost:8082/products")
public interface ProductClient 
{
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable int productId);
}
