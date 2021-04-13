package com.poly.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.QLHopDong;
@Repository
public interface HDRepository extends CrudRepository<QLHopDong, String>{

	List<QLHopDong> findByFilesLikeOrderByFiles(String search);
}
