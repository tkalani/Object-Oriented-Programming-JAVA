import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.*;
import java.util.*;
import java.nio.channels.*;
import java.nio.*;

public class SocketClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        // InetAddress host = InetAddress.getLocalHost();
        // Socket socket = null;
        // ObjectOutputStream oos = null;
        // ObjectInputStream ois = null;
        // for(int i=0; i<5;i++){
        //     socket = new Socket(host.getHostName(), 9876);
        //     oos = new ObjectOutputStream(socket.getOutputStream());
        //     System.out.println("Sending request to Socket Server");
        //     if(i==4)oos.writeObject("exit");
        //     else oos.writeObject(""+i);
        //     ois = new ObjectInputStream(socket.getInputStream());
        //     String message = (String) ois.readObject();
        //     System.out.println("Message: " + message);
        //     ois.close();
        //     oos.close();
        //     Thread.sleep(100);
        // }

        Socket socket = new Socket("localhost", 9876);
        OutputStream outputStream = socket.getOutputStream();

        BufferedImage image = ImageIO.read(new File("CGAN1.png"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", byteArrayOutputStream);

        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();

        // for(int i=0; i<size.length; i++)
        // {
        //     size[i] = (byte)(4*(int)(size[i])*(int)(size[i])*(int)(size[i]) + 2*(int)(size[i])*(int)(size[i]) + 4*(int)(size[i]) + 5);
        //     System.out.println(size[i]);
        // }
            

        outputStream.write(size);
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.flush();
        System.out.println("Flushed: " + System.currentTimeMillis());

        Thread.sleep(120000);
        System.out.println("Closing: " + System.currentTimeMillis());
        socket.close();
    }
}
