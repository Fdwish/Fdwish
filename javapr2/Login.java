/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_abdelaziz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    String employee[][]={{"abdel aziz","123456"},{"ahmed","111"},{"meshary","222"}};
    JLabel l1=new JLabel("Name:");
    JLabel l2=new JLabel("password");
     JLabel l3=new JLabel("");
    JTextField t1=new JTextField(10);
    JTextField t2=new JTextField(10);
    JButton b1=new JButton("Log in");
    public Login(){
        setSize(500,500);
        setTitle("Log in");
        setVisible(true);
        setLayout(new GridLayout(3,2));
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(l3);
      b1.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String n=t1.getText();
        String p=t2.getText();
        String x="Not Found";
        for(int i=0;i<employee.length;i++){
            if(employee[i][0].equals(n)&&employee[i][1].equals(p))
              x="welcom "+t1.getText();
            
        }
      l3.setText(x);
    }
}
