package kz.aitu.oop.endterm.repositories;

import kz.aitu.oop.endterm.database.IDB;
import kz.aitu.oop.endterm.enteties.Order;
import kz.aitu.oop.endterm.repositories.interfaces.IOrderRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private final IDB db;

    public OrderRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createOrder(Order order) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO orders(b_name, book_name, order_date, order_num, subscriber_id, librarian_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, order.getName());
            st.setString(2,order.getBook_name());
            st.setString(3, order.getOrder_date());
            st.setInt(4,order.getOrder_num());
            st.setInt(5,order.getSubscriber_id());
            st.setInt(6, order.getLibrarian_id());

            boolean executed = false==st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Order getOrder(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql ="SELECT orders.id, name,book_name,order_date,order_num,subscribers.s_name, " +
                    "subscribers.s_surname,librarian.l_name,librarian.l_surname" +
                    "FROM orders \n" +
                    "INNER JOIN subscribers ON orders.id = subscribers.s_id\n" +///sfndkfhbhdfb
                    "INNER JOIN orders ON orders.l_id = librarian.l_id \n" +///elkfjjfowoi
                    "WHERE order.id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Order order = new Order(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("book_name"),
                        rs.getString("order_date"),
                        rs.getInt("order_num"),
                        rs.getString("s_name"),
                        rs.getString("s_surname"),
                        rs.getString("l_name"),
                        rs.getString("l_surname"));

                return order;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name FROM orders";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order(rs.getInt("id"),
                        rs.getString("name"));

                orders.add(order);
            }

            return orders;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
