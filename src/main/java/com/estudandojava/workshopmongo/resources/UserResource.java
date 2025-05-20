package com.estudandojava.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudandojava.workshopmongo.domain.User;
import com.estudandojava.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")  // Nome do caminho geralmente posto no plural
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {		
		List<User> list = service.findAll();
		// Ok eh um metodo que instancia o ResponseEntity ja com o codigo de resposta HTTP que a resposta ocorreu com sucesso
		return ResponseEntity.ok().body(list);
	}
}
