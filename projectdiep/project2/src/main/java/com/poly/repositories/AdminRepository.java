package com.poly.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {

	
	List<Admin> findByFullnameLikeOrderByFullname(String search);
}
