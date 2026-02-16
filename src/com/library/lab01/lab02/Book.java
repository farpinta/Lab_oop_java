package com.library.lab01.lab02;

import java.util.Date;
import java.util.UUID;

public class Book {
    private String name;
    private double price;
    private String author;
    private String isbn;
    private String status;
    private String returnDate;
    private final UUID uuid;

    public Book(String name,  String author, String isbn, double price, String status) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
        this.returnDate = "N/A (Book is available)";
        this.uuid = UUID.randomUUID();
    }

    public void displayDetails() {
        System.out.println("\n - Title:           " + name);
        System.out.println(" - Author:          " + author);
        System.out.println(" - ISBN:            " + isbn);
        System.out.println(" - Price:           " + price);
        System.out.println(" - Status:          " + status);
        System.out.println(" - Return Due Date: " + returnDate);
    }

    public void checkOut(Member member) {
        if (member.getBooksBorrowed() > 3) {
            System.out.println(" Borrow request denied for member " + member.getName());
            return;
        }
        member.setBooksBorrowed(member.getBooksBorrowed() + 1);
        if (status.equals("Available")) {
            status = "Borrowed";
            Date date = new Date();
            returnDate =  (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDay();
            System.out.println("\n   Book \"" + name + "\" has been checked out successfully.");
            System.out.printf("   Book %s (%s) has been borrowed by %s%n", name, uuid, member.getName());
            System.out.println("   Return Due Date: " + returnDate);
        } else {
            System.out.println(" Error: Book \"" + name + "\" is already borrowed and cannot be checked out again.");
        }
    }

    public void returnBook() {
        status = "Available";
        returnDate = "N/A (Book is available)";
        System.out.println("   Book \"" + name + "\" has been returned successfully.");
    }

    public void printSummary() {
        System.out.printf("Book[Title='%s', Status='%s', UUID='%s']%n", name, status, uuid);
    }

    public String getName() {
        return name;
    }

    public String getUUID() {
        return uuid.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}