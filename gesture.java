import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.awt.event.*;

public class gesture extends JFrame implements MouseListener
{
	int get = 0;
	String bs;
	int bsi;
	int Cindex[] = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13};
	boolean lettercheck[] = new boolean[24];
	boolean place[] = new boolean[14];
	String letter[] = new String[]{"A", "B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	int index[] = new int[14];
	int rindex[] = new int[7];

	int win = 0;
	int r = 1+(int)(Math.random() * 23);
	int pr = 1+(int)(Math.random() * 14);
	int hint = 1+(int)(Math.random() * 5);
	
	

	//South Panel
	JLabel[] blnk = new JLabel[7];
	JLabel[] emp = new JLabel[7];
	JLabel[] ltr = new JLabel[14];


	//LEVEL ONE
	JPanel center = new JPanel();
	JButton bt1 = new JButton("HINT  ");
	JButton bt2 = new JButton("RESET");
	JPanel north = new JPanel();
	JPanel south = new JPanel();

	//North Panel
	JLabel nl = new JLabel("4 PICs 1 WORD", JLabel.CENTER);

	//Center Panel
	Icon ic1 = new ImageIcon("gesture1.jpg");
	Icon ic2 = new ImageIcon("gesture2.jpg");
	Icon ic3 = new ImageIcon("gesture3.jpg");
	Icon ic4 = new ImageIcon("gesture4.jpg");

	JLabel lb1 = new JLabel(ic1);
	JLabel lb2 = new JLabel(ic2);
	JLabel lb3 = new JLabel(ic3);
	JLabel lb4 = new JLabel(ic4);

	//South Panel


	boolean bltr[] = new boolean[14];
	boolean bblnk[] =new boolean[7];

	Font f = new Font("Century", Font.BOLD, 20);
	Font fu = new Font("Century Gothic", Font.CENTER_BASELINE, 15);
	GridLayout glayout = new GridLayout(2,2,2,2);
	BorderLayout layout = new BorderLayout();

	public gesture()
	{
		super("4 Pics 1 Word");
		setBounds(480,150,400,470);

		setLayout(layout);

		lvl1();

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void lvl1()
	{
				//north pane
				nl.setFont(fu);
				north.add(nl);
				north.setBackground(Color.pink.brighter());

				//center pane
				center.setLayout(glayout);
				center.add(lb1);
				center.add(lb2);
				center.add(lb3);
				center.add(lb4);
				center.setBackground(Color.GRAY.brighter());
				center.setVisible(true);

				//south pane
				south.setLayout(new GridLayout(4, 7));
				south.setBackground(Color.PINK);
				
				////////////////////////////////////////////
				// assigning all boolean expression to TRUE
				///////////////////////////////////////////
				
				for(int x = 0; x < 14;x++)									
				{															
					bltr[x] = true;											
				}	
				for(int x = 0; x < 7; x++)		
				{								
					bblnk[x] = true;			
				}								
				for(int x = 0; x < 24; x++)		
				{								
					lettercheck[x] = true;		
				}		
				
				
				
				for(int x = 0; x < 7; x++)						
				{												
					blnk[x] = new JLabel("__", JLabel.CENTER);	
					blnk[x].setFont(f);							
				}
				ltr[0] = new JLabel("G",JLabel.CENTER);
				ltr[1] = new JLabel("E",JLabel.CENTER);
				ltr[2] = new JLabel("S",JLabel.CENTER);
				ltr[3] = new JLabel("T",JLabel.CENTER);
				ltr[4] = new JLabel("U",JLabel.CENTER);
				ltr[5] = new JLabel("R",JLabel.CENTER);
				ltr[6] = new JLabel("E",JLabel.CENTER);



				////////////////////////////////////////////////////
				/////////////  GET THE INDEX FOR THE PLACEMENT//////
				////////////////////////////////////////////////////
				for(int x = 0; x < 13; x++)
				{
					place[x] = true;
				}

				for(int i = 0; i < 13; i++)
				{
					while(true)
					{

						boolean c = true;

						int x = 1+(int)(Math.random() * 14);

						for(int ii = 0; ii < 14; ii++)
						{
							if(x-1 == index[ii])
							{
								c = false;
								break;
							}
						}

						if(c == true)
						{
						index[i] = x-1;
						System.out.println(index[i]);
						break;
						}
						else
						{
							continue;
						}
					}
				}
				for(int x = 0; x<14; x++)
				{
					place[x] = true;
					for(int i = 0; i < 14; i++)
					{
						if(index[x] == Cindex[i])
						{
							place[x] =false;
							break;
						}
						else
						{
							continue;
						}
					}
					if(place[x]==true)
					{
						get = x;
					}
				}
				index[13] = get;
				/////////////////////////////////////////////////////////
				////////////END OF GETING INDEX FOR PLACEMENT //////////
				/////////////////////////////////////////////////////////
				//####################################################//
				//#####  GETTING INDEX FORE THE OTHER LABEL #########//
				//#####################################################//

				for(int i = 0; i < 7; i++)
				{
					while(true)
					{

						boolean c = true;

						int x = 1+(int)(Math.random() * 24);

						for(int ii = 0; ii < 7; ii++)
						{
							if(x-1 == rindex[ii])
							{
								c = false;
								break;
							}
						}

						if(c == true)
						{
						rindex[i] = x-1;
						//System.out.println(index[i]);
						break;
						}
						else
						{
							continue;
						}
					}
				}

				////////////////////////////////////////////
				//assigning the other labels////////
				////////////////////////////////

				for(int x = 0; x < 7; x++)
				{

					ltr[x+7] = new JLabel(letter[rindex[x]], JLabel.CENTER);
					ltr[x+7].setFont(f);
					ltr[x].setFont(f);
					ltr[x].addMouseListener(this);
					ltr[x+7].addMouseListener(this);
					blnk[x].addMouseListener(this);
				}

				//###########################################################//
				//####### END IF GETTING THE INDEX FOR OTHER LABELS #########//
				//###########################################################//

				for(int x = 0; x < 7; x++) emp[x] = new JLabel(" ");
				
				for(int x = 0; x < 7; x++)south.add(blnk[x]);
				for(int x = 0; x < 7; x++)south.add(emp[x]);
				for(int x = 0; x < 14; x++)south.add(ltr[index[x]]);
				

				add(bt1, BorderLayout.WEST);
				add(bt2, BorderLayout.EAST);
				add(north, BorderLayout.NORTH);
				add(south, BorderLayout.SOUTH);
				add(center, BorderLayout.CENTER);



				bt1.addMouseListener(this);
				bt2.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e)
	{

		for(int x = 0; x < ltr.length; x++)
		{

			if(e.getSource() == ltr[x])
			{
				if(bltr[x] == true)
				{
					for(int i = 0; i < 14; i++)		
					{								
						if(bblnk[i]==true)
						{
							blnk[i].setText(ltr[x].getText().toString());
							blnk[i].setForeground(Color.BLUE);
							ltr[x].setEnabled(false);
							bltr[x] = false;
							bblnk[i] = false;
							
							if(hint == i)
							{
								bs = ltr[x].getText().toString();
								bsi = x;
							}
							
							if(bblnk[6]== false)
							{
								for(int b = 0; b < 14; b++)
								{
									bltr[b] = false;
								}
			
								for(int l = 0; l < 7; l++)
								{
									if(blnk[l].getText().equals(ltr[l].getText()))	win++;
								}
								if(win == 7)
								{
									blnk[0].setForeground(Color.GREEN);
									blnk[1].setForeground(Color.GREEN);
									blnk[2].setForeground(Color.GREEN);
									blnk[3].setForeground(Color.GREEN);
									blnk[4].setForeground(Color.GREEN);
									blnk[5].setForeground(Color.GREEN);
									blnk[6].setForeground(Color.GREEN);

									//setVisible(false);
									//new message();
									
									Object[] option = {"Menu","Again"};
									int select;
									select = JOptionPane.showOptionDialog(null, "You Got It","4PICs1WORD", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
									boolean menu,again;
									if((menu=(select==JOptionPane.YES_OPTION))==true)
									{  
										
										setVisible(false);
										
									}
									else if((again=(select==JOptionPane.NO_OPTION))==true)
									{
										for(int m = 0; m < 7; m++)
										{
											blnk[m].setText("__");
										}
										for(int m = 0; m < 14; m++)
										{
											ltr[m].setEnabled(true);
										}
										for(int m = 0; m < 7; m++)
										{
											blnk[m].setForeground(Color.BLACK);
										}
										for(int m = 0; m < 14;m++)									
										{															
											bltr[m] = true;											
										}
										for(int m = 0; m < 7; m++)
										{			
											bblnk[m] = true;
										}
										win = 0;
										//setVisible(false);
										//new address();
										
										
									}
									else JOptionPane.showMessageDialog(null, "ERROR, Dili pwede pisliton","4PICs1WORD",JOptionPane.ERROR_MESSAGE);
								}
								else
								{
									blnk[0].setForeground(Color.RED);
									blnk[1].setForeground(Color.RED);
									blnk[2].setForeground(Color.RED);
									blnk[3].setForeground(Color.RED);
									blnk[4].setForeground(Color.RED);
									blnk[5].setForeground(Color.RED);
									blnk[6].setForeground(Color.RED);							
									win=0;
	
										
									
									JOptionPane.showMessageDialog(null, "                             Wrong guess","SUDOKU",JOptionPane.DEFAULT_OPTION);
								
									
								}
							}
							
							break;
						}	
					}

				}
			}	
					
		}
		
		for(int x = 0; x < 7; x++)
		{
			
			if(e.getSource() == blnk[x])
			{
				if(bblnk[x]==false)
				{
					String s = blnk[x].getText().toString();
					
					for(int i = 0; i < 14; i++)
					{
						if(s.equals(ltr[i].getText()))
						{
							blnk[x].setText("__");
							blnk[x].setForeground(Color.BLACK);
							ltr[i].setText(s);
							ltr[i].setEnabled(true);
							bltr[i] = true;
							bblnk[x] = true;
							break;
						}
					}
				}
			}
		}


				if(e.getSource() == bt2)
				{
					for(int m = 0; m < 7; m++)
					{
						blnk[m].setText("__");
					}
					for(int m = 0; m < 14; m++)
					{
						ltr[m].setEnabled(true);
					}
					for(int m = 0; m < 7; m++)
					{
						blnk[m].setForeground(Color.BLACK);
					}
					for(int m = 0; m < 14;m++)									
					{															
						bltr[m] = true;											
					}
					for(int m = 0; m < 7; m++)
					{			
						bblnk[m] = true;
					}
				}
				else if(e.getSource()==bt1)
				{
					
					
					if(bblnk[hint] == false)
					{
							if(bltr[bsi] == false)
							{
								ltr[bsi].setEnabled(true);
								bltr[bsi] = true;
							}
					}
					
				
					blnk[hint].setText(ltr[hint].getText().toString());
					blnk[hint].setForeground(Color.BLACK);
					bblnk[hint] = false;
					ltr[hint].setEnabled(false);
					bltr[hint] = false;
					
					for(int x = 0; x < 7; x++)
					{
					
						if(x == hint)
						{
							continue;
						}
						else if(bblnk[x] == false && blnk[x].getText().equals(ltr[hint].getText()))
						{
							
							blnk[x].setText("__");
							bblnk[x] = true;
							blnk[x].setForeground(Color.BLACK);
						}
						
					}

				}
		}
	public void mouseEntered(MouseEvent e)
	{

	}
	public void mouseExited(MouseEvent e)
	{

	}public void mousePressed(MouseEvent e)
	{

	}public void mouseReleased(MouseEvent e)
	{

	}

	
	public static void main(String[] args)
	{
		new gesture();
	}
}
