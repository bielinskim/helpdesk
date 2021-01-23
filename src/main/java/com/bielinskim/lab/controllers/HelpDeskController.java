package com.bielinskim.lab.controllers;

import com.bielinskim.lab.models.*;
import com.bielinskim.lab.repositories.*;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("ticket")
public class HelpDeskController {

    private TicketRepository ticketRepository;
    private CategoryRepository categoryRepository;
    private EmployeeRepository employeeRepository;
    private PriorityRepository priorityRepository;
    private StatusRepository statusRepository;

    public HelpDeskController(TicketRepository ticketRepository, CategoryRepository categoryRepository, EmployeeRepository employeeRepository, PriorityRepository priorityRepository, StatusRepository statusRepository) {
        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.employeeRepository = employeeRepository;
        this.priorityRepository = priorityRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping(path={"/", "/index"})
    public String index(Model model) {
        model.addAttribute("view", "home");
        return "index";
    }

    @GetMapping("/knowledgeBase")
    public String knowledgeBase(Model model) {
        model.addAttribute("view", "knowledgeBase");
        return "knowledgeBase";
    }

    @GetMapping("/knowledgeBase/{name}")
    public String showInfo(Model model, @PathVariable String name) {
        model.addAttribute("view", name);
        return "info";
    }

    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE"})
    @GetMapping("/tickets")
    public String showList(Model model) {
        model.addAttribute("tickets", ticketRepository.findAll());
        model.addAttribute("view", "tickets");
        return "tickets";
    }

    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE", "ROLE_USER"})
    @GetMapping({"/addTicket", "/editTicket"})
    public String showForm(Model model, Optional<Integer> id) {

        if(id.isPresent()) {
            model.addAttribute(ticketRepository.findById(id.get()).orElseThrow());
           model.addAttribute("view", "editTicket");
            return "editTicket";
        } else {
            var ticket = new Ticket();
            model.addAttribute(ticket);
            model.addAttribute("view", "addTicket");
            return "addTicket";
        }
    }

    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE", "ROLE_USER"})
    @PostMapping({"/addTicket", "/editTicket"})
    public String processForm(@Valid @ModelAttribute("ticket") Ticket ticket, BindingResult result, Optional<Integer> id) {

        if(result.hasErrors() && !id.isPresent()){
            return "addTicket";
        } else if(result.hasErrors() && id.isPresent()) {
            return "editTicket";
        }

        if(!id.isPresent()) {
            addTicket(ticket);
        }

        ticketRepository.save(ticket);

        if(!id.isPresent()) {
            return "ticket";
        } else {
            return "editTicket";
        }
    }

    public void addTicket(Ticket ticket) {
        Category category = categoryRepository.findById(ticket.getCategory().getId()).orElseThrow();
        ticket.setCategory(category);
        Priority priority = new Priority();
        priority.setId(1);
        ticket.setPriority(priority);
        Status status = new Status();
        status.setId(1);
        ticket.setStatus(status);

    }

    @ModelAttribute("categories")
    public List<Category> loadCategories() {
        return categoryRepository.findAll();
    }
    @ModelAttribute("statuses")
    public List<Status> loadStatuses() {
        return statusRepository.findAll();
    }
    @ModelAttribute("priorities")
    public List<Priority> loadPriorities() {
        return priorityRepository.findAll();
    }
    @ModelAttribute("employees")
    public List<Employee> loadEmployees() {
        return employeeRepository.findAll();
    }
}
