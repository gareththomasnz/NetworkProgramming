import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class SwingApplication {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Planet Viewer");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel(new GridLayout(0, 1));
    Border border = BorderFactory.createTitledBorder("Radio Buttons");
    panel.setBorder(border);
    ButtonGroup group = new ButtonGroup();
    JRadioButton aRadioButton = new JRadioButton("Mars",true);
    panel.add(aRadioButton);
    group.add(aRadioButton);
    aRadioButton = new JRadioButton("Venus");
    panel.add(aRadioButton);
    group.add(aRadioButton);
    aRadioButton = new JRadioButton("Jupiter");
    panel.add(aRadioButton);
    group.add(aRadioButton);
    aRadioButton = new JRadioButton("Saturn");
    panel.add(aRadioButton);
    group.add(aRadioButton);
    JButton myButton = new JButton("Exit");
    panel.add(myButton);
    
    Container contentPane = frame.getContentPane();
    contentPane.add(panel, BorderLayout.EAST);
    panel = new JPanel(new GridBagLayout());
    border = BorderFactory.createTitledBorder("Text Area");
    panel.setBorder(border);
    TextArea myText = new TextArea();
    panel.add(myText);
   
    contentPane.add(panel, BorderLayout.WEST);
    frame.setSize(400, 300);
    frame.setVisible(true);
    
    myButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 frame.dispose();
		}
    });
    
  } 
}
