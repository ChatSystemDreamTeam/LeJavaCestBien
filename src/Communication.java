import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.LinkedList;

/**
 * Created by djemaa on 07/11/14.
 */
public class Communication extends JFrame implements ActionListener {
    private BufferedReader reader;
    private BufferedWriter writer;
    private JButton bDrop;
    private JButton bSend;
    private JLabel lmessrec;
    private JLabel lmesssend;
    private JTextArea textRec;
    private JTextArea textToSend;
    private ListenSocket listener;

    public Communication(BufferedReader reader, BufferedWriter writer)
    {
        this.reader = reader;
        this.writer = writer;
        this.initComponents();

    }
    private void initComponents()
    {
        bDrop = new JButton("Erase");
        bDrop.addActionListener(this);
        bSend = new JButton("Send");
        bSend.addActionListener(this);
        bSend.setActionCommand("Send");
        bDrop.setActionCommand("Drop");
        lmessrec = new JLabel("Message receive : ");
        lmesssend = new JLabel("Message to send : ");
        textRec = new JTextArea();
        textToSend = new JTextArea("Entrez votre message");
        listener = new ListenSocket(reader, this);
        listener.start();

        textRec.setEditable(false);
        JScrollPane scrollTextRec = new JScrollPane(textRec);
        JScrollPane scrollTextToSend = new JScrollPane(textToSend);

        this.setLayout(new GridLayout(3,2));
        this.add(lmesssend);
        this.add(scrollTextToSend);
        this.add(bSend);
        this.add(bDrop);
        this.add(lmessrec);
        this.add(scrollTextRec);

        this.pack();

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                bye();
            }
        });


    }

    private void bye() {
        bDrop.removeActionListener(this);
        bSend.removeActionListener(this);
        listener.setPapaAlive(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Send")) {
            try {
                String aEcrire = textToSend.getText();
                writer.write(aEcrire+"\n");
                writer.flush();

            } catch (IOException i) {
                i.printStackTrace();
                System.out.println("Erreur lors de l'écriture :" +i);
            }
        }else if (e.getActionCommand().equals("Drop")) {
            listener.eraseLines();
        }

    }
    /** main entry point */
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Erreur : arguments attendus : fichier perso, fichier dans lequel on écrit");
            return;
        }
        try {
            BufferedReader aRead = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bWrite = new BufferedWriter(new FileWriter(args[1]));
            Communication c = new Communication(aRead,bWrite);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showLine(LinkedList<String> toto) {
        textRec.setText("");
        for (String i: toto){
            textRec.setText(textRec.getText()+"\n"+i);

        }
    }
    public void debug(String toto){
        System.out.println("Debug :"+toto);
    }
}
