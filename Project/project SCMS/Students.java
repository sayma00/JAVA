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

public class Students extends JFrame implements ActionListener , MouseListener /*, ItemListener*/
{
	
	Font myFont;
	JLabel tl,bg;
	ImageIcon img;
	
	//private JToggleButton button;
	
	private JFrame f;
	private JTextField t1,t2,t3,t4;
	private JButton adb,deb,upb,clb,ba,lo;
	JLabel id,nm,cls,sec;
	private JTable table;
	private JScrollPane jsp;
	DefaultTableModel model;
	
    Students()
	{    
        super("Students");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		//this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		myFont = new Font("Viking Squad", Font.PLAIN, 22);
		
		bg = new JLabel((new ImageIcon("teacher1.png")));//(new ImageIcon("bgs.jpg"));
		bg.setBackground(new Color(51,153,255));
	    bg.setBounds(00,00,800,800);
	    //this.add(bg);
		this.getContentPane().add(bg);
		bg.setLayout(null);
		
		id = new JLabel();
		id.setText("ID:");
		id.setFont(new Font("Viking Squad", Font.PLAIN, 20));
		id.setBounds(41, 550, 46, 14);
		bg.add(id);
		
		nm =  new JLabel();
		nm.setText("Name:");
		nm.setFont(new Font("Viking Squad", Font.PLAIN, 20));
		nm.setBounds(41, 570, 46, 14);
		bg.add(nm);
		
		cls =  new JLabel();
		cls.setText("Class:");
		cls.setFont(new Font("Viking Squad", Font.PLAIN, 20));
		cls.setBounds(41, 590, 50, 14);
		bg.add(cls);
		
		sec = new JLabel();
		sec.setText("Section:");
		sec.setFont(new Font("Viking Squad", Font.PLAIN, 20));
		sec.setBounds(41, 610, 80, 14);
		bg.add(sec);
		
		
		t1 = new JTextField();
		t1.setBounds(140, 550, 200, 20);
		bg.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(140, 570, 200, 20);
		bg.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(140, 590, 200, 20);
		bg.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(140, 610, 200,20);
		bg.add(t4);
		t4.setColumns(10);
		
		jsp = new JScrollPane();
		jsp.setBounds(20,150,750,350);
		bg.add(jsp);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setBackground(Color.cyan);
		model = new DefaultTableModel();
		Object[] column = {"ID","Name","Class","Section"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		jsp.setViewportView(table);

        adb = new JButton();
		adb.setText("Add");
		adb.setFont(myFont);
		adb.addActionListener(this);
		adb.setBounds(420,560,93,23);
		adb.setForeground(Color.BLUE);
		adb.setBackground(Color.WHITE);
		bg.add(adb);
		
		deb = new JButton();
		deb.setText("Delete");
		deb.setFont(myFont);
		deb.addActionListener(this);
		deb.setBounds(420,600,93,23);
		deb.setForeground(Color.BLUE);
		deb.setBackground(Color.WHITE);
		bg.add(deb);
		
		upb = new JButton();
		upb.setText("Update");
		upb.setFont(myFont);
		upb.addActionListener(this);
		upb.setBounds(520,560,93,23);
		upb.setForeground(Color.BLUE);
		upb.setBackground(Color.WHITE);
		bg.add(upb);
		
		clb = new JButton();
		clb.setText("Clear");
		clb.setFont(myFont);
		clb.addActionListener(this);
		clb.setBounds(520,600,93,23);
		
		clb.setForeground(Color.BLUE);
		clb.setBackground(Color.WHITE);
		bg.add(clb);
	  
	    lo = new JButton();
		lo.setText("Logout");
	    lo.setBounds(660, 20, 120, 30); 
		//lo.addMouseListener(this);
		lo.addActionListener(this);
		lo.setFont(new Font("Viking Squad", Font.PLAIN, 28));
	    bg.add(lo);
		lo.setBackground(Color.WHITE);
	    lo.setForeground(Color.BLUE);
		
	    ba = new JButton();
        ba.setText("Back");		
	    ba.setBounds(10, 690, 93,23);
		ba.addActionListener(this);
        ba.setFont(myFont);
		bg.add(ba);
		ba.setBackground(Color.WHITE);
	    ba.setForeground(Color.BLUE);
		
		tl = new JLabel("Students List");
		tl.setBounds(250,80,350,70);
	    tl.setFont(new Font("Viking Squad", Font.PLAIN, 35));
		tl.setForeground(Color.BLUE);
	    bg.add(tl);
		
		img = new ImageIcon("MAA1.png");
		this.setIconImage(img.getImage());
	}
	
		public  void read() 
		{
        try {
                File file = new File("SD.txt");
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
		
		public  void write()
		{
		    try 
			{
			    File file = new File("SD.txt");
			    if (!file.exists()) 
				{
				file.createNewFile();
			    }
			    FileWriter writer = new FileWriter(file);
			    BufferedWriter bw = new BufferedWriter(writer);
			for (int i = 0; i < model.getRowCount(); i++) 
			    {
				    for (int j = 0; j < model.getColumnCount(); j++) 
				    {
					    bw.write(model.getValueAt(i, j) + ",");
				    }
				        bw.write("\r\n");
			    }
			    bw.close();
			    writer.close();
		    }  
			    catch (Exception ex) 
			    {
			        ex.printStackTrace();
		        }
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
		else if(e.getSource()==adb)
		{
			if (t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Fill Complete Information");
			}
			else
			{
				Object[] row = new Object[4];
		    	row[0] = t1.getText();
				row[1] = t2.getText();
				row[2] = t3.getText();
				row[3] = t4.getText();
				
				model.addRow(row); 
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				
				this.write();
				JOptionPane.showMessageDialog(null,"Saved Successfully");
		    }
		}
		else if(e.getSource()==deb)
		{ 
	      int i=table.getSelectedRow();
		  if (i>=0)
		  {
		    model.removeRow(i);
			this.write();
		    JOptionPane.showMessageDialog(null,"Deleted Successfully");
		  }
		  else
		  {
		    JOptionPane.showMessageDialog(null,"Please Select a Row First");
		  }
		}
		else if(e.getSource()==clb)
		{ 
	        t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
		
		}
		else if(e.getSource()==upb)
		{ 
           	int i = table.getSelectedRow();
	        if (i>=0)
		   {
		    model.setValueAt(t1.getText(), i, 0);
			model.setValueAt(t2.getText(), i, 1);
			model.setValueAt(t3.getText(), i, 2);
			model.setValueAt(t4.getText(), i, 3);
			
			this.write();
		    JOptionPane.showMessageDialog(null,"Updated Successfully");
		   }
	        else
		   {
			JOptionPane.showMessageDialog(null,"Please Select a Row First");
		   }
		}	
	}
	public void mouseEntered(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me)
	{
	int i = table.getSelectedRow();
	t1.setText(model.getValueAt(i,0).toString());
	t2.setText(model.getValueAt(i,1).toString());
	t3.setText(model.getValueAt(i,2).toString());
	t4.setText(model.getValueAt(i,3).toString());
	
	}

	
      /*public static void main(String[] args) 
	  {    
          Students s= new Students();
		  s.setVisible(true);    
      } */   
}  