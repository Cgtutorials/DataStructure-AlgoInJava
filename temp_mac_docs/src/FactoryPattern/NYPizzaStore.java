package FactoryPattern;

public class NYPizzaStore extends PizzaStore{
    protected Pizza createPizza(String item){
        Pizza pizza=null;

        PizzaIngredientFactory pizzaIngredientFactory= new NYPizzaIngredientFactory();

        if(item.equals("cheese")){
           pizza=new CheesePizza(pizzaIngredientFactory);
           pizza.setName("New Yoirk Styple Cheese pizza");
        }
        else if(item.equals("pepperoni")){
            pizza=new PepperoniPizza(pizzaIngredientFactory);
            pizza.setName("New Yoirk Styple pepperoni pizza");
        }
        else if(item.equals("clam")){
            pizza=new ClamPizza(pizzaIngredientFactory);
            pizza.setName("New Yoirk Styple Clam pizza");
        }else if(item.equals("veggie")){
            pizza=new VeggiePizza(pizzaIngredientFactory);
            pizza.setName("New Yoirk Styple veggie pizza");
        }
      return pizza;
    }
}
