package kz.aitu.oop.endterm.controllers;

import kz.aitu.oop.endterm.enteties.Order;
import kz.aitu.oop.endterm.repositories.OrderRepository;
import kz.aitu.oop.endterm.repositories.interfaces.IOrderRepository;

import java.util.List;

public class OrderController {
    private final IOrderRepository repo;

    public OrderController(IOrderRepository repo) {
        this.repo = repo;
    }

    public String createOrder(String name,String book_name,String order_date,int order_num,int subscriber_id,int librarian_id) {
        Order orderRepository = new Order(name,book_name,order_date,order_num,subscriber_id,librarian_id);

        boolean create = repo.createOrder(orderRepository);

        return (create ? "Order was created!" : "Order creation was failed!");
    }

    public String getOrder(int id) {
        Order order = repo.getOrder(id);

        return (order == null ? "Order was not found!" : order.toString());
    }

    public String getAllOrder() {
        List<Order> orders = repo.getAllOrders();

        return orders.toString();
    }

}
