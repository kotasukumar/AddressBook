package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class BookList {

    static ArrayList<AddressBookMain> books=new ArrayList<AddressBookMain>();

    void addBook(String name, AddressBookMain book) {
        book.bookName=name;
        this.books.add(book);
        System.out.println("Book "+name+" added successfully");

    }

    void addInfo(Contact value) {
        Scanner scan=new Scanner(System.in);
        System.out.println("First Name :");
        value.firstName = scan.nextLine();
        System.out.println("Last Name :");
        value.lastName = scan.nextLine();
        System.out.println("Enter the address :");
        value.address = scan.nextLine();
        System.out.println("Enter city : ");
        value.city = scan.nextLine();
        System.out.println("Enter state : ");
        value.state = scan.nextLine();
        System.out.println("Enter Phone Number : ");
        value.phoneNumber = scan.nextLine();
        System.out.println("Enter Email : ");
        value.email = scan.nextLine();
        System.out.println("Enter zip : ");
        value.zip = scan.nextLine();
    }
    void operations(ArrayList<AddressBookMain> books,int i) {
        Scanner input=new Scanner(System.in);
        int condition1=0;///This is for checking the contact name exist or not
        int condition=0; ///This is condition for running while loop
        while(condition==0) {
            System.out.println("Do you want to add/edit/delete contact (0/1/2) :Press 3 to go back to main menu");
            int response=input.nextInt();
            switch (response) {
                case 0:
                    Contact contact=new Contact();
                    contact.addContact();
                    books.get(i).list.add(contact);
                    System.out.println("Contact added successfully");

                    break;
                case 1:
                    if(books.get(i).list.size()==0) {System.out.println("Addressbook is empty");}
                    else {
                        System.out.println("Enter the first name of person you want to edit :");
                        Scanner scan1=new Scanner(System.in);
                        String name1=scan1.nextLine();
                        for(Contact value:books.get(i).list) {
                            if(value.firstName.equals(name1)) {
                                addInfo(value);
                                System.out.println("Contact updated successfully");
                                condition1=1;
                                break;
                            }

                            if(condition1==0) {
                                System.out.println("Contact doesn't exist with the given name "+name1);
                            }

                        }
                    }
                    break;
                case 2:
                    if(books.get(i).list.size()==0) {System.out.println("Addressbook is empty");}
                    else {
                        System.out.println("Enter the first name of person you want to delete :");
                        Scanner scan2=new Scanner(System.in);
                        String name2=scan2.nextLine();
                        for(Contact value:books.get(i).list) {
                            if(value.firstName.equals(name2)) {
                                books.get(i).list.remove(value);
                                System.out.println("Contact deleted successfully");
                                condition1=1;
                                break;
                            }
                        }
                        if(condition1==0) {
                            System.out.println("Contact doesn't exist with the given name "+name2);
                        }
                    }
                    break;
                case 3:
                    condition=1;
                    break;
                default:
                    System.out.println("Enter valid command");
                    break;
            }
        }
    }
    int checkBook(String name) {
        int result=0;
        if( this.books.size()==0) {
            System.out.println("Booklist was empty. "+name+" is created.");


        }
        else {
            int track=0;
            for (int i = books.size() - 1; i >= 0; --i) {
                if (books.get(i).bookName.contains(name)) {

                    System.out.println("Book exist please go ahead");
                    operations(books,i);
                    track=1;
                    result=1;
                    break;

                }
            }
            if(track==0) {
                System.out.println("Book doesn't exist with the given name. "+name+" is created");

            }


        }
        return result;
    }
}
