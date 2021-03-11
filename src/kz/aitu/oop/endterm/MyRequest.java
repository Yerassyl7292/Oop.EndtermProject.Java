package kz.aitu.oop.endterm;

import kz.aitu.oop.endterm.controllers.LibrarianController;
import kz.aitu.oop.endterm.controllers.OrderController;
import kz.aitu.oop.endterm.controllers.SubscribersController;
import kz.aitu.oop.endterm.repositories.interfaces.ILibrarianRepository;
import kz.aitu.oop.endterm.repositories.interfaces.IOrderRepository;
import kz.aitu.oop.endterm.repositories.interfaces.ISubscribersRepository;

import java.util.Scanner;

public class MyRequest {
    private final OrderController orderController;
    private final SubscribersController subscribersController;
    private final LibrarianController librarianController;
    private final Scanner scanner;

    public MyRequest(IOrderRepository orderRepository, ISubscribersRepository subscribersRepository,
                     ILibrarianRepository librarianRepository){
        orderController = new OrderController(orderRepository);
        subscribersController = new SubscribersController(subscribersRepository);
        librarianController = new LibrarianController(librarianRepository);
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("Welcome to Requests!");
            System.out.println("Select option");
            System.out.println("1. As librarian");
            System.out.println("2. As subscriber");
            System.out.println("3. order");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    LibrarianMenu();
                } else if (option == 2) {
                    SubscribersMenu();
                } else if (option == 3) {
                    OrderMenu();
                } else {
                    break;
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
            System.out.println("***********************************");
        }
    }

    public void LibrarianMenu(){
        while (true){
            System.out.println();
            System.out.println("Select option");
            System.out.println("1. Get Librarian by id");
            System.out.println("2. Get all Librarians");
            System.out.println("3. New Librarian");
            System.out.println("4. Main menu");
            System.out.println("0. Exit");
            System.out.println();
            try{
                System.out.println("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getLibrarianByid();
                } else if (option == 2) {
                    getAllLibrarian();
                } else if (option == 3) {
                    createLibrarian();}

                else if(option==4) {
                    start();
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }

            System.out.println("***********************************");
        }
    }

    private void createLibrarian() {
        System.out.println("Please enter first name");
        String name = scanner.next();
        System.out.println("Please enter last name");
        String surname = scanner.next();
        System.out.println("Please enter age");
        int age = scanner.nextInt();
        System.out.println("Please enter experience");
        String experience = scanner.next();

        String resonse = librarianController.createLibrarian(name,surname,age,experience);
        System.out.println(resonse);
    }

    private void getAllLibrarian() {
        String response = librarianController.getAllLibrarian();
        System.out.println(response);
    }

    private void getLibrarianByid() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = librarianController.getLibrarian(id);
        System.out.println(response);
    }

    public void SubscribersMenu(){
        while (true){
            System.out.println();
            System.out.println("Select option");
            System.out.println("1. Get Subscribers by id");
            System.out.println("2. Get all Subscribers");
            System.out.println("3. Create Subscribers");
            System.out.println("4. Buy book");
            System.out.println("5. Main menu");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter option (1-5): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getSubscribersById();
                }
                else if (option == 2) {
                    getAllSubscribers();
                }
                else if (option == 3) {
                    createSubscribers();}
                else if (option == 4) {
                    buyBook();

                } else if(option==5) {
                    start();
                }
                else {
                    break;
                }

            }catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }

            System.out.println("***********************************");
        }
    }

    private void buyBook() {
        System.out.println("Please select book number ");
        int book_id = scanner.nextInt();
        String response = subscribersController.buyBooks(book_id);
        System.out.println(response);
    }

    private void createSubscribers() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender");
        boolean gender = scanner.nextBoolean();
        System.out.println("Please enter password_no");
        int password_no = scanner.nextInt();
        System.out.println("Please enter date of birthday");
        String dateOfBirthday = scanner.next();
        System.out.println("Please enter address");
        String address = scanner.next();

        String response = subscribersController.createSubscribers(name,surname,gender,password_no,dateOfBirthday,address);
        System.out.println(response);
    }

    private void getAllSubscribers() {
        String response = subscribersController.getAllSubscribers();
        System.out.println(response);
    }

    private void getSubscribersById() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();

        String response = subscribersController.getSubscribers(id);
        System.out.println(response);
    }

    public void OrderMenu(){
        while (true){
            System.out.println();
            System.out.println("Select option");
            System.out.println("1. Get info about orderers by id");
            System.out.println("2. Get all orders");
            System.out.println("3. Create order");
            System.out.println("4. Main menu");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getOrderById();
                } else if (option == 2) {
                    getAllOrders();
                } else if(option==3) {
                    createOrder();
                }
                else if(option==4) {
                    start();
                }
                else {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }

            System.out.println("***********************************");
        }
    }

    private void createOrder() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter book");
        String book_name = scanner.next();
        System.out.println("Please enter date");
        String order_date = scanner.next();
        System.out.println("Please enter num");
        int order_num = scanner.nextInt();
        System.out.println("Please enter subscriber_id");
        int subscriber_id = scanner.nextInt();
        System.out.println("Please enter librarian_id");
        int librarian_id = scanner.nextInt();

        String response = orderController.createOrder(name, book_name, order_date,order_num,subscriber_id,librarian_id);
        System.out.println(response);
    }

    private void getAllOrders() {
        String response = orderController.getAllOrder();
        System.out.println(response);
    }

    private void getOrderById() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();

        String response = orderController.getOrder(id);
        System.out.println(response);
    }


}
