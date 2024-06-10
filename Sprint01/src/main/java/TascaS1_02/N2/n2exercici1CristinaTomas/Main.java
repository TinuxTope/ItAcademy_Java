package TascaS1_02.N2.n2exercici1CristinaTomas;

public class Main {
    public static void main(String[] args){
        byte age= Entry.readByte("Enter your age: ");
        System.out.println("Age: " + age + ".");

        int number = Entry.readInt("Enter a number: ");
        System.out.println("Number: " + number + ".");

        float decimal = Entry.readFloat("Enter a number with two decimal places: ");
        System.out.println("Decimal: " + decimal + ".");

        double squareRoot = Entry.readDouble("Enter the number pi: ");
        System.out.println("The square root of 8 is: " + squareRoot + ".");

        char car = Entry.readChar("Enter your initial name: ");
        System.out.println("Your initial name is: " + car + ".");

        String surname = Entry.readString("Enter your surname: ");
        System.out.println("Your surname is: " + surname);

        boolean answer = Entry.readBool("Have you got a smartphone? ('y' for yes, 'n' no no)");
        System.out.println("Your answer is: " + answer);

    }
}
