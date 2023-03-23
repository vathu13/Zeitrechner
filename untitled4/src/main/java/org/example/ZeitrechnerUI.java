package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ZeitrechnerUI {


    private static JTextField textField = new JTextField();
    private JButton button1;
    private JButton button2;

    public ZeitrechnerUI() {
        JFrame frame1 = new JFrame();
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JTextField textField = new JTextField();
        String s = "         Dein Arbeitsbeginn";
        this.textField =textField;
        frame1.setVisible(true);
        frame1.setContentPane(panel);
        frame1.setSize(1200, 800);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setLayout(new GridLayout(2, 1));
        frame1.add(panel1, "NORTH");
        frame1.add(panel2, "SOUTH");
        panel1.setVisible(true);
        panel2.setVisible(true);

        panel1.add(label1);
        panel1.add(label2);
        panel1.setLayout(null);
        panel2.setLayout(null);
        label1.setVisible(true);
        label1.setText("Dein Zeitrechner");
        label1.setBounds(380, 50, 600, 80);
        label1.setFont(label1.getFont().deriveFont(60f));


        label2.setVisible(true);
        label2.setBounds(500, 150, 180, 60);
        panel1.add(label2);
        /**
         * Hier wird die Uhr aufgerufen
         */
        Timer t = new Timer(1000, e -> {
            SimpleDateFormat sdf = new SimpleDateFormat("H'h' "+":"+" mm'm'");
            label2.setText(sdf.format(Calendar.getInstance().getTime()));
        });
        t.start();
        label2.setFont(label2.getFont().deriveFont(40f));
        panel1.add(textField);
        textField.setVisible(true);
        textField.setBounds(500, 220, 180, 30);

        textField.addFocusListener(new FocusListener() {
            /**
             * Hier wird der Text im Eingabe generiert. Wen man da rein klickt, sollte das geschrieben verschwinden
             */
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().equals("")) {
                    textField.setText(s);
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("");

            }
        });

        button1.setVisible(true);
        button1.setText("Kurzarbeit");
        button1.setBounds(100, 1, 400, 200);
        button1.setFont(new Font("Arial", Font.PLAIN, 40));
        button1.setName("1");
        this.button1 = button1;
        panel2.add(button1);

        button2.setVisible(true);
        button2.setText("Normaler Arbeitstag");
        button2.setBounds(650, 1, 400, 200);
        button2.setFont(new Font("Arial", Font.PLAIN, 40));
        button2.setName("2");
        this.button2 = button2;
        panel2.add(button2);
    }


    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public static JTextField getTextField() {
        return textField;
    }
}
