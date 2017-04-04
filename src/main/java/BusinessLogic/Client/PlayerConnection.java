package BusinessLogic.Client;

import BusinessLogic.CirclePiece;

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
            final ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(toSend);
            final byte[] data = baos.toByteArray();

            final DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.send(packet);
        } catch (IOException e) {
            return false;
        }

        return true;

    }
}
