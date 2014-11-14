import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by djemaa on 07/11/14.
 */
public class Communication extends JFrame implements ActionListener {
    private BufferedWriter writer;
    private JButton bReceive;
    private JButton bSend;
    private JLabel lmessrec;
    private JLabel lmesssend;
    private JTextArea textRec;
    private JTextArea textToSend;
    private ListenSocket listener;

    public Communication(BufferedReader reader, BufferedWriter writer)
    {
        listener = new ListenSocket(reader);
        this.writer = writer;
        this.initComponents();

    }
    private void initComponents()
    {
        bReceive = new JButton("Receive");
        bReceive.addActionListener(this);
        bSend = new JButton("Send");
        bSend.addActionListener(this);
        bSend.setActionCommand("Send");
        bReceive.setActionCommand("Receive");
        lmessrec = new JLabel("Message receive : ");
        lmesssend = new JLabel("Message to send : ");
        textRec = new JTextArea();
        textToSend = new JTextArea("Entrez votre message");

        textRec.setEditable(false);
        JScrollPane scrollTextRec = new JScrollPane(textRec);
        JScrollPane scrollTextToSend = new JScrollPane(textToSend);

        this.setLayout(new GridLayout(3,2));
        this.add(lmesssend);
        this.add(scrollTextToSend);
        this.add(bSend);
        this.add(bReceive);
        this.add(lmessrec);
        this.add(scrollTextRec);

        this.pack();

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Send")) {
            try {
                String aEcrire = textToSend.getText();
                System.out.println(aEcrire);
                writer.write(aEcrire);
                writer.flush();

            } catch (IOException i) {
                i.printStackTrace();
                System.out.println("Erreur lors de l'écriture :" +i);
            } finally {

            }
        }else if(e.getActionCommand().equals("Receive")){
            textRec.setText(listener.getLastLine());

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
}
