/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_abdelaziz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Abo_mohamed
 */
public class Counter extends JFrame implements ActionListener{
    JButton b=new JButton(" + ");
    JButton b2=new JButton(" - ");
    JTextField t1=new JTextField("0",5);
    public Counter(){
        setSize(50, 30);
        setLayout(new FlowLayout());
        setTitle("counter");
        setVisible(true);

add(b);add(t1);add(b2);
b.addActionListener(this);
b2.addActionListener(this);
t1.setEnabled(false);
    }
    int counter=0;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b){
       counter++;
       t1.setText(counter+"");
        }else{
         counter--;
       t1.setText(counter+"");
        }
    }


}
