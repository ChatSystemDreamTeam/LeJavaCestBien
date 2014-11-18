import perso.CommunicaTCPClient;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by djemaa on 10/11/14.
 */
public class TCPClient {

    public static void main(String[] args){
        try {
            CommunicaTCPClient client = new CommunicaTCPClient(InetAddress.getByName("127.0.0.1"), 1524);
            Communication com = new Communication(new BufferedReader(new InputStreamReader(client.getSocketClient().getInputStream())),
                    new BufferedWriter(new OutputStreamWriter(client.getSocketClient().getOutputStream())));

        }catch(UnknownHostException e){
            e.printStackTrace();
            System.out.println("Erreur connexion : "+e );

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Erreur stream : " + e);
        }
    }

}
