package com.poly.services;

import java.util.List;
import java.util.Optional;

import com.poly.model.BDS;
import com.poly.model.BDSImage;

public interface BDSImageService {

	void deleteAll();

	void deleteAll(List<BDSImage> entities);

	void delete(BDSImage entity);

	void deleteById(Integer id);

	long count();

	List<BDSImage> findAllById(List<Integer> ids);

	List<BDSImage> findAll();

	boolean existsById(Integer id);

	Optional<BDSImage> findById(Integer id);

	List<BDSImage> saveAll(List<BDSImage> entities);

	BDSImage save(BDSImage entity);

	List<BDS> findAllBDS();

	List<BDSImage> findAllByBds_id( String id);
}
