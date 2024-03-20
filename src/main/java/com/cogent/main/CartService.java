package com.cogent.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CartService 
{
	@Autowired
	private CartProductEntityRepository cartProductEntityRepository;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private ProductClient productClient;

	public List<CartProductEntity> getCartProducts(int userId, String token)
	{
		if(!userClient.validUserToken(userId, token)) return null;
		return cartProductEntityRepository.findByUserId(userId);
	}

	public List<CartProductEntity> addProductToCart(int userId, int productId, int quantity, String token)
	{
		if(!userClient.validUserToken(userId, token)) return null;
		Product p = productClient.getProduct(productId);
		CartProductEntity cpe = CartProductEntity.builder()
			.userId(userId)
			.productId(productId)
			.name(p.getName())
			.description(p.getDescription())
			.price(p.getPrice())
			.category(p.getCategory())
			.quantity(quantity)
			.image(p.getImage())
			.build();
		if(cartProductEntityRepository.findByUserIdAndProductId(userId, productId).isPresent())
		{
			CartProductEntity cartProductEntity = cartProductEntityRepository.findByUserIdAndProductId(userId, productId).get();
			cartProductEntity.setQuantity(cartProductEntity.getQuantity()+cpe.getQuantity());
			cartProductEntityRepository.save(cartProductEntity);
		}
		else
		{
			cartProductEntityRepository.save(cpe);
		}
		return cartProductEntityRepository.findByUserId(userId);
	}

	
	public List<CartProductEntity> deleteProductFromCart(int userId, int productId, int quantity, String token) 
	{
		if(!userClient.validUserToken(userId, token)) return null;
		
		CartProductEntity cpe = cartProductEntityRepository.findByUserIdAndProductId(userId, productId).get();
		if(cpe.getQuantity() <= quantity)cartProductEntityRepository.delete(cpe);
		else 
		{
			cpe.setQuantity(cpe.getQuantity()-quantity);
			cartProductEntityRepository.save(cpe);
		}
		
		return cartProductEntityRepository.findByUserId(userId);
	}

	public List<CartProductEntity> updateCart(int userId, int[][] productsAndQuantities, String token) 
	{
		if(!userClient.validUserToken(userId, token)) return null;
		
		for(int[] l : productsAndQuantities)
		{
			if(cartProductEntityRepository.findByUserIdAndProductId(userId, (int)l[0]).isPresent()) 
			{
				CartProductEntity cpe = cartProductEntityRepository.findByUserIdAndProductId(userId, (int)l[0]).get();
				if(l[1] < 1) cartProductEntityRepository.delete(cpe);
				else
				{
					cpe.setQuantity(l[1]);
					cartProductEntityRepository.save(cpe);
				}
			}
			else if (l[1] > 0) 
			{
				addProductToCart(userId, l[0], l[1], token);
			}
		}
		
		return cartProductEntityRepository.findByUserId(userId);
	}

	@Transactional
	public boolean deleteCartByUserId(int userId, String token) 
	{
		if(!userClient.validAdminToken(token)) return false;
		if(cartProductEntityRepository.findByUserId(userId).size()<1) return false;
		cartProductEntityRepository.deleteByUserId(userId);
		return true;
	}
	
	
	
	
	
}
