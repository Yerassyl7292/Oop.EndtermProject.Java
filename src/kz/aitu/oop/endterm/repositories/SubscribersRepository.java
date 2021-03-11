package kz.aitu.oop.endterm.repositories;

import kz.aitu.oop.endterm.database.IDB;
import kz.aitu.oop.endterm.enteties.Books;
import kz.aitu.oop.endterm.enteties.Subscribers;
import kz.aitu.oop.endterm.repositories.interfaces.ISubscribersRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscribersRepository implements ISubscribersRepository {
    private final IDB db;

    public SubscribersRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createSubscriber(Subscribers subscribers) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO subscribers (s_name, s_surname,gender, pswrd_no, Birthday, address) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, subscribers.getName());
            st.setString(2, subscribers.getSurname());
            st.setBoolean(3, subscribers.isGender());
            st.setInt(4 ,subscribers.getPassword_no());
            st.setString(5,subscribers.getDateOfBirthday());
            st.setString(6, subscribers.getAddress());

            boolean executed = st.execute();
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
    public Subscribers getSubscriber(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT s_id,s_name, s_surname FROM subscribers WHERE s_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Subscribers subscribers = new Subscribers
                        (rs.getInt("s_id"),
                                rs.getString("s_name"),
                                rs.getString("s_surname"));

                return subscribers;
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
    public List<Subscribers> getAllSubscribers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT s_id, s_name,s_surname FROM subscribers";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Subscribers> subscribers = new ArrayList<>();
            while (rs.next()) {
                Subscribers subscribers1 = new Subscribers(rs.getInt("s_id"),
                        rs.getString("s_name"),
                        rs.getString("s_surname"));

                subscribers.add(subscribers1);
            }

            return subscribers;
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
    public Subscribers buyBook(int book_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT book_id FROM Books WHERE book_id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, book_id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Subscribers books = new Books
                        (rs.getInt("book_id"),
                                rs.getString("from_"),
                                rs.getString("to_"),
                                rs.getInt("read_time"),
                                rs.getInt("book_cost"));

                return books;
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
}
