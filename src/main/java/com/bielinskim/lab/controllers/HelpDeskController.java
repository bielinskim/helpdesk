package com.bielinskim.lab.controllers;

import com.bielinskim.lab.Data;
import com.bielinskim.lab.models.*;
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

    @GetMapping("/tickets")
    public String showList(Model model) {
        model.addAttribute("tickets", Data.tickets);
        model.addAttribute("view", "tickets");
        return "tickets";
    }

    @GetMapping({"/addTicket", "/editTicket"})
    public String showForm(Model model, Optional<Integer> id) {

        if(id.isPresent()) {
            var ticket = Data.tickets.stream().filter(item -> item.getId() == id.get()).findFirst();
            model.addAttribute(ticket.get());
           model.addAttribute("view", "editTicket");
            return "editTicket";
        } else {
            var ticket = new Ticket();
            model.addAttribute(ticket);
            model.addAttribute("view", "addTicket");
            return "addTicket";
        }
    }

    @PostMapping({"/addTicket", "/editTicket"})
    public String processForm(@Valid @ModelAttribute("ticket") Ticket ticket, BindingResult result, Optional<Integer> id) {

        if(result.hasErrors() && !id.isPresent()){
            return "addTicket";
        } else if(result.hasErrors() && id.isPresent()) {
            return "editTicket";
        }


        var category = Data.categories.stream().filter(cat-> cat.getId() == ticket.getCategory().getId()).findFirst();
        ticket.setCategory(category.get());
        if(!id.isPresent()) {
            addTicket(ticket);
            return "ticket";
        } else {
            editTicket(ticket, id.get());
            return "editTicket";

        }
    }

    public void addTicket(Ticket ticket) {
        ticket.setId(Data.getTicketId());
        var status = Data.statuses.stream().filter(stat-> stat.getId() == 1).findFirst();
        ticket.getStatus().setId(status.get().getId());
        ticket.getStatus().setName(status.get().getName());
        var priority = Data.priorities.stream().filter(prio-> prio.getId() == 1).findFirst();
        ticket.getPriority().setId(priority.get().getId());
        ticket.getPriority().setName(priority.get().getName());
        Data.tickets.add(ticket);
    }

    public void editTicket(Ticket ticket, int id) {

                //var priority = Data.categories.stream().filter(prio-> prio.getId() == ticket.getPriority().getId()).findFirst();
                //ticket.getEmployee().setName(priority.get().getName());

                var employee = Data.employees.stream().filter(emp-> emp.getId() == ticket.getEmployee().getId()).findFirst();
                ticket.getEmployee().setName(employee.get().getName());

                var status = Data.statuses.stream().filter(stat-> stat.getId() == ticket.getStatus().getId()).findFirst();
                ticket.getStatus().setName(status.get().getName());

                var priority = Data.priorities.stream().filter(prio-> prio.getId() == ticket.getPriority().getId()).findFirst();
                ticket.getPriority().setName(priority.get().getName());

                //var employee = findEmployee(ticket.getEmployee().getId());

                //Data.tickets.set(i, ticket);

    }


    @ModelAttribute("categories")
    public List<Category> loadCategories() throws Exception {
        return Data.categories;
    }
    @ModelAttribute("statuses")
    public List<Status> loadStatuses() throws Exception {
        return Data.statuses;
    }
    @ModelAttribute("priorities")
    public List<Priority> loadPriorities() throws Exception {
        return Data.priorities;
    }
    @ModelAttribute("employees")
    public List<Employee> loadEmployees() throws Exception {
        return Data.employees;
    }

}
