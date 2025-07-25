package gui;

import model.Client;
import model.Inspection;
import model.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SelectedVehicleInspectionsGUI extends JFrame {
    Client client;
    Vehicle vehicle;

    private JTable table1;
    private JButton returnButton;
    private JButton nextButton;
    private JLabel selectVehicle;
    private JPanel TableInspPanel;

    SelectedVehicleInspectionsGUI(Client client, Vehicle vehicle) {
        this.client = client;
        this.vehicle = vehicle;

        setContentPane(TableInspPanel);
        setTitle("Table of Inspections");

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("Marka");
        model.addColumn("Model");
        model.addColumn("Vin");
        model.addColumn("Data przeglądu");
        model.addColumn("Data końca");
        model.addColumn("Imię Serwisanta");
        model.addColumn("Nazwisko Serwisanta");

        for (Inspection r : vehicle.getInspections()) {
            if (vehicle.getNr_VIN().equals(r.getVehicle().getNr_VIN())) {
                model.addRow(new Object[]{
                        r.getVehicle().getBrand(),
                        r.getVehicle().getModel(),
                        r.getVehicle().getNr_VIN(),
                        r.getInspectionDate(),
                        r.getInspectionExpire(), // Assuming you have this method
                        r.getMechanic().getName(),
                        r.getMechanic().getSurname()
                });
            }
        }
        model.isCellEditable(1,1);

        returnButton.addActionListener(e -> {
            new VehicleListGUI(client,vehicle.getClass().getName());
            this.dispose();
        });
        nextButton.addActionListener(e -> {
            new RentSummaryGUI(client, vehicle);
            this.dispose();
        });


        table1.setModel(model);
        getContentPane().setBackground(new Color(207, 135, 21));
        setTitle("Select model.Vehicle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
