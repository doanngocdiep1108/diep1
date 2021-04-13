package com.poly.services;

import java.util.List;
import java.util.Optional;

import com.poly.model.QLHopDong;
import com.poly.model.Users;

public interface HDService {

	void deleteAll();

	void deleteAll(List<QLHopDong> entities);

	void delete(QLHopDong entity);

	void deleteById(String id);

	long count();

	List<QLHopDong> findAllById(List<String> ids);

	List<QLHopDong> findAll();

	boolean existsById(String id);

	Optional<QLHopDong> findById(String id);

	List<QLHopDong> saveAll(List<QLHopDong> entities);

	QLHopDong save(QLHopDong entity);

	List<Users> findAllUsers();

	List<QLHopDong> findByFilesLikeOrderByFiles(String search);
}
