
package travel;
///*
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements  Runnable{
    Thread t;
    private JProgressBar bar;

    String usernamee;
    public void setUploading() {
        setVisible(false);
        t.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {

                int m =  bar.getMaximum();
                int v =  bar.getValue();
                if (v < m) {
                    bar.setValue( bar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Dashboard(usernamee).setVisible(true);
//                    new Home(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Loading( String usernamee){
        this.usernamee = usernamee;
        // run method ko call krta h thread class
        /// creat threat obj
        t = new Thread( this);

        setBounds( 500 , 200 , 650 , 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel text = new JLabel("Travel and tourisam Application");
        text.setBounds(50 , 20 , 600 , 40);
        text.setForeground(new Color(72, 209, 204));
        text.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        add(text);

        // prgress bar
        bar = new JProgressBar();
        bar.setFont(new Font("Tahoma", Font.BOLD, 12));
        bar.setStringPainted(true);
        bar.setBounds(150 , 100 , 300 , 35);
        bar.setStringPainted(true);
        add(bar);

        // please wait
        JLabel loading = new JLabel("Loading Please wait...");
        loading.setBounds(180 , 140 , 350 , 30);
        loading.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        loading.setForeground(new Color(160, 82, 45));
        add(loading);

        JLabel username = new JLabel("Welcome "+usernamee+"");
        username.setBounds(40 , 310 , 400 , 30);
        username.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
        username.setFont(new Font("Raleway" , Font.BOLD , 35));
        add(username);

        t.start();
        setVisible(true);

    }
    public static void main(String[] args) {
        new Loading("");
    }
}
