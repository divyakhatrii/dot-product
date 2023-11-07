/* This class is where the user inputs the numbers into the vector
 */
package khatrigui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

  
public class Input extends JFrame implements ActionListener
{
   //declaration of variables
    private JTextField xOneField;
    private JTextField yOneField;
    private JTextField xTwoField;
    private JTextField yTwoField;
    private JLabel instructions;
    private JLabel firstOpenBracket;
    private JLabel firstCloseBracket;
    private JLabel secondOpenBracket;
    private JLabel secondCloseBracket;
    private JLabel dotSymbol;
    private JLabel firstComma;
    private JLabel secondComma;
    private JLabel imageLabel;
    private JButton calculateButton;
    private JButton returnButton;
    private JButton exitButton;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel imagePanel;
   
   
    //gets Image
    private final java.net.URL MY_PATH = getClass().getResource("Precal.jpg");
    private final ImageIcon PRECAL_IMAGE = new ImageIcon(new ImageIcon(
            MY_PATH).getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT));
    
    //constructor
    public Input()
    {
        //constructing frame
        super("Input");
        this.setBounds(200, 100, 1000, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        
        //creating text fields
        this.xOneField = new JTextField(5);
        this.yOneField = new JTextField(5);
        this.xTwoField = new JTextField(5);
        this.yTwoField = new JTextField(5);
        
        //creating labels and setting their fonts
        this.instructions = new JLabel("Input the two vectors: ", SwingConstants.CENTER);
        this.instructions.setFont(Introduce.NOICE_FONT);
        this.firstOpenBracket = new JLabel("〈");
        this.firstOpenBracket.setFont(Introduce.NOICE_FONT);
        this.secondOpenBracket = new JLabel("〈");
        this.secondOpenBracket.setFont(Introduce.NOICE_FONT);
        this.firstCloseBracket = new JLabel("〉");
        this.firstCloseBracket.setFont(Introduce.NOICE_FONT);
        this.secondCloseBracket = new JLabel("〉");
        this.secondCloseBracket.setFont(Introduce.NOICE_FONT);
        this.dotSymbol = new JLabel(" ⋅ ");
        this.dotSymbol.setFont(Introduce.NOICE_FONT);
        this.firstComma = new JLabel(" , ");
        this.firstComma.setFont(Introduce.NOICE_FONT);
        this.secondComma = new JLabel(" , ");
        this.secondComma.setFont(Introduce.NOICE_FONT);
        this.imageLabel = new JLabel(PRECAL_IMAGE);
        
        //constructing buttons
        this.calculateButton = new JButton("Calculate Dot Product!");
        this.calculateButton.addActionListener(this);
        this.calculateButton.setFont(Introduce.NOICE_FONT);
        this.returnButton = new JButton("Return");
        this.returnButton.addActionListener(this);
        this.returnButton.setFont(Introduce.NOICE_FONT);
        this.exitButton = new JButton("Exit!");
        this.exitButton.addActionListener(this);
        this.exitButton.setFont(Introduce.NOICE_FONT);
        
        //create Panels and add the textfields and labels to it
        this.inputPanel = new JPanel(new FlowLayout());
        this.inputPanel.add(instructions);
        this.inputPanel.add(firstOpenBracket);
        this.inputPanel.add(xOneField);
        this.inputPanel.add(firstComma);
        this.inputPanel.add(yOneField);
        this.inputPanel.add(firstCloseBracket);
        this.inputPanel.add(dotSymbol);
        this.inputPanel.add(secondOpenBracket);
        this.inputPanel.add(xTwoField);
        this.inputPanel.add(secondComma);
        this.inputPanel.add(yTwoField);
        this.inputPanel.add(secondCloseBracket);
        this.inputPanel.setBackground(Color.PINK);
        this.imagePanel = new JPanel(new FlowLayout());
        this.imagePanel.add(imageLabel);
        this.imagePanel.setBackground(Color.GRAY);
        
        //adding the buttons to the panel on the bottom
        this.buttonPanel = new JPanel(new FlowLayout());
        this.buttonPanel.add(returnButton);
        this.buttonPanel.add(calculateButton);
        this.buttonPanel.add(exitButton);
        this.buttonPanel.setBackground(Color.GRAY);
        
        //adding everything to the frame
        
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(imagePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        int xOne;
        int yOne;
        int xTwo;
        int yTwo;
        int dotProduct;
        
        
        if (command.equals("Calculate Dot Product!"))
        {
            //converting the text from a string to an integer
            xOne = Integer.parseInt(xOneField.getText());
            yOne = Integer.parseInt(yOneField.getText());
            xTwo = Integer.parseInt(xTwoField.getText());
            yTwo = Integer.parseInt(yTwoField.getText());
            
            //resetting textfields
            xOneField.setText("");
            yOneField.setText("");
            xTwoField.setText("");
            yTwoField.setText("");
            
            //sending the calculation to another class, receiving the output, and sending that to the output frame
            DotCalculation dotObj = new DotCalculation(xOne, xTwo, yOne, yTwo);
            dotProduct = dotObj.getDotProduct();
            Output outputObj = new Output(dotProduct);
        }
        else if (command.equals("Return")) //dispose of the frame and go back to welcome panel
        {
            Introduce introObj = new Introduce();
            this.dispose();
        }
        else if (command.equals("Exit!")) //dispose of the frame to exit
        {
            this.dispose();
        }
        
        this.validate();
        this.repaint();
    }
    
    

}
