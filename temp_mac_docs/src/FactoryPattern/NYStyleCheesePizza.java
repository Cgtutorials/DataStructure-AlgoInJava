package FactoryPattern;

public class NYStyleCheesePizza extends Pizza{
    public NYStyleCheesePizza(){


        toppings.add("Grated Reggiano Cheese");
    }

    @Override
    void prepare() {

    }
}
