package kz.aitu.oop.endterm.enteties;

public class Books extends Subscribers{
    private int book_id;
    private String from_;
    private String to_;
    private int read_time;
    private int book_cost;

    public Books(int book_id, String from_, String to_,
                  int read_time, int book_cost) {
        setBook_id(book_id);
        setFrom_(from_);
        setTo_(to_);
        setRead_time(read_time);
        setBook_cost(book_cost);

    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setFrom_(String from_) {
        this.from_ = from_;
    }

    public String getFrom_() {
        return from_;
    }

    public void setTo_(String to_) {
        this.to_ = to_;
    }

    public String getTo_() {
        return to_;
    }

    public void setRead_time(int read_time) {
        this.read_time = read_time;
    }

    public int getRead_time() {
        return read_time;
    }

    public void setBook_cost(int book_cost) {
        this.book_cost = book_cost;
    }

    public int getBook_cost() {
        return book_cost;
    }

    @Override
    public String toString() {
        return "Book id:" + getBook_id()
                + ", till: " + getFrom_() + ", until: " + getTo_()
                + ", cost: " + getBook_cost()
                + ", reading time : " + getRead_time();
    }
}
