package com.pk.esdemo.service;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.pk.esdemo.model.User;
import com.pk.esdemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ElasticsearchTemplate esTemplate;

	public void create(User user) {
    userRepository.save(user);
	}

	public List<User> searchPersonAnalysed(String freeText) {
		NativeSearchQuery query = new NativeSearchQueryBuilder()
    .withQuery(QueryBuilders.wildcardQuery("name", "*"+freeText+"*"))
    .withSort(SortBuilders.fieldSort("name.sort").order(SortOrder.ASC))
    .build();
		return esTemplate.queryForList(query, User.class);
	}

}
