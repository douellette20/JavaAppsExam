
public class Square implements Shape {
	
	private int ID;
	private int sideLength;
	private String color;
	
	public Square(int ID, int sl, String color){
		this.ID = ID;
		this.sideLength = sl;
		this.color = color;
	}
	
	private int getArea(){
		return sideLength *sideLength;
	}
	
	private int getPerimeter(){
		return sideLength *4;
	}
	
	@Override
	public String toString(){
		return "Square (ID# " + ID + ")";
	}

	@Override
	public String getKind() {
		return "Square";
	}

	@Override
	public String getDetailString() {
		String s = String.format("%s,Color: %s,Side Length: %s,Area: %s,Perimeter: %s", this.toString(), color, sideLength, this.getArea(), this.getPerimeter());
		return s;
	}

	@Override
	public int getID() {
		return ID;
	}

}
