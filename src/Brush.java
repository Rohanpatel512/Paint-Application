import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;


/**
 * Represents the paint brush
 * @author Rohan
 */
public class Brush implements MouseMotionListener {
    
    // Fields
    private Frame design;
    private Color brushColor;
    private boolean isEraser = false;
    private int brushX;
    private int brushY;
    
    
    /**
     * Constructs the paint board 
     * @param the window frame 
     */
    public Brush(Frame design) {
        this.brushColor = Color.BLACK;
        this.isEraser = isEraser;
        this.brushX = brushX;
        this.brushY = brushY;
        this.design = design;
        
        // Call method(s) within the class
        addMouseListener(design);
    }
    
    /**
     * Adds mouse motion listener to the paint board
     * @param the window frame 
     */
    private void addMouseListener(Frame design) {
        // Get the paint board 
        JPanel paintBoard = design.getPaintBoard();
        
        // Add a mouse motion listener to the paint board 
        paintBoard.addMouseMotionListener(this);
    }
    
    /**
     * Paints/draws onto the board 
     * @param the graphics
     */
    private void paint(Graphics g) {
        // Paint on the board
        g.setColor(this.brushColor);
        g.fillOval(this.brushX, this.brushY, 20, 20);
    }

    /**
     * Sets the color of the paint brush 
     * @param new color of the brush 
     */
    public void setBrushColor(Color color) {
        // Changes the brushes color
        this.brushColor = color;
    }
    
    /**
     * Changes from paint brush to eraser
     */
    public void setEraser() {
        // Changes from brush to eraser
        this.isEraser = !this.isEraser;
    }

    /**
     * Get the x and y coordinates of the brush when mouse is dragged
     * @param e 
     */
    public void mouseDragged(MouseEvent e) {
        // Get both x and y coordinate of brush 
        this.brushX = e.getX();
        this.brushY = e.getY();
        
        // Get the graphics 
        Graphics g = this.design.getGraphics();
        
        // Paint on the board 
        paint(g);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

   
}
