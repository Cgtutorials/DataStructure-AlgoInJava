package DecoratorPattern;

public class SteamedMilk extends CondimentDecorator{
    public SteamedMilk(Beverage beverage) {
        this.beverage=beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+.10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +" , Steamed Mlk";
    }
}
