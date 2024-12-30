import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Person;

public class App {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        App app = new App();
        int option = -1;

        List<Person> people = new ArrayList<Person>();

        while (option != 0) {
            app.menu();
            option = app.getOption();
            switch (option) {
                case 1:
                    app.createPerson(people);
                    break;
                case 0:
                    app.exit();
                    break;
                default:
                    System.out.println("Invalid option");
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
        System.out.println(">> [0]. Exit");
    }

    public int getOption() {
        System.out.print(">> Enter your option: ");
        return scanner.nextInt();
    }

    public void createPerson(List<Person> people) {
        System.out.println("\n >> Creating person...");

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

    public void exit() {
        System.out.println("\n>>Exiting...\n");
    }

    public void closeScanner() {
        scanner.close();
    }
}
