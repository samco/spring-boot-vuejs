package au.id.couter.springbootvuejs.controller;

import au.id.couter.springbootvuejs.domain.Book;
import au.id.couter.springbootvuejs.domain.Loan;
import au.id.couter.springbootvuejs.repository.BookRepository;
import au.id.couter.springbootvuejs.repository.LoanRepository;
import au.id.couter.springbootvuejs.repository.UserRepository;
import au.id.couter.springbootvuejs.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class BackendController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LoanRepository loanRepository;

    @RequestMapping(path = "/users")
    public @ResponseBody Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(path = "/books")
    public @ResponseBody Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(path="/loan/user/{userId}")
    public @ResponseBody Iterable<Loan> findLoansByUserId(@PathVariable("userId") long userId) {
        return loanRepository.findByUserId(userId);
    }
}
