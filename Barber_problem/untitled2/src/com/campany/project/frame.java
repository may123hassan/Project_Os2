package com.campany.project;
import com.campany.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame {

public frame(){
            //Creating the Frame

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(400, 400);


            //Creating the panel at bottom and adding components
            JPanel panel = new JPanel();
            // the panel is not visible in output
            JLabel label = new JLabel("Enter number of barber" );
            //Creating the panel at bottom and adding components
            JTextField tf = new JTextField(10);
            JLabel label1 = new JLabel("Enter number of chairs");
            JTextField th = new JTextField(10);  // accepts upto 10 characters
            JButton submit = new JButton("Submit");


            panel.add(label);
             panel.add(tf);
            panel.add(label1);
            panel.add(th);
            panel.add(submit);


            this.setVisible(true);
            this.setTitle("sleeping barber");
            this.add(panel);

            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource()==submit){
                        new Main(Integer.parseInt(tf.getText()),Integer.parseInt(th.getText()));

                    }

                }
            });

}



    }





