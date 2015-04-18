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
