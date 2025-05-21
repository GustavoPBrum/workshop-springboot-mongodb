package com.estudandojava.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandojava.workshopmongo.domain.User;
import com.estudandojava.workshopmongo.repository.UserRepository;
import com.estudandojava.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired  // Injecao de dependencia automatica do Spring
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();  // Vai no banco de dados e retorna todos os obj do tipo User
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		// Retorna objeto ou lanca uma excecao
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}
}
