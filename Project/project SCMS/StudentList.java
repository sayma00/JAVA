import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent.*;
import java.text.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class StudentList implements ActionListener, MouseListener
{
	public JFrame frame1;
	
	JComboBox button1;
	JComboBox button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	
	JTable jt;
	JPanel p;
	DefaultTableModel model;
	String filePath;
	File file;
	
	String combo =  new String();
	String combo1 =  new String();
	
	String path = "user.txt";
	String content;
	String [] line = new String [1000];
	String [][] data = new String [1000][100];
	String [] temp = new String [1000];
	
	String [] nLine = new String [100];
	
	String pk5 = new String();
	
	public void ComboBox1()
	{    
		String Class[]= new String[] {"Select Class","1","2","3","4","5"};
		button1 = new JComboBox(Class);
		button1.setBounds(50,80,155,30);
		button1.setFont(new Font("Viking Squad", Font.PLAIN, 25));
		button1.setForeground(new Color(132, 210, 252));
		button1.setBackground(Color.WHITE);
			this.button1.addActionListener(this);
			this.button1.addMouseListener(this);
	}
	
	public void ComboBox2()
	{    
		String Section[]= new String[] {"Select Section","A","B","C"};
		button2 = new JComboBox(Section);
		button2.setBounds(225,80,170,30);
		button2.setFont(new Font("Viking Squad", Font.PLAIN, 25));
		button2.setForeground(new Color(132, 210, 252));
		button2.setBackground(Color.WHITE);
			this.button2.addActionListener(this);
			this.button2.addMouseListener(this);
	}
	
	public StudentList (String pk)
	{
		pk5 = pk;
		frame1 = new JFrame("Student List");
		frame1.setLayout(null);
		
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
				}	
			}	
        } 
		catch (Exception ex) 
		{
            ex.printStackTrace();
        }
	
			/*********** setting buttons *************/
				ComboBox1();
				ComboBox2();
				
				button3 = new JButton("Show List");
					button3.setBounds(415,80,125,30);
					button3.setFont(new Font("Viking Squad", Font.PLAIN, 25));
					button3.setForeground(new Color(132, 210, 252));
					button3.setBackground(Color.WHITE);
						this.button3.addActionListener(this);
						this.button3.addMouseListener(this);
				
				button4 = new JButton();
					button4.setText("Delete");
					button4.setBounds(636,650,100,30);
					button4.setFont(new Font("Viking Squad", Font.PLAIN, 25));
					button4.setForeground(new Color(132, 210, 252));
					button4.setBackground(Color.WHITE);
						this.button4.addActionListener(this);
						this.button4.addMouseListener(this);
				
				button5 = new JButton();
					button5.setText("Back");
					button5.setBounds(20,711,80,30);
					button5.setFont(new Font("Viking Squad", Font.PLAIN, 25));
					button5.setForeground(new Color(132, 210, 252));
					button5.setBackground(Color.WHITE);
						this.button5.addActionListener(this);
						this.button5.addMouseListener(this);
				
				button6 = new JButton();
					button6.setText("LogOut");
					button6.setBounds(664,20,100,30);
					button6.setFont(new Font("Viking Squad", Font.PLAIN, 20));
					button6.setForeground(new Color(132, 210, 252));
					button6.setBackground(Color.WHITE);
						this.button6.addActionListener(this);
						this.button6.addMouseListener(this);
						
				button7 = new JButton();
					button7.setText("Upload Grade");
					button7.setBounds(450,650,170,30);
					button7.setFont(new Font("Viking Squad", Font.PLAIN, 25));
					button7.setForeground(new Color(132, 210, 252));
					button7.setBackground(Color.WHITE);
						this.button7.addActionListener(this);
						this.button7.addMouseListener(this);						
			/*************************************/
			
				/****************** setting icon *****************/
					ImageIcon icon = new ImageIcon("icon.png");
					frame1.setIconImage(icon.getImage());
				/******************************************/
				
					jt = new JTable();
					String column[] = new String [] {"ID","NAME","PHONE","ADDRESS","DOB","GRNDER","BG","RELIGION","SECTION"};
					model = new DefaultTableModel(); 
					model.setColumnIdentifiers(column);
					jt.setModel(model);
							  
					JScrollPane sp = new JScrollPane(jt);
					sp.setBounds(50,130,686,500);
					sp.setBackground(new Color(254, 228, 225));
					sp.getViewport().setBackground(new Color(254, 228, 225));
					
						JLabel label = new JLabel();
							label.setBounds(0,0,786,763);
							label.setOpaque(true);
							label.setBackground(new Color(173, 214, 204));
					
		/********* adding to frame1 ********/

		frame1.add(sp);
		frame1.add(button1);
		frame1.add(button2);
		frame1.add(button3);
		frame1.add(button4);
		frame1.add(button5);
		frame1.add(button6);
		frame1.add(button7);
		frame1.add(label);

		/*********************************/
		
		frame1.setSize(800, 800);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setBackground(Color.WHITE);
		frame1.setVisible(true);
		frame1.setResizable(false);
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == button1)
		{
			button1.setBackground(Color.WHITE);
			button1.setForeground(new Color(132, 210, 252));
		}
		else if(me.getSource() == button2)
		{
			button2.setBackground(Color.WHITE);
			button2.setForeground(new Color(132, 210, 252));
		}
		else if(me.getSource() == button3)
		{
			button3.setBackground(Color.WHITE);
			button3.setForeground(new Color(132, 210, 252));
		}
		else if(me.getSource() == button4)
		{
			button4.setBackground(Color.WHITE);
			button4.setForeground(new Color(132, 210, 252));
		}
		else if(me.getSource() == button5)
		{
			button5.setBackground(Color.WHITE);
			button5.setForeground(new Color(132, 210, 252));
		}
		else if(me.getSource() == button6)
		{
			button6.setBackground(Color.WHITE);
			button6.setForeground(new Color(132, 210, 252));
		}
		else if(me.getSource() == button7)
		{
			button7.setBackground(Color.WHITE);
			button7.setForeground(new Color(132, 210, 252));
		}
	}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == button1)
		{
			button1.setBackground(new Color(213, 53, 110));
			button1.setForeground(Color.WHITE);
		}
		else if(me.getSource() == button2)
		{
			button2.setBackground(new Color(213, 53, 110));
			button2.setForeground(Color.WHITE);
		}
		else if(me.getSource() == button3)
		{
			button3.setBackground(new Color(213, 53, 110));
			button3.setForeground(Color.WHITE);
		}
		else if(me.getSource() == button4)
		{
			button4.setBackground(new Color(213, 53, 110));
			button4.setForeground(Color.WHITE);
		}
		else if(me.getSource() == button5)
		{
			button5.setBackground(Color.RED);
			button5.setForeground(Color.WHITE);
		}
		else if(me.getSource() == button6)
		{
			button6.setBackground(Color.RED);
			button6.setForeground(Color.WHITE);
		}
		else if(me.getSource() == button7)
		{
			button7.setBackground(new Color(213, 53, 110));
			button7.setForeground(Color.WHITE);
		}
	}
	
	public void write()
	{
		try 
		{
			File file = new File("user.txt");
			if (!file.exists()) 
			{
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
			PrintWriter pw = new PrintWriter(writer);
			for (int i = 0; i < 100; i++) 
			{
				if(nLine [i] == null && nLine [i+1] == null)
				{
					break;
				}
				else if (nLine [i] == null && nLine [i+1] != null)
				{
					i++;
				}
				pw.print(nLine [i] + ",");

			}
			pw.close();
			writer.close();
		}  
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == button3)
		{
			combo = button1.getSelectedItem().toString();
			combo1 = button2.getSelectedItem().toString();
			try
			{
				if(combo.equals("Select Class") || combo1.equals("Select Section"))
				{
					JOptionPane.showMessageDialog(null,"Please select Class & Section prorely!");
				}
				else
				{
					for(int i = 0; i < 100; i++)
					{
						if(data[i][0] != null && data[i][13] != null && data[i][14] != null)
						{
							String w = data[i][1].toString();
							if(w.charAt(w.length()-1) == '2' && data[i][13].equals(combo) && data[i][14].equals(combo1))
							{
								model.addRow(new Object[]{data[i][1],data[i][3],data[i][4],data[i][6],data[i][7],data[i][8],data[i][9],data[i][10],data[i][14]});
							}
						}
					}
				}
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
			
		}
		
		else if (e.getSource() == button4)
		{
			int column = 0;
			int row = jt.getSelectedRow();
			String value = jt.getModel().getValueAt(row, column).toString();
			
			try
			{
				if (row>=0)
				{
					for(int i = 0; i < 100; i++)
					{
						for(int j = 0; j < 100; j++)
						{
							if(data[i][j] == null || data[i][1].equals(value))
							{
								break;
							}	
							else if(j == 0)
							{
								nLine [i] = data[i][j];
							}
							else if(0<j)
							{
								nLine [i] = nLine [i] + "  " + data[i][j];
							}		
						}
					}
					
					model.removeRow(row);
					this.write();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please select a row!");
				}
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
		
		else if (e.getSource()== button5)
		{
			frame1.setVisible(false);
			new Teacher(pk5);
		}
		
		else if (e.getSource()== button7)
		{
			frame1.setVisible(false);
			new UploadGrade (pk5);
		}
		
		else if (e.getSource()== button6)
		{
			ImageIcon a = new ImageIcon("Untitled-1.png");
			int x = JOptionPane.showOptionDialog(null,"Are you sure you want to Logout?","Confirm Logout",JOptionPane.YES_NO_OPTION,
																			JOptionPane.QUESTION_MESSAGE, a, null,0);
			if (x == 0)
			{
				frame1.setVisible(false);
				new LogOut();
			}
		}
		
	}
}