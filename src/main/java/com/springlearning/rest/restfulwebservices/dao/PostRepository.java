package com.springlearning.rest.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlearning.rest.restfulwebservices.bean.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
