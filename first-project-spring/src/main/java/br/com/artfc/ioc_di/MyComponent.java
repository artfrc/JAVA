package br.com.artfc.ioc_di;

import org.springframework.stereotype.Component;

@Component  
public class MyComponent {
   
   public String CallMyComponent() {
      return "Calling my component.";
   }
}
