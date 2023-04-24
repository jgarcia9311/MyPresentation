package myPresentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    //atributos
    private JButton myPhoto, myHobby, myExpectations;
    private JPanel containerButtons, containerImage;
    private Listener listener;
    private Title title;
    private JLabel imageLabel;
    private JTextArea expectativesText;

    private boolean messageShown;

    //metodos
    public GUI(){
        initGUI();
        this.setTitle("My Presentation");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private void initGUI() {
        //Definir container y Layout del JFrame
        //Crear objetos Escucha y Control
        //Configurar JComponents
        title = new Title("A little more about me", Color.BLACK);
        myPhoto = new JButton("Me");
        myHobby = new JButton("I like this");
        myExpectations = new JButton("Expectations");
        containerButtons = new JPanel();
        containerImage = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectativesText = new JTextArea(10, 12);

        containerImage.setBorder(BorderFactory.createTitledBorder(null, "About me", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.SANS_SERIF,Font.PLAIN,20), Color.BLACK));
        containerImage.add(imageLabel);

        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectations);

        myPhoto.addActionListener(listener);
        myHobby.addActionListener(listener);
        myExpectations.addActionListener(listener);
        this.addKeyListener(listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI myGui = new GUI();
            }
        });
    }

    private class Listener implements ActionListener, KeyListener{
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "Press button");
            imageLabel.setIcon(null);
            containerImage.remove(expectativesText);

            if(e.getSource() == myPhoto){
                this.image = new ImageIcon(getClass().getResource("/resources/Me.jpg"));
                imageLabel.setIcon(image);



                myHobby.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {

                        if (e.getClickCount() == 2) {
                            image = new ImageIcon(getClass().getResource("/resources/Hobby.png"));
                            imageLabel.setIcon(image);

                            }
                        else
                        {
                            expectativesText.setText("Press double click on the button 'I like this' to see my Hobbits");
                            expectativesText.setBackground(null);
                            expectativesText.setForeground(Color.BLACK);
                            containerImage.add(expectativesText);
                        }
                    }
                });

            }if(e.getSource() == myExpectations) {

                expectativesText.setText("My objective in this assignment is learn and practice to become an excellent software developer \n" + "My contact is juan.m.garcia@correounivalle.edu.co");
                expectativesText.setBackground(null);
                expectativesText.setForeground(Color.BLACK);
                containerImage.add(expectativesText);

            }

            revalidate();
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e)
        {


        }

        @Override
        public void keyPressed(KeyEvent e) {

                {
                    if (e.getKeyChar()=='m')
                    expectativesText.setText("My objective in this assignment is learn and practice to become an excellent software developer \n" + "My contact is juan.m.garcia@correounivalle.edu.co");
                    expectativesText.setBackground(null);
                    expectativesText.setForeground(Color.BLACK);
                    containerImage.add(expectativesText);
                }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }


    }
}
