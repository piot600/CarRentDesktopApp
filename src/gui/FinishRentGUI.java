package gui;

import model.Client;
import model.Rent;
import model.RentStatus;

import javax.swing.*;
import java.awt.*;

public class FinishRentGUI extends JFrame{
    Client client;

    private JButton returnButton;
    private JButton payButton;
    private JPanel finishRent;

    FinishRentGUI(Client client, Rent rent){
        this.client = client;
        returnButton.addActionListener(e -> {
            rent.setStatus(RentStatus.UNPAID);
            new ClientMenuGUI(client);
            this.dispose();
        });
        payButton.addActionListener(e -> {
            client.setBalance(client.getBalance()+rent.getVehicle().getPrice()*7);
            rent.setStatus(RentStatus.PAID);
            new ClientMenuGUI(client);
        });

        setContentPane(finishRent);
        getContentPane().setBackground(new Color(207, 135, 21));
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
