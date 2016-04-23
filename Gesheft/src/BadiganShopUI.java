import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class BadiganShopUI {

    private Badigan bad;

    public BadiganShopUI() {

        this.bad = bad;


        JFrame f = new JFrame();
        f.setMinimumSize(new Dimension(800, 225));
        f.setLocation(100, 100);
        f.getContentPane().add(createSellingPannel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private JPanel createSellingPannel(){

        JPanel panel = new JPanel();
        //panel.setLayout(new BorderLayout());
        //panel.setLayout(new GridLayout());
        //panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setLayout(null);

        JLabel date = new JLabel("Date: ");
        date.setBounds(50, 25, 50, 25);
        JTextField tfDate = new JTextField(10);
        tfDate.setBounds(100, 25, 150, 25);
        JLabel yName = new JLabel("Your Name: ");
        yName.setBounds(300, 25, 100, 25);
        JTextField tfName = new JTextField(20);
        tfName.setBounds(400, 25, 325, 25);
        JLabel choose = new JLabel("Choose the good: ");
        choose.setBounds(50, 75, 150, 25);
        String[] elements = new String[] {"\"Petrova, soda\", Tare.PAT, 2.0, 21.7", "\"Petrova, soda\", Tare.PAT, 1.0, 16.5",
                "\"Petrova, soda\", Tare.PAT, 0.5, 9.6", "\"Petrova, soda\", Tare.GLASS, 0.5, 11.5", "\"Tselebnaya, mineral\", Tare.PAT, 0.9, 24.6",
                "\"Tselebnaya, mineral\", Tare.GLASS, 0.45, 13.4", "None"};
        JComboBox combo = new JComboBox(elements);
        combo.setBounds(200, 75, 525, 25);
        JLabel quant = new JLabel("Quantity: ");
        quant.setBounds(50, 125, 75, 25);
        JTextField tfQuant = new JTextField(5);
        tfQuant.setBounds(125, 125, 250, 25);
        JButton buy = new JButton("Buy");
        buy.setBounds(400, 125, 325, 25);
        panel.add(yName);
        panel.add(tfName);
        panel.add(date);
        panel.add(tfDate);
        panel.add(choose);
        panel.add(combo);
        panel.add(quant);
        panel.add(tfQuant);
        panel.add(buy);
        return panel;
    }


//    setContentPane(panel);


}




