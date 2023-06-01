package view;

import javax.swing.*;
import java.awt.*;

public class ResultSelectFrame extends JFrame {


    public ResultSelectFrame(String result) {

        JTextArea ta = new JTextArea(result, 20, 20);
        ta.setEditable(false);
        ta.setBackground(new Color(241, 240, 240));
        ta.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,24));
        JPanel p = new JPanel();
        p.add(ta);
        setContentPane(p);
        setSize(650, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
