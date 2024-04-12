package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User ID not found"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    /* Esse método recebe um objeto "UserDTO" como parâmetro e cria um novo objeto "User" com base nas informações
     * fornecidas pelo "UserDTO". Ele serve para converter um objeto "UserDTO" em um objeto "User". */
    public User convertUserDTOToUser(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

}
