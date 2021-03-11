package kz.aitu.oop.endterm.enteties;

public class Order {
    private int id;
    private String name;
    private String book_name;
    private String order_date;
    private int order_num;
    private int librarian_id;
    private String librarian_name;
    private String librarian_surname;
    private int subscriber_id;
    private String subscriber_name;
    private String subscriber_surname;

    public Order(int id,String name){
        setId(id);
        setName(name);
    }

    public Order(String name,String book_name,String order_date,
                   int order_num,int subscriber_id,int librarian_id){
        setId(id);
        setName(name);
        setOrder_date(order_date);
        setOrder_num(order_num);
        setBook_name(book_name);
        setSubscriber_id(subscriber_id);
        setLibrarian_id(librarian_id);
    };

    public Order(int id, String name, String book_name, String order_date,
                   int order_num, String name1, String surname,
                   String name2, String surname1) {
        setLibrarian_id(librarian_id);
        setSubscriber_id(subscriber_id);
        setName(name);
        setBook_name(book_name);
        setOrder_date(order_date);
        setOrder_num(order_num);
        setSubscriber_surname(surname);
        setSubscriber_name(name1);
        setLibrarian_name(name2);
        setLibrarian_surname(surname1);
        setId(id);
    }

    public void setLibrarian_id(int librarian_id) {
        this.librarian_id = librarian_id;
    }

    public int getLibrarian_id() {
        return librarian_id;
    }

    public void setSubscriber_id(int subscriber_id) {
        this.subscriber_id = subscriber_id;
    }

    public int getSubscriber_id() {
        return subscriber_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setSubscriber_surname(String subscriber_surname) {
        this.subscriber_surname = subscriber_surname;
    }

    public String getSubscriber_surname() {
        return subscriber_surname;
    }

    public void setSubscriber_name(String subscriber_name) {
        this.subscriber_name = subscriber_name;
    }

    public String getSubscriber_name() {
        return subscriber_name;
    }

    public void setLibrarian_name(String librarian_name) {
        this.librarian_name = librarian_name;
    }

    public String getLibrarian_name() {
        return librarian_name;
    }

    public void setLibrarian_surname(String librarian_surname) {
        this.librarian_surname = librarian_surname;
    }

    public String getLibrarian_surname() {
        return librarian_surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_name() {
        return book_name;
    }
    @Override
    public String toString() {
        return "order id: " + getId()
                + ", order name: " + getName() + " "
                + ", order date: " + getOrder_date() + "\n"
                + "subscriber name: " + getSubscriber_name() + "\n"
                + "subscriber surname: " + getSubscriber_surname() + "\n"
                + "librarian: " + getLibrarian_name() + "\n"
                + "book name: " + getBook_name();
    }
}
