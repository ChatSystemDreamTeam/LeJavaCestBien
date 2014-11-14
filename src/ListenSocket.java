

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by djemaa on 14/11/14.
 */
public class ListenSocket extends Thread {
    private BufferedReader reader;
    private LinkedList<String> lines;



    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public ListenSocket(BufferedReader reader){
        this.reader = reader;
        this.lines = new LinkedList<String>();


    }

    public void run(){
        String aLire;
        while (true){
            try {
                lines.add(reader.readLine());
            }catch (IOException i) {
                    i.printStackTrace();
                    System.out.println("Rien a lire");
            }
        }

    }


    public String getLastLine(){
        try {
            String lastLine = lines.remove();
            return lastLine;
        }catch (NoSuchElementException e) {
            return "Rien à lire";
        }
    }
}
