package gui;

import model.Client;
import model.Rent;
import model.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class RentSummaryGUI extends JFrame{
    Client client;
    Vehicle vehicle;

    private JButton returnButton;
    private JButton acceptButton;
    private JLabel startDate;
    private JLabel endDate;
    private JLabel price;
    private JLabel vehicleLabel;
    private JPanel summary;

    RentSummaryGUI(Client client, Vehicle vehicle){
        this.client = client;
        this.vehicle = vehicle;
        LocalDate now = LocalDate.now();

        vehicleLabel.setText(vehicle.toString());
        price.setText(String.valueOf("Do zapłaty: "+vehicle.getPrice()*7));
        startDate.setText("Data wynajmu: " + now.toString());
        endDate.setText("Data zakończenia: " + now.plusDays(7).toString());

        returnButton.addActionListener(e -> {
            new ClientMenuGUI(client);
            this.dispose();
        });
        acceptButton.addActionListener(e -> {
            Rent r = new Rent(client,vehicle);
            new FinishRentGUI(client,r);
            this.dispose();
        });


        setContentPane(summary);
        getContentPane().setBackground(new Color(207, 135, 21));
        setTitle("Type Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
