import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainmenu extends JFrame implements MouseListener
{
	int count = 0;
	
	JLabel north = new JLabel("4 PICs 1 WORD", JLabel.CENTER);
	JPanel west = new JPanel();
	JPanel east = new JPanel();
	JPanel south = new JPanel();
	
	JPanel menu = new JPanel();
	JLabel lvlone = new JLabel("Level 1", JLabel.CENTER);
	JLabel lvltwo = new JLabel("Level 2", JLabel.CENTER);
	JLabel lvlthree = new JLabel("Level 3", JLabel.CENTER);
	JLabel lvlfour = new JLabel("Level 4", JLabel.CENTER);
	JLabel lvlfive = new JLabel("Level 5", JLabel.CENTER);
	
	boolean x1 = true;
	boolean x2 = true;
	boolean x3 = false;
	boolean x4 = false;
	boolean x5 = false;
	
	JButton ss;
	Object o =  ss;
	
	public mainmenu()
	{
		super("4 Pics 1 Word");
		setBounds(480,150,400,470);
		setLayout(new BorderLayout());
		JPanel n = new JPanel();
		north.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
		n.add(north);
		n.setBackground(Color.PINK.brighter());
		add(n, BorderLayout.NORTH);
		west.setBackground(Color.GRAY.brighter());
		east.setBackground(Color.GRAY.brighter());
		south.setBackground(Color.GRAY.brighter());
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		
		
		
		mmenu();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void mouseClicked(MouseEvent e)
	{
		
		if(e.getSource() == lvlone)
		{
			
				count++;
				x1 = true;
				if(count == 2) lvlthree.setEnabled(true);
				
				if(x1 == true && x2 == true && count == 2)
				{lvlthree.setEnabled(true);x3 = true;}
				
				new weather();
				
				
			
		}
		else if(e.getSource() == lvltwo)
		{
			
					count++;
					//x3 = true;
					x2 = true;
					
					if(x1 == true && x2 == true && count == 2)
					{lvlthree.setEnabled(true);x3 = true;}
					
					new healthy();
			
		}
		else if(e.getSource() == lvlthree)
		{
			if(x3 == true)
			{
				
					count++;
					x4 = true;
					lvlfour.setEnabled(true);
					if(count == 3) lvlthree.setEnabled(true);
					
				
					new address();
			}
		}
		else if(e.getSource() == lvlfour)
		{
			if(x4 == true)
			{
				
					count++;
					x5 = true;
					
					if(x5 == true) lvlfive.setEnabled(x5);
					
				
					new gesture();
			}
		}
		else if(e.getSource() == lvlfive)
		{
			if(x5 == true)
			{
				
					if(count == 5) lvlthree.setEnabled(x3);	
					
					new level5();
			}
		}
	}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseReleased(MouseEvent e)
	{
	}
	public void mousePressed(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{

	}
	public void mmenu()
	{
		
		menu.setLayout(new GridLayout(5,1));
		menu.setBackground(Color.GRAY.brighter());
		lvlone.setFont(new Font("Comic San MS", Font.BOLD, 25));
		lvltwo.setFont(new Font("Comic San MS", Font.BOLD, 25));
		lvlthree.setFont(new Font("Comic San MS", Font.BOLD, 25));
		lvlfour.setFont(new Font("Comic San MS", Font.BOLD, 25));
		lvlfive.setFont(new Font("Comic San MS", Font.BOLD, 25));
		
		menu.add(lvlone);
		menu.add(lvltwo);
		menu.add(lvlthree);
		menu.add(lvlfour);
		menu.add(lvlfive);
		add(menu, BorderLayout.CENTER);
		
		lvlone.setEnabled(x1);
		lvltwo.setEnabled(x2);
		lvlthree.setEnabled(x3);
		lvlfour.setEnabled(x4);
		lvlfive.setEnabled(x5);
		
		lvlone.setToolTipText("Click to anwser level 1");
		lvltwo.setToolTipText("Click to answer level 2");
		
		if(x3 == false)
		{
			lvlthree.setToolTipText("You must answer 1 and 2 to unlock this level");
		}
		
		if(x4== false)
		{
			lvlfour.setToolTipText("You must answer level 3 to unlock this level");
		}
		
		if(x5 == false)
		{
			lvlfive.setToolTipText("You must answer level 4 to unlock this level");
		}
		
		
		
		lvlone.addMouseListener(this);
		lvltwo.addMouseListener(this);
		lvlthree.addMouseListener(this);
		lvlfour.addMouseListener(this);
		lvlfive.addMouseListener(this);
		
		
	}
	public static void main(String[] args)
	{
		
		new mainmenu();	
		
	}
}
