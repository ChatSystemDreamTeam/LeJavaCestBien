import javax.swing.*;
import java.awt.*;

/**
 * Example of a Fenetre (JFrame) using awt and swing
 * @author djemaa
 */
public class Fenetre extends JFrame {
    /** a textfield for the name */
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    /** a button to perform an action: e.g. say hello (TBD) */
    private JButton button;

    /** Creates a Fenetre */
    public Fenetre() {
        initComponents();
    }

    /** Initializes the Fenetre components */

    private void initComponents() {
        // create the components
        // a new label with the "Nom" as value
        // a new text field with 20 columns
        text1 = new JTextField(20);
        text2 = new JTextField(20);
        text3 = new JTextField(20);
        text4 = new JTextField(20);
        // a new button identified as OK
        button = new JButton("OK");
        // configures the JFrame layout using a border layout
        this.setLayout(new BorderLayout());
        // places the components in the layout
        this.add("West",text1);
        this.add("Center",button);
        this.add("East",text2);
        this.add("North", text3);
        this.add("South", text4);
        // packs the fenetre: size is calculated
        // regarding the added components
        this.pack();
        // the JFrame is visible now
        this.setVisible(true);
    }

    /** main entry point */
    public static void main(String[] args) {
        Fenetre f = new Fenetre();
    }

}
