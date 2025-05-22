package com.estudandojava.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudandojava.workshopmongo.domain.Post;
import com.estudandojava.workshopmongo.domain.User;
import com.estudandojava.workshopmongo.dto.UserDTO;
import com.estudandojava.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")  // Nome do caminho geralmente posto no plural
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {		
		List<User> list = service.findAll();
		// Transformar em um listDto usando expressao lambda
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		// Ok eh um metodo que instancia o ResponseEntity ja com o codigo de resposta HTTP que a resposta ocorreu com sucesso
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDto(objDto);
		
		obj = service.insert(obj);  // Retorna o proprio obj inserido
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();  // Codigo para resposta vazia 204
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}	
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		User obj = service.findById(id);  // Pegamos o usuario pelo id
		
		// Mesmo com o carregamento tardio (lazy = true), pelo getPosts no endpoint, ele ira carregar os posts do usuario
		return ResponseEntity.ok().body(obj.getPosts());  
	}
}
