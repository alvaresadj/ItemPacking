import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class itemPacking extends JFrame {
    
	private JTextField weightField, heightField, widthField, depthField,resultField;
    
    public itemPacking() {
    	
    	 // Setting up the JFrame
    	 setTitle("Item Packing");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(500, 500);
         setLocationRelativeTo(null);
         setVisible(true);
         
         // Main Panel using BorderLayout
         JPanel mp = new JPanel(new BorderLayout());
         
         // Panel for input components using GridBagLayout
         JPanel inputPanel = new JPanel(new GridBagLayout());
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.insets = new Insets(15, 15, 15, 15);
         gbc.anchor = GridBagConstraints.CENTER; // Align components to the center

         // Labels, Fields & Buttons
         JLabel tLabel = new JLabel("Please enter the values below");
         tLabel.setHorizontalAlignment(SwingConstants.CENTER);
         tLabel.setFont(new Font("Arial", Font.BOLD, 28));

         JLabel weightLabel = new JLabel("Weight of box:");
         weightField = new JTextField(15);
         JLabel mLabel = new JLabel("Dimensions of Box");
         mLabel.setHorizontalAlignment(SwingConstants.CENTER);
         mLabel.setFont(new Font("Arial", Font.BOLD, 28));

         JLabel heightLabel = new JLabel("Height:");
         heightField = new JTextField(10);
         JLabel widthLabel = new JLabel("Width:");
         widthField = new JTextField(10);
         JLabel depthLabel = new JLabel("Depth:");
         depthField = new JTextField(10);
         JButton cItem = new JButton("Calculate Item Package");

         // Weight Label at column 0, row 1
         gbc.gridx = 0;
         gbc.gridy = 1;
         gbc.gridwidth = 2; // Span across two columns
         inputPanel.add(weightLabel, gbc);

         // Weight Field at column 2, row 1
         gbc.gridx = 2;
         gbc.gridwidth = 2; // Span across two columns
         weightField.setMinimumSize(new Dimension(100, weightField.getPreferredSize().height)); // Set a minimum width for the weight field
         inputPanel.add(weightField, gbc);

         // Dimensions of Box Label centered underneath weight
         gbc.gridx = 0;
         gbc.gridy = 2;
         gbc.gridwidth = 6; // Span across six columns
         inputPanel.add(mLabel, gbc);

         // Height Label at column 0, row 3
         gbc.gridx = 0;
         gbc.gridy = 3;
         gbc.gridwidth = 1; // Reset grid width
         inputPanel.add(heightLabel, gbc);

         // Height Field at column 1, row 3
         gbc.gridx = 1;
         heightField.setMinimumSize(new Dimension(70, heightField.getPreferredSize().height)); // Set a minimum width for the height field
         inputPanel.add(heightField, gbc);

         // Width Label at column 2, row 3
         gbc.gridx = 2;
         inputPanel.add(widthLabel, gbc);

         // Width Field at column 3, row 3
         gbc.gridx = 3;
         widthField.setMinimumSize(new Dimension(70, widthField.getPreferredSize().height)); // Set a minimum width for the width field
         inputPanel.add(widthField, gbc);

         // Depth Label at column 4, row 3
         gbc.gridx = 4;
         inputPanel.add(depthLabel, gbc);

         // Depth Field at column 5, row 3
         gbc.gridx = 5;
         depthField.setMinimumSize(new Dimension(70, depthField.getPreferredSize().height)); // Set a minimum width for the depth field
         inputPanel.add(depthField, gbc);

         // Calculate Item Button at column 0, row 4
         gbc.gridy = 4;
         gbc.gridx = 1; // Adjust the starting column to center the button
         gbc.gridwidth = 4; // Span across four columns for center alignment
         gbc.anchor = GridBagConstraints.CENTER; // Align to the center
         inputPanel.add(cItem, gbc);

         // Adding the Input Panel to the main panel's center
         mp.add(inputPanel, BorderLayout.CENTER);

         // Panel for the Title Label using FlowLayout centered at the top
         JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         topPanel.add(tLabel);

         // Adding the Title Label Panel to the main panel's NORTH
         mp.add(topPanel, BorderLayout.NORTH);

         // Panel for the Home Button using FlowLayout aligned to the right
         JPanel homePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
         JButton bHome = new JButton("Home");
         homePanel.add(bHome);

         // Create a Panel to hold the title and Home button Panels side by side
         JPanel titleHomePanel = new JPanel(new BorderLayout());
         titleHomePanel.add(topPanel, BorderLayout.CENTER);
         titleHomePanel.add(homePanel, BorderLayout.EAST);

         // Adding both Title and Home Button Panel to the Main Panel's NORTH
         mp.add(titleHomePanel, BorderLayout.NORTH);

         // Add the main panel to the frame
         add(mp);
        
         // Create a Panel for the Result Field
         JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         resultField = new JTextField(35); // Initialize the resultField here
         resultField.setEditable(false);
         resultField.setHorizontalAlignment(JTextField.CENTER);
         Font font = resultField.getFont();
         resultField.setFont(new Font(font.getName(), Font.PLAIN, 16));
         resultPanel.add(resultField);

         // Add the Result Panel to the Main Panel's SOUTH
         mp.add(resultPanel, BorderLayout.SOUTH);
         
         // Adding ActionListener to the "Calculate Item Package" Button
         cItem.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        try {
        	        	//Parsing input values from Text Fields
        	            double weight = Double.parseDouble(weightField.getText());
        	            double height = Double.parseDouble(heightField.getText());
        	            double width = Double.parseDouble(widthField.getText());
        	            double depth = Double.parseDouble(depthField.getText());

        	            // Calculating box volume and number of boxes needed
        	            double boxVolume = height * width * depth;
        	            int boxesNeeded = (int) Math.ceil(weight / boxVolume);
                        
        	            // Displaying the result in the Result Field
        	            resultField.setText("Number of boxes needed: " + boxesNeeded);
        	        } catch (NumberFormatException ex) {
        	        	// Handling non-numeric inputs in Text Fields
        	            resultField.setText("Please enter valid numbers in all fields");
        	        }
        	    }
        	});
        
    }
    
public static void main(String[] args) {
	
        SwingUtilities.invokeLater(itemPacking::new); // Using SwingUtilities.invokeLater to ensure GUI-related tasks are performed in the event-dispatching thread
    }}