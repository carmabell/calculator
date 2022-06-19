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
        JButton b1, bAddition;

        // create number buttons
        b1 = new JButton("1");

        // create operator buttons
        bAddition = new JButton("+");

        // create a panel
        JPanel panel = new JPanel();

        // add action listeners
        bAddition.addActionListener(calc);
        b1.addActionListener(calc);

        // add elements to panel
        panel.add(display);
        panel.add(bAddition);
        panel.add(b1);

        // set Background of panel
        panel.setBackground(Color.LIGHT_GRAY);
        // add panel to frame
        frame.add(panel);

        frame.setSize(350, 300);
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
        else {
            // save operand for later calculation
            if (operator.equals("") || num2.equals("")){
                operator = command;
            }
            // else evaluate
            // else {
            //     double result;

            //     // store result value in 1st
            //     result = runMathOperation(num1, operator, num2);

            //     // convert it to string
            //     num1 = Double.toString(result);

            //     // save selected operator
            //     operator = command;

            //     // clear second operand
            //     num2 = "";
            // }

            // set the value of text
            display.setText(num1 + operator + num2);
        }
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
