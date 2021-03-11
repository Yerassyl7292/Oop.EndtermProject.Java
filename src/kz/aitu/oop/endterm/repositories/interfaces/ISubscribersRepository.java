package kz.aitu.oop.endterm.repositories.interfaces;

import kz.aitu.oop.endterm.enteties.Subscribers;

import java.util.List;

public interface ISubscribersRepository {
    boolean createSubscriber(Subscribers subscribers);
    Subscribers getSubscriber(int id);
    List<Subscribers> getAllSubscribers();
    Subscribers buyBook(int book_id);
}
