package com.servicedesk.backend.exceptions;

import com.servicedesk.backend.dtos.erro.ErroRespostaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcecaoGlobalHandler {
    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<ErroRespostaDTO> handleNaoEncontradoExcecao(NaoEncontradoException naoEncontradoException){
        ErroRespostaDTO erroResposta = new ErroRespostaDTO(naoEncontradoException.getMessage(),"Registro não encontrado");
        return new ResponseEntity<>(erroResposta, HttpStatus.NOT_FOUND);
    }
}
