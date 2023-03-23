package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class ControllerZeitrechner implements ActionListener {
    private ZeitrechnerUI zeitrechnerUI;

    /**
     * Hiermit werden die Buttons mit den Actionlistner verbunden
     */
    public ControllerZeitrechner() {
        zeitrechnerUI = new ZeitrechnerUI();
        // Buttons mit ActionListener verknüpfen
        zeitrechnerUI.getButton1().addActionListener(this);
        zeitrechnerUI.getButton2().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn == zeitrechnerUI.getButton1()) {
            JTextField textField = zeitrechnerUI.getTextField();
            String inputTime = textField.getText();
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date startTime;
            try {
                startTime = format.parse(inputTime);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Falsches Format."+"\n"+"Bitte gib dein Arbeitsbeginn in der Form HH:mm an."+ "\n"+"As Beispiel 06:15");
                return;
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(startTime);
            cal.add(Calendar.HOUR_OF_DAY, 6);
            Date endTime = cal.getTime();
            String outputTime = format.format(endTime);
            JOptionPane.showMessageDialog(null, "Du kannst Feierabend machen um: "+"\n" + outputTime + "\n"+"Du arbeitest ohne Pause");
            

        } else if (btn == zeitrechnerUI.getButton2()) {
            JTextField textField = zeitrechnerUI.getTextField();
            String inputTime = textField.getText();
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date startTime;
            try {
                startTime = format.parse(inputTime);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Falsches Format."+"\n"+"Bitte gib dein Arbeitsbeginn in der Form HH:mm an."+ "\n"+"As Beispiel 06:15");
                return;
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(startTime);
            cal.add(Calendar.HOUR_OF_DAY, 8);
            cal.add(Calendar.MINUTE,18);
            Date endTime = cal.getTime();
            String outputTime = format.format(endTime);
            JOptionPane.showMessageDialog(null, "Du kannst Feierabend machen um: "+"\n" + outputTime + "\n"+"Du machst 30 Minuten Pause");
        } else {
            // Do nothing
        }
    }
}
