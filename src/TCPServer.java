import perso.CommunicaTCPServer;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * TCPSERVER
 *
 * Created by djemaa on 10/11/14.
 */
public class TCPServer {
    private static int numClient = 0;


    public static void main(String[] args){


        ArrayList<Socket> remote = new ArrayList<Socket>();
        CommunicaTCPServer server = new CommunicaTCPServer(1524);
        while(numClient !=5) {

            remote.add(server.accept());
            try {
                Communication toto = new Communication(new BufferedReader(new InputStreamReader(remote.get(numClient).getInputStream())),
                        new BufferedWriter(new OutputStreamWriter(remote.get(numClient).getOutputStream())));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Erreur server : " + e);
            }
            numClient++;

        }


    }

}
