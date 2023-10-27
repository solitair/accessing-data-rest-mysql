package com.example.accessingdatarestmysql;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface AdminRepository extends PagingAndSortingRepository<Admin, Long>, CrudRepository<Admin,Long> {

	List<Admin> findByName(@Param("name") String name);

}
