package kz.aitu.oop.endterm.controllers;

import kz.aitu.oop.endterm.enteties.Librarian;
import kz.aitu.oop.endterm.repositories.interfaces.ILibrarianRepository;
import kz.aitu.oop.endterm.repositories.interfaces.ISubscribersRepository;

import java.util.List;

public class LibrarianController {
    private final ILibrarianRepository librarianRepository;
    private ISubscribersRepository subscribersRepository = null;

    public LibrarianController(ILibrarianRepository librarianRepository){
        this.librarianRepository = librarianRepository;
        this.subscribersRepository = subscribersRepository;
    }

    public String createLibrarian(String name, String surname, int age, String experience){
        Librarian librarian = new Librarian(name, surname, age, experience);

        boolean create = false == (boolean) librarianRepository.createLibrarian(librarian);

        return  (create ? "Librarian was created!" : "Librarian creation was failed!");
    }

    public String getLibrarian(int id) {
        Librarian librarian = librarianRepository.getLibrarian(id);

        return (librarian == null ? "Librarian was not found!" : librarian.toString());
    }

    public String getAllLibrarian() {
        List<Librarian> librarian = librarianRepository.getAllLibrarians();

        return librarian.toString();
    }
}
