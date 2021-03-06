import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;

/**
 * Represents the background that is being displayed, and the pokemon sprites too.
 * 
 * @author Kush Khanna
 * @version 1.0
 */
public class PokemonBackground extends JPanel{

    private BufferedImage background;
    private BufferedImage front;
    private BufferedImage back;
    
    /**
     * Constructs a background with the given pokemon names.
     * @param back the pokemon showing its back.
     * @param front the pokemon showing its front.
     */
    public PokemonBackground(String back, String front){
        try{
        background = ImageIO.read(new File("Background.png"));
        this.front = ImageIO.read(new File(front+"Front.png"));
        this.back = ImageIO.read(new File(back+"Back.png"));
        } catch (Exception ex){
            System.exit(0);
        }
        
    }
    
    /**
     * Overrides the paintComponent method to draw the images of the background and the pokemon.
     * @param g the graphics object.
     */
    public void paintComponent(Graphics g){
        g.drawImage(background,0,0,this);
        g.drawImage(front,559,85,this); 
        g.drawImage(back,127,219,this);
    }
}