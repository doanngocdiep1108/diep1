package com.poly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.model.QLHopDong;
import com.poly.model.Users;
import com.poly.repositories.HDRepository;
import com.poly.repositories.UserRepository;
@Service
public class HDServiceImpl implements HDService {
	
	@Autowired
	HDRepository hdRepository;

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Users> findAllUsers(){
		return (List<Users>) userRepository.findAll();
	}
	
	@Override
	public QLHopDong save(QLHopDong entity) {
		return hdRepository.save(entity);
	}

	@Override
	public List<QLHopDong> saveAll(List<QLHopDong> entities) {
		return (List<QLHopDong>) hdRepository.saveAll(entities);
	}

	@Override
	public Optional<QLHopDong> findById(String id) {
		return hdRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return hdRepository.existsById(id);
	}

	@Override
	public List<QLHopDong> findAll() {
		return (List<QLHopDong>) hdRepository.findAll();
	}

	@Override
	public List<QLHopDong> findAllById(List<String> ids) {
		return (List<QLHopDong>) hdRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return hdRepository.count();
	}

	@Override
	public void deleteById(String id) {
		hdRepository.deleteById(id);
	}

	@Override
	public void delete(QLHopDong entity) {
		hdRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<QLHopDong> entities) {
		hdRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		hdRepository.deleteAll();
	}

	@Override
	public List<QLHopDong> findByFilesLikeOrderByFiles(String search) {
		return hdRepository.findByFilesLikeOrderByFiles("%"+search+"%");
	}

}
