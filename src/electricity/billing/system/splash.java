package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame implements Runnable{

    Thread t1;
    splash()
    {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(576,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        int x=1;
        setVisible(true);//this makes the user to see the frame and the default side is left corner
        for(int i=2 ; i<600 ; i+=4,x++)
        {
            setSize(i+x,i );//setting width and height of frame
            setLocation(700-((i+ x)/2),500-(i/2));
            try {
                Thread.sleep(5);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        t1 = new Thread(this);
        t1.start();
        //x-from left   y-from up
        setVisible(true);
    }
    public static void main(String[] args) {
        new splash();
    }

    @Override
    public void run() {
        try{
            Thread.sleep(7000);
            setVisible(false);//The frame closes after 7 seconds
            //starting Login Frame

            new login();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
