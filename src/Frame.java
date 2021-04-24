import javax.swing.*;
import java.awt.*;

/**
 * Represents the GUI displayed to user 
 * @author Rohan
 */
public class Frame extends JFrame {
    
    // Fields 
    //private JPanel paintBoard;
    private JPanel paintMenu;
    private JPanel colorMenu;
    private JPanel paintBoard;
    
    private JButton[] colorButtons = new JButton[6];
    private JButton eraser = new JButton("Eraser");
    private JButton moreOptions = new JButton("More colors");
    
    private String[] colors = {"red", "orange", "yellow", "green", "blue", "magenta"};
    
    /**
     * Constructs the window frame
     * Creates all the GUI components 
     */
    public Frame() {
        this.setTitle("Paint App");
        this.setSize(800, 500);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        // Initialize the fields 
        this.paintMenu = new JPanel();
        this.colorMenu = new JPanel();
        this.paintBoard = new JPanel();
        
        // Adds all components to the frame 
        addComponents();
    }
    
    /**
     * Helper method to call methods to add components 
     */
    private void addComponents() {
        addPanels();
        addColorButtons();
        addButtons();
    }
    
    /**
     * Designs and adds panels to the window 
     */
    private void addPanels() {
        
        // Set the dimension of both panels 
        this.paintMenu.setPreferredSize(new Dimension(300, 500));
        this.colorMenu.setPreferredSize(new Dimension(100, 100));
        this.paintBoard.setPreferredSize(new Dimension(500, 500));
        
        // Set the layout of each panel  
        this.paintMenu.setLayout(new BorderLayout());
        this.colorMenu.setLayout(new GridLayout(2, 3));
        
        // Set the background color of the paint board 
        this.paintBoard.setBackground(Color.WHITE);
                
        // Add panels into their corresponding panels 
        this.paintMenu.add(this.colorMenu, BorderLayout.PAGE_START);
        
        // Add both panels onto the main frame 
        this.add(this.paintMenu, BorderLayout.EAST);
        this.add(this.paintBoard, BorderLayout.WEST);
    }
    
    /**
     * Designs and adds color buttons to the panels 
     */
    private void addColorButtons() {
        
        // Loop through all buttons 
        for(int i = 0; i < this.colorButtons.length; i++) {
            // Create a new button 
            this.colorButtons[i] = new JButton();
            
            // Set the size of the color buttons 
            this.colorButtons[i].setSize(5, 5);
            
            // Get the background color of button 
            Color background = getBackground(i);
            
            // Set the background of the button 
            this.colorButtons[i].setBackground(background);
            this.colorButtons[i].setActionCommand(colors[i]);
            
            // Add the color button to corresponding panel 
            this.colorMenu.add(this.colorButtons[i]);
        }
    }
    
    
    /**
     * Adds other buttons onto the panel 
     */
    private void addButtons() {
        
        // Method variables 
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        
        // Add the button panel to the center of the paint menu 
        this.paintMenu.add(buttonsPanel, BorderLayout.CENTER);
        
        // Set action command for both buttons 
        this.eraser.setActionCommand("Eraser");
        this.moreOptions.setActionCommand("Options");
        
        // Add both eraser and more options to the buttons panel 
        buttonsPanel.add(this.eraser);
        buttonsPanel.add(this.moreOptions);
        
    }
    
    /**
     * Gets the background for each button
     * @param index of button
     * @return the color of each button
     */
    private Color getBackground(int index) {
        // Check which color to choose 
        switch(index) {
            case 0:
                // Return red
                return Color.RED;
            case 1:
                // Return orange
                return Color.ORANGE;
            case 2:
                // Return yellow
                return Color.YELLOW;
            case 3:
                // Return green
                return Color.GREEN;
            case 4:
                // Return blue
                return Color.BLUE;
            case 5:
                // Return magenta
                return Color.MAGENTA;
            default:
        }
        return Color.WHITE;
    }
    
    /**
     * Access to the color buttons 
     * @return color buttons
     */
    public JButton[] getColorButtons() {
        return this.colorButtons;
    }
    
    /**
     * Access to the more options button 
     * @return the more options
     */
    public JButton getMoreOptions() {
        return this.moreOptions;
    }
    
    /**
     * Access to the eraser 
     * @return the eraser 
     */
    public JButton getEraser() {
        return this.eraser;
    }
    
    /**
     * Access to the paint board
     * @return paint board
     */
    public JPanel getPaintBoard() {
        return this.paintBoard;
    }
    
}
