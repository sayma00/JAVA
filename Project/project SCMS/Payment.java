import java.awt.EventQueue;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;  
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent.*;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import java.text.*;
import java.util.*;
import javax.swing.JToggleButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.nio.file.*;

public class Payment extends JFrame implements ActionListener
{
	
	Font myFont;
	JLabel tl,bg;
	ImageIcon img;
	private JToggleButton button;
	private JButton ba,lo;
	private JTable table;
	private JScrollPane jsp;
	DefaultTableModel model;
	
	String pk8 = new String();
	
    Payment(String pk)
	{
        super("Payment");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		
		  
		pk8 = pk;
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		myFont = new Font("Arial", Font.PLAIN, 18);
		
		bg = new JLabel();
		bg.setBackground(new Color(51,153,255));
	    bg.setBounds(00,00,800,800);
	    //this.add(bg);
		this.getContentPane().add(bg);
		bg.setLayout(null);
		
		jsp = new JScrollPane();
		jsp.setBounds(20,150,750,350);
		bg.add(jsp);
		
		table = new JTable();
		table.setBackground(Color.cyan);
		model = new DefaultTableModel();
		Object[] column = {"Purpose","Amount","Status"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		jsp.setViewportView(table);
	  
	    lo = new JButton();
		lo.setText("Logout");
	    lo.setBounds(510, 20, 93,23); 
		//lo.addMouseListener(this);
		lo.addActionListener(this);
		lo.setFont(myFont);
	    bg.add(lo);
		lo.setBackground(Color.WHITE);
	    lo.setForeground(Color.BLUE);
		lo.addActionListener(new ActionListener(){
			
			
						public void actionPerformed(ActionEvent e)
						{
							
							 EventQueue.invokeLater(new Runnable()
							{
								public void run()
								{
								 try
									{
									 new LogOut();
									 this.setVisible(false);
									} 
								 catch (Exception e)
									{
									  e.printStackTrace();
									}
								}
							});   
							
							}
					});
		
	    ba = new JButton();
        ba.setText("Back");		
	    ba.setBounds(10, 690, 93,23);
		ba.addActionListener(this);
        ba.setFont(myFont);
		bg.add(ba);
		ba.setBackground(Color.WHITE);
	    ba.setForeground(Color.BLUE);
		ba.addActionListener(new ActionListener(){
			
			
						public void actionPerformed(ActionEvent e)
						{
							
							 EventQueue.invokeLater(new Runnable()
							{
								public void run()
								{
								 try
									{
									 Student s = new Student(pk8);
									 //win.read();
									 s.setVisible(true);
									 this.setVisible(false);
									} 
								 catch (Exception e)
									{
									  e.printStackTrace();
									}
								}
							});   
							
							}
					});
		
		tl = new JLabel("Payment History");
		tl.setBounds(250,80,350,70);
	    tl.setFont(new Font("Arial", Font.PLAIN, 28));
		tl.setForeground(Color.BLUE);
	    bg.add(tl);
		
		img = new ImageIcon("icon.png");
		this.setIconImage(img.getImage());
	}
	
		public  void read() 
		{
        try {
                File file = new File("PH.txt");
                FileReader read = new FileReader(file);
                BufferedReader reader = new BufferedReader(read);
            
                Object[] lines = reader.lines().toArray();

                    for (int i = 0; i < lines.length; i++) 
			        {
                    String[] row = lines[i].toString().split(",");
                    model.addRow(row);
                    }

                reader.close();
            }

                catch (IOException ae) 
		        {
                   //JOptionPane.showMessageDialog(null, "Error");
                   ae.printStackTrace();
                }
        }
    
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == ba)
		    {
				this.setVisible(false);
			    new Student(pk8);
		    }
		else if (e.getSource() == lo)
			{
				/*this.setVisible(false);
				LogIn lp = new LogIn();*/
			}
	}	  
	
     
}  