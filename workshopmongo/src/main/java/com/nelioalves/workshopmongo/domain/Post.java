package com.nelioalves.workshopmongo.domain;

import com.nelioalves.workshopmongo.dto.AuthorDTO;
import com.nelioalves.workshopmongo.dto.CommentDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private AuthorDTO author;
    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

}