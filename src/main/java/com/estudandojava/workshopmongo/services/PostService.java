package com.estudandojava.workshopmongo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandojava.workshopmongo.domain.Post;
import com.estudandojava.workshopmongo.repository.PostRepository;
import com.estudandojava.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired  // Injecao de dependencia automatica do Spring
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		// Retorna objeto ou lanca uma excecao
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}

	public List<Post> findAll() {
	    return repo.findAll();
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
}
