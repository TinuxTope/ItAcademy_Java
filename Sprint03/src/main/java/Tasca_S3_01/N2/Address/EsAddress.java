package Tasca_S3_01.N2.Address;

public class EsAddress implements Address{
    private String address;

    public EsAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return "Spain address: " + address;
    }
}
