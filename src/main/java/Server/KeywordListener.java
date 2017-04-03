package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by BorisGrunwald on 28/02/2017.
 */
public class KeywordListener implements Runnable {

    DatagramSocket socket;
    DatagramPacket request;
    ClientList clientList;

    public KeywordListener() throws SocketException {
        clientList = new ClientList();
        try {
            socket = new DatagramSocket(1235);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            request = new DatagramPacket(new byte[1024],1024);

            try {
                socket.receive(request);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String keyword = new String(request.getData(),0,request.getLength());
            System.out.println("KEYWORD RECEIVED: " + keyword);
            RunServer.getController().console.appendText("KEYWORD: " + keyword + "\n");

            clientList.checkKeyword(keyword,request);
        }
        }

    }
