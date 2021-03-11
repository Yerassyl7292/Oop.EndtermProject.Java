package kz.aitu.oop.endterm.enteties;

public class Subscribers {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private int password_no;
    private String Birthday;
    private String address;
    private String dateOfBirthday;

    public Subscribers(){}

    public Subscribers(int id,String name,String surname){
        setId(id);
        setName(name);
        setSurname(surname);
    }

    public Subscribers(String name,String surname,boolean gender,int passport_no,String dateOfBirthday,String adress){
        setName(name);
        setSurname(surname);
        setGender(gender);
        setPassword_no(password_no);
        setDateOfBirthday(Birthday);
        setAddress(address);
    };

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setPassword_no(int password_no) {
        this.password_no = password_no;
    }

    public int getPassword_no() {
        return password_no;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public boolean isGender() {
        return gender;
    }
    @Override
    public String toString() {
        return "Librarian id:" + getId() + ", name: " + getName()
                + ", surname: " + getSurname() + ", gender: " + isGender()
                + ", date of birthday :" + getDateOfBirthday()
                + ", address : " + getAddress();
    }
}
