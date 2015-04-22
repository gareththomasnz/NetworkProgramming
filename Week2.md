import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApplication extends JFrame implements ActionListener {

    private TextArea textArea;

    public SwingApplication() {
        super("Planet Viewer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 150);
        build(getContentPane());
        setVisible(true);
    }

    private void build(Container pane) {
        //-- Text --//
        textArea = new TextArea();
        pane.add(textArea, BorderLayout.CENTER);

        //-- Buttons --//
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        pane.add(btnPanel, BorderLayout.EAST);

        ButtonGroup radioGroup = new ButtonGroup();
        String[] planets = {
                "first:Mercury", "second:Venus", "third:Earth", "fourth:Mars"
        };
        for (String planet : planets) {
            JRadioButton radioButton = new JRadioButton(planet.split(":")[1]);
            btnPanel.add(radioButton, BorderLayout.EAST);
            radioGroup.add(radioButton);

            radioButton.setActionCommand(planet);
            radioButton.addActionListener(this);

            if (radioGroup.getSelection() == null) {
                radioGroup.setSelected(radioButton.getModel(), true);
            }
        }
        renderPlanet(planets[0]);

        //-- Exit
        JButton exitBtn = new JButton("Exit");
        btnPanel.add(exitBtn, BorderLayout.EAST);

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingApplication.this.dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPlanet(e.getActionCommand());
    }

    private void renderPlanet(String text) {
        String[] split = text.split(":");
        textArea.setText("About " + split[1] + ": The " + split[0] + " planet from the sun");
    }

    public static void main(String args[]) {
        new SwingApplication();
    }
}
