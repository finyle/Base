package com.lin.controller;

import com.lin.pojo.Books;
import com.lin.pojo.User;
import com.lin.service.BookService;
import com.lin.service.userService;
import org.apache.jasper.runtime.HttpJspBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.jsp.HttpJspPage;
import java.util.List;

    @Controller
    @RequestMapping("/book")
    public class BookController {


        //返回类型是ResponseEntity(可以添加HttpStatus状态码)
        @RequestMapping(value="enterUser",  method={RequestMethod.POST, RequestMethod.GET})
        public ResponseEntity<User> EnterUser(@RequestBody User user){
            System.out.println(user);
            User check_userName = userService.check(user);
            if (check_userName == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(userService.EnterUser(user), HttpStatus.OK);
        }


        @Autowired
        @Qualifier("BookServiceImpl")
        private BookService bookService;

        @RequestMapping("/allBook")
        public String list(Model model) {
            List<Books> list = bookService.queryAllBook();
            model.addAttribute("list", list);
            return "allbook";
        }

        @RequestMapping("/toAddBook")
        public String toAddPaper() {
            return "addbook";
        }

        @RequestMapping("/addBook")
        public String addPaper(Books books) {
            System.out.println(books);
            bookService.addBook(books);
            return "redirect:/book/allbook";
        }

        @RequestMapping("/toUpdateBook")
        public String toUpdateBook(Model model, int id) {
            Books books = bookService.queryBookById(id);
            System.out.println(books);
            model.addAttribute("book",books );
            return "updatebook";
        }

        @RequestMapping("/updateBook")
        public String updateBook(Model model, Books book) {
            System.out.println(book);
            bookService.updateBook(book);
            Books books = bookService.queryBookById(book.getBookID());
            model.addAttribute("books", books);
            return "redirect:/book/allbook";
        }

        @RequestMapping("/del/{bookId}")
        public String deleteBook(@PathVariable("bookId") int id) {
            bookService.deleteBookById(id);
            return "redirect:/book/allbook";
        }
}
