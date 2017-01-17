
public class Rectangle implements Shape {
	
	private int ID;
	private int length;
	private int width;
	private String color;

	public Rectangle(int ID, int length, int width, String color){
		this.ID = ID;
		this.length = length;
		this.width = width;
		this.color = color;
	}
	
	private int getArea(){
		return length * width;
	}
	
	private int getPerimeter(){
		return 2* (length + width);
	}
	
	@Override
	public String toString(){
		return "Rectangle (ID# " + ID + ")";
	}
	
	
	@Override
	public String getKind() {
		return "Rectangle";
	}

	@Override
	public String getDetailString() {
		String s = String.format("%s,Color: %s,Length: %s,Width: %s,Area: %s,Perimeter: %s", this.toString(), color, length, width, this.getArea(), this.getPerimeter());
		return s;
	}

	@Override
	public int getID() {
		return ID;
	}

}
