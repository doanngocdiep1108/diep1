package com.poly.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.BDS;

@Repository
public interface BDSRepository extends CrudRepository<BDS, String> {
	
	List<BDS> findAllByOrderByTimeDesc();
	
	List<BDS> findTop3ByOrderByTimeDesc();
	
	List<BDS> findTop10ByOrderByTimeDesc();

	List<BDS> findByIdStartingWithAndNameLikeAndTypeLike(String id, String name, String type);

	List<BDS> findByIdStartingWithAndNameLikeAndTypeLikeAndSLessThanEqualAndPriceLessThanEqual(String id, String name,
			String type, int s, float price);
	
}
