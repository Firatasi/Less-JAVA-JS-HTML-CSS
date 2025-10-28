/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.arraylist_librarymanagementsystem;

import java.util.ArrayList;

class Book {

    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }
    
     public String getAuthor() { 
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{"
                + "title='" + title + '\''
                + ", author='" + author + '\''
                + ", isbn='" + isbn + '\''
                + ", isAvailable=" + isAvailable
                + '}';
    }
}

class Member {

    private String name;
    private int memberId;
    private ArrayList<Book> borrowedBooks;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() >= 5) {
            System.out.println("Üye zaten 5 kitap ödünç almış.");
            return false;
        }
        borrowedBooks.add(book);
        return true;
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member{"
                + "name='" + name + '\''
                + ", memberId=" + memberId
                + ", borrowedBooks=" + borrowedBooks
                + '}';
    }
}

class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kitap eklendi: " + book.getTitle());
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Üye eklendi: " + member.getName());
    }

    public void borrowBook(int memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);

        if (member == null) {
            System.out.println("Üye bulunamadı.");
            return;
        }
        if (book == null || !book.isAvailable()) {
            System.out.println("Kitap mevcut değil.");
            return;
        }

        if (member.borrowBook(book)) {
            book.setAvailable(false);
            System.out.println(member.getName() + " kitabı ödünç aldı: " + book.getTitle());
        }
    }

    public void returnBook(int memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);

        if (member == null || book == null) {
            System.out.println("Üye veya kitap bulunamadı.");
            return;
        }

        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.setAvailable(true);
            System.out.println(member.getName() + " kitabı iade etti: " + book.getTitle());
        } else {
            System.out.println("Bu kitap bu üyede bulunmuyor.");
        }
    }

    public void listBooks() {
        System.out.println("Kütüphanedeki Kitaplar:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listMembers() {
        System.out.println("Kayıtlı Üyeler:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    private Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void removeBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Kitap bulunamadı.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Kitap ödünç verildiği için silinemez.");
            return;
        }
        books.remove(book);
        System.out.println("Kitap silindi: " + book.getTitle());
    }

    public void removeMember(int memberId) {
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Üye bulunamadı.");
            return;
        }
        if (!member.getBorrowedBooks().isEmpty()) {
            System.out.println("Üyenin iade edilmemiş kitapları olduğu için silinemez.");
            return;
        }
        members.remove(member);
        System.out.println("Üye silindi: " + member.getName());
    }

    public void searchBooks(String keyword) {
        System.out.println("Arama sonuçları:");
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
            }
        }

    }
    
    public void listBorrowedBooks(int memberId) {
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Üye bulunamadı.");
            return;
        }
        System.out.println(member.getName() + " tarafından ödünç alınan kitaplar:");
        for (Book book : member.getBorrowedBooks()) {
            System.out.println(book);
        }
    }
}

public class ArrayList_LibraryManagementSystem {

    public static void main(String[] args) {

        Library library = new Library();

        // Kitaplar ekleniyor
        library.addBook(new Book("1984", "George Orwell", "12345"));
        library.addBook(new Book("Sefiller", "Victor Hugo", "67890"));
        library.addBook(new Book("Suç ve Ceza", "Dostoyevski", "11223"));

        // Üyeler ekleniyor
        library.addMember(new Member("Ali", 1));
        library.addMember(new Member("Ayşe", 2));

        // Kitap arama
        library.searchBooks("1984");

        // Kitap silme
        library.removeBook("67890");

        // Üye silme
        library.removeMember(2);

        // Üyenin kitaplarını listeleme
        library.listBorrowedBooks(1);

        // İşlemler
        library.borrowBook(1, "12345");
        library.borrowBook(2, "67890");
        library.borrowBook(1, "11223");

        // Listeleme
        library.listBooks();
        library.listMembers();

        // Kitap iade
        library.returnBook(1, "12345"); // Ali 1984 kitabını iade ediyor
        library.listBooks();
    }
}
