import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener  {
	private int startX, startY;
	private int x1, y1, x2, y2, width, height, arcWidth, arcHeight;
	private Color foreground;
	private String drawingComponent = "";
	//Drawing panel constructor on new instance
	public DrawingPanel()
	{
		super();
		//set size of this to the frame size
		this.setSize(600, 300);
		//mouse listeners
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		//sets background default to yellow and foreground to black
		this.setBackground(Color.YELLOW);
		 this.foreground = Color.BLACK;
		 //default drawing starter variables (these are updated based on mouse listener)
		 startX = 0;
		 startY = 0;
		 x2 = 0;
		 y2 = 0;
		 width = 0;
		 height = 0;
		 arcWidth = 50;
		 arcHeight = 50;
		 
	}
	//to change the foreground color
	public void setFG(Color x) {
		this.foreground = x;
		System.out.println(this.foreground);
	}
	//to select what to draw on panel
	public void setDrawing(String drawShape) {
		this.drawingComponent = drawShape;
	}
	//clears the figure
	public void clear() {
		 startX = 0;
		 startY = 0;
		 x2 = 0;
		 y2 = 0;
		 width = 0;
		 height = 0;
		this.drawingComponent = "";
		//clears
		repaint();
	}
	//paint a figure, chosen one
	public void paintComponent(Graphics g)
	{
		//start drawing with selected foreground color..
		super.paintComponent(g);
		g.setColor(this.foreground);
		if(this.drawingComponent.equals("StraightLine")) //draw straightline
		{
			g.drawLine(startX, startY, x2, y2);
		}
		else if(this.drawingComponent.equals("Rectangle")) //draw rectangle
		{
			g.drawRect(startX, startY, width, height);
		}
		else if(this.drawingComponent.equals("Oval")) //draw oval
		{
			g.drawOval(startX, startY, width, height);
		}
		else if(this.drawingComponent.equals("RoundRectangle")) //draw roundrectangle
		{
			g.drawRoundRect(startX, startY, width, height, arcWidth, arcHeight);
		}
		else if(this.drawingComponent.equals("FilledRectangle")) //draw filledrectangle
		{
			g.fillRect(startX, startY, width, height);
		}
		else if(this.drawingComponent.equals("FilledOval")) //draw filledoval
		{
			g.fillOval(startX, startY, width, height);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) { //keep track of where user drags mouse
		x2 = e.getX();
		y2 = e.getY();
		
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) { //keeps track of mouse press
		startX = e.getX();
		startY = e.getY();
		width = e.getX();
		height = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) { //keeps track of where mouse was released
		width = Math.abs(e.getX() - width);
		height = Math.abs(e.getY() - height);
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
