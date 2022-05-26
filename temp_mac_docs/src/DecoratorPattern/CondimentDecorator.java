package DecoratorPattern;

import javax.swing.*;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}
