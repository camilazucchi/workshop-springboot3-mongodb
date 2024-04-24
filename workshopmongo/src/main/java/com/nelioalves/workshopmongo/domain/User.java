package com.nelioalves.workshopmongo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
/* Essas anotações instruem o Lombok a gerar os métodos getters e setters para todos os campos da classe, economizando
 * tempo e reduzindo a verbosidade do código.*/
@NoArgsConstructor
/* A anotação @NoArgsConstructor do Lombok é usada para instruir o Lombok a gerar automaticamente um construtor
 * sem argumentos para uma classe. */
@Document(collection = "user")
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;
    // Lembrando que List é apenas uma interface e ArrayList é uma interpretação possível de List!
    @DBRef(lazy = true)
    /* A anotação "@DBRef" é uma característica específica do Spring Data MongoDB, e é usada para estabelecer uma
     * referência entre documentos em coleções diferentes dentro do MongoDB. Permite a criação de associações entre
     * documentos usando referências, ao invés de incorporar documentos diretamente um no outro. */
    private List<Post> posts = new ArrayList<>();

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