package com.nelioalves.workshopmongo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
/* Essas anotações instruem o Lombok a gerar os métodos getters e setters para todos os campos da classe, economizando
 * tempo e reduzindo a verbosidade do código.*/
@NoArgsConstructor
/* A anotação @NoArgsConstructor do Lombok é usada para instruir o Lombok a gerar automaticamente um construtor
 * sem argumentos para uma classe. */
public class User implements Serializable {

    private String id;
    private String name;
    private String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}