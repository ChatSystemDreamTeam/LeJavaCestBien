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
        Socket current;
        CommunicaTCPServer server = new CommunicaTCPServer(1524);
        while(numClient !=5) {

            current = server.accept();
            try {

                Communication toto = new Communication(new BufferedReader(new InputStreamReader(current.getInputStream())),
                        new BufferedWriter(new OutputStreamWriter(current.getOutputStream())));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Erreur server : " + e);
            }
            numClient++;

        }


    }

}
