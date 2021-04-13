package com.poly.services;

import java.util.List;
import java.util.Optional;

import com.poly.model.Users;

public interface UserService {

	void deleteAll();

	void deleteAll(List<Users> entities);

	void delete(Users entity);

	void deleteById(String id);

	long count();

	List<Users> findAllById(List<String> ids);

	List<Users> findAll();

	boolean existsById(String id);

	Optional<Users> findById(String id);

	List<Users> saveAll(List<Users> entities);

	Users save(Users entity);

	boolean checkLogin(String email, String password);
	
	boolean checkLogin(String email);
	
	List<Users> findByFullnameLikeOrderByFullname(String search);

}
