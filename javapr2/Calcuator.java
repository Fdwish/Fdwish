/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Calcuator extends JFrame implements ActionListener {
    JTextField t1=new JTextField(5);
     JTextField t2=new JTextField(5);
     JRadioButton j1=new JRadioButton("  +  ");
       JRadioButton j2=new JRadioButton("  -  ");
         JRadioButton j3=new JRadioButton("  *  ");
         JButton b1=new JButton("Calculate");
         JLabel l1=new JLabel("result");
         public Calcuator(){
             setSize(500, 500);
        setLayout(new GridLayout(4,1));
        setTitle("CALCULATOR");
        setVisible(true);
        j2.setSelected(true);
             JPanel p1=new JPanel(new FlowLayout());
             p1.add(t1);  p1.add(t2);
             add(p1);
            JPanel p2=new JPanel(new FlowLayout());
            p2.add(j1);p2.add(j2);p2.add(j3);
             ButtonGroup gp=new ButtonGroup();
             gp.add(j1);gp.add(j2);gp.add(j3);
            add(p2);
            add(b1);
            add(l1);
            b1.addActionListener(this);
         }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
      int x=Integer.parseInt(t1.getText());
      int y=Integer.parseInt(t2.getText());
      if(j1.isSelected())
          l1.setText(x+" + "+y+" = "+(x+y));
      else  if(j2.isSelected())
          l1.setText(x+" - "+y+" = "+(x-y));
      else
           l1.setText(x+" * "+y+" = "+(x*y));
        }catch(Exception eX){
            l1.setText("    ERROR IN OPERATION ");
        }
    }

}
