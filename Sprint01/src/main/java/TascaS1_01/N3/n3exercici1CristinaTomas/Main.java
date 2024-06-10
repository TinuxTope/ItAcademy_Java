package TascaS1_01.N3.n3exercici1CristinaTomas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Editor> editors = new ArrayList<Editor>();
    static int option;
    static String answer = "";

    public static void main(String[] args) {


        System.out.println("Welcome to GameOn, your news Sports portal .");
        do {
            System.out.println(
                    "Choose an option \n" +
                            "0. Exit.\n" +
                            "1. Insert editor.\n" +
                            "2. Delete editor.\n" +
                            "3. Insert news to an editor.\n" +
                            "4. Delete news (must request editor and headline of the news).\n" +
                            "5. Show all news by editor.\n" +
                            "6. Calculate news score.\n" +
                            "7. Calculate news price.\n" +
                            "Option: "
            );
            option = input.nextByte();
            input.nextLine(); //vaciar buffer

            switch (option) {
                case 1:
                    answer = insertEditor();
                    break;
                case 2:
                    answer = deleteEditor();
                    break;
                case 3:
                    answer = insertNew();
                    break;
                case 4:
                    answer = deleteNews();
                    break;
                case 5:
                    answer = showNewsByEditor();
                    break;
                case 6:
                    answer = calculateNewsPoints();
                    break;
                case 7:
                    answer = calculateNewsPrice();
                    break;
                default:
                    answer = "Error. option incorrect";
                    break;
            }
            System.out.println(answer);
        } while (option != 0);
    }

    public static String insertEditor() {
        String name, dni = "";
        System.out.println("You have chosen option" + option
                + "\n Tell me the name of the editor: ");
        name = input.nextLine().toLowerCase();

        System.out.println("Tell me the DNI of the editor: ");
        dni = input.nextLine().toLowerCase();

        if (checkDni(dni)) {
            answer = "Editor with this DNI alredy exists. ";
        } else {
            Editor editor = new Editor(name, dni);
            editors.add(editor);
            answer = "Editor inserted successfully" + editor.toString() +"\n";
        }
        return answer;
}
    private static boolean checkDni (String dni){
        for (Editor editor : editors){
            if (editor.getDNI().equalsIgnoreCase(dni)){
                return true;
            }
        }
        return false;
    }
    public static String deleteEditor(){
        String dniDelete, confirmation= "";

        System.out.println("You have chosen option " + option
                + "\nEnter the DNI of the editor you want to delete: ");
        dniDelete = input.nextLine().toLowerCase();

        if (checkDni(dniDelete)){
            int index = findEditor(dniDelete);

            if (index != -1){
                System.out.println("Are you sure you want to delete the editor with DNI " + dniDelete + "? (y/n)");
                confirmation = input.nextLine().toLowerCase();
                if(confirmation.equals("y")){
                    editors.remove(index);
                    answer = "Editor with DNI " + dniDelete + " deleted successfully.";
                } else {
                    answer = "Cancelled deletion";
                }
            }
        }else{
            answer = "Editor with DNI " +dniDelete + " not found";
        }
        return answer;
    }
    private static int findEditor(String dni){
        int pEditor = -1;
        if(!editors.isEmpty()){
            for (Editor editor : editors) {
                if (editor.getDNI().equalsIgnoreCase(dni)) {
                    pEditor = editors.indexOf(editor);
                }
            }
        }
        return pEditor;
    }
    public static String insertNew(){
        String dni, name, headline = "";
        String competition, club, player, team = "";
        int index= 0;

        System.out.println("You have chosen option " + option
                + "\nEnter the DNI of the editor you want to insert the new: ");
        dni = input.nextLine().toLowerCase();
        index = findEditor(dni);
        if (index == -1){
            answer = "Not found";
        }else{
            name = editors.get(index).getName();
            System.out.println(
                    "What type of news do you want to add to the editor " + name + "\n"
                            + "1. Football. \n"
                            + "2. Basketball. \n"
                            + "3. Tennis. \n"
                            + "4. F1. \n"
                            + "5. Motorcycle. \n"
                    + "Choose an option: "
            );
            option = input.nextInt();
            input.nextLine();
            System.out.println("Enter the headline of the news: ");
            headline = input.nextLine().toLowerCase();
            String type= "";

            switch (option){
                case 1:
                    System.out.println("Enter the copetition (League, Champion or other): ");
                    competition = input.nextLine().toLowerCase();
                    System.out.println("Enter the club (Barça, Madrid, other): ");
                    club = input.nextLine().toLowerCase();
                    System.out.println("Enter the player (Ferran Torres, Benzema, other) ");
                    player = input.nextLine().toLowerCase();
                    NFootball football1 = new NFootball(headline, competition,club,player);
                    editors.get(index).getNews().add(football1);
                    type = "Football";
                    break;
                case 2:
                    System.out.println("Enter the copetition (Eurolliga, ACB or other): ");
                    competition = input.nextLine().toLowerCase();
                    System.out.println("Enter the club (Barça, Madrid, other): ");
                    club = input.nextLine().toLowerCase();
                    NBasketball basketball1 = new NBasketball(headline, competition,club);
                    editors.get(index).getNews().add(basketball1);
                    type = "Basketball";
                    break;
                case 3:
                    System.out.println("Enter the player (Federer, Nadal, Djokovic) ");
                    player = input.nextLine().toLowerCase();
                    NTennis tennis1 = new NTennis(headline, player);
                    editors.get(index).getNews().add(tennis1);
                    type = "Tennis";
                    break;
                case 4:
                    System.out.println("Enter the team (Ferrari, Mercedes, other): ");
                    team= input.nextLine().toLowerCase();
                    NF1 F11 = new NF1(headline, team);
                    editors.get(index).getNews().add(F11);
                    type = "F1";
                    break;
                case 5:
                    System.out.println("Enter the team (Honda, Yamaha, other): ");
                    team= input.nextLine().toLowerCase();
                    NMotorcycle motorcycle1 = new NMotorcycle(headline, team);
                    editors.get(index).getNews().add(motorcycle1);
                    type = "Motorcycle";
                    break;
                default:
                    System.out.println("Error. option incorrect");
                    break;
            }
            answer = "The new of " + type  + " has been added to the editor " + name + ".";
        }
        return answer;
    }
    public static String deleteNews() {
        String dni, headline, answer = "";
        int index = 0;

        System.out.println("You have chosen option " + option
                + "\nEnter the DNI of the editor who owns the news: ");
        dni = input.nextLine().toLowerCase();
        index = findEditor(dni);
        if (index == -1) {
            answer = "Editor not found";
        } else {
            System.out.println("Enter the headline of the news you want to delete: ");
            headline = input.nextLine().toLowerCase();
            ArrayList<New> newsList = editors.get(index).getNews();
            for (int i = 0; i < newsList.size(); i++) {
                if (newsList.get(i).getHeadline().equalsIgnoreCase(headline)) {
                    System.out.println("Are you sure you want to delete the news with headline " + headline + "? (y/n)");
                    String confirmation = input.nextLine().toLowerCase();
                    if (confirmation.equals("y")) {
                        newsList.remove(i);
                        answer = "News with headline " + headline + " deleted successfully.";
                    } else {
                        answer = "Cancelled deletion";
                    }
                    return answer;
                }
            }
            answer = "News with headline " + headline + " not found";
        }
        return answer;
    }
    public static String showNewsByEditor() {
        String dni, answer = "";
        int index = 0;

        System.out.println("You have chosen option " + option
                + "\nEnter the DNI of the editor whose news you want to show: ");
        dni = input.nextLine().toLowerCase();
        index = findEditor(dni);
        if (index == -1) {
            answer = "Editor not found";
        } else {
            ArrayList<New> newsList = editors.get(index).getNews();
            if (newsList.isEmpty()) {
                answer = "No news found for this editor";
            } else {
                answer = "News for editor with DNI " + dni + ":\n";
                for (New news : newsList) {
                    answer += "Headline: " + news.getHeadline() + "\n";

                }
            }
        }
        return answer;
    }
    private static String calculateNewsPrice() {
        String dni, answer = "";
        int index = 0;

        System.out.println("You have chosen option " + option
                + "\nEnter the DNI of the editor whose news you want to calculate the price for: ");
        dni = input.nextLine().toLowerCase();
        index = findEditor(dni);
        if (index == -1) {
            answer = "Editor not found";
        } else {
            ArrayList<New> newsList = editors.get(index).getNews();
            if (newsList.isEmpty()) {
                answer = "No news found for this editor";
            } else {
                answer = "Price calculation for news of editor with DNI " + dni + ":\n";
                for (New news : newsList) {
                    double price = news.calculateNewsPrice();
                    answer += "Headline: " + news.getHeadline() + " - Price: " + price + "€\n";
                }
            }
        }
        return answer;
    }
    private static String calculateNewsPoints() {
        String dni, answer = "";
        int index= 0;

        System.out.println("You have chosen option " + option
                + "\nEnter the DNI of the editor whose news you want to calculate the points for: ");
        dni = input.nextLine().toLowerCase();
        index = findEditor(dni);
        if (index == -1) {
            answer = "Editor not found";
        } else {
            ArrayList<New> newsList = editors.get(index).getNews();
            if (newsList.isEmpty()) {
                answer = "No news found for this editor";
            } else {
                answer = "Point calculation for news of editor with DNI " + dni + ":\n";
                for (New news : newsList) {
                    byte points = news.calculateNewsPoint();
                    answer += "Headline: " + news.getHeadline() + " - Points: " + points + "\n";
                }
            }
        }
        return answer;
    }


}
