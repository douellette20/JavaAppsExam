import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main implements ListSelectionListener{
	
	private static ArrayList<Shape> shapes = new ArrayList<Shape>();
	private static ArrayList<String> names = new ArrayList<String>();
	JFrame frame;
	JPanel bigPanel;
	JPanel textPanel;
	Image circle;
	Image rectangle;
	Image triangle;
	Image square;
	JLabel image = new JLabel();
	JList list;
	
	
	public Main(){
		initialize();
		
	    frame.setVisible(true);
	}

	private void initialize() {
		readInput();
		for(Shape s :shapes){
			names.add(String.format("%s (%s)", s.getKind(), s.getID()));
		}
		
		try{
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			URL imgUrl = getClass().getResource("/resources/circle.gif");
			circle = toolkit.getImage(imgUrl);
			circle = circle.getScaledInstance(102, 102, Image.SCALE_SMOOTH);
			imgUrl = getClass().getResource("/resources/triangle.png");
			triangle = toolkit.getImage(imgUrl);
			triangle = triangle.getScaledInstance(120, 104, Image.SCALE_SMOOTH);
			imgUrl = getClass().getResource("/resources/rectangle.png");
			rectangle = toolkit.getImage(imgUrl);
			rectangle = rectangle.getScaledInstance(192, 114, Image.SCALE_SMOOTH);
			imgUrl = getClass().getResource("/resources/square.png");
			square = toolkit.getImage(imgUrl);
			square = square.getScaledInstance(102, 102, Image.SCALE_SMOOTH);
		}
		catch (Exception ex){System.out.printf("Failed for %s\n", "the images");}
		
		frame = new JFrame();
		frame.setSize(650, 400);
		
		bigPanel = new JPanel();
		bigPanel.setLayout(new BorderLayout());
		textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		
		bigPanel.add(textPanel, BorderLayout.CENTER);
		bigPanel.add(image, BorderLayout.NORTH);
		
		frame.setLayout(new BorderLayout());
		list = new JList(names.toArray());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		frame.add(new JScrollPane(list), BorderLayout.WEST);
		frame.add(bigPanel, BorderLayout.CENTER);
		
	    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	private void readInput() {
		try (FileInputStream is = new FileInputStream("src\\resources\\shapes.txt")) {
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();
            while (line != null) {
                String[] parts = line.split(" ");
                if(parts[0].equals("circle:"))
                	shapes.add(new Circle(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]));
                else if(parts[0].equals("triangle:"))
                	shapes.add(new Triangle(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), parts[5]));
                else if(parts[0].equals("rectangle:"))
                	shapes.add(new Rectangle(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]));
                else
                	shapes.add(new Square(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]));
                line = rdr.readLine();
            }

        }
        catch (Exception ex) { System.out.printf("Failed for %s\n", "shapes.txt");}
	}
	
	public static void main(String[] args) {
		Main m = new Main();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Shape s = shapes.get(list.getSelectedIndex());
		Image i;
		if (s.getKind().equals("Rectangle"))
			i = rectangle;
		else if (s.getKind().equals("Circle"))
			i = circle;
		else if (s.getKind().equals("Triangle"))
			i = triangle;
		else
			i = square;
		ImageIcon icon = new ImageIcon(i);
		image.setIcon(icon);
		
		textPanel.removeAll();
		String[] tokens = s.getDetailString().split(",");
		for (String st : tokens)
			textPanel.add(new JLabel(st));
		frame.repaint();
		frame.revalidate();
	}
}
