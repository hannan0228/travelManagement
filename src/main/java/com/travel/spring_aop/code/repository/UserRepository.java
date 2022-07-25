package com.travel.spring_aop.code.repository;

import org.springframework.data.repository.CrudRepository;

import com.travel.spring_aop.code.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
