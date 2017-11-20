package pattern.decorator.coffee;

//Decorator WithSprinkles mixes sprinkles onto coffee.
//Note it extends CoffeeDecorator.
public  class WithSprinkles extends CoffeeDecorator {
 public WithSprinkles(Coffee c) {
     super(c);
 }

 public double getCost() {
     return super.getCost() + 0.2;
 }

 public String getIngredients() {
     return super.getIngredients() + ", Sprinkles";
 }
}
