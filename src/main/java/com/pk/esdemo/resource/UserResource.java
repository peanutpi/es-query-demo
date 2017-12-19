package com.pk.esdemo.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pk.esdemo.model.User;
import com.pk.esdemo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create(@RequestBody User user) {
		if (user.getId() == null) {
			user.setId(UUID.randomUUID().toString());
		}
		userService.create(user);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<User> getPerson(@RequestParam(required=false) String q, Pageable pageable) {
		return userService.searchPersonAnalysed(q, pageable);
	}

}
