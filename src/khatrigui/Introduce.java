/* 2/4/20 Divya Khatri 
This GUI will comput the dot product of two vectors
this class will introduce the user to the program and what it will do
 */
package khatrigui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Introduce extends JFrame implements ActionListener
{

    //declare variables
    public static final Font NOICE_FONT = new Font("Braggadocio", Font.BOLD, 30);
    public static final Color TURQUOISE = new Color(66, 138, 150);
    public static final Color PURPLE = new Color(147, 112, 219);
    private JLabel welcomeLabel;
    private JLabel imageLabel;
    private JButton inputButton;
    private JPanel buttonPanel;

    //getting the image
    private final java.net.URL MY_PATH = getClass().getResource("Welcome.gif");
    private final ImageIcon WELCOME_IMAGE = new ImageIcon(new ImageIcon(
            MY_PATH).getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT));

    //constructor
    public Introduce()
    {
        //construct frame
        super("Welcome!");
        this.setBounds(100, 500, 1200, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(TURQUOISE);
        this.setLayout(new BorderLayout());

        //create labels
        this.welcomeLabel = new JLabel("Welcome to the program that will help you find the dot product of two vectors!", SwingConstants.CENTER);
        this.welcomeLabel.setFont(NOICE_FONT);
        this.imageLabel = new JLabel(WELCOME_IMAGE);

        //create button
        this.inputButton = new JButton("Input Values!");
        this.inputButton.setFont(NOICE_FONT);
        this.inputButton.addActionListener(this);

        //create panel that will make button
        this.buttonPanel = new JPanel(new FlowLayout());
        this.buttonPanel.add(inputButton);
        this.buttonPanel.setBackground(PURPLE);

        //add to frame
        this.add(welcomeLabel, BorderLayout.NORTH);
        this.add(imageLabel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        Introduce introObj = new Introduce();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //Opening the input frame and getting rid of the welcome frame when the button is pressed
        if (command.equals("Input Values!"))
        {
            Input inputObj = new Input();
            this.dispose();
        }
        this.validate();
        this.repaint();
    }

}
