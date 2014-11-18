package perso;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by djemaa on 10/11/14.
 */
public class CommunicaTCPClient {
    Socket socketClient;


    public CommunicaTCPClient(InetAddress adress, int port){
        try {
            socketClient = new Socket(adress,port);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Erreur creation socket : "+e);
        }

    }

    public Socket getSocketClient() {
        return socketClient;
    }

    public void setSocketClient(Socket socketClient) {
        this.socketClient = socketClient;
    }
}
