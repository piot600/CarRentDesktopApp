package gui;

import model.Client;
import model.DriverLicenceCategories;

import javax.swing.*;
import java.awt.*;

public class CategoryErrorGUI extends JFrame{
    Client client;

    private JButton returnButton;
    private JLabel error;
    private JPanel ErrorCategoryPanel;

    CategoryErrorGUI(Client client, DriverLicenceCategories category){
        error.setText("- Brak kategorii. Wymagana kategoria: " + category);
        returnButton.addActionListener(e -> {
            new TypeSelectGUI(client);
            this.dispose();
        });

        setContentPane(ErrorCategoryPanel);
        getContentPane().setBackground(new Color(207, 135, 21));
        setTitle("Error");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
