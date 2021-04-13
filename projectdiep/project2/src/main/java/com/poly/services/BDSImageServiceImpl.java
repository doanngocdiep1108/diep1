package com.poly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.model.BDS;
import com.poly.model.BDSImage;
import com.poly.repositories.BDSRepository;
import com.poly.repositories.ImageRepository;
@Service
public class BDSImageServiceImpl implements BDSImageService {
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	BDSRepository bdsRepository;
	@Override
	public List<BDS> findAllBDS(){
		return (List<BDS>) bdsRepository.findAll();
	}
	@Override
	public BDSImage save(BDSImage entity) {
		return imageRepository.save(entity);
	}

	@Override
	public List<BDSImage> saveAll(List<BDSImage> entities) {
		return (List<BDSImage>) imageRepository.saveAll(entities);
	}

	@Override
	public Optional<BDSImage> findById(Integer id) {
		return imageRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return imageRepository.existsById(id);
	}

	@Override
	public List<BDSImage> findAll() {
		return (List<BDSImage>) imageRepository.findAll();
	}

	@Override
	public List<BDSImage> findAllById(List<Integer> ids) {
		return (List<BDSImage>) imageRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return imageRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		imageRepository.deleteById(id);
	}

	@Override
	public void delete(BDSImage entity) {
		imageRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<BDSImage> entities) {
		imageRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		imageRepository.deleteAll();
	}
	public List<BDSImage> findAllByBds_id(String id) {
		return imageRepository.findAllByBds_id(id);
	}

	
}
