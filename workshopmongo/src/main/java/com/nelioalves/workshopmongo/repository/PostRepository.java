package com.nelioalves.workshopmongo.repository;

import com.nelioalves.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
        /* A anotação acima é usada em métodos de consulta em frameworks como Spring Data JPA no Java para realizar uma
         * consulta que busca por registros onde o título corresponda a um padrão específico.
         * - "{ 'title': { $regex: ?0, $options: 'i' } }": é uma expressão em formato JSON que descreve a condição da
         * consulta.
         * - 'title': campo da entidade pelo qual estamos consultando, neste caso, é o título.
         * - $regex: é um operador que permite fazer uma correspondência com uma expressão regular.
         * - ?0: é um marcador de posição para o primeiro parâmetro do método onde esta anotação está sendo usada. Ou seja,
         * a consulta vai buscar por registros onde o título corresponda à expressão regular fornecida como primeiro
         * parâmetro.
         * - $options: 'i': 'i' indica que a correspondência não deve ser sensível a maiúsculas e minúsculas. */
    List<Post> findByTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}