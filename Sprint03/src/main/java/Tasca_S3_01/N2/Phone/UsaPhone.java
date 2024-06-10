package Tasca_S3_01.N2.Phone;

public class UsaPhone implements Phone {
    private String phoneNumber;

    public UsaPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return "USA phone: " + phoneNumber;
    }
}
