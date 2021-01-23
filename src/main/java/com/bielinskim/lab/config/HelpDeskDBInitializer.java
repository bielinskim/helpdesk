package com.bielinskim.lab.config;


import com.bielinskim.lab.repositories.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bielinskim.lab.Data;

@Configuration
public class HelpDeskDBInitializer {

    private TicketRepository ticketRepository;
    private CategoryRepository categoryRepository;
    private EmployeeRepository employeeRepository;
    private PriorityRepository priorityRepository;
    private StatusRepository statusRepository;

    public HelpDeskDBInitializer(TicketRepository ticketRepository, CategoryRepository categoryRepository, EmployeeRepository employeeRepository, PriorityRepository priorityRepository, StatusRepository statusRepository) {
        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.employeeRepository = employeeRepository;
        this.priorityRepository = priorityRepository;
        this.statusRepository = statusRepository;
    }

    @Bean
    InitializingBean init() {

        return () -> {
            if(categoryRepository.findAll().isEmpty()) {

                for(int i=0; i<Data.categories.size(); i++) {
                    categoryRepository.save(Data.categories.get(i));
                }

                for(int i=0; i<Data.employees.size(); i++) {
                    employeeRepository.save(Data.employees.get(i));
                }

                for(int i=0; i<Data.priorities.size(); i++) {
                    priorityRepository.save(Data.priorities.get(i));
                }

                for(int i=0; i<Data.statuses.size(); i++) {
                    statusRepository.save(Data.statuses.get(i));
                }

                for(int i=0; i<Data.tickets.size(); i++) {
                    ticketRepository.save(Data.tickets.get(i));
                }

            }
        };

    }


}
