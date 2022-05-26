package FactoryPattern;

public class ChicagoStypleCheesePizza extends Pizza{
    public ChicagoStypleCheesePizza() {
       /* name="Chicao Style cheese pizza ";
        dough="Extra thick Crust Dough";
        sauce="Plum tamato Sauce";

        toppings.add("Shredded Mozzarella Cheese");*/
    }

    @Override
    void prepare() {

    }

    void cut(){
        System.out.println("Square slices cut");
    }
}
