package Tasca_S3_01.N2;

import Tasca_S3_01.N2.Address.Address;
import Tasca_S3_01.N2.Factory.ContactFactory;
import Tasca_S3_01.N2.Factory.EsContactFactory;
import Tasca_S3_01.N2.Factory.UsaContactFactory;
import Tasca_S3_01.N2.Phone.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private List<Address> addresses;
    private List<Phone> phones;
    private Scanner scanner;

    public ContactManager() {
        this.addresses = new ArrayList<>();
        this.phones = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        Boolean running = true;
        while (running) {
            System.out.println("Enter country (ES/USA) or 'exit' to quit:");
            String country = scanner.nextLine().trim();
            if (country.equalsIgnoreCase("exit")) {
                running = false;
            }

            ContactFactory factory;
            if (country.equalsIgnoreCase("ES")) {
                factory = new EsContactFactory();
            } else if (country.equalsIgnoreCase("USA")) {
                factory = new UsaContactFactory();
            } else {
                System.out.println("Invalid country.");
                continue;
            }

            System.out.println("Enter address:");
            String address = scanner.nextLine();
            System.out.println("Enter phone number:");
            String phoneNumber = scanner.nextLine();

            addContact(factory, address, phoneNumber);
            System.out.println("Contact added.");
        }

        listContacts();
        scanner.close();
    }

    public void addContact(ContactFactory factory, String address, String phoneNumber) {
        this.addresses.add(factory.createAddress(address));
        this.phones.add(factory.createPhone(phoneNumber));
    }

    public void listContacts() {
        System.out.println("Addresses:");
        for (Address address : addresses) {
            System.out.println(address.getAddress());
        }
        System.out.println("Phone Numbers:");
        for (Phone phone : phones) {
            System.out.println(phone.getPhoneNumber());
        }
    }
}
