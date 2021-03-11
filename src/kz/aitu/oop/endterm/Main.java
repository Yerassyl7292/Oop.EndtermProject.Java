package kz.aitu.oop.endterm;

import kz.aitu.oop.endterm.database.IDB;
import kz.aitu.oop.endterm.database.PostgreSqlDB;
import kz.aitu.oop.endterm.repositories.LibrarianRepository;
import kz.aitu.oop.endterm.repositories.OrderRepository;
import kz.aitu.oop.endterm.repositories.SubscribersRepository;
import kz.aitu.oop.endterm.repositories.interfaces.ILibrarianRepository;
import kz.aitu.oop.endterm.repositories.interfaces.IOrderRepository;
import kz.aitu.oop.endterm.repositories.interfaces.ISubscribersRepository;

public class Main {

    public static void main(String[] args) {

        IDB db = new PostgreSqlDB();
        IOrderRepository orderRepository = new OrderRepository(db);
        ISubscribersRepository subscribersRepository = new SubscribersRepository(db);
        ILibrarianRepository librarianRepository = new LibrarianRepository(db);
        MyRequest req = new MyRequest(orderRepository,subscribersRepository,librarianRepository);
        req.start();

    }
}
