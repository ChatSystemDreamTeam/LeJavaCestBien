

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by djemaa on 14/11/14.
 */
public class ListenSocket extends Thread {
    private BufferedReader reader;
    private Communication papa;
    private LinkedList<String> lines;
    private boolean isPapaAlive = true;



    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public ListenSocket(BufferedReader reader, Communication papa){
        this.papa = papa;
        this.reader = reader;
        this.lines = new LinkedList<String>();


    }

    public void run(){
        String aLire;
        boolean isRemoteAlive = true;
        while (true && isPapaAlive && isRemoteAlive){
            try {
                aLire = reader.readLine();
                if(aLire !=null) {
                    lines.add(aLire);
                    papa.debug("lu");
                    papa.showLine(lines);
                }


            }catch (SocketException e){
                isRemoteAlive = false;
                papa.debug("1");
            }catch (IOException i) {
                papa.debug("2");
            }
        }

    }

    public void eraseLines() {
        lines.clear();
    }

    public void setPapaAlive(boolean b){
        isPapaAlive = b;
    }
}
