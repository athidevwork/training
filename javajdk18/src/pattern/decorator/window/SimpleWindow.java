package pattern.decorator.window;

//Implementation of a simple Window without any scrollbars
public class SimpleWindow implements Window {
@Override
public void draw() {
   // Draw window
}
@Override
public String getDescription() {
   return "simple window";
}
}