package TascaS1_04.N1.n1exercici1CristinaTomas;

import java.util.ArrayList;
import java.util.List;

public class LlistaMesos {

    public static List<Mes> inserirMesos(){

        List<Mes> mesos = new ArrayList<>();

        mesos.add(new Mes("gener", 1));
        mesos.add(new Mes("febrer", 2));
        mesos.add(new Mes("març", 3));
        mesos.add(new Mes("abril", 4));
        mesos.add(new Mes("maig", 5));
        mesos.add(new Mes("juny", 6));
        mesos.add(new Mes("juliol", 7));
        mesos.add(new Mes("agost", 8));
        mesos.add(new Mes("setembre", 9));
        mesos.add(new Mes("octubre", 10));
        mesos.add(new Mes("novembre", 11));
        mesos.add(new Mes("desembre", 12));
        return mesos;
    }
}
