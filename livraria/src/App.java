import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Book;
import models.Person;

public class App {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        App app = new App();
        app.clearScreen();
        int option = -1;

        List<Person> people = new ArrayList<Person>();
        List<Book> books = new ArrayList<Book>();

        while (option != 0) {
            app.menu();
            option = app.getOption();
            app.clearScreen();
            switch (option) {
                case 1:
                    app.createPerson(people);
                    break;
                
                case 2:
                    app.listPeople(people);
                    break;

                case 3:
                    app.getPerson(people);
                    break;

                case 4:
                    app.createBook(books);
                    break;
                
                case 5:
                    app.listBooks(books);
                    break;

                case 0:
                    app.exit();
                    break;
                default:
                    System.out.println("Invalid option\n");
                    break;
            }
        }

        app.closeScanner();
    }

    public void menu() {
        System.out.println("==================== MENU ====================\n");
        System.out.println(">> [1]. Create person");
        System.out.println(">> [2]. List people");
        System.out.println(">> [3]. Get person");
        System.out.println(">> [4]. Create book");
        System.out.println(">> [5]. List books");
        System.out.println(">> [0]. Exit");
    }

    public int getOption() {
        System.out.print(">> Enter your option: ");
        return scanner.nextInt();
    }

    public void createPerson(List<Person> people) {

        Person person = new Person();
        System.out.print(">> Enter the person's name: ");
        person.setName(scanner.next());
        System.out.println(">> Enter the person's birth date: ");
        person.setBirthDate(scanner.next());
        System.out.print(">> Enter the person's email: ");
        person.setEmail(scanner.next());
        person.setId((long) (people.size() + 1));
        
        people.add(person);
        System.out.println(">> Person created successfully!\n");

    }

    public void listPeople(List<Person> people) {
        for (Person person : people) {
            System.out.println("ID: " + person.getId());
            System.out.println("Name: " + person.getName() + "\n");
        }
    }

    public void getPerson(List<Person> people) {
        listPeople(people);
        System.out.print(">> Enter the person's ID: ");
        Long id = scanner.nextLong();
        for (Person person : people) {
            if (person.getId() == id) {
                System.out.println("Name: " + person.getName());
                System.out.println("Birth date: " + person.getBirthDate());
                System.out.println("Email: " + person.getEmail() + "\n");
                return;
            }
        }
        System.out.println("Person not found\n");
    }

    public void createBook(List<Book> books) {
         String title;
         String author;
         Long id = (long) (books.size() + 1);

        System.out.print(">> Enter the book's title: ");
        title = scanner.next();
        System.out.print(">> Enter the book's author: ");
        author = scanner.next();
        Book book = new Book( id, title, author, true);
        books.add(book);
        System.out.println(">> Book created successfully!\n");
    }

    public void listBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println("ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Available: " + book.getAvailable());
            System.out.println("Created at: " + book.getCreatedAt());   
        }
    }

    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing the terminal.");
        }
    }       

    public void exit() {
        System.out.println("\n>> Exiting...\n");
    }

    public void closeScanner() {
        scanner.close();
    }
}
