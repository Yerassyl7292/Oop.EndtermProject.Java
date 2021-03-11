package kz.aitu.oop.endterm.enteties;

public class Librarian {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String experience;

    public Librarian(int anInt){

    }

    public Librarian(int id, String name,String surname,
                     int age,String experience){
        setId(id);
        setAge(age);
        setName(name);
        setExperience(experience);
        setSurname(surname);
    }

    public Librarian(String name,String surname,int age,String experience){
        setAge(age);
        setName(name);
        setExperience(experience);
        setSurname(surname);
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExperience() {
        return experience;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString(){
        return "id: "+getId() +"\n" + "Full name: "
                + getName() + " "
                + getSurname() + "\n"
                + "age: " + getAge() + "\n"
                + "experience: "+getExperience() + "\n";
    }
}
