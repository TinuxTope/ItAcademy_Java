package TascaS1_01.N2.n2exercici1CristinaTomas;

public class Smartphone extends Phone implements Camera,Clock{
    public Smartphone(String brand, String model){
        super(brand,model);
    }
    @Override
    public String photograph(){
        return "A photo is being taken";
    };
    @Override
    public String alarm(){
        return "The alarm is sounding";
    }



}
