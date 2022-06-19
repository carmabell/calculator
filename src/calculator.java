import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class calculator extends JFrame implements ActionListener {

    static JFrame frame;

    static JTextField display;
    // store operator and operands
    String num1;
    String operator;
    String num2;

    calculator() {
        num1 = operator = num2 = "";
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        // create a frame
        frame = new JFrame("calculator");

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // create a object of class
        calculator calc = new calculator();

        // create a textfield
        display = new JTextField(16);

        // set the textfield to non editable
        display.setEditable(false);

        // create number buttons and some operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAddition, bSubtraction, bDivision, bMultiplication, bComma,
                bCorrection, bEqual;

        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        // equals button
        bEqual = new JButton("=");

        // create operator buttons
        bAddition = new JButton("+");
        bSubtraction = new JButton("-");
        bDivision = new JButton("/");
        bMultiplication = new JButton("*");

        bCorrection = new JButton("C");
        bComma = new JButton(".");

        // create a panel
        JPanel panel = new JPanel();

        // add action listeners
        bMultiplication.addActionListener(calc);
        bDivision.addActionListener(calc);
        bSubtraction.addActionListener(calc);
        bAddition.addActionListener(calc);
        b9.addActionListener(calc);
        b8.addActionListener(calc);
        b7.addActionListener(calc);
        b6.addActionListener(calc);
        b5.addActionListener(calc);
        b4.addActionListener(calc);
        b3.addActionListener(calc);
        b2.addActionListener(calc);
        b1.addActionListener(calc);
        b0.addActionListener(calc);
        bComma.addActionListener(calc);
        bCorrection.addActionListener(calc);
        bEqual.addActionListener(calc);

        // add elements to panel
        panel.add(display);
        panel.add(bAddition);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bSubtraction);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bMultiplication);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bDivision);
        panel.add(bComma);
        panel.add(b0);
        panel.add(bCorrection);
        panel.add(bEqual);

        // set Background of panel
        panel.setBackground(Color.LIGHT_GRAY);
        // add panel to frame
        frame.add(panel);

        frame.setSize(200, 220);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // if the value is a number
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
            // if operand is present then add to numbers to display all input
            if (!operator.equals("")) {
                num2 = num2 + command;
            } else {
                num1 = num1 + command;
            }
            // set the value of text
            display.setText(num1 + operator + num2);
        } else if (command.charAt(0) == 'C') {
            // clear all variables
            num1 = operator = num2 = "";

            // set empty value of text, clear display field
            display.setText("");
        } else if (command.charAt(0) == '=') {

            double result;

            // execute the operation
            result = runMathOperation(num1, operator, num2);

            // set the value of text
            display.setText(num1 + operator + num2 + "=" + result);

            // convert it to string
            num1 = Double.toString(result);

            operator = num2 = "";
        } 
        // else {
        //     // save operand for later calculation
        //     if (operator.equals("") || num2.equals("")){
        //         operator = command;
        //     }
        //     // else evaluate
        //     // else {
        //     //     double result;

        //     //     // store result value in 1st
        //     //     result = runMathOperation(num1, operator, num2);

        //     //     // convert it to string
        //     //     num1 = Double.toString(result);

        //     //     // save selected operator
        //     //     operator = command;

        //     //     // clear second operand
        //     //     num2 = "";
        //     // }

        //     // set the value of text
        //     display.setText(num1 + operator + num2);
        // }
    }

    private Double runMathOperation(String num1, String operator, String num2) {

        Double result;

        if(num2.isEmpty()){
            return 1234.67890;
        }

        if (operator.equals("+")) {
            result = (Double.parseDouble(num1) + Double.parseDouble(num2));
        } else if (operator.equals("-")) {
            result = (Double.parseDouble(num1) - Double.parseDouble(num2));
        } else if (operator.equals("/")) {
            result = (Double.parseDouble(num1) / Double.parseDouble(num2));
        } else {
            result = (Double.parseDouble(num1) * Double.parseDouble(num2));
        }

        return result;
    }
}
