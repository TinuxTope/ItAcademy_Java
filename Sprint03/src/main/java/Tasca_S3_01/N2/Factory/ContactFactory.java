package Tasca_S3_01.N2.Factory;


import Tasca_S3_01.N2.Address.Address;
import Tasca_S3_01.N2.Phone.Phone;

public interface ContactFactory {
    Address createAddress(String address);
    Phone createPhone(String phoneNumber);
}
