package Tasca_S3_01.N2.Phone;

public class EsPhone implements  Phone{
    private String phoneNumber;

    public EsPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return "Spain phone: " + phoneNumber;
    }
}
