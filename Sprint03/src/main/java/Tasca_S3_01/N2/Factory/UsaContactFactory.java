package Tasca_S3_01.N2.Factory;

import Tasca_S3_01.N2.Address.Address;
import Tasca_S3_01.N2.Address.UsaAddress;
import Tasca_S3_01.N2.Phone.Phone;
import Tasca_S3_01.N2.Phone.UsaPhone;

public class UsaContactFactory implements ContactFactory{
    @Override
    public Address createAddress(String address) {
        return new UsaAddress(address);
    }

    @Override
    public Phone createPhone(String phoneNumber) {
        return new UsaPhone(phoneNumber);
    }
}
