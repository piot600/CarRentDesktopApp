package gui;

import model.*;

import javax.swing.*;
import java.awt.*;

public class ClientMenuGUI extends JFrame{
    Client client;

    private JPanel ClientMenuGUI;
    private JLabel companyName;
    private JLabel clientDataLabel;
    private JButton showRentHistoryButton;
    private JButton payRentButton;
    private JButton cancelRentButton;
    private JButton rentVehicleButton;
    private JButton showOfferButton;
    private JLabel balanceLabel;
    private JButton saveButton;

    public ClientMenuGUI(Client client){
        this.client = client;
        if(client == null){return;}
        clientDataLabel.setText(client.getName()+" "+client.getSurname()+" "+ client.getPESEL());
        balanceLabel.setText(" Balance:  "+client.getBalance());
        setContentPane(ClientMenuGUI);

        rentVehicleButton.addActionListener(e -> {
            client.rentVehicle();
            this.dispose();
        });

        payRentButton.addActionListener(e -> {
            client.payRent();
            this.dispose();
        });

        showRentHistoryButton.addActionListener(e -> {
            System.out.println("model.Rent Klient extent:");
            for (Rent r : Rent.extent) {
                if(client.getPESEL().equals(r.getClient().getPESEL()))
                    System.out.println(r);
            }
        });
        saveButton.addActionListener(e -> {
            Person.writeExtent();
            Vehicle.writeExtent();
            Inspection.writeExtent();
            Rent.writeExtent();
        });

        getContentPane().setBackground(new Color(207, 135, 21));
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
