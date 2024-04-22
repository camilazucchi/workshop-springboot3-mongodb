package com.nelioalves.workshopmongo.dto;

import com.nelioalves.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    // Copia o id e o nome do usuário (User) para o objeto AuthorDTO:
    public AuthorDTO(User user) {
        id = user.getId();
        name = user.getName();
    }

}