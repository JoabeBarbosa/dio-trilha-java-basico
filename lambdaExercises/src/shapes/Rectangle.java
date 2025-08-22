package shapes;

public record Rectangle(double width,double heigth) implements Shape {
	@Override
	public double area() {
		//---
		return width*heigth;
	}
}
