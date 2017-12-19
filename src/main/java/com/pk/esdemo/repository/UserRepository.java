package com.pk.esdemo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.pk.esdemo.model.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

}
