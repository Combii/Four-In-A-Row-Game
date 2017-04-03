package Server;
/**
 * Created by David Stovlbaek
 * 16 February 2017.
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class ServerListener implements Runnable{

    DatagramSocket socket;
    DatagramPacket request;
    ClientList clientList;

    public ServerListener() throws SocketException {
        clientList = new ClientList();
    }

    @Override
    public void run() {
        try{
        socket = new DatagramSocket(1234);
            
        while (true) {
            request = new DatagramPacket(new byte[1024], 1024);
            System.out.println("Server is listening on port: " + socket.getLocalPort());

            socket.receive(request);
            String text = new String(request.getData(), 0, request.getLength());

            clientList.sendTextToClients(text);
            RunServer.getController().console.appendText(text + "\n");
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}