package com.estudandojava.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudandojava.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")  // Nome do caminho geralmente posto no plural
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User joao = new User("1", "Joao White", "joaozinho@gmail.com");
		User pedrao = new User("2", "Pedrin", "pedrin@gmail.com");
		
		// List eh uma interface, por isso usamos a implementacao da interface ArrayList para instancia-la
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(joao, pedrao));
		
		// Ok eh um metodo que instancia o ResponseEntity ja com o codigo de resposta HTTP que a resposta ocorreu com sucesso
		return ResponseEntity.ok().body(list);
	}
}
