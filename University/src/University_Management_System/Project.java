package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
    public Project() {
        setSize(1540,850);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,800, Image.SCALE_DEFAULT);
        //read on chatgpt
        // we made ImageIcon object bcz JLabel k andar aap image class ka object pass nhi kar skte
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // read on chatgpt, JLabel class directly image ko show nhi kr skti that's why we have to make another object for that
        add(image); // it's an add image function read on chatgpt

        JMenuBar mb = new JMenuBar(); // menubar bnane k liye used class

        JMenu newInfo = new JMenu("New Information"); // for setting the name
        mb.add(newInfo);

        // now for making list in that newIfo that called menu items
        //New information
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem stundentInfo = new JMenuItem("New Student Information");
        stundentInfo.setBackground(Color.WHITE);
        stundentInfo.addActionListener(this);
        newInfo.add(stundentInfo);

        // Faculty details
        JMenu details = new JMenu("View Details"); // for setting the name
        mb.add(details);

        // now for making list in that newIfo that called menu items
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem stundentDetails = new JMenuItem("View Student Details");
        stundentDetails.setBackground(Color.WHITE);
        stundentDetails.addActionListener(this);
        details.add(stundentDetails);
//
//        //Apply leave
//        JMenu leave = new JMenu("Apply Leave"); // for setting the name
//        mb.add(leave);
//
//        // now for making list in that newIfo that called menu items
//        JMenuItem facultyLeave = new JMenuItem("Teacher Leave");
//        facultyLeave.setBackground(Color.WHITE);
//        leave.add(facultyLeave);
//
//        JMenuItem stundentLeave = new JMenuItem("Student Leave");
//        stundentLeave.setBackground(Color.WHITE);
//        leave.add(stundentLeave);

        //Leave Details
//        JMenu leaveDetails = new JMenu("Leave Details"); // for setting the name
//        mb.add(leaveDetails);
//
//        // now for making list in that newIfo that called menu items
//        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
//        facultyLeaveDetails.setBackground(Color.WHITE);
//        leaveDetails.add(facultyLeaveDetails);
//
//        JMenuItem stundentLeaveDetails = new JMenuItem("Student Leave Details");
//        stundentLeaveDetails.setBackground(Color.WHITE);
//        leaveDetails.add(stundentLeaveDetails);

        //Exams
//        JMenu exam = new JMenu("Examination"); // for setting the name
//        mb.add(exam);

        // now for making list in that newIfo that called menu items
//        JMenuItem examDetails = new JMenuItem("Examination Results");
//        examDetails.setBackground(Color.WHITE);
//        exam.add(examDetails);
//
//        JMenuItem enterMarks = new JMenuItem("Enter Marks");
//        enterMarks.setBackground(Color.WHITE);
//        exam.add(enterMarks);

//        //Update Info
//        JMenu updateInfo = new JMenu("Update Details"); // for setting the name
//        mb.add(updateInfo);
//
//        // now for making list in that newIfo that called menu items
//        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
//        updateFacultyInfo.setBackground(Color.WHITE);
//        updateInfo.add(updateFacultyInfo);
//
//        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
//        updateStudentInfo.setBackground(Color.WHITE);
//        updateInfo.add(updateStudentInfo);

        //Fee
//        JMenu fee = new JMenu("Fee Details"); // for setting the name
//        mb.add(fee);

        // now for making list in that newIfo that called menu items
//        JMenuItem feeStructure = new JMenuItem("Fee Structure");
//        feeStructure.setBackground(Color.WHITE);
//        fee.add(feeStructure);
//
//        JMenuItem feeForm = new JMenuItem("Fee Form");
//        feeForm.setBackground(Color.WHITE);
//        fee.add(feeForm);

        //Utility
        JMenu utility = new JMenu("Utility"); // for setting the name
        mb.add(utility);

        // now for making list in that newIfo that called menu items
        JMenuItem notepad = new JMenuItem("Calculator");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Notepad");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        //Exit
        JMenu exit = new JMenu("Exit"); // for setting the name
        mb.add(exit);

        // now for making list in that newIfo that called menu items
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this); // it's an event listener on which we click and happen any event or happen some work
        exit.add(ex);

        setJMenuBar(mb); // meu bar ko screen pr dikhane k liye setMenubar function ka use krte h



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){ // its a abstract override function in implement ActionListener we have to add this when we use ActionListener
        String msg = ae.getActionCommand();
        if(msg.equals("Exit")){ // this equals method takes string as a click button but this string must be same as written upper
            setVisible(false);
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe"); // exec("calc.exe") = it tells operating system to run the calculator
            }catch (Exception e){

            }
        } else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){

            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
            
        }else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();

        } else if (msg.equals("Teacher Leave")) {
        new TeacherLeave();
    } else if (msg.equals("Student Leave")) {
        new StudentLeave();

    }
    }

    public static void main(String[] args) {
        Project project = new Project();
    }
}
