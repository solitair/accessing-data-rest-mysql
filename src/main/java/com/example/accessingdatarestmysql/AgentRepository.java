package com.example.accessingdatarestmysql;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "agent", path = "agent")
public interface AgentRepository extends PagingAndSortingRepository<Agent, Long>, CrudRepository<Agent,Long> {

}


