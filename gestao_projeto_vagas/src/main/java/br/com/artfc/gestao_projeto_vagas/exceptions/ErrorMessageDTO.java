package br.com.artfc.gestao_projeto_vagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {

      private String message;
      private String field;
}
