import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimplePaintProgram extends JFrame implements ActionListener {
	//menu declaration 
	private JMenu Menu = null;
	private JMenu Figure = null;
	//menu item declaration for figure
	private JMenuItem StraightLine = null;
	private JMenuItem Rectangle = null;
	private JMenuItem Oval = null;
	private JMenuItem RoundRectangle = null;
	private JMenuItem FilledRectangle = null;
	private JMenuItem FilledOval = null;
	//color menu declaration
	private JMenu Color = null;
	//foreground menu declaration
	private JMenu ForeGround = null;
	//background menu declaration
	private JMenu BackGround = null;
	
	// Declaring bg colors
	private JMenuItem Black = null;
	private JMenuItem Blue = null;
	private JMenuItem Cyan = null;
	private JMenuItem Green = null;
	private JMenuItem Magenta = null;
	private JMenuItem Red = null;
	
	//Declaring fg colors
	private JMenuItem Black1 = null;
	private JMenuItem Blue1 = null;
	private JMenuItem Cyan1 = null;
	private JMenuItem Green1 = null;
	private JMenuItem Magenta1 = null;
	private JMenuItem Red1 = null;
	
	//clear menu
	private JMenuItem Clear = null;
	
	//font and styles menu
	private JMenu Font = null;
	private JMenu Style = null; 
	private JMenu Size = null;
	//font menu items
	private JMenuItem Bold = null;
	private JMenuItem Italics = null;
	
	//styles menu items
	private JMenuItem Size10 = null;
	private JMenuItem Size20 = null;
	private JMenuItem Size72 = null;
	
	//the menu bar on top of frame
	private JMenuBar bar = null;
	
	//declaring panels
	private JPanel bigpan = null;
	private JPanel northpan = null;
	private JPanel southpan = null;
	
	//declaring textarea
	private JTextArea tf = null;
	private int fstyle = java.awt.Font.PLAIN;
	private DrawingPanel pan = null;
	
	//constructor
	public SimplePaintProgram(){
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600); //size of the frame
		bigpan = new JPanel(new BorderLayout()); //creating the panel 
		bigpan.setBackground(java.awt.Color.YELLOW);
		pan = new DrawingPanel();
		//Textarea
		tf = new JTextArea(5, 50);
		tf.setText("Enter text here");

		//scroll pane
		JScrollPane jsp = new JScrollPane(tf);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//adding northpan to bigpan
		northpan = new JPanel();
		northpan.setBackground(java.awt.Color.YELLOW);
		northpan.add(jsp);
		bigpan.add(northpan, BorderLayout.NORTH);
		
		//creating the menu
		Menu = new JMenu("Menu"); 
		Figure = new JMenu("Figure");
		Color = new JMenu ("Color");
		Font = new JMenu("Font");
		
		
		//Creating Figure items
		StraightLine = new JMenuItem("Straight Line");
		Rectangle = new JMenuItem("Rectangle");
		Oval = new JMenuItem("Oval");
		RoundRectangle = new JMenuItem("Round Rectangle");
		FilledRectangle = new JMenuItem("Filled Rectangle");
		FilledOval = new JMenuItem("Filled Oval");
		
		//creating submenu of Color menu
		ForeGround = new JMenu("Foreground");
		BackGround = new JMenu("Background");
		Clear = new JMenuItem("Clear");
		Clear.addActionListener(this);
		
		//creating items in Foreground
		Black = new JMenuItem("Black");
		Blue = new JMenuItem("Blue");
		Cyan = new JMenuItem("Cyan");
		Green = new JMenuItem("Green");
		Magenta = new JMenuItem("Magenta");
		Red = new JMenuItem("Red");
		
		//creating items in Background
		Black1 = new JMenuItem("Black");
		Blue1 = new JMenuItem("Blue");
		Cyan1 = new JMenuItem("Cyan");
		Green1 = new JMenuItem("Green");
		Magenta1 = new JMenuItem("Magenta");
		Red1 = new JMenuItem("Red");
		
		//creating submenus for Font
		Style = new JMenu("Style");
		Size = new JMenu("Size");
		
		//creating items for submenu style
		Bold = new JMenuItem("Bold");
		Italics = new JMenuItem("Italics");
		
		//creating items for submenu size
		Size10 = new JMenuItem("Size 10");
		Size20 = new JMenuItem("Size 20");
		Size72 = new JMenuItem("Size 72");
		
		
		//adding figure items to Figure
		Figure.add(StraightLine);
		StraightLine.addActionListener(this);
		Figure.add(Rectangle);
		Rectangle.addActionListener(this);
		Figure.add(Oval);
		Oval.addActionListener(this); //action listener for oval
		Figure.add(RoundRectangle);
		RoundRectangle.addActionListener(this);
		Figure.add(FilledRectangle);
		FilledRectangle.addActionListener(this);
		Figure.add(FilledOval);
		FilledOval.addActionListener(this); //action listener for filled oval
		
		//adding things under color as a submenu
		Color.add(ForeGround);
		Color.add(BackGround);
		Color.add(Clear);
		
		//adding items under foreground
		addForegroundItem(ForeGround);
		
		//adding items under background
		addBackgroundItem(BackGround);
		
		//adding Font's submenu 
		Font.add(Style);
		Font.add(Size);
		
		//adding items under style
		Style.add(Bold);
		//actionlistener for Bold
		Bold.addActionListener(this); 
		Style.add(Italics);
		//actionlistener for Italic
		Italics.addActionListener(this); 
		
		//adding items under size
		Size.add(Size10);
		Size10.addActionListener(this);
		Size.add(Size20);
		Size20.addActionListener(this);
		Size.add(Size72);
		Size72.addActionListener(this);

		//creating menu bar
		bar = new JMenuBar();
		//adding menus to the bar
		Menu.add(Figure);
		Menu.add(Color);
		Menu.add(Font);
		bar.add(Menu);
		
		//setting draw panel visible to the user
		pan.setVisible(true);
		bigpan.add(pan);
		
		//Adding everything to the root frame
		this.setJMenuBar(bar);
		this.add(bigpan);
		//actionlisteners for figures
		StraightLine.addActionListener(this);
		Rectangle.addActionListener(this);
		Oval.addActionListener(this);
		RoundRectangle.addActionListener(this);
		FilledRectangle.addActionListener(this);
		FilledOval.addActionListener(this);
	}
	public void addBackgroundItem(JMenu background) {
		//adds colors to the background menu
		//NOTE: inside actionlisteners of color, color the bigpanel
		background.add(Black);
		Black.addActionListener(this);
		background.add(Blue);
		Blue.addActionListener(this);
		background.add(Green);
		Green.addActionListener(this);
		background.add(Cyan);
		Cyan.addActionListener(this);
		background.add(Magenta);
		Magenta.addActionListener(this);
		background.add(Red);
		Red.addActionListener(this);
	}
	public void addForegroundItem(JMenu foreground) {
		//adds colors to the foreground menu and their action listeners
		foreground.add(Black1);
		Black1.addActionListener(this);
		foreground.add(Blue1);
		Blue1.addActionListener(this);
		foreground.add(Green1);
		Green1.addActionListener(this); //ex: this is the action listener for green
		foreground.add(Cyan1);
		Cyan1.addActionListener(this);
		foreground.add(Magenta1);
		Magenta1.addActionListener(this);
		foreground.add(Red1); //ex: this is adding the red menu item to the foreground menu
		Red1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Black) { //sets the background to black
			bigpan.setBackground(java.awt.Color.BLACK);
			northpan.setBackground(java.awt.Color.BLACK);
			pan.setBackground(java.awt.Color.BLACK);
		}
		else if(e.getSource() == Blue) { //sets the background to blue
			bigpan.setBackground(java.awt.Color.BLUE);
			northpan.setBackground(java.awt.Color.BLUE);
			pan.setBackground(java.awt.Color.BLUE);
		}
		else if(e.getSource() == Green) { //sets the background to green
			bigpan.setBackground(java.awt.Color.GREEN);
			northpan.setBackground(java.awt.Color.GREEN);
			pan.setBackground(java.awt.Color.GREEN);
		}
		else if(e.getSource() == Cyan) { //sets the background to cyan
			bigpan.setBackground(java.awt.Color.CYAN);
			northpan.setBackground(java.awt.Color.CYAN);
			pan.setBackground(java.awt.Color.CYAN);
		}
		else if(e.getSource() == Magenta) { //sets the background to magenta
			bigpan.setBackground(java.awt.Color.MAGENTA);
			northpan.setBackground(java.awt.Color.MAGENTA);
			pan.setBackground(java.awt.Color.MAGENTA);
		}
		else if(e.getSource() == Red) { //sets the background to black
			bigpan.setBackground(java.awt.Color.RED);
			northpan.setBackground(java.awt.Color.RED);
			pan.setBackground(java.awt.Color.RED);
		}
		else if(e.getSource() == Bold) //sets the text to bold
		{
			fstyle = java.awt.Font.BOLD;
			Font boldFont = new Font(tf.getFont().getName(), fstyle, tf.getFont().getSize());
			tf.setFont(boldFont);
		}
		else if(e.getSource() == Italics) //sets the text to Italics
		{
			fstyle = java.awt.Font.ITALIC;
			Font italicFont = new Font(tf.getFont().getName(), fstyle, tf.getFont().getSize());
			tf.setFont(italicFont);
		}
		else if(e.getSource() == Size10) //sets the text size to Size10
		{
			//get style which is already set, and then only set size to 10
			Font size = new Font(tf.getFont().getName(), tf.getFont().getStyle(), 10);
			tf.setFont(size);
		}
		else if(e.getSource() == Size20) //sets the text size to Size20
		{
			//get style which is already set, and then only set size to 10
			Font size = new Font(tf.getFont().getName(), tf.getFont().getStyle(), 20);
			tf.setFont(size);
		}
		else if(e.getSource() == Size72) //sets the text size to Size72
		{
			//get style which is already set, and then only set size to 10
			Font size = new Font(tf.getFont().getName(), tf.getFont().getStyle(), 72);
			tf.setFont(size);
		}
		else if(e.getSource() == StraightLine) //start drawing a straight line
		{
			pan.setDrawing("StraightLine");
		}
		else if(e.getSource() == Rectangle) //start drawing a rectangle
		{
			pan.setDrawing("Rectangle");
		}
		else if(e.getSource() == Oval) //start drawing an oval
		{
			pan.setDrawing("Oval");
		}
		else if(e.getSource() == RoundRectangle) //start drawing a roundrectangle
		{
			pan.setDrawing("RoundRectangle");
		}
		else if(e.getSource() == FilledRectangle) //start drawing a filledrectangle
		{
			pan.setDrawing("FilledRectangle");
		}
		else if(e.getSource() == FilledOval) //start drawing a filled oval
		{
			pan.setDrawing("FilledOval");
		}
		else if(e.getSource() == Black1) { //sets the foreground to black
			pan.setFG(java.awt.Color.BLACK);
		}
		else if(e.getSource() == Blue1) { //sets the foreground to blue
			pan.setFG(java.awt.Color.BLUE);
		}
		else if(e.getSource() == Green1) { //sets the foreground to green
			pan.setFG(java.awt.Color.GREEN);
		}
		else if(e.getSource() == Magenta1) { //sets the foreground to magenta
			pan.setFG(java.awt.Color.MAGENTA);
		}
		else if(e.getSource() == Cyan1) { //sets the foreground to cyan
			pan.setFG(java.awt.Color.CYAN);
		}
		else if(e.getSource() == Red1) { //sets the foreground to red
			pan.setFG(java.awt.Color.RED);
		}
		else if(e.getSource() == Clear) { //clears the figure and resets the font styling
			pan.clear();
			tf.setText("Enter text here");
			tf.setFont(null);
		}
		
		
	}	
}
