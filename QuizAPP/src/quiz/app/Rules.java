
package quiz.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    JButton start, back;
    String name;

    Rules(String name){

        this.name = name;

        //to write quizzer name on main frame
        JLabel heading = new JLabel("Welcome "+ name +" to QUIZ TEST");
        heading.setBounds(150,100,700,30);
        heading.setFont( new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(22,99,54));
        add(heading);

        // to write rules on main frame
        JLabel rules = new JLabel();
        rules.setBounds(70,150,700,350);
        rules.setFont( new Font("Tahoma", Font.PLAIN, 16));
        rules.setForeground(new Color(22,99,54));
        rules.setText(
                "<html>"+
                        "1. Participation in the quiz is free and open to all persons above 18 years old." + "<br><br>" +
                        "2. There are a total 10 questions. " + "<br><br>" +
                        "3. You only have 15 seconds to answer the question." + "<br><br>" +
                        "4. No cell phones or other secondary devices in the room or test area." + "<br><br>" +
                        "5. No talking." + "<br><br>" +
                        "6. No one else can be in the room with you." + "<br><br>" +
                        "<html>"
        );
        add(rules);

        //code to create back button
        back = new JButton("Back");
        back.setBounds(300,500,100,30);
        back.setBackground(new Color(22,99,54));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //code to create start button
        start = new JButton("Start");
        start.setBounds(450,500,100,30);
        start.setBackground(new Color(22,99,54));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        // image ko frame pe laane ke liye
//
        try {
            // Attempt to load the image resource
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));

            if (i1 != null) {
                // Scale the image
                Image i = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i);
                JLabel image = new JLabel(i2);
                image.setBounds(0, 0, 800, 650);
                add(image);
            } else {
                // If the resource is not found, display a message to the console
                System.err.println("Error: Image resource not found.");
            }
        } catch (Exception e) {
            // If an exception occurs during loading, display an error message to the console
            System.err.println("Error loading image: " + e.getMessage());
        }


        setSize(800,650);
        setLocation(350,100);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    // button pe click karne se kya hoga
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start){
            setVisible(false);
            new Quiz(name);
        }else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {

        new Rules("User");
    }
}



