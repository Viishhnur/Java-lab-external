import java.util.HashMap;
// import java.util.HashMap;

class Resistor{

    private HashMap<String,Integer> color;

    private String band1,band2,band3;
    double resistance ;
    // parametrized constructor
    Resistor(String b1,String b2,String b3){
        this.band1 = b1;
        this.band2 = b2;
        this.band3 = b3;
        resistance = 0;
        init(); // initialize all colors 
    }
    private void init(){
        color = new HashMap<>();

        color.put("black",0);
        color.put("brown",1);
        color.put("red",2);
        color.put("orange",3);
        color.put("yellow",4);
        color.put("green",5);
        color.put("blue",6);
        color.put("violet",7);
        color.put("grey",8);
        color.put("white",9);
    }

    public double getResistance(){
        resistance = (color.get(band1) * 10 + color.get(band2) ) * Math.pow(10,color.get(band3));
        return resistance;
    }


}
public class exp2 {
    
    public static void main(String[] args){
        
        Resistor r = new Resistor("red","black","orange");
        System.out.println("Resistance = " + r.getResistance()/1000 + " kilo ohms");
    
    }
}
