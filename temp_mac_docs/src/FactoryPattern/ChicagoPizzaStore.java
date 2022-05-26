package FactoryPattern;

public class ChicagoPizzaStore extends PizzaStore{
    Pizza createPizza(String item){
        if(item.equals("cheese")){
            return new ChicagoStypleCheesePizza();
        }
        else if(item.equals("pepperoni")){
            return new ChicagoStylePepperoniPizza();
        }
        else if(item.equals("clam")){
            return new ChicagoStyleClamPizza();
        }else if(item.equals("veggie")){
            return  new ChicagoStyleVeggiePizza();
        }
        else return null;
    }
}
