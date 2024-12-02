/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoprogramacioni;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author disma
 */
public class ProyectoProgramacionI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JFrame frame = new JFrame("Pokedex");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.BLACK);

        URL logoURL = ProyectoProgramacionI.class.getResource("/Pokedex_logo.png");
        ImageIcon logoIcon = new ImageIcon(logoURL);
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        URL iconURL = ProyectoProgramacionI.class.getResource("/Pokeball_logo.png");
        ImageIcon frameIcon = new ImageIcon(iconURL);
        frame.setIconImage(frameIcon.getImage());
        
        JButton btnRegister = new JButton("Registrar Pokémon");
        JButton btnList = new JButton("Listar Pokémon");
        JButton btnReview = new JButton("Revisión de Pokédex");
        JButton btnExit = new JButton("Salir");

        btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnList.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReview.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(logoLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        mainPanel.add(btnRegister);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(btnList);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(btnReview);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(btnExit);

        frame.add(mainPanel);
        frame.setVisible(true);
        
    }
}
