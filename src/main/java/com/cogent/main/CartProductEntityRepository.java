package com.cogent.main;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductEntityRepository extends JpaRepository<CartProductEntity, Integer>
{

	List<CartProductEntity> findByUserId(int userId);

	@Query(value = "from CartProductEntity where userId = :userId and productId = :productId")
	Optional<CartProductEntity> findByUserIdAndProductId(int userId, int productId);

	void deleteByUserId(int userId);

	
}
