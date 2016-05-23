import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 18.05.2016.
 */

public class CalcGUI extends JPanel implements ActionListener {

    private Calculator calc;
    private Object str;
    private String buttonText;
    private String displayed;
    private JButton buttonClicked;
    private double number;
    //

    private JPanel cPan;
    private JTextField window;
    private JButton bS;
    private JButton mM;
    private JButton mP;
    private JButton mC;
    private JButton mR;
    private JButton ceC;
    private JButton onAC;
    private JButton m1;
    private JButton m4;
    private JButton m7;
    private JButton m0;
    private JButton m2;
    private JButton m5;
    private JButton m8;
    private JButton m00;
    private JButton m3;
    private JButton m6;
    private JButton m9;
    private JButton mT;
    private JButton sqrt;
    private JButton divid;
    private JButton plus;
    private JButton mult;
    private JButton mU;
    private JButton perc;
    private JButton minus;
    private JButton equal;

    public void setDisplayedValue(String num) {

        window.setText(num);
    }

    public String getDisplayedValue() {

        return window.getText();
    }


    public CalcGUI(Calculator calc) {

        this.calc = calc;

        JFrame f = new JFrame("CALCULATOR");
        f.setLocation(50, 50);
        f.setMinimumSize(new Dimension(600, 350));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.getContentPane().add(createCalcPannel());

        f.pack();
        f.setVisible(true);

        bS.addActionListener(this);
        mM.addActionListener(this);
        mP.addActionListener(this);
        mC.addActionListener(this);
        mR.addActionListener(this);
        ceC.addActionListener(this);
        onAC.addActionListener(this);
        m1.addActionListener(this);
        m4.addActionListener(this);
        m7.addActionListener(this);
        m0.addActionListener(this);
        m2.addActionListener(this);
        m5.addActionListener(this);
        m8.addActionListener(this);
        m00.addActionListener(this);
        m3.addActionListener(this);
        m6.addActionListener(this);
        m9.addActionListener(this);
        mT.addActionListener(this);
        sqrt.addActionListener(this);
        divid.addActionListener(this);
        plus.addActionListener(this);
        mult.addActionListener(this);
        mU.addActionListener(this);
        perc.addActionListener(this);
        minus.addActionListener(this);
        equal.addActionListener(this);

    }

    public double getNumber() {
        return number;
    }

    public JButton getM0() {
        return m0;
    }

    public JButton getM00() {
        return m00;
    }

    public JButton getM1() {
        return m1;
    }

    public JButton getM2() {
        return m2;
    }

    public JButton getM3() {
        return m3;
    }

    public JButton getM4() {
        return m4;
    }

    public JButton getM5() {
        return m5;
    }

    public JButton getM6() {
        return m6;
    }

    public JButton getM7() {
        return m7;
    }

    public JButton getM8() {
        return m8;
    }

    public JButton getM9() {
        return m9;
    }

    public JButton getMult() {

        return mult;
    }

    public JButton getMinus() {

        return minus;
    }

    public JButton getEqual() {

        return equal;
    }

    public JButton getDivid() {

        return divid;
    }

    public JButton getPlus() {

        return plus;
    }

    public JButton getmR() {
        return mR;
    }

    public JButton getbS() {
        return bS;
    }

    public JButton getmT() {
        return mT;
    }

    public JButton getOnAC() {
        return onAC;
    }

    public JButton getPerc() {
        return perc;
    }

