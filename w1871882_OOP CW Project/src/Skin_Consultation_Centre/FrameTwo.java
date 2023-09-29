package Skin_Consultation_Centre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameTwo implements ActionListener {
    JFrame frame = new JFrame();
    //JPanel panel1 = new JPanel();
    //JPanel panel2 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JButton button = new JButton();
    JTextArea textArea = new JTextArea();
    public void frameTwo(){
        //panel1.setBackground(Color.orange);
        //panel1.setBounds(0,0,1280,60);
       // panel1.add(label1);






        label1.setBounds(0,0,1280,60);
        label1.setText("Doctor list");

        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBackground(Color.orange);
        label1.setOpaque(true);


        button.setBounds(10,10,80,40);
        button.setText("Back");
        button.setFocusPainted(false);
        button.addActionListener(this);



        label2.setBounds(0,60,1280,660);
        label2.setBackground(Color.green);
        label2.setOpaque(true);
        label2.add(textArea);

        textArea.setBounds(10,10,1245,605);
        for (int i = 0; i < WestminsterSkinConsultationManager.doctorArray.length; i++) {
            if (WestminsterSkinConsultationManager.doctorArray[i] == null) {
                //continue;
                break;
            } else {
                textArea.append(WestminsterSkinConsultationManager.doctorArray[i].toString()+"\n"+"\n");


            }
        }


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1280,720);
        frame.setVisible(true);
        frame.setLayout(null);  // add Flow layout

        //frame.add(panel1);
        //frame.add(panel2);
        frame.add(label1);
        frame.add(label2);

        frame.add(button);
        //frame.add(textArea);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            MyFrame myFrame = new MyFrame();
            boolean x =myFrame.exitCall();
            if (x){
                frame.dispose();
            }
            else {

            }


        }

    }
}
