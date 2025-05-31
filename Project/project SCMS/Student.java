import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.event.ActionEvent.*;
import java.text.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*; 
 

public class Student extends JFrame
{
    ImageIcon img;
	JLabel labell,sLabel,nLabel,iLabel;
	JPanel panel;
	JButton viewBtn,resultBtn,noticeBtn,sBtn,paymentBtn,s2Btn,lBtn,bBtn; 
	JLabel background;
		Font myFont;
		
	String path = "user.txt";
	String content;
	String [] line = new String [1000];
	String [][] data = new String [1000][100];
	String [] temp = new String [1000];

	String pk6 = new String();
	int  a;
	
	public Student(String pk)
	{
		super("Student");
		this.setSize(800, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		
		pk6 = pk;
		try 
		{
			content = new String(Files.readString(Paths.get(path)));
			line = content.split(",");  
			int n = line.length;
		
			for(int i = 0; i < n; i++)
			{	
				temp = line[i].split("  "); 
				int t = temp.length;
				
				for(int j = 0; j < t; j++)
				{
					data[i][j] = temp[j];
					if (data[i][0].equals(pk6))
					{
						a = i;
					}
				}	
			}	
        } 
		catch (Exception ex) 
		{
            ex.printStackTrace();
        }
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		img = new ImageIcon("icon.png");
		this.setIconImage(img.getImage());
		
		nLabel = new JLabel(data[a][3]);
		nLabel.setBounds(230, 60, 160, 80);
		nLabel.setOpaque(true);
		myFont = new Font("Arial",Font.PLAIN,16);
		nLabel.setFont(myFont);
		panel.add(nLabel);
		iLabel = new JLabel(data[a][1]);
		iLabel.setBounds(230, 110, 160, 80);
		iLabel.setOpaque(true);
		myFont = new Font("Arial",Font.PLAIN,16);
		iLabel.setFont(myFont);
		panel.add(iLabel);
		
		
		viewBtn = new JButton("View Profile");
		viewBtn.setBounds(300, 250, 220, 30);
		viewBtn.setFont(new Font("Viking Squad", Font.PLAIN, 20));
		viewBtn.setForeground(Color.BLUE);
		panel.add(viewBtn);
		
		
		viewBtn.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e)
			{
				ViewProfile1 v = new ViewProfile1(pk6);
				v.setVisible(true);
			    this.setVisible(false);
			}
		});
		
		
		resultBtn = new JButton("Result");
		resultBtn.setBounds(300, 300, 220, 30);
		resultBtn.setFont(new Font("Viking Squad", Font.PLAIN, 20));
		resultBtn.setForeground(Color.BLUE);
		
		panel.add(resultBtn);
		
		resultBtn.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e)
			{
				
				Result f=new Result(pk6);
				f.setVisible(true);
				this.setVisible(false);
				}
		});
		
		
		
		noticeBtn = new JButton("Notice");
		noticeBtn.setBounds(300, 350, 220, 30);
		noticeBtn.setFont(new Font("Viking Squad", Font.PLAIN, 20));
		noticeBtn.setForeground(Color.BLUE);
		panel.add(noticeBtn);
		
		noticeBtn.addActionListener(new ActionListener()
		{
			
			
			public void actionPerformed(ActionEvent e)
			{
				
				Notice n =new Notice(pk6);
				n.setVisible(true);
				this.setVisible(false);
				}
		});
		
		
		sBtn = new JButton("Class Schedule");
		sBtn.setBounds(300, 400, 220, 30);
		sBtn.setFont(new Font("Viking Squad", Font.PLAIN, 20));
		sBtn.setForeground(Color.BLUE);
		panel.add(sBtn);
		sBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Schedule1 (pk6);
				this.setVisible(false);
			}
		});
		
		paymentBtn = new JButton("Payment");
		paymentBtn.setBounds(300, 450, 220, 30);
		paymentBtn.setFont(new Font("Viking Squad", Font.PLAIN, 20));
		paymentBtn.setForeground(Color.BLUE);
		
		panel.add(paymentBtn);
		
		paymentBtn.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e)
			{
				
				 EventQueue.invokeLater(new Runnable()
		        {
			        public void run()
			        {
				     try
					    {
					     Payment win = new Payment(pk6);
					     win.read();
					     win.setVisible(true);
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
		
		
		lBtn = new JButton("Logout");
		lBtn.setBounds(650, 30, 100, 30);
		lBtn.setFont(new Font("Viking Squad", Font.PLAIN, 15));
		lBtn.setForeground(Color.BLUE);
		panel.add(lBtn);
		lBtn.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e)
			{
				
				 EventQueue.invokeLater(new Runnable()
		        {
			        public void run()
			        {
				     try
					    {
							ImageIcon a = new ImageIcon("Untitled-1.png");
							int x = JOptionPane.showOptionDialog(null,"Are you sure you want to Logout?","Confirm Logout",JOptionPane.YES_NO_OPTION,
																							JOptionPane.QUESTION_MESSAGE, a, null,0);
							if (x == 0)
							{
								new LogOut();
								this.setVisible(false);
							}
			            } 
				     catch (Exception e)
					    {
				          e.printStackTrace();
			            }
		            }
	            });   
				
				}
		});
		
		
		
		
		bBtn = new JButton("Back");
		bBtn.setBounds(30, 700, 80, 30);
		bBtn.setFont(new Font("Viking Squad", Font.PLAIN, 15));
		bBtn.setForeground(Color.BLUE);
		panel.add(bBtn);
		bBtn.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e)
			{
				
				 EventQueue.invokeLater(new Runnable()
		        {
			        public void run()
			        {
				     try
					    {
							ImageIcon a = new ImageIcon("Untitled-1.png");
							int x = JOptionPane.showOptionDialog(null,"Do you want to Logout?","Confirm Logout",JOptionPane.YES_NO_OPTION,
																							JOptionPane.QUESTION_MESSAGE, a, null,0);
							if (x == 0)
							{
								new LogOut();
								this.setVisible(false);
							}
			            } 
				     catch (Exception e)
					    {
				          e.printStackTrace();
			            }
		            }
	            });   
				
				}
		});
		
		
		
		
		
	
		
	JLabel sLabel=new JLabel();
		sLabel.setIcon(new ImageIcon(new ImageIcon(data[a][12]).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		sLabel.setBounds(30,20,150, 150); 
		panel.add(sLabel);
		
	
	this.add(panel);
	}
		
}