package shapes;

public sealed interface Shape 
	permits Circle, Rectangle, Triangle{
	//---
	double area();
}
