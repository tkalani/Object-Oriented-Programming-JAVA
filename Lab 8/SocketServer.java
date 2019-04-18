import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
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

public class SocketServer {
    
    private static ServerSocket server;
    private static int port = 9876;
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        // server = new ServerSocket(port);
        // while(true){
        //     System.out.println("Waiting for the client request");
        //     Socket socket = server.accept();
        //     ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        //     String message = (String) ois.readObject();
        //     System.out.println("Message Received: " + message);
        //     ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        //     oos.writeObject("Hi Client "+message);
        //     ois.close();
        //     oos.close();
        //     socket.close();
        //     if(message.equalsIgnoreCase("exit")) break;
        // }
        // System.out.println("Shutting down Socket server!!");
        // server.close();


        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        System.out.println("Reading: " + System.currentTimeMillis());

        byte[] sizeAr = new byte[4];
        inputStream.read(sizeAr);
        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

        byte[] imageAr = new byte[size];
        inputStream.read(imageAr);

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

        System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
        ImageIO.write(image, "png", new File("Tanmay.png"));

        serverSocket.close();
    }    
}
