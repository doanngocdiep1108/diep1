package com.poly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.model.BDS;
import com.poly.repositories.BDSRepository;

@Service
public class BDSServiceImpl implements BDSService {
	@Autowired
	BDSRepository bdsRepository;

	@Override
	public BDS save(BDS entity) {
		return bdsRepository.save(entity);
	}

	@Override
	public List<BDS> saveAll(List<BDS> entities) {
		return (List<BDS>) bdsRepository.saveAll(entities);
	}

	@Override
	public Optional<BDS> findById(String id) {
		return bdsRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return bdsRepository.existsById(id);
	}

	@Override
	public List<BDS> findAll() {
		return (List<BDS>) bdsRepository.findAll();
	}

	@Override
	public List<BDS> findAllById(List<String> ids) {
		return (List<BDS>) bdsRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return bdsRepository.count();
	}

	@Override
	public void deleteById(String id) {
		bdsRepository.deleteById(id);
	}

	@Override
	public void delete(BDS entity) {
		bdsRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<BDS> entities) {
		bdsRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		bdsRepository.deleteAll();
	}

	@Override
	public List<BDS> findByIdStartingWithAndNameLikeAndTypeLike(String id, String name, String type) {
		return bdsRepository.findByIdStartingWithAndNameLikeAndTypeLike(id, "%" + name + "%", "%" + type + "%");
	}

	@Override
	public List<BDS> findByIdStartingWithAndNameLikeAndTypeLikeAndSLessThanEqualAndPriceLessThanEqual(String id,
			String name, String type, int s, float price) {
		return bdsRepository.findByIdStartingWithAndNameLikeAndTypeLikeAndSLessThanEqualAndPriceLessThanEqual(id,
				"%" + name + "%", "%" + type + "%", s, price);
	}

	@Override
	public List<BDS> findAllByOrderByTimeDesc() {
		return bdsRepository.findAllByOrderByTimeDesc();
	}

	@Override
	public List<BDS> findTop3ByOrderByTimeDesc() {
		return bdsRepository.findTop3ByOrderByTimeDesc();
	}

	@Override
	public List<BDS> findTop10ByOrderByTimeDesc() {
		// TODO Auto-generated method stub
		return bdsRepository.findTop10ByOrderByTimeDesc();
	}
}
