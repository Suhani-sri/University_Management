package University_Management_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {

    Choice crollno, ctime;

    JDateChooser datechooser;

    JButton submit, cancel;

    StudentLeave(){
        setSize(500,500);
        setLocation(550,100);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(30,45,300,30);
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        add(heading);

        JLabel lblrollno = new JLabel("Search by Roll No");
        lblrollno.setBounds(60,95,200,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(60,125,200,20);
        add(crollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(60,200,200,20);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(lblDate);

        datechooser = new JDateChooser();
        datechooser.setBounds(60,230,200,25);
        add(datechooser);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,280,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60,305,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        /*JButton*/ submit = new JButton("Submit"); // Jbutton generates buttons
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE); // this adds color in words
        submit.setFont(new Font("Tamoha", Font.BOLD,14));
        submit.addActionListener(this); // kisi button per even lagana ho to action listener ka use krte h like button se koi kaam krwana ho
        add(submit);

        /*JButton*/ cancel = new JButton("Cancel"); // Jbutton generates buttons
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE); // this adds color in words
        cancel.setFont(new Font("Tamoha", Font.BOLD,14));
        cancel.addActionListener( this);
        add(cancel);


        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "insert into studentLeave values('" + rollno + "','" + date + "', '" + duration + "')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }


    }

