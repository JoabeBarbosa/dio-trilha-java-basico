package shapes;

public sealed interface Shape 
	permits Circle, Square, Rectangle{
	//---
	double area();
}