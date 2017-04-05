package BusinessLogic.Client;


import BusinessLogic.CirclePiece;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.*;

/**
 * Created by David Stovlbaek
 * 21 February 2017.
 */
public class ClientListener implements Runnable {

    DatagramSocket socket = new DatagramSocket(2222,InetAddress.getLocalHost());

    public ClientListener() throws SocketException, UnknownHostException {
    }

    @Override
    public void run() {
                while (true) {
                    CirclePiece c = reveicePiece();
                    System.out.println(c);

                }
    }




    public String receiveMessage(){
            try {
                DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                socket.receive(request);
                String text = new String(request.getData(), 0, request.getLength());
                System.out.println("Received Text: " + text);
                return text;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }

    public CirclePiece reveicePiece() {

        try {
            DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
            System.out.println("Now listening on ip: " + socket.getLocalAddress() + " and port: " + socket.getLocalPort());
            socket.receive(request);
            System.out.println("received");
            ByteArrayInputStream inputStream = new ByteArrayInputStream(request.getData());
            ObjectInputStream ois = new ObjectInputStream(inputStream);

            return (CirclePiece) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    public static void main(String[] args) throws SocketException, UnknownHostException {

        new ClientListener().run();

    }


}
