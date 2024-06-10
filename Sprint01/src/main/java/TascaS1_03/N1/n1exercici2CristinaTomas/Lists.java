package TascaS1_03.N1.n1exercici2CristinaTomas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Lists {
    public static void main(String[] args) {
        List<Integer> listFirst = new ArrayList<>();

        listFirst.add(1);
        listFirst.add(2);
        listFirst.add(3);

        System.out.println("There are these numbers in the first list: " + listFirst);

        List<Integer> listSecond = new ArrayList<>();

        ListIterator<Integer>listInt = listFirst.listIterator(listFirst.size());
        while (listInt.hasPrevious()){
            listSecond.add(listInt.previous());
        }


        System.out.println("There are these numbers in the second list: " + listSecond);




    }
}
