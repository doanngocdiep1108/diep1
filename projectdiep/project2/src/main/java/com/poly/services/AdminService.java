package com.poly.services;

import java.util.List;
import java.util.Optional;

import com.poly.model.Admin;

public interface AdminService {

	void deleteAll();

	void deleteAll(List<Admin> entities);

	void delete(Admin entity);

	void deleteById(String id);

	long count();

	List<Admin> findAllById(List<String> ids);

	List<Admin> findAll();

	boolean existsById(String id);

	Optional<Admin> findById(String id);

	List<Admin> saveAll(List<Admin> entities);

	Admin save(Admin entity);

	boolean checkLogin(String id, String password);
	boolean checkLogin(String id);

	List<Admin> findByFullnameLikeOrderByFullname(String search);

}
