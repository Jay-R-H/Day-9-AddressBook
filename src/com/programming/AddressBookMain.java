package com.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ContactInfo> arrayPersonDetails = new ArrayList<>();
    static HashMap<String, ArrayList<ContactInfo>> hashmap = new HashMap<>();

    static AddressBookMain userDetails = new AddressBookMain();


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
        System.out.println(arrayPersonDetails);

    }


    public void editDetails() {
        System.out.println("Confirm your first name to edit details: ");
        String confirm_name = sc.next();

        for (int i = 0; i < arrayPersonDetails.size(); i++) {
            if (arrayPersonDetails.get(i).getFirstName().equals(confirm_name)) {
                System.out.println("Select options from below: ");
                System.out.println(
                        "\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip\n7.Mobile number\n8.Email");
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


    public void createAddressBook() {

        while (true) {
            System.out.println("Choose what you want to do: ");
            System.out.println("1.Create new address book.\n2.Edit existing address book.\n3.Display all address books.\n4.exit");
            int choose = sc.nextInt();

            if (choose == 4) {
                System.out.println("Exited");
                break;
            }

            switch (choose) {
                case 1:
                    System.out.println("Enter the name of address book: ");
                    String address_name = sc.next();

                    // condition to check for uniqueness of address book.
                    if (hashmap.containsKey(address_name)) {
                        System.out.println("Address book name exits, enter different name");
                        break;
                    }

                    ArrayList<ContactInfo> new_address_book = new ArrayList<>();
                    arrayPersonDetails = new_address_book;
                    while (true) {
                        System.out.println("Choose what you want to do: ");
                        System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
                        int choose1 = sc.nextInt();

                        if (choose1 == 4) {
                            System.out.println("Exited");
                            break;
                        }
                        switch (choose1) {
                            case 1:
                                userDetails.addDetails();
                                for (int i = 0; i < arrayPersonDetails.size(); i++) {
                                    if (arrayPersonDetails.contains(arrayPersonDetails.get(i).getFirstName())) {
                                        System.out.println("User with field already exists, enter different detail");
                                    } else {
                                        userDetails.addDetails();
                                    }
                                }
                                break;
                            case 2:
                                userDetails.editDetails();
                                break;
                            case 3:
                                userDetails.deleteUser();
                                break;
                            default:
                                System.out.println("Choose valid option");
                                break;
                        }
                        hashmap.put(address_name, arrayPersonDetails);
                        System.out.println(hashmap);
                    }
                    break;

                case 2:
                    System.out.println("Enter the name of address book: ");
                    String address_name_old = sc.next();

                    if (hashmap.containsKey(address_name_old)) {

                        ArrayList<ContactInfo> old_address_book = new ArrayList<>();
                        arrayPersonDetails = old_address_book;
                        arrayPersonDetails = hashmap.get(address_name_old);
                        while (true) {
                            System.out.println("Choose what you want to do: ");
                            System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
                            int choose1 = sc.nextInt();
                            if (choose1 == 4) {
                                System.out.println("Exited");
                                break;
                            }
                            switch (choose1) {
                                case 1:
                                    userDetails.addDetails();
                                    break;
                                case 2:
                                    userDetails.editDetails();
                                    break;
                                case 3:
                                    userDetails.deleteUser();
                                    break;
                                default:
                                    System.out.println("Choose valid option");
                                    break;
                            }
                            hashmap.put(address_name_old, arrayPersonDetails);
                            System.out.println(hashmap);
                        }
                    } else {
                        System.out.println("Enter valid address book name");
                    }
                    break;

                case 3:
                    System.out.println(hashmap);
                    break;

                default:
                    System.out.println("Enter valid option");

            }

        }

    }


    public static void main(String[] args) {

        System.out.println("Welcome to Address Book program ");
        userDetails.createAddressBook();

    }

}


