package br.com.artfc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/firstController")
public class FirstController {

   @GetMapping("/firstMethod/{id}")
   public String firstMethod(@PathVariable String id) {
      return "My first method API Rest com id: " + id;
   }

   @GetMapping("/methodWithQueryParams")
   public String methodWithQueryParams(@RequestParam String id) {
      return "My first method API Rest com with Param id: " + id;

   }

   @GetMapping("/methodWithQueryParamsMap")
   public String methodWithQueryParamsMap(@RequestParam Map<String, String> allParams) {
      return "My first method API Rest com with Param id: " + allParams.entrySet();

   }

   @PostMapping("/methodWithBodyParams")
   public String methodWithBodyParams(@RequestBody String username) {
      return "methodWithBodyParams " + username;
   }

   @PostMapping("/methodWithHeaders")
   public String methodWithHeaders(@RequestHeader("name") String name) {
      return "methodWithBodyParams " + name;
   }

   @PostMapping("/methodWithHeadersMap")
   public String methodWithHeadersMap(@RequestHeader Map<String,String> headers) {
      return "methodWithBodyParams " + headers.entrySet();
   }

   @GetMapping("/methodResponseEntity/{id}")
   public ResponseEntity<Object> methodResponseEntity(@PathVariable Long id) {
      var user =  new User("artfc");

      if (id > 5) {
      return ResponseEntity.status(HttpStatus.OK).body(user);
      }
      return ResponseEntity.badRequest().body("Number less than 5.");
      
   }

   record User(String username) {

   }
   
}
