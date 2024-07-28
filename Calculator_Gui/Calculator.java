import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import javax.swing.*;

public class Calculator implements ActionListener{
    private JTextArea textarea;
    private JPanel panel_2,panel_3;
    private JScrollPane scroll;
    private JFrame frame;
    private GridLayout gridLayout;
    private JButton button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_0;
    private JButton button_plus,button_minus,button_multiply, button_divide,button_equal,button_dot,button_c,button_brackets,button_e,button_pi;
    private JButton button_backspace,button_percentage, button_square,button_one_by_x;

    public Calculator() {
        frame = new JFrame();        
        panel_2 = new JPanel();
        panel_3 = new JPanel();
        textarea = new JTextArea(5,16);
        scroll = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        gridLayout = new GridLayout(6,4);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        textarea.setBackground(Color.LIGHT_GRAY);
        textarea.setFont(new Font("Crashnumberinggothic-MAjp", Font.BOLD, 20));
        Image icon = Toolkit.getDefaultToolkit().getImage("calc.jpg");    
        frame.setIconImage(icon);   

        button_1 = new JButton("1");        button_2 = new JButton("2");
        button_3 = new JButton("3");        button_4 = new JButton("4");
        button_5 = new JButton("5");        button_6 = new JButton("6");
        button_7 = new JButton("7");        button_8 = new JButton("8");
        button_9 = new JButton("9");        button_0 = new JButton("0");
        button_plus = new JButton("+");     button_minus = new JButton("-");
        button_equal = new JButton("=");    button_dot = new JButton(".");
        button_c = new JButton("C");        button_brackets = new JButton("()");
        button_multiply = new JButton("*");    button_divide = new JButton("/");
        button_e = new JButton("e");    button_pi = new JButton("π");
        button_backspace = new JButton("⌫"); button_percentage = new JButton("%");
        button_square = new JButton("x²");  button_one_by_x = new JButton("1/x");
        
        button_1.addActionListener(this);        button_2.addActionListener(this);
        button_3.addActionListener(this);        button_4.addActionListener(this);
        button_5.addActionListener(this);        button_6.addActionListener(this);
        button_7.addActionListener(this);        button_8.addActionListener(this);
        button_9.addActionListener(this);        button_0.addActionListener(this);
        button_plus.addActionListener(this);     button_minus.addActionListener(this);
        button_dot.addActionListener(this);      button_brackets.addActionListener(this);
        button_equal.addActionListener(this);    button_c.addActionListener(this);
        button_multiply.addActionListener(this);    button_divide.addActionListener(this);
        button_e.addActionListener(this);    button_pi.addActionListener(this);
        button_backspace.addActionListener(this); button_percentage.addActionListener(this);
        button_square.addActionListener(this);   button_one_by_x.addActionListener(this);
 
        panel_2.setBackground(Color.gray);
        panel_3.setBackground(Color.green);

        panel_2.add(scroll);
        panel_3.setLayout(gridLayout);
        panel_2.setBorder(BorderFactory.createEmptyBorder(2,5,5,5)); 
        panel_3.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
        
        panel_3.add(button_backspace);    panel_3.add(button_square);    panel_3.add(button_percentage);    panel_3.add(button_one_by_x);
        panel_3.add(button_c);    panel_3.add(button_e);    panel_3.add(button_pi);    panel_3.add(button_plus);
        panel_3.add(button_1);    panel_3.add(button_2);    panel_3.add(button_3);    panel_3.add(button_minus);
        panel_3.add(button_4);    panel_3.add(button_5);    panel_3.add(button_6);    panel_3.add(button_multiply);
        panel_3.add(button_7);    panel_3.add(button_8);    panel_3.add(button_9);    panel_3.add(button_divide); 
        panel_3.add(button_dot);  panel_3.add(button_0);    panel_3.add(button_equal); panel_3.add(button_brackets);

        //panel_1.setPreferredSize(new Dimension(300, 50));
        panel_2.setPreferredSize(new Dimension(300, 150));
        panel_3.setPreferredSize(new Dimension(300, 250));

        //frame.add(panel_1,BorderLayout.NORTH);
        frame.add(panel_2,BorderLayout.NORTH);
        frame.add(panel_3,BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Evaluator eval = new Evaluator();
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();
        
        if (buttonText.equals("1")) {
            textarea.setText(textarea.getText()+"1");
        }
        else if (buttonText.equals("2")){
            textarea.setText(textarea.getText()+"2");
        }
        else if (buttonText.equals("3")){
            textarea.setText(textarea.getText()+"3");
        }
        else if (buttonText.equals("4")){
            textarea.setText(textarea.getText()+"4");
        }
        else if (buttonText.equals("5")){
            textarea.setText(textarea.getText()+"5");
        }
        else if (buttonText.equals("6")){
            textarea.setText(textarea.getText()+"6");
        }
        else if (buttonText.equals("7")){
            textarea.setText(textarea.getText()+"7");
        }
        else if (buttonText.equals("8")){
            textarea.setText(textarea.getText()+"8");
        }
        else if (buttonText.equals("9")){
            textarea.setText(textarea.getText()+"9");
        }
        else if (buttonText.equals("0")){
            textarea.setText(textarea.getText()+"0");
        }
        else if (buttonText.equals("+")){
            textarea.setText(textarea.getText()+"+");
        }
        else if (buttonText.equals("-")){
            textarea.setText(textarea.getText()+"-");
        }
        else if (buttonText.equals("=")){
            try {
                textarea.setText(eval.evaluateExpression("0" + textarea.getText())+"");
            } 
            catch (ArithmeticException error1) {textarea.setText("Infinity");}
            catch (EmptyStackException error2){System.out.println(""); }
            catch (StringIndexOutOfBoundsException error3){System.out.println("");}
        }
        else if (buttonText.equals("C")){
            textarea.setText("");
        }
        else if (buttonText.equals(".")){
            textarea.setText(textarea.getText()+".");
        }
        else if (buttonText.equals("*")){
            textarea.setText(textarea.getText()+"*");
        }
        else if (buttonText.equals("/")){
            textarea.setText(textarea.getText()+"/");
        }
        else if (buttonText.equals("e")){
            textarea.setText(textarea.getText()+2.71828 + "");
        }
        else if (buttonText.equals("π")){
            textarea.setText(textarea.getText()+3.14 + "");
        }
        else if (buttonText.equals("⌫")){
            String exp = textarea.getText();
            if (!exp.isEmpty()){
                textarea.setText(exp.substring(0,exp.length()-1));
            }
        }
        else if (buttonText.equals("%")){
            textarea.setText(textarea.getText()+"/100");
        }
        else if (buttonText.equals("1/x")){
            String exp = textarea.getText();
            
            textarea.setText(exp.substring(0,findlastnumber(exp))+ "(1/" + exp.substring(findlastnumber(exp),exp.length()) + ")");
        }
        else if (buttonText.equals("x²")){
            String exp = textarea.getText();
            textarea.setText(exp.substring(0,findlastnumber(exp))+ "(" + exp.substring(findlastnumber(exp),exp.length()) +"*" + exp.substring(findlastnumber(exp),exp.length()) + ")");
        }
        else if (buttonText.equals("()")){
            String exp = textarea.getText();
            if (exp.endsWith("(") || exp.equals("") || exp.equals("*") ||exp.equals("/") || exp.equals("-") || exp.equals("*") || ((check_frequency(exp, "(") == 0) || (check_frequency(exp, "(") == check_frequency(exp, ")")))){
                textarea.setText(exp+"(");
            }
            /*else if ((check_frequency(exp, "(")> 0) && (exp.endsWith("1") ||exp.endsWith("2") ||exp.endsWith("3") ||exp.endsWith("4") ||exp.endsWith("5") ||exp.endsWith("6") ||exp.endsWith("7") ||exp.endsWith("8") ||exp.endsWith("9") ||exp.endsWith("0"))){
                textarea.setText(exp+"*(");
            }*/
            else if (check_frequency(exp, "(") > check_frequency(exp, ")")) {
                textarea.setText(exp+")");
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }

    public static int check_frequency(String a,String val){
        int sum = 0;
        for (String i: a.split("")){
            if (i.equals(val)){
                sum++;
            }
        }
        return sum;
    }

    public static int findlastnumber(String s){
        int index = 0;
        for (int i = s.length()-1;i >0;i--){
            if ((s.charAt(i) == '-') || (s.charAt(i) == '+') || (s.charAt(i) == '*') || (s.charAt(i) == '/')){
                index = i;
                break;
            }
        }
        return index+1;
    }
}