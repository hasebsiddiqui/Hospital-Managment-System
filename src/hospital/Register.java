/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 * @author abbas
 */
public class Register extends JFrame {
    JLabel l1=new JLabel("Enter Name");
    JLabel l2=new JLabel("Enter Password");
    JLabel l3=new JLabel("Enter Mobile-No.");
    JLabel l4=new JLabel("Enter DOB");
    JLabel l5=new JLabel("Enter Address");
    JLabel l6=new JLabel("Select Gender");
    JLabel l7=new JLabel("Registration System");
    
    JTextField f1=new JTextField();
    JPasswordField f2=new JPasswordField();
    JTextField f3=new JTextField();
    JTextArea a1=new JTextArea();
    JButton b1=new JButton("Submit");
   // JTextArea output =new JTextArea();
    JComboBox Day;
    JComboBox Month;
    JComboBox Year;
    JRadioButton Male;
    JRadioButton Female;
    JCheckBox c1;
  
    
    Container c;
    public Register(){
         c=this.getContentPane();
         c.setLayout(null);
         c.setBackground(Color.CYAN);
         Font f5=new Font("Arial",Font.BOLD,24);
         
      
         l1.setBounds(100,100,100,40);
         l2.setBounds(100,150,100,40);
         l3.setBounds(100,200,100,40);
         l4.setBounds(100,250,100,40);
         l5.setBounds(100,400,100,40);
         l6.setBounds(100,300,100,40);
         l7.setBounds(100,0,300,100);
         l7.setFont(f5);
         f1.setBounds(250,100,80,30);
         f2.setBounds(250,150,80,30);
         f3.setBounds(250,200,80,30);
         a1.setBounds(250,400,200,100);
         b1.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 btnclick(e);
             }

             private void btnclick(ActionEvent e) {
                     if(c1.isSelected()==true)
              {
                  String name=f1.getText();
                  String Pass=f2.getText();
                /*  String Mobile=f3.getText();
                  String d=(String) Day.getSelectedItem();
                  String m=(String) Month.getSelectedItem();
                  String y=(String) Year.getSelectedItem();
                  String Address=a1.getText();
                  String gen="Male";
                  if(Female.isSelected())
                      gen="Female";*/
                  try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url="jdbc:mysql://localhost:3306/abc";
           String uname="root";
           String pass="";
            String query ="use abc";
           String query1 ="INSERT INTO Login VALUES('"+name+"','"+Pass+"')";
           Connection con=DriverManager.getConnection(url,uname,pass);
             
         Statement st=con.createStatement();
          int count1=st.executeUpdate(query);
          int count=st.executeUpdate(query1);
                      System.out.println(count);
                      
          JOptionPane.showMessageDialog(null,"Sucessfully Sign up");
          setVisible(false);
          new login().setVisible(true);
           
         
        
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       }  
 
    }
                     else
                         JOptionPane.showMessageDialog(null,"Please accept terms and conditions");
              }
          
                   
         });
         b1.setBounds(150,600,100,70);
      //   output.setBounds(600,100,400,400);
         
         Male=new JRadioButton("Male");
         Male.setBounds(250,300,70,30);
         
         Female=new JRadioButton("Female");
         Female.setBounds(250,330,70,30);
         
         ButtonGroup g1=new ButtonGroup();
         g1.add(Male);
         g1.add(Female);
         
         c1=new JCheckBox("Accept Terms and Conditions");
         c1.setBounds(100,550,300,40);
         
          String[] Day_arr=new String[31];
          for(int i=1;i<=31;i++)
              Day_arr[i-1]=Integer.toString(i);
          Day=new JComboBox(Day_arr); 
          Day.setBounds(250,250,70,40);
          
          String[] Month_arr={"January","February","March","Abril","May","June","July","August","September","October","November","December"};
          Month=new JComboBox(Month_arr);          
          Month.setBounds(340,250,100,40);
  
          
          String[] Year_arr=new String[80];
          for(int i=1950;i<=2021;i++)
              Year_arr[i-1950]=Integer.toString(i);
         Year=new JComboBox(Year_arr); 
          Year.setBounds(460,250,80,40);
          
        
         c.add(l1);
         c.add(l2);
         c.add(l3);
         c.add(l4);
         c.add(l5);
         c.add(l6);
         
         c.add(f1);
         c.add(f2);
         c.add(f3);
         c.add(Day);
         c.add(Month);
         c.add(Year);
         c.add(a1);
         c.add(Male);
         c.add(Female);
         c.add(c1);
         c.add(b1);
         c.add(l7);
         //c.add(output);
    }  
}
 

