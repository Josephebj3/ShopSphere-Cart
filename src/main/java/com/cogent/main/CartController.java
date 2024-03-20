package com.cogent.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



@RestController
@RequestMapping("/cart")
public class CartController 
{
	@Autowired
	private CartService cartService;
	
	
	@GetMapping("/{userId}")
	public List<CartProductEntity> getCartProducts(@PathVariable int userId, @RequestHeader("Authorization") String token) 
	{
		return cartService.getCartProducts(userId, token);
	}
	
	@PostMapping("/{userId}/add")
	public List<CartProductEntity> addProductToCart(@PathVariable int userId, @RequestParam int productId, @RequestParam int quantity, @RequestHeader("Authorization") String token) 
	{
		return cartService.addProductToCart(userId, productId, quantity, token);
	}
	
	@DeleteMapping("/{userId}/remove/{productId}")
	public List<CartProductEntity> deleteProductFromCart(@PathVariable int userId, @PathVariable int productId, @RequestParam int quantity, @RequestHeader("Authorization") String token)
	{
		return cartService.deleteProductFromCart(userId, productId, quantity, token);
	}
	
	@DeleteMapping("/{userId}/remove")
	public boolean deleteCartByUserId(@PathVariable int userId, @RequestHeader("Authorization") String token)
	{
		return cartService.deleteCartByUserId(userId, token);
	}
	
	@PutMapping("/{userId}/update")
	public List<CartProductEntity> updateCart(@PathVariable int userId, @RequestBody int[][] productsAndQuantities, @RequestHeader("Authorization") String token) 
	{
		return cartService.updateCart(userId, productsAndQuantities, token);
	}
	
	
	
}
