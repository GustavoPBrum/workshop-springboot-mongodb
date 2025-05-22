package com.estudandojava.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudandojava.workshopmongo.domain.Post;
import com.estudandojava.workshopmongo.services.PostService;

@RestController
@RequestMapping(value ="/posts")  // Nome do caminho geralmente posto no plural
public class PostResource {
	
	@Autowired 	
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
	    Post obj = service.findById(id);
	    return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
	    List<Post> list = service.findAll();
	    return ResponseEntity.ok().body(list);
	}
}
