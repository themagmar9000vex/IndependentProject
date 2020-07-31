/**
 * The pokemon Heracross.
 *
 * @author Kush Khanna.
 * @version 1.0
 */
public class Heracross extends Pokemon
{

    /**
     * Constructs a Heracross with its base stats and moves.
     */
    public Heracross(){
        super("Heracross", Types.BUG, Types.FIGHTING, 300,300,200,100,230,220,"Megahorn", "Brick Break", "Bulk Up", "Aerial Ace");
    }   
    
    /**
     * Megahorn - Physical bug type move that has 90 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move1(Pokemon opp){     
        setCurrentMoveType(Types.BUG);
        return 90;
    }
    /**
     * Brick break - Physical fighting type move that has 80 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move2(Pokemon opp){  
        setCurrentMoveType(Types.FIGHTING);
        return 80;
    }
    /**
     * Bulk up - Status  fighting type move that raises defense and attack.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move3(Pokemon opp){
        setCurrentMoveType(Types.FIGHTING);
        raiseDef();
        raiseAtt();
        return 0;   
    }
    /**
     * Aerial Ace - Physical fighting type move that has 60 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move4(Pokemon opp){
        setCurrentMoveType(Types.FLYING);
        return 60;
    }     
    
}
