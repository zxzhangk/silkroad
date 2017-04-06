package com.silk.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.silk.entity.User;


@Transactional
public interface UserDaoI extends CrudRepository<User, Long>
{
}
