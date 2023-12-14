package finishedProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener, KeyListener{


    JButton zeroBtn = new JButton("0");
    JButton oneBtn = new JButton("1");
    JButton twoBtn = new JButton("2");
    JButton threeBtn = new JButton("3");
    JButton fourBtn = new JButton("4");
    JButton fiveBtn = new JButton("5");
    JButton sixBtn = new JButton("6");
    JButton sevenBtn = new JButton("7");
    JButton eightBtn = new JButton("8");
    JButton nineBtn = new JButton("9");
    JButton plusBtn = new JButton("+");
    JButton minusBtn = new JButton("-");
    JButton multiplyBtn = new JButton("x");
    JButton devideBtn = new JButton("/");
    JButton calculateBtn = new JButton("=");
    JButton removeBtn = new JButton("<-");
    JButton commaBtn = new JButton(",");
    JButton resetBtn = new JButton("C");
    JButton sqrtBtn = new JButton("x^");
    JButton nothing = new JButton("");

    JLabel label = new JLabel();
    JLabel display = new JLabel("", SwingConstants.CENTER);
    JLabel Btns = new JLabel();
    JLabel firstNumber = new JLabel();
    JButton[] buttons = {
            sqrtBtn, resetBtn, removeBtn, devideBtn,
            sevenBtn, eightBtn, nineBtn, plusBtn,
            fourBtn, fiveBtn, sixBtn, minusBtn,
            oneBtn, twoBtn, threeBtn, multiplyBtn,
            nothing, zeroBtn, commaBtn, calculateBtn
    };
    double x = 0;
    String typeOfCalculation;


    Calculator() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);

        label.setBounds(0, 0, 600, 600);
        label.setBackground(Color.white);
        label.setOpaque(true);
        label.setLayout(null);

        firstNumber.setBounds(20, 0,600,35);
        firstNumber.setText("");


        display.setBounds(0, 0, 600, 75);
        display.setBackground(Color.white);
        display.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.gray));
        display.setOpaque(true);
        display.setFont(new Font(null, Font.PLAIN, 30));
        display.add(firstNumber);
        display.setText("");

        Btns.setBounds(0, 75, 600, 525);

        Btns.setLayout(new GridLayout(6, 3, 10, 10));
        for (JButton i : buttons) {
            i.setFocusable(false);
            i.addActionListener(this);
            i.setBackground(new Color(230,230,230));
            Btns.add(i);
        }

        label.add(display);
        label.add(Btns);


        this.add(label);
        this.setResizable(false);
        this.setSize(614, 550);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == zeroBtn) {
                if (display.getText().equals("0")) {
                    return;
                } else {
                    display.setText(display.getText() + "0");
                }
            } else if (e.getSource() == oneBtn) {
                typeNumber("1");
            } else if (e.getSource() == twoBtn) {
                typeNumber("2");
            } else if (e.getSource() == threeBtn) {
                typeNumber("3");
            } else if (e.getSource() == fourBtn) {
                typeNumber("4");
            } else if (e.getSource() == fiveBtn) {
                typeNumber("5");
            } else if (e.getSource() == sixBtn) {
                typeNumber("6");
            } else if (e.getSource() == sevenBtn) {
                typeNumber("7");
            } else if (e.getSource() == eightBtn) {
                typeNumber("8");
            } else if (e.getSource() == nineBtn) {
                typeNumber("9");
            } else if (e.getSource() == plusBtn) {
                plus();
            } else if (e.getSource() == minusBtn) {
               minus();
            } else if (e.getSource() == multiplyBtn) {
               multiply();
            } else if (e.getSource() == devideBtn) {
                devide();
            } else if (e.getSource() == removeBtn) {
                remove();
            } else if (e.getSource() == resetBtn) {
                clear();
            } else if (e.getSource() == nothing) {

            } else if (e.getSource() == commaBtn) {
                comma();
            } else if (e.getSource() == sqrtBtn) {
                sqrt();
            } else if (e.getSource() == calculateBtn) {
                calculate();
            }
        }
        catch (NumberFormatException | StringIndexOutOfBoundsException a){
            return;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(e.getKeyCode() == 49){
            typeNumber("1");
        }
        else if(e.getKeyCode() == 50){
            typeNumber("2");
        }
        else if(e.getKeyCode() == 51){
            typeNumber("3");
        }
        else if(e.getKeyCode() == 52){
            typeNumber("4");
        }
        else if(e.getKeyCode() == 53){
            typeNumber("5");
        }
        else if(e.getKeyCode() == 54){
            typeNumber("6");
        }
        else if(e.getKeyCode() == 55){
            typeNumber("7");
        }
        else if(e.getKeyCode() == 56){
            typeNumber("8");
        }
        else if(e.getKeyCode() == 57){
            typeNumber("9");
        }
        else if(e.getKeyCode() == 48){
            typeNumber("0");
        }
        else if(e.getKeyCode() == 27){
            clear();
        }
        else if(e.getKeyCode() == 47){
            devide();
        }
        else if(e.getKeyCode() == 56){
            multiply();
        }
        else if(e.getKeyCode() == 61 || e.getKeyCode() == 10){
            calculate();
        }
        else if(e.getKeyCode() == 45){
            minus();
        }
        else if(e.getKeyCode() == 130){
            sqrt();
        }
        else if(e.getKeyCode() == 44 || e.getKeyCode() == 46){
            comma();
        }
        else if(e.getKeyCode() == 8){
            remove();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public void typeNumber (String nr){
        if (display.getText().equals("0")) {
            display.setText(nr);
        } else {
            display.setText(display.getText() + nr);
        }
    }
    public void clear(){
        firstNumber.setText("");
        display.setText("");
        typeOfCalculation = "";
    }
    public void calculate(){
        double z;
        try {
            switch (typeOfCalculation) {
                case "+" -> {
                    z = Double.parseDouble(display.getText()) + x;
                    display.setText(z + "");
                }
                case "-" -> {
                    z = x - Double.parseDouble(display.getText());
                    display.setText(z + "");
                }
                case "/" -> {
                    z = x / Double.parseDouble(display.getText());
                    display.setText(z + "");
                }
                case "*" -> {
                    z = Double.parseDouble(display.getText()) * x;
                    display.setText(z + "");
                }
                case "^" -> {
                    z = Math.pow(x, Double.parseDouble(display.getText()));
                    display.setText(z + "");
                }
            }

        }
        catch (NumberFormatException | StringIndexOutOfBoundsException | NullPointerException a){
            return;
        }
    }
    public void minus(){
        if (display.getText().equals("")) {
            display.setText("-");
        } else {
            x = Double.parseDouble(display.getText());
            firstNumber.setText(x + "-");
            typeOfCalculation = "-";
            display.setText("");
        }
    }
    public void plus(){
        try{
            x = Double.parseDouble(display.getText());
            firstNumber.setText(x + "+");
            typeOfCalculation = "+";
            display.setText("");
        }
        catch (NumberFormatException | StringIndexOutOfBoundsException a){
            return;
        }
    }
    public void multiply(){
        try{
            x = Double.parseDouble(display.getText());
            firstNumber.setText(x + "*");
            typeOfCalculation = "*";
            display.setText("");
        }
        catch (NumberFormatException | StringIndexOutOfBoundsException a){
            return;
        }
    }
    public void devide(){
        try{
            x = Double.parseDouble(display.getText());
            firstNumber.setText(x + "/");
            typeOfCalculation = "/";
            display.setText("");
        }
        catch (NumberFormatException | StringIndexOutOfBoundsException a){
            return;
        }
    }
    public void remove(){
        try{
            StringBuilder i = new StringBuilder(display.getText());
            i.deleteCharAt(display.getText().length() - 1);
            display.setText(i + "");
        }
        catch (NumberFormatException | StringIndexOutOfBoundsException a){
            return;
        }
    }
    public void comma(){
        if (display.getText().contains(".")) {
            return;
        } else {
            display.setText(display.getText() + ".");
        }
    }
    public void sqrt(){
        try{
            x = Double.parseDouble(display.getText());
            typeOfCalculation = "^";
            firstNumber.setText(x + "^");
            display.setText("");
        }
        catch (NumberFormatException | StringIndexOutOfBoundsException a){
            return;
        }
    }
}