package TascaS1_03.N1.n1exercici1CristinaTomas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import  java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Month> months = new ArrayList<Month>();
        int cont = 1;

        months.add(new Month("january"));
        months.add(new Month("february"));
        months.add(new Month("march"));
        months.add(new Month("april"));
        months.add(new Month("may"));
        months.add(new Month("june"));
        months.add(new Month("july"));
        months.add(new Month("september"));
        months.add(new Month("october"));
        months.add(new Month("november"));
        months.add(new Month("december"));

        System.out.println("List of 11 months excluding August: ");
        for (Month monthList : months){
            int index = months.indexOf(monthList) + 1;
            System.out.println(index + " : " + monthList.getName() );
        }

        Month august = new Month("august");
        months.add(7, august);

        System.out.println("\n List of 12 months inclued August: ");
        for (Month monthList : months){
            int index = months.indexOf(monthList) + 1;
            System.out.println(index + " : " + monthList.getName() );
        }

        HashSet<Month> monthSt = new HashSet<>(months);
        cont = 1;
        System.out.println("\n List month with HashSet: ");
        for (Month month : monthSt){
            System.out.println(cont + " : " + month.getName() );
            cont++;
        }

        System.out.println("Hashset before adding duplicates " + monthSt.size());

        monthSt.add(august);
        monthSt.add(august);

        System.out.println("HashSet after adding duplicates: " + monthSt.size());

        System.out.println("\n HashSet does not allow duplicates and provides an unordered list. " +
                "List month with HashSet after adding duplicates: ");
        for (Month month : monthSt){
            System.out.println(month.getName() );
        }

        System.out.println();

        System.out.println("\nIterate through the list with a for loop: ");
        for (int i = 0; i < months.size(); i++) {
            System.out.println((i + 1) + " : " + months.get(i).getName());
        }

        System.out.println("\nIterate through the list with an iterator: ");
        Iterator<Month> iterator = months.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Month month = iterator.next();
            System.out.println(index + " : " + month.getName());
            index++;
        }

    }
}
