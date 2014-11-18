package perso;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by djemaa on 10/11/14.
 */
public class CommunicaTCPServer {

    ServerSocket serverSocket;

    public CommunicaTCPServer(int port) {
        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("erreur creation Socket : " + e);
        }
    }

    public Socket accept(){
        try{
            return serverSocket.accept();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Erreur accept: " + e);
            return null;
        }
    }

}
