# Group Members

* Evan (Zhenghui Liu, 1433013)
* Gareth Thomas (1440960)

# Answers

## 1

``` java
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {
    public static void main(String[] args) {
        String host = args[0];
        System.out.println("Host name: " + host);
        try {
            InetAddress address = InetAddress.getByName(host);
            System.out.println("IP address: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
```

## 2

`MyServer`

```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                Socket socket = server.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String msg = dis.readUTF();
                System.out.println("Receive message from Client: " + msg);
                dos.writeUTF("Hi there, got your message!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

`MyClient`

```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 5000);
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            DataInputStream dis = new DataInputStream(client.getInputStream());

            dos.writeUTF("Hello");
            dos.flush();

            String msg = dis.readUTF();
            System.out.println("Receive message from server: " + msg);

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 3 

`SingleThreadedServer` 

```java
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                Socket socket = server.accept();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeLong(System.currentTimeMillis());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

`SingleThreadedServerClient` 

```java
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class SingleThreadedServerClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 5000);
            DataInputStream dis = new DataInputStream(client.getInputStream());
            Date now = new Date(dis.readLong());
            System.out.println("Server time: " + now.toString());

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 4

`SwingApplication.java`

```java
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
```

## 5

`Main.java`

```java
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

`sample.fxml`

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.TextArea?>
<?import javafx.scene.layout.BorderPane?>
<BorderPane xmlns="http://javafx.com/javafx/8" xmlns:fx="http://javafx.com/fxml/1" fx:controller="sample.Controller">
    <top>
        <Button mnemonicParsing="false" onAction="#onHello" text="Click Me!" BorderPane.alignment="CENTER"/>
    </top>
    <center>
        <TextArea fx:id="txtHello" BorderPane.alignment="CENTER"/>
    </center>
</BorderPane>
```

`Controller.java`

```java
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    public TextArea txtHello;

    public void onHello(ActionEvent e) {
        txtHello.appendText("Hello World\n");
        System.out.println("Hello World");
    }
}
```
