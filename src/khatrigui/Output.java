/* This class outputs the dot product
 */
package khatrigui;

//all imports
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
import javax.swing.SwingConstants;

public class Output extends JFrame implements ActionListener
{

    //declare variables
    public static final Color REDDISH = new Color(154, 106, 108);
    public static final Color MAROON = new Color(176, 147, 152);
    private JLabel dotProductLabel;
    private JLabel imageLabel;
    private JButton returnButton;
    private JPanel returnPanel;
    private JPanel imagePanel;

    //getting the image
    private final java.net.URL MY_PATH = getClass().getResource("HereYaGo.gif");
    private final ImageIcon OUTPUT_IMAGE = new ImageIcon(new ImageIcon(
            MY_PATH).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));

    //constructor
    public Output(int dotProduct)
    {
        super("Output!");
        this.setBounds(300, 200, 600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(MAROON);
        this.setLayout(new BorderLayout());

        //constructing labels
        this.dotProductLabel = new JLabel("The dot product is " + dotProduct + "!", SwingConstants.CENTER);
        this.dotProductLabel.setFont(Introduce.NOICE_FONT);
        this.imageLabel = new JLabel(OUTPUT_IMAGE);

        //construct button
        this.returnButton = new JButton("Return");
        this.returnButton.addActionListener(this);
        this.returnButton.setFont(Introduce.NOICE_FONT);

        //construct Panels
        this.returnPanel = new JPanel(new FlowLayout());
        this.returnPanel.add(returnButton);
        this.returnPanel.setBackground(REDDISH);
        this.imagePanel = new JPanel(new FlowLayout());
        this.imagePanel.add(imageLabel);

        //adding everything to the frame
        this.add(dotProductLabel, BorderLayout.NORTH);
        this.add(imagePanel, BorderLayout.CENTER);
        this.add(returnPanel, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //since its a pop-up, when you click return, all you have to do is get rid of the current frame, the pop-up
        if (command.equals("Return"))
        {
            this.dispose();
        }
        this.validate();
        this.repaint();
    }

    //to test if the class itself was working and how it would look
    public static void main(String[] args)
    {
        Output outputObj = new Output(45);
    }
}
