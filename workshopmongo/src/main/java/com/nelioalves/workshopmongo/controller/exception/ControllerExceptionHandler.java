package com.nelioalves.workshopmongo.controller.exception;

import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
/* Essa anotação é usada para definir classes globais de tratamento de exceções. Essas classes são essencialmente
 * interceptores que envolvem os controladores e lidam com exceções lançadas por métodos de controlador. */
public class ControllerExceptionHandler {

    /* Este método captura exceções do tipo "ObjectNotFoundException", cria uma resposta HTTP com o status "NOT_FOUND"
     * e um corpo contendo detalhes sobre o erro, e retorna essa resposta ao cliente que fez a requisição. */
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(System.currentTimeMillis(), status, "Not found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

}
