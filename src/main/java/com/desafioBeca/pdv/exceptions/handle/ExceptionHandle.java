package com.desafioBeca.pdv.exceptions.handle;

import com.desafioBeca.pdv.exceptions.TamanhoNaoValidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.UnexpectedTypeException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(TamanhoNaoValidoException.class)
    public ResponseEntity<DefaultException> hanble(TamanhoNaoValidoException naoValido) {
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem(naoValido.getMessage());
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        defaultException.setDataAgora(LocalDateTime.now());

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<DefaultException> hanble( UnexpectedTypeException naoValido) {
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem("Compo obrigatorio não preenchido!");
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        defaultException.setDataAgora(LocalDateTime.now());

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }
}
