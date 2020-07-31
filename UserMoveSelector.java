/**
 * Represents the selected move of the user to be used in Click Listener.
 *
 * @author Kush Khanna
 * @version 1.0
 */
public class UserMoveSelector
{
    private static int selectedMove;
    
    /**
     * Returns the selected move.
     * @return the selected move.
     */
    public static int getSelectedMove(){return selectedMove;}
    
    /**
     * Sets the selected move.
     * @param x sets the selected move to this value.
     */
    public static void setSelectedMove(int x){selectedMove = x;}
}
