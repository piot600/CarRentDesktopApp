package gui;

import model.Client;

import javax.swing.*;
import java.awt.*;

public class ErrorGUI extends JFrame{
    Client client;
    private JButton returnButton;
    private JLabel error;
    private JPanel ErrorPanel;

    public ErrorGUI(Client client){
        this.client=client;

        error.setText("-Ujemny stan konta. Twój stan konta: "+ client.getBalance());

        returnButton.addActionListener(e -> {
            new ClientMenuGUI(client);
            this.dispose();
        });

        setContentPane(ErrorPanel);
        getContentPane().setBackground(new Color(207, 135, 21));
        setTitle("Error");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
