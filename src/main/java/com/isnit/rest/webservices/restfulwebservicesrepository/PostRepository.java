package com.isnit.rest.webservices.restfulwebservicesrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isnit.rest.webservices.restfulwebservices.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
