import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    JTextField textField1,textField2;
    JLabel label1,label2;

    MyFrame(){

        JLabel label1=new JLabel();
        label1.setText("Enter number of barbers : ");
        label1.setBounds(30,30,150,150);
        label1.setVisible(true);

        JTextField textField1=new JTextField();
        textField1.setPreferredSize(new Dimension(250,40));
        textField1.setBackground(Color.red);
        textField1.setVisible(true);
        this.add(textField1);

        JButton button=new JButton();
        button.setBounds(200,200,80,50);
        button.setText("Enter");
        button.addActionListener(e -> System.out.println("hello"));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500,500);
        this.setLayout(null);
        this.add(button);
        this.add(label1);
        this.add(textField1);

    }
}