    private JPanel createCalcPannel(){

        cPan = new JPanel(new GridBagLayout());
        cPan.setBackground(Color.DARK_GRAY);

        JLabel brand = new JLabel("J-PEVLAR V.001");
        brand.setFont(new Font("Garamond", Font.BOLD, 20));
        brand.setForeground(Color.ORANGE);

        window = new JTextField();
        window.setFont(new Font("Garamond", Font.BOLD, 36));
        window.setForeground(Color.BLUE);
        window.setHorizontalAlignment(JTextField.RIGHT);

        bS = new JButton("Backspace");
        bS.setFont(new Font("Garamond", Font.BOLD, 20));
        bS.setForeground(Color.BLACK);

        mM = new JButton("MS");
        mM.setFont(new Font("Garamond", Font.BOLD, 20));
        mM.setForeground(Color.BLACK);

        mP = new JButton("M+");
        mP.setFont(new Font("Garamond", Font.BOLD, 20));
        mP.setForeground(Color.BLACK);

        mC = new JButton("MC");
        mC.setFont(new Font("Garamond", Font.BOLD, 20));
        mC.setForeground(Color.BLACK);

        mR = new JButton("0→00");
        mR.setFont(new Font("Garamond", Font.BOLD, 20));
        mR.setForeground(Color.BLACK);

        ceC = new JButton("CE/C");
        ceC.setFont(new Font("Garamond", Font.BOLD, 20));
        ceC.setForeground(Color.BLACK);

        onAC = new JButton("ON/AC");
        onAC.setFont(new Font("Garamond", Font.BOLD, 20));
        onAC.setForeground(Color.BLACK);

        m1 = new JButton("1");
        m1.setFont(new Font("Garamond", Font.BOLD, 20));
        m1.setForeground(Color.BLACK);

        m4 = new JButton("4");
        m4.setFont(new Font("Garamond", Font.BOLD, 20));
        m4.setForeground(Color.BLACK);

        m7 = new JButton("7");
        m7.setFont(new Font("Garamond", Font.BOLD, 20));
        m7.setForeground(Color.BLACK);

        m0 = new JButton("0");
        m0.setFont(new Font("Garamond", Font.BOLD, 20));
        m0.setForeground(Color.BLACK);

        m2 = new JButton("2");
        m2.setFont(new Font("Garamond", Font.BOLD, 20));
        m2.setForeground(Color.BLACK);

        m5 = new JButton("5");
        m5.setFont(new Font("Garamond", Font.BOLD, 20));
        m5.setForeground(Color.BLACK);

        m8 = new JButton("8");
        m8.setFont(new Font("Garamond", Font.BOLD, 20));
        m8.setForeground(Color.BLACK);

        m00 = new JButton("00");
        m00.setFont(new Font("Garamond", Font.BOLD, 20));
        m00.setForeground(Color.BLACK);

        m3 = new JButton("3");
        m3.setFont(new Font("Garamond", Font.BOLD, 20));
        m3.setForeground(Color.BLACK);

        m6 = new JButton("6");
        m6.setFont(new Font("Garamond", Font.BOLD, 20));
        m6.setForeground(Color.BLACK);

        m9 = new JButton("9");
        m9.setFont(new Font("Garamond", Font.BOLD, 20));
        m9.setForeground(Color.BLACK);

        mT = new JButton(".");
        mT.setFont(new Font("Garamond", Font.BOLD, 20));
        mT.setForeground(Color.BLACK);

        sqrt = new JButton("√sqrt");
        sqrt.setFont(new Font("Garamond", Font.BOLD, 20));
        sqrt.setForeground(Color.BLACK);

        divid = new JButton("/");
        divid.setFont(new Font("Garamond", Font.BOLD, 20));
        divid.setForeground(Color.BLACK);

        plus = new JButton("+");
        plus.setFont(new Font("Garamond", Font.BOLD, 20));
        plus.setForeground(Color.BLACK);

        mult = new JButton("*");
        mult.setFont(new Font("Garamond", Font.BOLD, 20));
        mult.setForeground(Color.BLACK);

        mU = new JButton("MU");
        mU.setFont(new Font("Garamond", Font.BOLD, 20));
        mU.setForeground(Color.BLACK);

        perc = new JButton("%");
        perc.setFont(new Font("Garamond", Font.BOLD, 20));
        perc.setForeground(Color.BLACK);

        minus = new JButton("-");
        minus.setFont(new Font("Garamond", Font.BOLD, 20));
        minus.setForeground(Color.BLACK);

        equal = new JButton("=");
        equal.setFont(new Font("Garamond", Font.BOLD, 20));
        equal.setBackground(Color.cyan);
        equal.setForeground(Color.BLACK);
        equal.setEnabled(true);


        cPan.add(brand, new GridBagConstraints(0, 0, 0, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
        cPan.add(window, new GridBagConstraints(0, 1, 0, 1, 0, 0,
                GridBagConstraints.LAST_LINE_END, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));

        cPan.add(bS, new GridBagConstraints(0, 2, 2, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
        cPan.add(mM, new GridBagConstraints(2, 2, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
        cPan.add(mP, new GridBagConstraints(3, 2, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
        cPan.add(mC, new GridBagConstraints(0, 3, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(mR, new GridBagConstraints(0, 4, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(ceC, new GridBagConstraints(0, 5, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(onAC, new GridBagConstraints(0, 6, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 5), 0, 0));

        cPan.add(m1, new GridBagConstraints(1, 3, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(m4, new GridBagConstraints(1, 4, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(m7, new GridBagConstraints(1, 5, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(m0, new GridBagConstraints(1, 6, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 5, 0, 10), 0, 0));

        cPan.add(m2, new GridBagConstraints(2, 3, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(m5, new GridBagConstraints(2, 4, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(m8, new GridBagConstraints(2, 5, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(m00, new GridBagConstraints(2, 6, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(m3, new GridBagConstraints(3, 3, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 15), 0, 0));

        cPan.add(m6, new GridBagConstraints(3, 4, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 15), 0, 0));

        cPan.add(m9, new GridBagConstraints(3, 5, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 15), 0, 0));

        cPan.add(mT, new GridBagConstraints(3, 6, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 15), 0, 0));

        cPan.add(sqrt, new GridBagConstraints(4, 2, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(divid, new GridBagConstraints(4, 3, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(mult, new GridBagConstraints(4, 4, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(plus, new GridBagConstraints(4, 5, 1, 2, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(mU, new GridBagConstraints(5, 2, 1, 1, 1, 0,
                GridBagConstraints.LAST_LINE_END, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(perc, new GridBagConstraints(5, 3, 1, 1, 1, 0,
                GridBagConstraints.LAST_LINE_END, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(minus, new GridBagConstraints(5, 4, 1, 1, 1, 0,
                GridBagConstraints.LAST_LINE_END, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        cPan.add(equal, new GridBagConstraints(5, 5, 1, 2, 1, 0,
                GridBagConstraints.LAST_LINE_END, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        return cPan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        str = e.getSource();
        buttonClicked = (JButton) e.getSource();
        buttonText = buttonClicked.getText();
        displayed = getDisplayedValue();

        if(numbers() || point()) {
            setDisplayedValue(displayed + buttonText);
        }

        if (operand() && !displayed.equals("") && !displayed.equals(".") ) {
            setDisplayedValue(displayed + buttonText);
            number = calc.getFirstDouble(displayed);
            System.out.println(number);
        }

        if (equal() && !displayed.equals("") && !displayed.equals(".")) {
            System.out.println(displayed);
            number = calc.calculation(calc.getOperand(displayed), number, calc.getSecondDouble(displayed) );
            System.out.println(number);
            setDisplayedValue(String.valueOf(number));
        }

        if (percent() && !displayed.equals("") && !displayed.equals(".")) {
            number = calc.calcPercentage(calc.getOperand(displayed), number, calc.getSecondDouble(displayed) );
            System.out.println(number);
            setDisplayedValue(String.valueOf(number));
        }

        if(str == getOnAC()){
            setDisplayedValue("\b");
        }

        if(str == getbS()){
            setDisplayedValue(displayed.substring(0, displayed.length() - 1));
        }

    }

    private boolean numbers(){

        if(str == getM0() || str == getM1() || str == getM2() || str == getM3() ||
                str == getM4() || str == getM5() || str == getM6() || str == getM7() ||
                str == getM8() || str == getM9() || str == getM00()){
            return true;
        }
        return false;
    }

    private boolean operand(){

        if(str == getPlus() || str == getMinus() || str == getDivid() || str == getMult()){
            return true;
        }
        return false;
    }

    private boolean equal(){
        if(str == getEqual()){
            return true;
        }
        return false;
    }

    private boolean point(){
        if(str == getmT()){
            return true;
        }
        return false;
    }

    private boolean percent(){
        if(str == getPerc()){
            return true;
        }
        return false;
    }



}
