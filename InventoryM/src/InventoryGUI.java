import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryGUI extends JFrame {
    private InventoryManager manager;  // Instance of InventoryManager to manage inventory items
    private JTextArea displayArea;     // Text area to display inventory items
    private JTextField idField, nameField, quantityField, priceField;

    public InventoryGUI() {
        // Initialize the manager (handles inventory logic)
        manager = new InventoryManager();

        // Set up the frame
        setTitle("Inventory Management System");
        setSize(500, 500);  // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close on exit
        setLayout(new BorderLayout());

        // Create a text area to display the inventory list (non-editable)
        displayArea = new JTextArea();
        displayArea.setEditable(false);  // Make it non-editable
        JScrollPane scrollPane = new JScrollPane(displayArea);  // Add scrolling
        add(scrollPane, BorderLayout.CENTER);  // Add the scroll pane to the center

        // Panel to hold input fields (ID, Name, Quantity, Price)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));  // 5 rows, 2 columns for labels and fields

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        add(inputPanel, BorderLayout.NORTH);  // Add input panel to the top

        // Panel to hold buttons (Add, Update, Delete, Display)
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Item");
        JButton updateButton = new JButton("Update Item");
        JButton deleteButton = new JButton("Delete Item");
        JButton displayButton = new JButton("Display All Items");

        // Add event listeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateItem();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayItems();
            }
        });

        // Add buttons to the panel
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(displayButton);

        add(buttonPanel, BorderLayout.SOUTH);  // Add button panel to the bottom
    }

    // Method to add an item to the inventory
    private void addItem() {
        String id = idField.getText();
        String name = nameField.getText();
        String quantityText = quantityField.getText();
        String priceText = priceField.getText();

        // Input Validation
        if (id.isEmpty() || name.isEmpty() || quantityText.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return; // Exit the method if any field is empty
        }

        try {
            int quantity = Integer.parseInt(quantityText); // Parse quantity
            double price = Double.parseDouble(priceText);  // Parse price

            if (quantity < 0 || price < 0) {
                JOptionPane.showMessageDialog(this, "Quantity and price must be non-negative.");
                return;
            }

            InventoryItem newItem = new InventoryItem(id, name, quantity, price);
            manager.addItem(newItem);

            clearFields();  // Clear input fields after adding item
            displayItems();  // Refresh inventory display

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for quantity and price.");
        }
    }

    // Method to update an item in the inventory
    private void updateItem() {
        String id = idField.getText();
        String name = nameField.getText();
        String quantityText = quantityField.getText();
        String priceText = priceField.getText();

        // Input Validation
        if (id.isEmpty() || name.isEmpty() || quantityText.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityText); // Parse quantity
            double price = Double.parseDouble(priceText);  // Parse price

            if (quantity < 0 || price < 0) {
                JOptionPane.showMessageDialog(this, "Quantity and price must be non-negative.");
                return;
            }

            InventoryItem updatedItem = new InventoryItem(id, name, quantity, price);
            boolean updated = manager.updateItem(id, updatedItem);

            if (updated) {
                displayItems();  // Refresh inventory display
            } else {
                JOptionPane.showMessageDialog(this, "Item not found.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for quantity and price.");
        }
    }

    // Method to delete an item from the inventory
    private void deleteItem() {
        String id = idField.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an ID to delete.");
            return;
        }

        boolean deleted = manager.deleteItem(id);

        if (deleted) {
            displayItems();  // Refresh inventory display
        } else {
            JOptionPane.showMessageDialog(this, "Item not found.");
        }
    }

    // Method to display all inventory items
    private void displayItems() {
        displayArea.setText("");  // Clear the text area
        for (InventoryItem item : manager.getAllItems()) {
            displayArea.append(item + "\n");  // Append each item to the text area
        }
    }

    // Method to clear input fields after actions like Add or Update
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        // Create and display the GUI window
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InventoryGUI gui = new InventoryGUI();
                gui.setVisible(true);  // Make the GUI visible
            }
        });
    }
}
