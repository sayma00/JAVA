import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;  
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent.*;
import javax.swing.ImageIcon;
import java.text.*;
import java.util.*;
import javax.swing.JToggleButton;  

public class Admin extends JFrame implements MouseListener,ActionListener
{
	
	Font myFont;
	//Jbg bg;
	JButton pr;
	JButton te;
	JButton st;
	JButton no;
	JButton lo;
	JButton ph;
	JButton sch;
	JButton exitBtn;
	JLabel pp;
	JLabel bg;
	JLabel nm;
	JLabel nm2;
	/*ImageIcon imgl;*/ ImageIcon img;
		//private JToggleButton button;  
		
	public Admin()
	{
		super("Admin");
		
		
		//initComponents();
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		
		myFont = new Font("Viking Squad", Font.PLAIN, 28);
		
		bg = new JLabel((new ImageIcon("teacher1.png")));//(new ImageIcon("bgs.jpg"));
		bg.setBackground(new Color(51,153,255));
	    bg.setBounds(00,00,800,800);
	    this.add(bg);
		
		pr = new JButton("Profile");  
	    pr.setBounds(300, 230, 200,30);
		pr.addMouseListener(this);
		pr.addActionListener(this);
        pr.setFont(myFont);		
	    bg.add(pr); 
	    pr.setBackground(Color.WHITE);
	    pr.setForeground(Color.BLUE);
	  
	    te = new JButton("Teachers"); 
	    te.setBounds(300, 280, 200,30); 
		te.addMouseListener(this);
		te.addActionListener(this);
		te.setFont(myFont);
	    bg.add(te);
		te.setBackground(Color.WHITE);
	    te.setForeground(Color.BLUE);
		
	    st = new JButton("Students"); 
	    st.setBounds(300, 330, 200,30);
		st.addMouseListener(this);
		st.addActionListener(this);
        st.setFont(myFont);
		bg.add(st);
		st.setBackground(Color.WHITE);
	    st.setForeground(Color.BLUE);
		
	    no = new JButton("Notice");
        no.setBounds(300, 380, 200,30);
		no.addMouseListener(this);
		no.addActionListener(this);
        no.setFont(myFont);
		bg.add(no);
		no.setBackground(Color.WHITE);
	    no.setForeground(Color.BLUE);
		
		ph = new JButton("Payment");
        ph.setBounds(300, 430, 200,30);
		ph.addMouseListener(this);
		ph.addActionListener(this);
        ph.setFont(myFont);
		ph.setBackground(Color.WHITE);
	    ph.setForeground(Color.BLUE);
		bg.add(ph);
		
		sch = new JButton("Schedule");
        sch.setBounds(300, 480, 200,30);
		sch.addMouseListener(this);
		sch.addActionListener(this);
        sch.setFont(myFont);
		sch.setBackground(Color.WHITE);
	    sch.setForeground(Color.BLUE);
		bg.add(sch);
		
	    lo = new JButton("Logout");
        lo.setBounds(660, 20, 120, 30);
		lo.addMouseListener(this);
		lo.addActionListener(this);
        lo.setFont(myFont);
		bg.add(lo);
		lo.setBackground(Color.WHITE);
	    lo.setForeground(Color.BLUE);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(660,695,105,30);
		exitBtn.setFont(myFont);
		exitBtn.setBackground(Color.WHITE);
		exitBtn.setForeground(Color.BLUE);
		exitBtn.addActionListener(this);
		exitBtn.addMouseListener(this);
		bg.add(exitBtn);
		
		pp = new JLabel(new ImageIcon("C.png"));
	    pp.setBounds(10,20,150,200);
	    bg.add(pp);
		
		nm = new JLabel("Md. Ashikuzzaman Abir");
		nm.setBounds(200,100,300,70);
	    nm.setFont(myFont);
		nm.setForeground(Color.BLACK);
	    bg.add(nm);
		
		nm2 = new JLabel("22-47006-1");
		nm2.setBounds(200,140,250,55);
	    nm2.setFont(myFont);
		nm2.setForeground(Color.BLACK);
	    bg.add(nm2);
		
		img = new ImageIcon("MAA1.png");
		this.setIconImage(img.getImage());
		
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);		
	}
	
	/*private void setJToggleButton() 
	{  
        button = new JToggleButton("evsjv"); 
        button.setBounds(660,20,100,30);
		button.setFont(new Font("SutonnyMJ", Font.PLAIN, 20));		
        bg.add(button);  
		button.addMouseListener(this);
		button.setBackground(Color.WHITE);
	    button.setForeground(Color.BLUE);
    }  
    private void setAction() 
	{		
        button.addItemListener(this);  
    }  
    public void itemStateChanged(ItemEvent eve) 
	{  
        if (button.isSelected())
		    {  
            button.setText("English");
		    button.setFont(new Font("Arial", Font.PLAIN, 20));
			}
        else{
            button.setText("evsjv");
		    button.setFont(new Font("SutonnyMJ", Font.PLAIN, 25));
			}			
    }*/
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == pr)
		{
			pr.setBackground(Color.GREEN);
			pr.setForeground(Color.WHITE);
		}
		else if(me.getSource() == te)
		{
			te.setBackground(Color.BLUE);
			te.setForeground(Color.WHITE);
		}
		else if(me.getSource() == st)
		{
			st.setBackground(Color.ORANGE);
			st.setForeground(Color.WHITE);
		}
		else if(me.getSource() == no)
		{
			no.setBackground(Color.RED);
			no.setForeground(Color.WHITE);
		}
		else if(me.getSource() == lo)
		{
			lo.setBackground(Color.MAGENTA);
			lo.setForeground(Color.WHITE);
		}
		/*else if(me.getSource() == button)
		{
			button.setBackground(Color.BLUE);
			button.setForeground(Color.WHITE);
		}*/
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(Color.RED);
			exitBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource() == ph)
		{
			ph.setBackground(Color.CYAN);
			ph.setForeground(Color.WHITE);
		}
		else if(me.getSource() == sch)
		{
			sch.setBackground(Color.BLUE);
			sch.setForeground(Color.WHITE);
		}
		else
		{
			
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == pr)
		{
			pr.setBackground(Color.WHITE);
			pr.setForeground(Color.BLUE);
		}
		else if(me.getSource() == te)
		{
			te.setBackground(Color.WHITE);
			te.setForeground(Color.BLUE);
		}
		else if(me.getSource() == st)
		{
			st.setBackground(Color.WHITE);
			st.setForeground(Color.BLUE);
		}
		else if(me.getSource() == no)
		{
			no.setBackground(Color.WHITE);
			no.setForeground(Color.BLUE);
		}
		else if(me.getSource() == lo)
		{
			lo.setBackground(Color.WHITE);
			lo.setForeground(Color.BLUE);
		}
		/*else if(me.getSource() == button)
		{
			button.setBackground(Color.WHITE);
			button.setForeground(Color.BLUE);
		}*/
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(Color.WHITE);
			exitBtn.setForeground(Color.BLUE);
		}
		else if(me.getSource() == ph)
		{
			ph.setBackground(Color.WHITE);
			ph.setForeground(Color.BLUE);
		}
		else if(me.getSource() == sch)
		{
			sch.setBackground(Color.WHITE);
			sch.setForeground(Color.BLUE);
		}
		else
		{
			
		}
	}
	
	    public void actionPerformed(ActionEvent e)
	    {
		    if (e.getSource() == te)
		    {
			     this.setVisible(false);
			     EventQueue.invokeLater(new Runnable()
		        {
			        public void run()
			        {
				     try
					    {
					     Teachers win = new Teachers();
					     win.read();
					     win.setVisible(true);
			            } 
				     catch (Exception e)
					    {
				          e.printStackTrace();
			            }
		            }
	            });
		    }
	    
			else if (e.getSource() == st)
		       {
			     this.setVisible(false);
			     EventQueue.invokeLater(new Runnable()
		        {
			        public void run()
			        {
				     try
					    {
					     Students win = new Students();
					     win.read();
					     win.setVisible(true);
			            } 
				     catch (Exception e)
					    {
				          e.printStackTrace();
			            }
		            }
	            });
		       }
			   else if (e.getSource() == ph)
		       {
			     this.setVisible(false);
			     EventQueue.invokeLater(new Runnable()
		        {
			        public void run()
			        {
				     try
					    {
					     SPay win = new SPay();
					     win.read();
					     win.setVisible(true);
			            } 
				     catch (Exception e)
					    {
				          e.printStackTrace();
			            }
		            }
	            });
		       }
			else if (e.getSource() == no)
			   {
				 
				Notice1 n = new Notice1 ();
				 this.setVisible(false);
		   	   }
            else if (e.getSource() == pr)
			   {
				new Profile();
				this.setVisible(false);
			   }
			else if (e.getSource() == sch)
			   {
				this.setVisible(false);
				 new Schedule2();
			   }
          else if (e.getSource() == lo)
			   {
				this.setVisible(false);
				
				new LogOut();
			   }   
            else if (e.getSource()==exitBtn)
			   {
				 System.exit(0);
			   }				
		}		
/*public static void main(String [] argv)
	{
		Admin a= new Admin();
		a.setVisible(true);
	}*/
}