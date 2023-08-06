import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

class Client {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String price;

    public Client(String name, String email, String phone, String address, String price) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPrice() {
        return price;
    }
}

public class CRMClient {
    private static ArrayList<Client> clients = new ArrayList<>();
    private static JTextArea outputArea;

    public static void main(String[] args) {
        // Create and configure the GUI frame
        JFrame frame = new JFrame("CRM System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Create a panel for the intro image
        JPanel introPanel = new JPanel();
        introPanel.setLayout(new FlowLayout());

        // Add an image to the intro panel
        ImageIcon imageIcon = new ImageIcon("intro_image.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        introPanel.add(imageLabel);

        // Create a panel for the output area
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());

        // Create an output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to the frame
        frame.add(introPanel, BorderLayout.NORTH);
        frame.add(outputPanel, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);

        // Process client information using a console-based menu
        Scanner scanner = new Scanner(System.in);
        outputArea.append("Welcome! Please enter your choice in the menu below.\n");

        while (true) {
          // Display menu options
            outputArea.append("\n1. Add Client\n");
            outputArea.append("2. Display Client Information\n");
            outputArea.append("3. Remove Client Information\n");
            outputArea.append("4. Exit\n");
            // Get user's choice
            int choice = Integer.parseInt(scanner.nextLine());
          
    
            if (choice == 1) {
                outputArea.append("\nEnter client name: \n");
                String name = scanner.nextLine();
                outputArea.append("Enter client email: \n");
                String email = scanner.nextLine();
                outputArea.append("Enter client phone: \n");
                String phone = scanner.nextLine();
                outputArea.append("Enter client's address: \n");
                String address = scanner.nextLine();
                outputArea.append("Enter client's purchase price: \n");
                String price = scanner.nextLine();
              
                // Create a new client object and add it to the list
                Client client = new Client(name, email, phone, address, price);
                clients.add(client);
                outputArea.append("\nClient added successfully!\n");

            } else if (choice == 2) {
                // Display client information
                outputArea.append("\nEnter client name: \n");
                String name = scanner.nextLine();
                boolean found = false;

                for (Client client : clients) {
                    if (client.getName().equalsIgnoreCase(name)) {
                        // Client found, display information
                        outputArea.append("\nClient Information:\n");
                        outputArea.append("\nName: " + client.getName() + "\n");
                        outputArea.append("Email: " + client.getEmail() + "\n");
                        outputArea.append("Phone: " + client.getPhone() + "\n");
                        outputArea.append("Address: " + client.getAddress() + "\n");
                        outputArea.append("Price: " + client.getPrice() + "\n");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    // Client not found
                    outputArea.append("\nClient not found!\n");
                }
            } else if (choice == 3) {
                // Remove client information
                outputArea.append("\nEnter client name: \n");
                String name = scanner.nextLine();
                boolean removed = false;

                for (Client client : clients) {
                    if (client.getName().equalsIgnoreCase(name)) {
                        clients.remove(client);
                        outputArea.append("\nClient remove successfully!\n");
                        removed = true;
                        break;
                    }
                }

                if (!removed) {
                    // Client not found
                    outputArea.append("\nClient not found!\n");
                }
            } else if (choice == 4) {
                // Exit the loop and terminate the program
                      try {
                    outputArea.append("\n--- Goodbye! ---\n");
                    for (Client client : clients) {
                        // Display client information
                        outputArea.append("Name: " + client.getName() + "\n");
                        outputArea.append("Email: " + client.getEmail() + "\n");
                        outputArea.append("Phone: " + client.getPhone() + "\n");
                        outputArea.append("Address: " + client.getAddress() + "\n");
                        outputArea.append("Price: " + client.getPrice() + "\n");
                    }
                    Thread.sleep(3000); // Delay for 3 seconds (3000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            } else {
                // Invalid choice
                outputArea.append("Invalid choice! Please try again.\n");
            }
        }
    }
}
 