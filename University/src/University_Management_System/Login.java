package University_Management_System;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    JButton login, cancel; // ye globally declare krege taki actionperformed cfunction me jb hm declare kre to koi erro na de
    JTextField Text, textPassword; // for using these two things in login we have to declare this globally
//    JPasswordField textPassword;
    public Login() {
        getContentPane().setBackground(Color.WHITE); // for changing the color
        // there are multiple layout of swing in java to set the things on screen
        // but if you dont want to use any layout you need to do null all layouts
        setLayout(null); // this will remove all the things over the screen

        JLabel lblUserName = new JLabel("Username"); // JLabel basically screen pr kch bhi show krne ya label krne k liye use hota h
        // now is component of explicitly frame k upar place krna pdega, uske liye
        lblUserName.setBounds(40,20,100,20); // for showing component over screen we use **setBounds()** function
        // this is very useful method you can give exact values of your component jha pe aap chahte ho

        add(lblUserName); // this is a function of JLabel to show things on screen

        Text = new JTextField(); // this used to take the input from user
        Text.setBounds(150,20,150,20);
        add(Text);

        JLabel userPassword = new JLabel("Password");
        userPassword.setBounds(40, 50, 100,20);
        add(userPassword);

        textPassword = new JPasswordField(); // this will invisible the words like password
        textPassword.setBounds(150,50,150,20);
        add(textPassword);

        /*JButton*/ login = new JButton("Login"); // Jbutton generates buttons
        login.setBounds(40,110, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE); // this adds color in words
        login.setFont(new Font("Tamoha", Font.BOLD,14));
        login.addActionListener(this); // kisi button per even lagana ho to action listener ka use krte h like button se koi kaam krwana ho
        add(login);

        /*JButton*/ cancel = new JButton("Cancel"); // Jbutton generates buttons
        cancel.setBounds(180,110, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE); // this adds color in words
        cancel.setFont(new Font("Tamoha", Font.BOLD,14));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        //read on chatgpt
        // we made ImageIcon object bcz JLabel k andar aap image class ka object pass nhi kar skte
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // read on chatgpt
        image.setBounds(350, -10, 200, 200); // hmne isme layout null kr rkha h to set.bounds krna pdega

        add(image);

        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==login){
            String username = Text.getText();
            String password = textPassword.getText();

            String query  = "SELECT * FROM login WHERE username = 'admin' AND password = '12345';";
            try{
                Conn c = new Conn();

                ResultSet resultSet = c.s.executeQuery(query);

                if(resultSet.next()){
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane. showMessageDialog(null, "Inavlid username or password");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        Login L = new Login();
    }

}

