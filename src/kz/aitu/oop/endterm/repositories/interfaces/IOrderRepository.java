package kz.aitu.oop.endterm.repositories.interfaces;

import kz.aitu.oop.endterm.enteties.Order;

import java.util.List;

public interface IOrderRepository {
    boolean createOrder(Order order);
    Order getOrder(int id);
    List<Order> getAllOrders();
}
