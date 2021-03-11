package kz.aitu.oop.endterm.repositories;

import kz.aitu.oop.endterm.database.IDB;
import kz.aitu.oop.endterm.enteties.Librarian;
import kz.aitu.oop.endterm.repositories.interfaces.ILibrarianRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarianRepository implements ILibrarianRepository {
    private final IDB db;

    public LibrarianRepository(IDB db) {
        this.db = db;
    }

    @Override
    public Object createLibrarian(Librarian librarian) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO librarian(l_name, l_surname, age, experience) VALUES (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, librarian.getName());
            st.setString(2, librarian.getSurname());
            st.setInt(3, librarian.getAge());
            st.setString(4, librarian.getExperience());

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
            return false;
        }
    }

    @Override
    public Librarian getLibrarian(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT l_id,l_name, l_surname,age,experience FROM Pilot WHERE l_id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Librarian librarian = new Librarian(rs.getInt("l_id"),
                        rs.getString("l_name"),
                        rs.getString("l_surname"),
                        rs.getInt("age"),
                        rs.getString("experience")
                );

                return librarian;
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
    public List<Librarian> getAllLibrarians() {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "SELECT l_id, l_name, s_surname, age, experience  FROM librarian";
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(sql);
                List<Librarian> librarians = new ArrayList<>();
                while (rs.next()) {
                    Librarian librarian = new Librarian(rs.getInt("l_id"),
                            rs.getString("l_name"),
                            rs.getString("l_surname"),
                            rs.getInt("age"),
                            rs.getString("experience"));

                    librarians.add(librarian);
                }

                return librarians;
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