package University_Management_System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{ // implements Runnable is multithreading concepts and we have to create multithreading method too which we have created in Splash class
    // because we already extend JFrame, so we have to use multithreading implements method
    Thread t;

    public Splash() {

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,700, Image.SCALE_DEFAULT);
        //read on chatgpt
        // we made ImageIcon object bcz JLabel k andar aap image class ka object pass nhi kar skte
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // read on chatgpt, JLabel class directly image ko show nhi kr skti that's why we have to make another object for that
        add(image); // it's an add image function read on chatgpt
        t = new Thread(this); // created thread object here
        t.start(); // ye method internally run method ko call kr dega
        // if we want to set something dynamically
        int x =1;
        setVisible(true);
        for(int i =2; i<=600; i+=4, x++){
            setLocation(600-((i+x)/2),370-(i/2));
            setSize(i+3*x,i+x/2);

            try{ // this is inside the for loop
                Thread.sleep(7);
            }catch(Exception e){};
        }

//       // these sets for creating a direct set of things on the  screen, this give the height width everything to the frame
//        setLocation(250,50);
//        setSize(1000,700);
//        setVisible(true);


    }
    public void run(){ // this is a multithreading method
    try {
        Thread.sleep(7000);// 7 second == 7000 miliseconds
        setVisible(false);// it will hide the page, means 7 seconds k bad jo page open hua tha wo automatic close ho jayega

//        next Frame
        Login login = new Login(); // after creating login class and implement all the code of login page add here by constructor calling
    }catch(Exception e) {
    }
    }


    public static void main(String[] args) {

        Splash s = new Splash();
    }
}