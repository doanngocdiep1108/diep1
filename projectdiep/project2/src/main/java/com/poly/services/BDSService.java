package com.poly.services;

import java.util.List;
import java.util.Optional;

import com.poly.model.BDS;

public interface BDSService {

	void deleteAll();

	void deleteAll(List<BDS> entities);

	void delete(BDS entity);

	void deleteById(String id);

	long count();

	List<BDS> findAllById(List<String> ids);

	List<BDS> findAll();

	boolean existsById(String id);

	Optional<BDS> findById(String id);

	List<BDS> saveAll(List<BDS> entities);

	BDS save(BDS entity);

	List<BDS> findAllByOrderByTimeDesc();
	
	List<BDS> findTop3ByOrderByTimeDesc();
	
	List<BDS> findTop10ByOrderByTimeDesc();
	
	List<BDS> findByIdStartingWithAndNameLikeAndTypeLike(String id,String name, String type);
	
	List<BDS> findByIdStartingWithAndNameLikeAndTypeLikeAndSLessThanEqualAndPriceLessThanEqual(String id, String name, String type,int s, float price);

	
}
