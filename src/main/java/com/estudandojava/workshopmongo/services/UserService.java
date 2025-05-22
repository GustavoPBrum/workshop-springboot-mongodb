package com.estudandojava.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandojava.workshopmongo.domain.User;
import com.estudandojava.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);  // Tratar se caso nao exista o id
		repo.deleteById(id);;
	}
	
	// Esse obj como argumento sao os dados enviados na requisicao, nao tendo *VINCULO* com o BD
	public User update(User obj) {
		User newObj = findById(obj.getId()); // obj original do banco de dados que sera atualizado
		
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	// Metodo auxiliar que usamos para salvar no newObj (original do BD) os dados do *obj* (dados enviados na requisicao)
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
