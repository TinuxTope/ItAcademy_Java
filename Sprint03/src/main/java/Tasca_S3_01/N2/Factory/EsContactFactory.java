package Tasca_S3_01.N2.Factory;

import Tasca_S3_01.N2.Address.Address;
import Tasca_S3_01.N2.Address.EsAddress;
import Tasca_S3_01.N2.Phone.EsPhone;
import Tasca_S3_01.N2.Phone.Phone;

public class EsContactFactory implements ContactFactory {
    @Override
    public Address createAddress(String address) {
        return new EsAddress(address);
    }

    @Override
    public Phone createPhone(String phoneNumber) {
        return new EsPhone(phoneNumber);
    }
}
