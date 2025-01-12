package com.br.artfc.cursos.exceptions;

public class ErroMessage {

   private String message;
   private String field;
   
   public ErroMessage(String message, String field) {
      this.message = message;
      this.field = field;
   }

   public String getMessage() {
      return message;
   }
   public void setMessage(String message) {
      this.message = message;
   }
   public String getField() {
      return field;
   }
   public void setField(String field) {
      this.field = field;
   }
   
}
