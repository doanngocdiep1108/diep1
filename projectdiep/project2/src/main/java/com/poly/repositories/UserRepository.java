package com.poly.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.Users;
@Repository
public interface UserRepository extends CrudRepository<Users, String>{

	List<Users> findByFullnameLikeOrderByFullname(String search);
}
