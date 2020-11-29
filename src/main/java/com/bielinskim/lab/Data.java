package com.bielinskim.lab;

import com.bielinskim.lab.models.*;

import java.util.ArrayList;
import java.util.List;

 public class Data {


    public static List<Ticket> tickets;
    public static List<Category> categories;
     public static List<Status> statuses;
     public static List<Priority> priorities;
     public static List<Employee> employees;
    public static int ticketId;

    static {

        tickets = new ArrayList<>();
        categories = new ArrayList<>();
        statuses = new ArrayList<>();
        priorities = new ArrayList<>();
        employees = new ArrayList<>();

        categories.add(new Category(1, "Bezpieczeństwo"));
        categories.add(new Category(2, "Konto"));
        categories.add(new Category(3, "Płatności"));
        categories.add(new Category(4, "Usługi"));
        categories.add(new Category(5, "Reklamacja"));
        categories.add(new Category(6, "Awaria"));
        categories.add(new Category(7, "Panel klienta"));
        categories.add(new Category(8, "Inne"));

        statuses.add(new Status(1, "Zgłoszone"));
        statuses.add(new Status(2, "Przydzielone"));
        statuses.add(new Status(3, "W trakcie"));
        statuses.add(new Status(4, "Zakończone"));

        priorities.add(new Priority(1, "Brak"));
        priorities.add(new Priority(2, "Niski"));
        priorities.add(new Priority(3, "Średni"));
        priorities.add(new Priority(4, "Wysoki"));

        employees.add(new Employee(1, "Sebastian Marcinkowski"));
        employees.add(new Employee(2, "Aleksander Domański "));
        employees.add(new Employee(3, "Hanna Borkowska"));
        employees.add(new Employee(4, "Mateusz Dąbrowski"));

        tickets.add(new Ticket(getTicketId(), "Kacper", "Kowalski",  "test123@gmail.com", "555-555-555", new Category(3, "Płatności"), "Title1", "Desc1", new Status(1, "Zgłoszone"), new Priority(4, "Wysoki")));
        tickets.add(new Ticket(getTicketId(), "Paweł", "Nowak",  "test123@gmail.com", "555-555-555", new Category(6, "Awaria"), "Title2", "Desc2", new Status(3, "W trakcie"), new Priority(4, "Wysoki")));
        tickets.add(new Ticket(getTicketId(), "Adam", "Lewandowski",  "test123@gmail.com", "555-555-555", new Category(3, "Płatności"), "Title3", "Desc3", new Status(4, "Zakończone"), new Priority(4, "Wysoki")));

    }
    public static int getTicketId() {
        return ticketId++;
    }
}
