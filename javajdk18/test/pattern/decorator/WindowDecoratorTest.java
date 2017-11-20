package pattern.decorator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pattern.decorator.coffee.Coffee;
import pattern.decorator.coffee.SimpleCoffee;
import pattern.decorator.coffee.WithMilk;
import pattern.decorator.coffee.WithSprinkles;
import pattern.decorator.window.HorizontalScrollBarDecorator;
import pattern.decorator.window.SimpleWindow;
import pattern.decorator.window.VerticalScrollBarDecorator;
import pattern.decorator.window.Window;

public class WindowDecoratorTest {

	@Test
	public void testWindowDecoratorTest() {
	    Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));
      	    // assert that the description indeed includes horizontal + vertical scrollbars
	    System.out.println("Window Description : " + decoratedWindow.getDescription());
        assertEquals("simple window, including vertical scrollbars, including horizontal scrollbars", decoratedWindow.getDescription());
	}

	@Test
	public void testCoffeeDecoratorTest() {
        Coffee c = new SimpleCoffee();
        printInfo(c);

        c = new WithMilk(c);
        printInfo(c);

        c = new WithSprinkles(c);
        printInfo(c);		
	}
	
    public static void printInfo(Coffee c) {
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
    }

}
