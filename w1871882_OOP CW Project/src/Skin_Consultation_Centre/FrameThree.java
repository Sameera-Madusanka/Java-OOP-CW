package Skin_Consultation_Centre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrameThree implements ActionListener {
    JFrame frame = new JFrame();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label0 = new JLabel();
    JLabel label1 = new JLabel();
    JLabel label2= new JLabel();
    JLabel label3= new JLabel();

    JTextArea textArea1 = new JTextArea();
    JTextArea textArea2 = new JTextArea();
    JTextArea textArea3 = new JTextArea();


    public void frameThree(){

        label0.setBounds(0,0,1280,60);
        label0.setLayout(null);
        label0.setText("Consultation");
        label0.setVerticalAlignment(JLabel.CENTER);
        label0.setHorizontalAlignment(JLabel.CENTER);
        label0.setBackground(Color.green);
        label0.setOpaque(true);
        label0.add(button1);
        label0.add(button2);

        button1.setBounds(10,10,80,40);
        button1.setText("Back");
        button1.setFocusPainted(false);
        button1.addActionListener(this);

        button2.setBounds(1100,10,160,40);
        button2.setText("Book a Consultation");
        button2.setFocusPainted(false);
        button2.addActionListener(this);

        button3.setBounds(0,0,90,25);
        button3.setText("Refresh");
        button3.setFocusPainted(false);
        button3.addActionListener(this);

        panel1.setLayout(null);
        panel1.setBackground(new Color(255,254,200));
        panel1.setBounds(6,66,631,288);
        panel1.add(textArea1);
        panel1.add(label1);


        panel2.setLayout(null);
        panel2.setBackground(new Color(255,254,200));
        panel2.setBounds(643,66,617,288);
        panel2.add(textArea2);
        panel2.add(label2);

        panel3.setLayout(null);
        panel3.setBackground(new Color(255,254,200));
        panel3.setBounds(6,363,1254,333);
        panel3.add(textArea3);
        panel3.add(label3);

        label1.setBounds(0,0,631,25);
        label1.setLayout(null);
        label1.setText("Available doctors");
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBackground(Color.orange);
        label1.setOpaque(true);

        label2.setBounds(0,0,631,25);
        label2.setLayout(null);
        label2.setText("Booked Consultation by console");
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBackground(Color.orange);
        label2.setOpaque(true);

        label3.setBounds(0,0,1254,25);
        label3.setLayout(null);
        label3.setText("Newly added Consultation");
        label3.setVerticalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setBackground(Color.orange);
        label3.setOpaque(true);
        label3.add(button3);


        textArea1.setBounds(10,35,611,242);             // to show available doctors
        for (int i = 0; i < WestminsterSkinConsultationManager.doctorArray.length; i++) {
            if (WestminsterSkinConsultationManager.doctorArray[i] == null) {
                //continue;
                break;
            } else {
                textArea1.append(WestminsterSkinConsultationManager.doctorArray[i].guiToString()+"\n"+"\n");

            }
        }

        textArea2.setBounds(10,35,598,242);             // to show available doctors
        for (int i = 0; i < WestminsterSkinConsultationManager.consultationsArray.length; i++) {
            if (WestminsterSkinConsultationManager.consultationsArray[i] == null) {
                //continue;
                break;
            } else {
                textArea2.append(WestminsterSkinConsultationManager.consultationsArray[i].toString()+"\n"+"\n");

            }
        }
        textArea3.setBounds(10,35,1235,275);
        for (int i = 0; i < WestminsterSkinConsultationManager.guiConsultationArray.length; i++) {
            if (WestminsterSkinConsultationManager.guiConsultationArray[i] == null) {
                //continue;
                break;
            } else {
                textArea3.append(WestminsterSkinConsultationManager.guiConsultationArray[i].guiConsultString()+"\n"+"\n");

            }
        }







        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1280,720);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.add(label0);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            MyFrame myFrame = new MyFrame();
            boolean x =myFrame.exitCall();
            if (x){
                frame.dispose();
            }
            else {

            }
        }
        if(e.getSource() == button3){
            frame.dispose();
            FrameThree frameRefreshed = new FrameThree();
            frameRefreshed.frameThree();
        }
        if(e.getSource() == button2){
            try{
                String pName = JOptionPane.showInputDialog("Enter patient name");
                String pSName = JOptionPane.showInputDialog("Enter patient surname");
                String pDOB = JOptionPane.showInputDialog("Enter patient DOB");
                String mNo = JOptionPane.showInputDialog("Enter patient mobile number");
                int PId = Integer.parseInt(JOptionPane.showInputDialog("Enter patient ID"));  // convert string to integer
                String cDoctor = JOptionPane.showInputDialog("Enter !! available doctor name !!that you want to have consultation with ");
                String cDate = JOptionPane.showInputDialog("Enter Consultation Date");
                String cTime = JOptionPane.showInputDialog("Enter Consultation Start time");
                int cHours =Integer.parseInt(JOptionPane.showInputDialog("Enter Consultation Duration/hours (Each consultation is £25 \n" +
                        "per hour and the first consultation is £15 per hour)"));

                Consultation guiConsult = new Consultation();
                guiConsult.setConsultPatient(pName);
                guiConsult.setConsultPatientSurname(pSName);
                guiConsult.setConsultDOB(pDOB);
                guiConsult.setConsultMobile(mNo);
                guiConsult.setConsultPatientId(PId);
                guiConsult.setDate(cDate);
                guiConsult.setTime(cTime);
                guiConsult.setConsultDoctor(cDoctor);
                if (Consultation.guiConsultationArrayIndex == 0){
                    guiConsult.setConsultPrice(cHours * 15);
                }
                else{
                    guiConsult.setConsultPrice(cHours * 25);
                }

                WestminsterSkinConsultationManager.guiConsultationArray[Consultation.guiConsultationArrayIndex] = guiConsult;  //adding object to hte object array
                Consultation.guiConsultationArrayIndex++;     //increment index number for object array
            }
            catch(NumberFormatException c){
                System.out.println("Please enter Only a Integers for Patient ID and No.of hours");
            }
            catch (Exception c){
                System.out.println(c+"Exception occurs");
            }


             // getting notes from customer
             int respond = JOptionPane.showConfirmDialog(null,"Do you want to add some notes(textual information/Images)","Aditional notes",JOptionPane.YES_NO_OPTION);
             if (respond == 0){
                 JFileChooser fileChooser = new JFileChooser();
                 fileChooser.setCurrentDirectory(new File("."));
                 fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                 int selection = fileChooser.showOpenDialog(null);        // select file to open (this returns integer values 0-select 1-cancel/close)

                 if (selection == JFileChooser.APPROVE_OPTION){    // same as (selection == 0)

                     Encryptor en = Encryptor.getEncrypter(false);          //Uses DES algorithm/api to encrypt and decrypt data
                     Decryptor de = Decryptor.getDecrypter(false);          // ** i didn't implement algorithm **
                                                                            //Full credit goes to @author "Sopiro"

                     File image = new File(fileChooser.getSelectedFile().getAbsolutePath());    //selecting the private folder path
                     //System.out.println(image);
                     File ency = new File("./EncryptedNotes");           // path for encrypted data

                     en.encrypt(image, ency);   // for encryption

                     //de.decrypt(src, src);    //for decryption


                 }
             }


        }

    }

}
