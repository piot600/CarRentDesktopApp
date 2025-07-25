package gui;

import model.Client;
import model.Vehicle;

import javax.swing.*;
import java.awt.*;

public class VehicleListGUI extends JFrame{
    Client client;

    private JList<Vehicle> vehicleList;
    private JButton returnButton;
    private JButton nextButton;
    private JPanel vehiclePane;
    private JPanel ListPanel;
    private JList list1;
    private JLabel text;
    private JLabel companyText;

    VehicleListGUI(Client client, String type){
        this.client = client;

        vehiclePane = new JPanel(new GridLayout(4,1));

        DefaultListModel<Vehicle> listModel = new DefaultListModel<>();
        for (Vehicle a : Vehicle.getVehicles())
            if(a.getClass().getName().equals(type) && !a.getIsRented())
                listModel.addElement(a);
        vehicleList = new JList<>(listModel);
        if (!listModel.isEmpty()) {
            vehicleList.setSelectedIndex(0);
        }

        JScrollPane scrollPane = new JScrollPane(vehicleList);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(207, 135, 21));
        nextButton.addActionListener(e -> {
            new SelectedVehicleInspectionsGUI(client,vehicleList.getSelectedValue());
            this.dispose();
        });
        returnButton.addActionListener(e -> {
            new TypeSelectGUI(client);
            this.dispose();
        });


        buttonPanel.add(returnButton);
        buttonPanel.add(nextButton);

        vehiclePane.add(companyText);
        companyText.setHorizontalAlignment(SwingConstants.CENTER);
        vehiclePane.add(text);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        vehiclePane.add(scrollPane);
        vehiclePane.add(buttonPanel);

        setContentPane(vehiclePane);
        getContentPane().setBackground(new Color(207, 135, 21));
        setTitle("Select model.Vehicle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
