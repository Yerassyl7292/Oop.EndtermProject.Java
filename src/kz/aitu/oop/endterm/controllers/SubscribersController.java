package kz.aitu.oop.endterm.controllers;

import kz.aitu.oop.endterm.enteties.Books;
import kz.aitu.oop.endterm.enteties.Subscribers;
import kz.aitu.oop.endterm.repositories.interfaces.ISubscribersRepository;

import java.util.List;

public class SubscribersController {
    private final ISubscribersRepository subscribersRepository;

    public SubscribersController(ISubscribersRepository subscribersRepository) {
        this.subscribersRepository = subscribersRepository;
    }

    public String createSubscribers(String name, String surname, boolean gender, int password_no, String dateOfBirthday, String address){
        Subscribers subscribers = new Subscribers(name, surname, gender,password_no, dateOfBirthday, address);
        boolean create = false == subscribersRepository.createSubscriber(subscribers);
        return(create ? "Subscribers was created" : "Subscribers creation was failed!");
    }

    public  String getSubscribers(int id){
        Subscribers subscribers =subscribersRepository.getSubscriber(id);
        return(subscribers == null ? "Subscribers was not found!": subscribers.toString());
    }

    public String getAllSubscribers(){
        List<Subscribers> subscribers =subscribersRepository.getAllSubscribers();
        return subscribers.toString();
    }

    public  String buyBooks(int book_id){
        Books books=(Books)subscribersRepository.buyBook(book_id);
        return (books == null ? "Books was not found!" : books.toString()) ;
    }

}
