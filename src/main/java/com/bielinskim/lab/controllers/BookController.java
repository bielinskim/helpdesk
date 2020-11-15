package com.bielinskim.lab.controllers;

import com.bielinskim.lab.models.Book;
import com.bielinskim.lab.models.CoverType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes(value = {"obj1", "obj2"})
public class BookController {

    ArrayList<Book> bookList = new ArrayList<Book>();
    List<CoverType> list = new ArrayList<CoverType>();


    public BookController() {
        list.add(new CoverType(1, "Oprawa twarda tradycyjna"));
        list.add(new CoverType(2, "Oprawa twarda przemysłowa"));
        list.add(new CoverType(3, "Oprawa klejona"));
        list.add(new CoverType(4, "Oprawa szyta"));

        var book = new Book();
        book.setId(1l);
        book.setTitle("W pustyni i w puszczy");
        book.setAuthor("Henryk Sienkiewicz");
        book.setReleaseDate(LocalDate.of(2005, 12, 23));
        book.setPrice(39.00f);
        book.setBestseller(true);
        book.setCoverType(list.get(2));

        bookList.add(book);
        bookList.add(new Book(2l, "Andrzej Sapkowski", "Sezon burz", LocalDate.of(2008, 11, 13), 39.87f, true, list.get(1)));
        bookList.add(new Book(3l, "Tony Halik", "Moja wielka przygoda", LocalDate.of(1988, 11, 13), 29.87f, true, list.get(3)));


    }

    @GetMapping(path={"/book", "/book/{id}"})
    public String getBookController(Model model, @PathVariable("id") Optional<Long> eid){


        if(eid.isPresent()) {
            var book = bookList.stream().filter(item -> ((Book) item).getId() == eid.get()).findFirst();
            model.addAttribute(book.get());
        } else {
            var book = bookList.stream().filter(item -> ((Book) item).getId() == 1).findFirst();
            model.addAttribute(book.get());
        }
        return "book";
    }

    @GetMapping("/list")
    public String showList(Model model) {

        model.addAttribute("books", bookList);
        return "bookList";
    }

    @GetMapping(path={"/showForm", "/showForm/{id}"})
    public String showForm(Model model, @PathVariable("id") Optional<Long> eid) {

        if(eid.isPresent()) {
            var book = bookList.stream().filter(item -> ((Book) item).getId() == eid.get()).findFirst();
            model.addAttribute(book.get());
            model.addAttribute("obj1", new Object1());
            return "editBook";
        } else {
            var book = new Book();
            model.addAttribute(book);
            model.addAttribute("obj1", new Object1());
            return "addBook";
        }

    }
    @PostMapping(path={"/showForm", "/showForm/{id}"})
    public String processForm(@ModelAttribute("book") Book book,  @ModelAttribute("coverTypesList") CoverType covers, @ModelAttribute(value = "obj1") Object1 object1, @PathVariable("id") Optional<Long> eid) {


        var coverType = list.stream().filter(ct -> ((CoverType) ct).getId() == book.getCoverType().getId()).findFirst();
        book.setCoverType(coverType.get());
        if(!eid.isPresent()) {
            bookList.add(book);
        } else {
            for(int i=0; i<bookList.size(); i++) {
                if(bookList.get(i).getId() == eid.get()) {
                    bookList.set(i, book);
                }
            }
        }
        return "book";

    }
    @ModelAttribute("coverTypesList")
    public List<CoverType> loadCoverTypes() throws Exception {
        return list;
    }
    @ModelAttribute(value = "obj2")
    public List<Object2> loadDependencies() {
        System.out.println("wywołano metodę loadDependencies");
        List<Object2> dependenciesList = new ArrayList<Object2>();
        return dependenciesList;
    }

    class Object1{}
    class Object2{}

}
