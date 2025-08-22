package shapes;

public record Circle(double radius) implements Shape {
	@Override
	public double area() {
		//---
		return Math.PI*Math.pow(radius,2);
	}
}
