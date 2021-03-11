package kz.aitu.oop.endterm.repositories.interfaces;
import kz.aitu.oop.endterm.enteties.Librarian;

import java.util.List;

public interface ILibrarianRepository {
    Object createLibrarian(Librarian librarian);
    Librarian getLibrarian(int id);
    List<Librarian> getAllLibrarians();
}
