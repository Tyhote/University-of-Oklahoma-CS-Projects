import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Project12_TristanDow extends JPanel
{
	// You may change this constant
	private static final int SIZE = 300;

	public static void main(String[] args) 
	{
		// You may change the parameters in the code below a little, 
// but proceed with extreme caution. Do not reorder the methods.
		JFrame frame = new JFrame("Line");
		JPanel panel = new Project12_TristanDow();
		frame.setSize(SIZE,SIZE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setVisible(true);
	}
	
	// Do not change this method name or parameters
	public void paintComponent(Graphics g)
	{
		// Do not change the next two lines of code
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// This is where your code should go
		// Creating black circle
		Ellipse2D.Double blackOutline = new Ellipse2D.Double();
		blackOutline.setFrame(64,64,172,172);
		g2d.setColor(Color.BLACK);
		g2d.fill(blackOutline);
		
		// Layering red arc on top
		Arc2D.Double redHalf = new Arc2D.Double();
		redHalf.setArc(75,75,150,150,0,180,Arc2D.OPEN);
		g2d.setColor(Color.RED);
		g2d.fill(redHalf);
		
		// Layering white arc in a mirror to the red arc
		Arc2D.Double whiteHalf = new Arc2D.Double(75,75,150,150,0,-180,Arc2D.OPEN);
		g2d.setColor(Color.WHITE);
		g2d.fill(whiteHalf);
		
		// Creating the band across the center
		Rectangle2D.Double blackRectangle = new Rectangle2D.Double();
		blackRectangle.setRect(75,144.5,150,11);
		g2d.setColor(Color.BLACK);
		g2d.fill(blackRectangle);
		
		// Overlaying with a smaller black circle for an outline to the center
		Ellipse2D.Double centerBlackCircle = new Ellipse2D.Double(122.0+(1.0/3),122.0+(1.0/3),172.0/3,172.0/3);
		g2d.fill(centerBlackCircle);
		
		// Overlaying with a white circle on the center
		Ellipse2D.Double centerWhiteCircle = new Ellipse2D.Double(131,131,121.0/3,121.0/3);
		g2d.setColor(Color.WHITE);
		g2d.fill(centerWhiteCircle);
		
		// Don’t change anything after this
	}

}
