package Tasca_S3_01.N2.Address;

public class UsaAddress implements Address {
    private String address;

    public UsaAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return "USA address: " + this.address;
    }
}
