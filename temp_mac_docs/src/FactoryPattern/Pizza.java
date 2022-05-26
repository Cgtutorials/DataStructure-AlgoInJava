package FactoryPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    public void setName(String name) {
        this.name = name;
    }

    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Veggies veggies[];
    Pepperoni pepperoni;
    Clams clams;
    List<String> toppings= new ArrayList<String >();

     abstract void prepare();
     void bake(){
         System.out.println("Bake for 25  minutes at 350");
     }
      void cut(){
          System.out.println("Cutting the pizza into diagonal slices");
      }
    void box(){
        System.out.println("Place pizza in official PizzaSore box");
    }

    public String getName() {
        return name;
    }


}
