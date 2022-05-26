package FactoryPattern;

public class ClamPizza extends  Pizza{

    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing "+name);
        dough=ingredientFactory.createDough();
        sauce=ingredientFactory.createSauce();
        cheese=ingredientFactory.createCheese();
        clams=ingredientFactory.createClams();
    }

    @Override
    public void bake() {

    }

    @Override
    public void cut() {

    }

    @Override
    public void box() {

    }
}
