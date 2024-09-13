package University_Management_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class AddStudent extends JFrame implements ActionListener {
    JTextField tfname,tffname,tfaddress,tfpnumber,tfemail,tfXpercent,tfXII,tfAdhar;
    JLabel labelrollno;
    JDateChooser datechooserdob;

    JComboBox  cbCourse, cbBranch;

    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L); // yha par sirf positive number hi generate hoge math.abs se
    AddStudent(){
        setSize(1050,900);
        setLocation(300,20);
        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100,150,100,30);
        lblname.setFont(new Font("serif", Font.BOLD,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220,150,200,30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(460,150,200,30);
        lblfname.setFont(new Font("serif", Font.BOLD,20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(620,150,200,30);
        add(tffname);

        JLabel lblrollno = new JLabel("Roll No");
        lblrollno.setBounds(100,220,100,30);
        lblrollno.setFont(new Font("serif", Font.BOLD,20));
        add(lblrollno);

        labelrollno = new JLabel("1533" + first4);
        labelrollno.setBounds(220,220,100,30);
        labelrollno.setFont(new Font("serif", Font.BOLD,20));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(460,220,200,30);
        lbldob.setFont(new Font("serif", Font.BOLD,20));
        add(lbldob);

        datechooserdob = new JDateChooser();
        datechooserdob.setBounds(620,220,200,30);
        add(datechooserdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100,290,100,30);
        lbladdress.setFont(new Font("serif", Font.BOLD,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,200,30);
        add(tfaddress);

        JLabel lblpnumber = new JLabel("Phone");
        lblpnumber.setBounds(460,290,200,30);
        lblpnumber.setFont(new Font("serif", Font.BOLD,20));
        add(lblpnumber);

        tfpnumber = new JTextField();
        tfpnumber.setBounds(620,290,200,30);
        add(tfpnumber);

        JLabel lblemail = new JLabel("Email I'd");
        lblemail.setBounds(100,360,100,30);
        lblemail.setFont(new Font("serif", Font.BOLD,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220,360,200,30);
        add(tfemail);

        JLabel lblXpercent = new JLabel("Class X(%)");
        lblXpercent.setBounds(460,360,200,30);
        lblXpercent.setFont(new Font("serif", Font.BOLD,20));
        add(lblXpercent);

        tfXpercent = new JTextField();
        tfXpercent.setBounds(620,360,200,30);
        add(tfXpercent);

        JLabel lblXiipercent = new JLabel("Class XII(%)");
        lblXiipercent.setBounds(100,430,200,30);
        lblXiipercent.setFont(new Font("serif", Font.BOLD,20));
        add(lblXiipercent);

        tfXII = new JTextField();
        tfXII.setBounds(220,430,200,30);
        add(tfXII);

        JLabel lblAdhar = new JLabel("Aadhar Number");
        lblAdhar.setBounds(460,430,200,30);
        lblAdhar.setFont(new Font("serif", Font.BOLD,20));
        add(lblAdhar);

        tfAdhar = new JTextField();
        tfAdhar.setBounds(620,430,200,30);
        add(tfAdhar);

        JLabel lblCourse = new JLabel("Course");
        lblCourse.setBounds(100,500,200,30);
        lblCourse.setFont(new Font("serif", Font.BOLD,20));
        add(lblCourse);


        String course[] = {"B.Tech", "BBA", "BCA", "MCA", "BSc", "MSc", "MBA", "MA", "BA", "MCom"};
        cbCourse = new JComboBox(course);
        cbCourse.setBounds(220,500,200,30);
        cbCourse.setBackground(Color.WHITE);
        add(cbCourse);

        JLabel lblBranch = new JLabel("Branch");
        lblBranch.setBounds(460,500,200,30);
        lblBranch.setFont(new Font("serif", Font.BOLD,20));
        add(lblBranch);

        String branch[] = {"Computer Science", "Electronics", "IT", "Civil", "Mechanical"};
        cbBranch = new JComboBox(branch);
        cbBranch.setBounds(620,500,200,30);
        cbBranch.setBackground(Color.WHITE);
        add(cbBranch);

        /*JButton*/ submit = new JButton("Submit"); // Jbutton generates buttons
        submit.setBounds(240,620,200,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE); // this adds color in words
        submit.setFont(new Font("Tamoha", Font.BOLD,14));
        submit.addActionListener(this); // kisi button per even lagana ho to action listener ka use krte h like button se koi kaam krwana ho
        add(submit);

        /*JButton*/ cancel = new JButton("Cancel"); // Jbutton generates buttons
        cancel.setBounds(540,620,200,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE); // this adds color in words
        cancel.setFont(new Font("Tamoha", Font.BOLD,14));
        cancel.addActionListener( this);
        add(cancel);



        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== submit){
        String name = tfname.getText();
        String fname = tffname.getText();
        String rollno = labelrollno.getText();
        String dob = ((JTextField)datechooserdob.getDateEditor().getUiComponent()).getText();
        String address = tfaddress.getText();
        String phone = tfpnumber.getText();
        String email = tfemail.getText();
        String x = tfXpercent.getText();
        String xii = tfXII.getText();
        String aadhar = tfAdhar.getText();
        String course = (String)cbCourse.getSelectedItem();
        String branch = (String)cbBranch.getSelectedItem();

        try{
            String query = "Insert into student values('"+name+"','"+fname+"','"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"','"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+branch+"' )";
            Conn c = new Conn();
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
        }else {
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new AddStudent();
    }


}
