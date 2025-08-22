package shapes;

public record Square(double length) implements Shape {
	@Override
	public double area() {
		//---
		return length*length;
	} 
}
//---
