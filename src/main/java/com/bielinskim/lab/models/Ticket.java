package com.bielinskim.lab.models;


import javax.validation.constraints.*;
import java.util.Date;

public class Ticket {

    int id;

    //@NotBlank
    @NotEmpty
    @Size(min=2, max=20)
    String firstName;

    //@NotBlank
    @NotEmpty
    @Size(min=2, max=20)
    String lastName;

    @NotEmpty
    @Size(max=30)
    @Email
    String emailAddress;

    @NotEmpty
    @Size(max=30)
    @Pattern(regexp="(?<!\\w)(\\(?(\\+|00)?48\\)?)?[ -]?\\d{3}[ -]?\\d{3}[ -]?\\d{3}(?!\\w)")
    String phoneNumber;

    Category category;

    @NotEmpty
    @Size(min=3, max=50)
    String title;

    @NotEmpty
    @Size(min=5, max=2000)
    String description;

    Status status;
    Priority priority;
    Employee employee;
   Date createdDate;

    public Ticket() {
        this.category = new Category();
        this.status = new Status();
        this.priority = new Priority();
        this.employee = new Employee();
        this.createdDate = new Date();
    }

    public Ticket(int id, String firstName, String lastName, String emailAddress, String phoneNumber, Category category, String title, String description, Status status, Priority priority) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.employee = new Employee();
        this.createdDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
