package bookstore.bookstore.controller;


import bookstore.bookstore.dal.BookRepository;
import bookstore.bookstore.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Show all students
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index(){

        return "This is bookstore";

    }

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<Book> books =  (List<Book>) bookRepository.findAll(); // haeta tietokannasta autot
        model.addAttribute("books", books); // välitetään autolista templatelle model-olion avulla
        return "booklist"; // DispatherServlet saa tämän template-nimen ja kutsuu seuraavaksi booklist.html-templatea,
        // joka prosessoidaan palvelimella
    }

    // RESTful service to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    // RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }

    // Save new book
    @RequestMapping(value = "/books/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:booklist";
    }



}
