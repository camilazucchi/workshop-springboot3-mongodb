package com.nelioalves.workshopmongo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/* Esta anotação é usada para gerar automaticamente os métodos "equals()" e "hashCode()" na classe. O parâmetro
 * "(onlyExplicitlyIncluded = true)" indica que apenas os campos explicitamente marcados com "@EqualsAndHashCode.Include"
 * serão considerados na geração dos métodos "equals()" e "hashCode()". */
public class Post implements Serializable {

    @EqualsAndHashCode.Include
    private String id;
    private Date date;
    private String title;
    private String body;
    private User author;

    public Post(String id, Date date, String title, String body, User author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

}