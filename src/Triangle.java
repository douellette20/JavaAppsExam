
public class Triangle implements Shape{
	
	private int ID;
	private String color;
	private int s1;
	private int s2;
	private int s3;
	
	public Triangle(int ID, int s1, int s2, int s3, String color){
		this.ID = ID;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.color = color;
	}
	
	private int getPerimeter(){
		return s1+s2+s3;	
	}
	
	private double getArea(){
		double s = (s1+s2+s3) / 2.0;
		double a = Math.sqrt(s *(s-s1)*(s-s2)*(s-s3));
		return a;
	}

	@Override
	public String toString(){
		return "Triangle (ID# " + ID + ")";
	}
	
	@Override
	public String getKind() {
		return "Triangle";
	}

	@Override
	public String getDetailString() {
		String s = String.format("%s,Color: %s,Side 1; %s,Side 2: %s,Side 3: %s,Area: %s,Perimeter: %s", this.toString(), color, s1, s2, s3, this.getArea(), this.getPerimeter());
		return s;
	}

	@Override
	public int getID() {
		return ID;
	}
}
