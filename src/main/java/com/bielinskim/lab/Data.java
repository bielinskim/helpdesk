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

        categories.add(new Category( "Bezpieczeństwo"));
        categories.add(new Category( "Konto"));
        categories.add(new Category( "Płatności"));
        categories.add(new Category( "Usługi"));
        categories.add(new Category( "Reklamacja"));
        categories.add(new Category( "Awaria"));
        categories.add(new Category( "Panel klienta"));
        categories.add(new Category("Inne"));

        statuses.add(new Status("Zgłoszone"));
        statuses.add(new Status( "Przydzielone"));
        statuses.add(new Status( "W trakcie"));
        statuses.add(new Status( "Zakończone"));

        priorities.add(new Priority("Brak"));
        priorities.add(new Priority("Niski"));
        priorities.add(new Priority( "Średni"));
        priorities.add(new Priority( "Wysoki"));

        employees.add(new Employee("Sebastian Marcinkowski"));
        employees.add(new Employee("Aleksander Domański "));
        employees.add(new Employee( "Hanna Borkowska"));
        employees.add(new Employee("Mateusz Dąbrowski"));

        tickets.add(new Ticket("Kacper", "Kowalski",  "test123@gmail.com", "555-555-555", new Category(3, "Płatności"), "Title1", "Desc1", new Status(1, "Zgłoszone"), new Priority(4, "Wysoki")));
        tickets.add(new Ticket( "Paweł", "Nowak",  "test123@gmail.com", "555-555-555", new Category(6, "Awaria"), "Title2", "Desc2", new Status(3, "W trakcie"), new Priority(4, "Wysoki")));
        tickets.add(new Ticket( "Adam", "Lewandowski",  "test123@gmail.com", "555-555-555", new Category(3, "Płatności"), "Title3", "Desc3", new Status(4, "Zakończone"), new Priority(4, "Wysoki")));

    }
    public static int getTicketId() {
        return ticketId++;
    }
}
