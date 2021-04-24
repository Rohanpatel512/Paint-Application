import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * Represents the painting application
 * @author Rohan
 */
public class App implements ActionListener {
    
    // Fields 
    private Frame design;
    private Brush paint;
    
    private String colors = "red orange yellow green blue magenta";
    
    /**
     * Constructs the paint application
     */
    public App() {
        this.design = new Frame();
        this.paint = new Brush(this.design);
        
        // Call method(s) within the class 
        addClicks();
    }
    
    /**
     * Adds click to each button
     */
    private void addClicks() {
        
        // Get all the buttons (eraser, color buttons, and more options)
        JButton[] colorButtons = this.design.getColorButtons();
        JButton eraser = this.design.getEraser();
        JButton moreOptions = this.design.getMoreOptions();
        
        // Loop through all the color buttons 
        for(int i = 0; i < colorButtons.length; i++) {
            // Add action listener to each color button
            colorButtons[i].addActionListener(this);
        }
        
        // Add action listener to the eraser and more options button 
        eraser.addActionListener(this);
        moreOptions.addActionListener(this);
        
    }
    
    
    /**
     * Check which color to choose
     * @param brushes new color
     * @return new color of brush
     */
    private Color checkColor(String color) {
        switch(color) {
            case "red":
                // Return red
                return Color.RED;
            case "orange":
                // Return orange
                return Color.ORANGE;
            case "yellow":
                // Return yellow
                return Color.YELLOW;
            case "green":
                // Return green
                return Color.GREEN;
            case "blue":
                // Return blue
                return Color.BLUE;
            case "Magenta":
                // Return magenta
                return Color.MAGENTA;
            default:
        }
        // Return default color black
        return Color.BLACK;
    }
    
    

    /**
     * Event performed when a button is clicked 
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
       
        // Get the buttons command 
        String command = e.getActionCommand();
        
        // Get the background color of the paint board 
        JPanel paintBoard = this.design.getPaintBoard();
        Color boardBackground = paintBoard.getBackground();
        
        // Check if command is a color, eraser, or more options
        if(colors.contains(command)) {
            // Set the color of the brush 
            Color brushColor = this.checkColor(command);
            this.paint.setBrushColor(brushColor);
            
        } else if(command.equals("Eraser")) {
            // Change from brush to eraser 
            this.paint.setEraser();
            this.paint.setBrushColor(boardBackground);
        }   
    }
}
