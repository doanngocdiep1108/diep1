package com.poly.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.BDSImage;
@Repository
public interface ImageRepository extends CrudRepository<BDSImage, Integer>{

    List<BDSImage> findAllByBds_id( String id);
    
    
}
