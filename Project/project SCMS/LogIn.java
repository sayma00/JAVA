import javax.swing.*;
import java.awt.*;
import java.awt.event.*;   
import java.awt.event.ItemEvent;  
import java.awt.event.ItemListener;  
import java.awt.Color;  
import java.awt.Graphics;  
import java.text.*;  
import java.util.*; 
import java.io.*;
import java.nio.file.*;
import java.lang.*;  
 
  
public class LogIn extends JFrame implements ActionListener {  
 
	JLabel header;
	private static JDialog d;  
	JButton b;
	JButton b1;

	JPasswordField value;
	JTextField text1;
	
	String path = "user.txt";
	String content;
	String [] line = new String [1000];
	String [][] data = new String [1000][100];
	String [] temp = new String [1000];
	
	//primary key "pk"
	String pk = new String();
    
	//main constructor
	LogIn() {  
        setTitle("Log In");  
        setLayout(null); 	
		
		//password field & login button
		value = new JPasswordField();   
		value.setBounds(348,231, 130,30);
		value.setEchoChar('*');
		
		JLabel l5=new JLabel(new ImageIcon("lock.png"));   
		l5.setBounds(308,231,30, 30); 
		add(l5);
		
		//Pending
		text1 = new JTextField();  
        text1.setBounds(348,186, 130,30);
		
		JLabel l4=new JLabel(new ImageIcon("user.png"));    
		l4.setBounds(308,186,30, 30); 
		add(l4);
		
		b = new JButton("Log in");  
			b.setBounds(308,276, 170,30);
			b.setFont(new Font("Viking Squad", Font.PLAIN, 25));
			b.setForeground(Color.BLACK);
			b.setBackground(Color.WHITE);
			this.b.addActionListener(this);
		
		add(b);
		add(text1);
		add(value);

		//forgot button
		JLabel l3=new JLabel("Forgot Password?");    
			l3.setBounds(287,340, 110,20);
		
        b1 = new JButton("Click Here");  
			b1.setBounds(399,340, 100,20);
			b1.setFont(new Font("Viking Squad", Font.PLAIN, 16));
			b1.setForeground(Color.BLACK);
			b1.setBackground(Color.WHITE);
			this.b1.addActionListener(this);
		add(l3);
		add(b1);
		
		//Adding logo
		JLabel label1 = new JLabel(new ImageIcon("logo2.png"));
			label1.setBounds(333,60,120,106);
			add(label1);
		
		JLabel labelx = new JLabel();
			labelx.setBounds(251,35,282,351);
			labelx.setOpaque(true);
			labelx.setBackground(new Color(132, 210, 252));
			
		add(labelx);
		
		JLabel label = new JLabel(new ImageIcon("School Small.png"));
			label.setBounds(0,0,786,763);
			add(label);
		
		
		//frame
        setSize(800, 800); 
		setLocationRelativeTo(null);		
        setVisible(true);  
		
		
		//change icon
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
		setIconImage(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }   
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == b)
		{
			try 
			{
				content = new String(Files.readString(Paths.get(path)));
				
				line = content.split(","); 
				int n = line.length;
				boolean flag = false;
				boolean flag1 = false;
				boolean flag2 = false;
			
				for(int i = 0; i < n; i++)
				{	
					temp = line[i].split("  "); 
					int t = temp.length;
					
					for(int j = 0; j < t; j++)
					{
						data[i][j] = temp[j];
					}
					
				}
				
				for(int i = 0; i < data.length; i++)
				{
					if(data[i][0]!=null)
					{
						if (data[i][2].equals(value.getText()))
						{
							if (data[i][1].equals(text1.getText()))
							{
								String s = text1.getText();
								if(s.charAt(s.length()-1) == '0')
								{
									flag = true;
									pk = data[i][0];
								}
								else if(s.charAt(s.length()-1) == '1')
								{
									flag1 = true;
									pk = data[i][0];
								}	
								else if(s.charAt(s.length()-1) == '2')
								{
									flag2 = true;
									pk = data[i][0];
								}
							} 
							break;
						}	
					}
					else{
						break;
					}
				}
				
				if(flag == true)
				{
					JOptionPane.showMessageDialog(null,"Successfully Logged In.");
					setVisible(false);
					Admin a = new Admin();
				}
				else if(flag1 == true)
				{
					JOptionPane.showMessageDialog(null,"Successfully Logged In.");
					setVisible(false);
					new Teacher(pk);
				}
				else if(flag2 == true)
				{
					JOptionPane.showMessageDialog(null,"Successfully Logged In.");
					setVisible(false);
					new Student(pk);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid user/password");
				}
				
			} 
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}	
		}
		
		else if (e.getSource() == b1)
		{
			setVisible(false);
			new ForgotPass ();
		}
	}
	
}  