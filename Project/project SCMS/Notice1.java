import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent.*;
import java.text.*;
import java.util.*;

public class Notice1 extends JFrame implements ActionListener //ItemListener,   
{
	//public JFrame frame1;
	Font myFont;
	JButton up;
	JButton del;
	JButton ba;
	JButton lo;
	JLabel un;
	JLabel bg;
	JLabel tit;
	JButton n1;
	JButton n2;
	JButton n3;
	JButton n4;
	ImageIcon img;
	//JToggleButton button4;
	
	
	
	public Notice1 ()
	{
		super("Notice");
		this.setLayout(null);
		this.setResizable(false);
		
		myFont = new Font("Viking Squad", Font.PLAIN, 18);
		
		bg = new JLabel((new ImageIcon("teacher1.png")));//(new ImageIcon("bgs.jpg"));
		bg.setBackground(new Color(51,153,255));
	    bg.setBounds(00,00,800,800);
	    this.add(bg);
		
					up = new JButton();
						up.setText("Update");
						up.setBounds(200,600,130,30);
						up.setFont(new Font("Viking Squad", Font.PLAIN, 25));
						up.setForeground(Color.BLUE);
						up.setBackground(Color.WHITE);
						
						del = new JButton();
						del.setText("Delete");
						del.setBounds(500,600,130,30);
						del.setFont(new Font("Viking Squad", Font.PLAIN, 25));
						del.setForeground(Color.BLUE);
						del.setBackground(Color.WHITE);
					
					ba = new JButton();
						ba.setText("Back");
						ba.setBounds(10, 690, 93,23);
						ba.addActionListener(this);
						ba.setFont(new Font("Viking Squad", Font.PLAIN, 25));
						ba.setForeground(Color.BLUE);
						ba.setBackground(Color.WHITE);
					    
					
					lo = new JButton();
						lo.setText("LogOut");
						lo.setBounds(660, 20, 120, 30);
						lo.setFont(new Font("Viking Squad", Font.PLAIN, 28));
						lo.addActionListener(this);
						lo.setForeground(Color.BLUE);
						lo.setBackground(Color.WHITE);
						
					JLabel un = new JLabel();
					un.setBounds(40,150,704,430);
					un.setOpaque(true);
					un.setBackground(Color.cyan);
					
					tit = new JLabel();
					tit.setText("Latest Notices");
					tit.setBounds(300,70,704,110);
					tit.setFont(new Font("Viking Squad", Font.PLAIN, 35));
					tit.setForeground(Color.BLUE);
					
					tit.setOpaque(true);
					//tit.setBackground(Color.cyan);
					
					n1 = new JButton();
					n1.setBounds(20,20,600,40);
					n1.setText("Holiday due to National Mourning Day, 2022");
				    n1.setOpaque(true);
					n1.addActionListener(this);
					n1.setBackground(Color.GRAY);
					n1.setForeground(Color.BLACK);
					
					n2 = new JButton();
					n2.setBounds(20,70,600,40);
					n2.setText("Mid-Term seat plan.");
				    n2.setOpaque(true);
					n2.addActionListener(this);
					n2.setBackground(Color.GRAY);
					n2.setForeground(Color.BLACK);
					
					n3 = new JButton();
					n3.setBounds(20,120,600,40);
					n3.setText("Mid-tern Permit Distribution");
				    n3.setOpaque(true);
					n3.addActionListener(this);
					n3.setBackground(Color.GRAY);
					n3.setForeground(Color.BLACK);
					
					n4 = new JButton();
					n4.setBounds(20,170,600,40);
					n4.setText("Midterm Routine has been published (STD I - VIII)");
				    n4.setOpaque(true);
					n4.addActionListener(this);
					n4.setBackground(Color.GRAY);
					n4.setForeground(Color.BLACK);
					
					img = new ImageIcon("MAA1.png");
		            this.setIconImage(img.getImage());
				
		bg.add(up);
		bg.add(ba);
		bg.add(lo);
		bg.add(un);
		bg.add(del);
        bg.add(tit);
		un.add(n1);
		un.add(n2);
		un.add(n3);
		un.add(n4);
		
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame1.getContentPane().setBackground(Color.GRAY);
		this.setVisible(true);
	}
    
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == ba)
		    {
				this.setVisible(false);
			    new Admin();
		    }
		else if (e.getSource() == lo)
			{
			    this.setVisible(false);
				new LogOut();
			}
		else if (e.getSource() == n4)
			{
			    this.setVisible(false);
				new MTR();
			}
		/*else if (e.getSource() == l2)
			{
			    this.setVisible(false);
				
			}
	    else if (e.getSource() == l3)
			{
			    this.setVisible(false);
				
			}*/
	}
	
	/*public static void main(String[] args)
	{  
		new Notice();
	}*/
}