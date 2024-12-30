package models;


public class Person {
   
   private Long id;
   private String name;
   private String birthDate;
   private String email;

   public Person(Long id, String name, String birthDate, String email) {
      this.id = id;
      this.name = name;
      this.birthDate = birthDate;
      this.email = email;
   }

   public Person() {
   }

   public Long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getBirthDate() {
      return birthDate;
   }
   public void setBirthDate(String birthDate) {
      this.birthDate = birthDate;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
}
