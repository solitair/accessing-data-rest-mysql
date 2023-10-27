package com.example.accessingdatarestmysql;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "schedule", path = "schedule")
public interface ScheduleRepository extends PagingAndSortingRepository<Schedule, Long>, CrudRepository<Schedule,Long> {

}


