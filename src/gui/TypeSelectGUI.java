package gui;

import model.Client;
import model.DriverLicenceCategories;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TypeSelectGUI extends JFrame{
    Client client;
    DriverLicenceCategories category;
    String type;

    private JComboBox comboBox1;
    private JButton returnButton;
    private JButton nextButton;
    private JPanel TypePanel;

    public TypeSelectGUI(Client client){
        this.client = client;
        setContentPane(TypePanel);

        returnButton.addActionListener(e -> {
            new ClientMenuGUI(client);
            this.dispose();
        });

        nextButton.addActionListener(e -> {
            if (Objects.equals(comboBox1.getSelectedItem(), "Ciężarówka")) {
                if (client.getClientLicences().contains(DriverLicenceCategories.C)) {
                    category = DriverLicenceCategories.C;
                    type = "model.Truck";
                    new VehicleListGUI(client,type);
                }
                else { new CategoryErrorGUI(client,DriverLicenceCategories.C);}
            }
            else if(Objects.equals(comboBox1.getSelectedItem(), "Samochód")) {
                if (client.getClientLicences().contains(DriverLicenceCategories.B)) {
                    category = DriverLicenceCategories.B;
                    type = "model.Car";
                    new VehicleListGUI(client,type);;
                }
                else { new CategoryErrorGUI(client,DriverLicenceCategories.B); }
            }
            else {
                if (client.getClientLicences().contains(DriverLicenceCategories.A)) {
                    category = DriverLicenceCategories.A;
                    type = "model.Motorbike";
                    new VehicleListGUI(client,type);
                }
                else if(client.getClientLicences().contains(DriverLicenceCategories.A1)) {
                    category = DriverLicenceCategories.A1;
                    new VehicleListGUI(client,type);
                    type = "model.Motorbike";
                }
                else if (client.getClientLicences().contains(DriverLicenceCategories.A2)) {
                    new VehicleListGUI(client,type);
                    category = DriverLicenceCategories.A2;
                    type = "model.Motorbike";
                }
                else { new CategoryErrorGUI(client, DriverLicenceCategories.A); }
            }
            this.dispose();
        });

        getContentPane().setBackground(new Color(207, 135, 21));
        setTitle("Type Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
