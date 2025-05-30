package com.estudandojava.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.estudandojava.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	// '?0' quer dizer o **primeiro** parametro, se fosse o segundo seria '?1' e assim por diante
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

	List<Post> findByTitleContainingIgnoreCase(String text); // Query methods

	@Query("{ $and: [ { date: {$gte: ?1}}, { date: { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } },"
			+ " { 'body': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }") // Para buscar o texto dentro de cada
																			// comentario
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
