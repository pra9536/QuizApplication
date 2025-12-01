
/* package quiz.app;
import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class Login extends JFrame  {
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1000, 500);// set size of frame
        setLocation(200, 150);// distance of frame from x-axis and y-axis
        setVisible(true);// bydefault Visibility is false
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png")); // image ko frame ke ander lekar aana
        Image i = i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT); // image ko kuch scale value dena i.e provide width and height
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        setBounds(450, 0, 550, 500);// x and y se kaha rahega
        add(image);
    }

    public static void main(String[] args) throws Exception {
        new Login();
    }
}*/
package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener { // perform click event
    JTextField text;
    JButton Next, back;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        try {
            // Attempt to load the image resource
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));

            if (i1 != null) {

                Image i = i1.getImage().getScaledInstance(550,500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i);
                JLabel image = new JLabel(i2);
                image.setBounds(450,0,550,500);
                add(image);
            } else {

                System.err.println("Error: Image resource not found.");
            }
        } catch (Exception e) {

            System.err.println("Error loading image: " + e.getMessage());
        }

        // showing any text on frame
        JLabel heading = new JLabel("QUIZ TEST");
        heading.setBounds(140,60,300,45);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40)); //type,style,size
        heading.setForeground(new Color(22,99,54));
        add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(160,150,300,20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD,18));
        name.setForeground(new Color(22,99,54));
        add(name);

        text = new JTextField();
        text.setBounds(80,200,300,25);
        text.setFont(new Font("Times New Roman", Font.BOLD,18));
        add(text);

        Next = new JButton("Next");
        Next.setBounds(100,270,120,25);
        Next.setBackground(new Color(22,99,54));
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        add(Next);

        back = new JButton("Back");
        back.setBounds(250,270,120,25);
        back.setBackground(new Color(22,99,54));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // creating main frame
        setSize(1000,500); // to set size of frame
        setLocation(200,150); // to set location of frame on display
        setUndecorated(true);
        setVisible(true); // bydefault visibility is false so its compulsory to make it true if we want to see the frame
    }

    @Override
    // by clicking button what should happen
    public void actionPerformed(ActionEvent e) { // override abstract method
        if (e.getSource() == Next){
            String name = text.getText();
            setVisible(false);
            new Rules(name);
        } else if (e.getSource() == back) {
            System.exit(50);
        }
    }

    public static void main(String[] args) throws Exception {
        new Login();
    }
}
