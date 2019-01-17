package service;

import dao.LibraryDAOImpl;
import entity.Book;
import entity.Library;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class BookToLibraryServiceImpl implements BookToLibraryService {

    @Inject
    private LibraryDAOImpl libraryDAO;

    @Inject
    private Logger logger;

    @Override
    public boolean addBookToLibrary(Book book, Library library) {
        List<Book> bib = library.getBooksInLibrary();
        if (countOccurrenceOfBookInBib(book, bib) < 5){
            bib.add(book);
            libraryDAO.update(library);
            logger.info("Book successfully added to library");
            return true;
        }
        return false;
    }

    private int countOccurrenceOfBookInBib(Book book, List<Book> bib){
        int count = 0;
        for (Book b : bib){
            if (b.equals(book))
                count++;
        }
        return count;
    }
}
