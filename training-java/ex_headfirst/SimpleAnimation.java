/**
 * Of76
 */
import java.util.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;

public class SimpleAnimation{
    JLabel label;
    JFrame frame;
    JPanel panel;
    int x = 70, y = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }
    
    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();

        JButton labelButton = new JButton("Change label");
        JButton colorButton = new JButton("Change color");
        
        labelButton.addActionListener(new labelListener());
        colorButton.addActionListener(new colorListener());

        label = new JLabel("I am a label");
        MyDrawPanel drawpanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawpanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.setSize(300, 300);
        frame.setVisible(true);

    }
    class labelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            label.setText("My name is Binh");
        }
    }

    class colorListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            frame.repaint();
        }
    }
    class MyDrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.green);
            g.fillOval(7, 7, 10, 10);
        }
    }
}