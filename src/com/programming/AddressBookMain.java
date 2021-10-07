package com.programming;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    private static Scanner sc = new Scanner(System.in);
    static ArrayList<ContactInfo> arrayPersonDetails = new ArrayList<>();

    /*
     * Method to Add contact details of a person and storing it an array.
     */
    public void addDetails() {
        ContactInfo contact_details = new ContactInfo();

        System.out.println("Enter First name: ");
        contact_details.setFirstName(sc.next());
        System.out.println("Enter Last name: ");
        contact_details.setLastName(sc.next());
        System.out.println("Enter Address: ");
        contact_details.setAddress(sc.next());
        System.out.println("Enter your City: ");
        contact_details.setCity(sc.next());
        System.out.println("Enter your State: ");
        contact_details.setState(sc.next());
        System.out.println("Enter Zip code: ");
        contact_details.setZip(sc.nextLong());
        System.out.println("Enter your Phone Number: ");
        contact_details.setPhoneNumber(sc.nextLong());
        System.out.println("Enter your E-mail: ");
        contact_details.setEmail(sc.next());

        arrayPersonDetails.add(contact_details);
    }

    public void editDetails() {
        System.out.println("Confirm your first name to edit details: ");
        String confirm_name = sc.next();

        for (int i = 0; i < arrayPersonDetails.size(); i++) {
            if (arrayPersonDetails.get(i).getFirstName().equals(confirm_name)) {
                System.out.println("Select form below to change: ");
                System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip\n7.Mobile number\n8.Email");
                int edit = sc.nextInt();

                switch (edit) {
                    case 1:
                        System.out.println("Enter new first name");
                        arrayPersonDetails.get(i).setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter new Last name");
                        arrayPersonDetails.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter new Address");
                        arrayPersonDetails.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter new City");
                        arrayPersonDetails.get(i).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter new State");
                        arrayPersonDetails.get(i).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter new Zip");
                        arrayPersonDetails.get(i).setZip(sc.nextLong());
                        break;
                    case 7:
                        System.out.println("Enter new Mobile number");
                        arrayPersonDetails.get(i).setPhoneNumber(sc.nextLong());
                        break;
                    case 8:
                        System.out.println("Enter new E-mail");
                        arrayPersonDetails.get(i).setEmail(sc.next());
                        break;
                }
                System.out.println("Edited list is: ");
                System.out.println(arrayPersonDetails);

            } else
                System.out.println("Enter valid First name");
        }

    }

    public void deleteUser() {
        System.out.println("Confirm your first name to delete contact");
        String confirmName = sc.next();
        for (int i = 0; i < arrayPersonDetails.size(); i++) {

            if (arrayPersonDetails.get(i).getFirstName().equals(confirmName)) {

                arrayPersonDetails.remove(i);
            } else {
                System.out.println("Enter valid first name");

            }

        }
        System.out.println("User details deleted.");
        System.out.println(arrayPersonDetails);

    }


    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program ");

        AddressBookMain userDetails = new AddressBookMain();
        userDetails.addDetails();

        while (true) {
            System.out.println("Choose what you want to do: ");
            System.out.println("1.Edit details.\n2.Delete contact.\n3.Add another person details");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    userDetails.editDetails();
                    break;
                case 2:
                    userDetails.deleteUser();
                    break;
                case 3:
                    userDetails.addDetails();
                    break;

                default:
                    System.out.println("Choose valid option");
                    break;
            }

        }

    }
}


class ContactInfo {
    private String firstName, lastName, address, city, state, email;
    private long zip, phoneNumber;

    /* Generating setters and getters for class */
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
