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

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    /* Tive um probleminha nesse método mas resolvi da seguinte forma:
     * 1 - Em vez de chamar diretamente "repository.findById(user.getId())", armazenei o resultado em um "Optional<User>".
     * 2 - Verifiquei se o "Optional<User>" contém um valor usando "isPresent()".
     * 3 - Se estiver presente, obtém o "User" do "Optional<User>" usando "get()".
     * 4 - Caso contrário, lança uma exceção informando que o usuário não foi encontrado. */
    @SuppressWarnings("UnusedReturnValue")
    public User update(User user) {
        Optional<User> optionalUser = repository.findById(user.getId());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            updateData(existingUser, user);
            return repository.save(existingUser);
        } else {
            throw new ObjectNotFoundException("User not found");
        }
    }

    private void updateData(User updatedUser, User user) {
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
    }

    /* Esse método recebe um objeto "UserDTO" como parâmetro e cria um novo objeto "User" com base nas informações
     * fornecidas pelo "UserDTO". Ele serve para converter um objeto "UserDTO" em um objeto "User". */
    public User convertUserDTOToUser(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

}
