package Skin_Consultation_Centre;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame implements ActionListener {

    JFrame frame = new JFrame();

    JPanel topPanel = new JPanel();
    JPanel bottomLeftPanel = new JPanel();
    JPanel bottomRightPanel = new JPanel();
    JLabel topLabel = new JLabel();
    JLabel bottomLeftLabel = new JLabel();
    JLabel bottomRightLabel = new JLabel();

    JButton bottomLeftButton = new JButton();
    JButton bottomRightButton = new JButton();

    ImageIcon topImage = new ImageIcon(new ImageIcon("Skin care.jpg").getImage().getScaledInstance(720, 220, Image.SCALE_SMOOTH));

    ImageIcon bottomLeftImage = new ImageIcon(new ImageIcon("Doctor.jpg").getImage().getScaledInstance(380, 240, Image.SCALE_SMOOTH));

    ImageIcon bottomRightImage = new ImageIcon(new ImageIcon("BookConsultation.jpg").getImage().getScaledInstance(380, 240, Image.SCALE_SMOOTH));

    public void firstFrame() {
        topPanel.setLayout(null);   //////
        topPanel.setBackground(Color.cyan);
        topPanel.setBounds(0, 0, 720, 240);
        topPanel.add(topLabel);

        topLabel.setText("Westminster Skin Consultation Centre");
        topLabel.setIcon(topImage);
        topLabel.setHorizontalTextPosition(JLabel.CENTER);
        topLabel.setVerticalTextPosition(JLabel.TOP);
        topLabel.setBounds(0, 0, 720, 240);


        bottomLeftPanel.setBackground(Color.green);
        bottomLeftPanel.setBounds(0, 220, 360, 240);
        bottomLeftPanel.add(bottomLeftLabel);

        bottomLeftLabel.setIcon(bottomLeftImage);
        bottomLeftLabel.setBounds(0, 240, 360, 240);


        bottomLeftButton.setBounds(105, 360, 150, 50);
        bottomLeftButton.setText("View Doctors");
        bottomLeftButton.setFocusPainted(false);
        bottomLeftButton.addActionListener(this);


        bottomRightPanel.setBackground(Color.orange);
        bottomRightPanel.setBounds(360, 220, 360, 240);
        bottomRightPanel.add(bottomRightLabel);

        bottomRightLabel.setIcon(bottomRightImage);
        bottomLeftLabel.setBounds(360, 240, 360, 240);


        bottomRightButton.setBounds(465, 360, 150, 50);
        bottomRightButton.setText("Book consultation");
        bottomRightButton.setFocusPainted(false);
        bottomRightButton.addActionListener(this);


        frame.setTitle("Skin Consultation Centre.");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //The frame will be closed and disposed but the application will not exit.
        frame.setResizable(false);
        frame.setSize(720, 480);
        frame.setVisible(true);     //make frame visible
        frame.setLayout(null);

        frame.add(topPanel);
        frame.add(bottomLeftPanel);
        frame.add(bottomRightPanel);

        frame.add(bottomLeftButton);
        frame.add(bottomRightButton);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bottomLeftButton) {

            frame.dispose();      // to close the frame
            FrameTwo frameTwo = new FrameTwo();
            frameTwo.frameTwo();


        } else if (e.getSource() == bottomRightButton) {
            frame.dispose();
            FrameThree frameThree = new FrameThree();
            frameThree.frameThree();


        }

    }

    public boolean exitCall() {
        //0 ,1 ,-1 return values
        boolean z = false;
        String[] options = {"Home page", "Stay here"};
        int respond = JOptionPane.showOptionDialog(null, "Where do you want to go back ?", "Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, 0);
        if (respond == 0) {
            firstFrame();
            z = true;

        }/*
        else if(respond== 1 || respond== -1 ) {
            z= false;
        }*/
        return z;
    }



}