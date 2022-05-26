package ObserverPattern;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example= new SwingObserverExample();
        example.go();
    }

    public  void go(){
        frame= new JFrame();
        JButton button= new JButton("Should i for it?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
    }

    class AngelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it, you might regret it");
        }


    }
    class DevilListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Do it bro");
        }
    }

}
