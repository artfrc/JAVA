package models;

import java.time.LocalDateTime;

public class Book {
   
   private Long id;
   private String title;
   private String author;
   private Boolean available;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;

   public Book(Long id, String title, String author, Boolean available) {
      this.id = id;
      this.title = title;
      this.author = author;
      this.available = available;
      this.createdAt = LocalDateTime.now();
      this.updatedAt = LocalDateTime.now();
   }

   public Book() {
   }

   public Long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getAuthor() {
      return author;
   }
   public void setAuthor(String author) {
      this.author = author;
   }
   public Boolean getAvailable() {
      return available;
   }
   public void setAvailable(Boolean available) {
      this.available = available;
   }
   public LocalDateTime getCreatedAt() {
      return createdAt;
   }
   public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
   }
   public LocalDateTime getUpdatedAt() {
      return updatedAt;
   }
   public void setUpdatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
   }
}
