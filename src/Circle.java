
public class Circle implements Shape{
	
	private int ID;
	private String color;
	private int radius;
	private final double PI = 3.14;
	
	public Circle(int ID, int radius, String color){
		this.radius = radius;
		this.ID = ID;
		this.color = color;
	}
	
	private double calculateArea(){
		return PI * radius * radius;
	}
	
	private double calculatePerimeter(){
		return PI * 2 * radius;
	}

	@Override
	public String toString(){
		return "Circle (ID# " + ID + ")";
	}
	
	
	@Override
	public String getKind() {
		return "Circle";
	}

	@Override
	public String getDetailString() {
		String s = String.format("%s,Color: %s,Radius: %s,Area: %s,Perimeter: %s", this.toString(), color, radius, this.calculateArea(), this.calculatePerimeter());
		return s;
	}

	@Override
	public int getID() {
		return ID;
	}
}
