package BusinessLogic.Client;

import BusinessLogic.TheGame.CirclePiece;
import javafx.scene.paint.Color;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 * Created by David Stovlbaek
 * 26 February 2017.
 */
public class PlayerConnection {

    private DatagramSocket socket = new DatagramSocket(9999);
    private final int playerPort;
    private final InetAddress playerIp;


    public PlayerConnection(int playerPort, InetAddress playerIp) throws SocketException {
        this.playerPort = playerPort;
        this.playerIp = playerIp;
    }

    public boolean sendCirclePiece(CirclePiece toSend) {

        try {

            final ByteArrayOutputStream baos = new ByteArrayOutputStream(6400);
            System.out.println(baos);
            final ObjectOutputStream oos = new ObjectOutputStream(baos);
            System.out.println(oos);
            oos.writeObject(toSend);
            System.out.println(oos);
            final byte[] data = baos.toByteArray();

            final DatagramPacket packet = new DatagramPacket(data, data.length,InetAddress.getLocalHost(),2222);
            socket.send(packet);
        } catch (IOException e) {
            return false;
        }

        return true;

    }

    public static void main(String[] args) throws UnknownHostException, SocketException {
        CirclePiece c = new CirclePiece(new Color(0.5,1,1,1),2,2);

        PlayerConnection p = new PlayerConnection(2222,InetAddress.getLocalHost());

        p.sendCirclePiece(c);

        System.out.println("sent!");



    }
}
