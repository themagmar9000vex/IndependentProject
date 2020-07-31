/**
 * The pokemon Garchomp.
 *
 * @author Kush Khanna.
 * @version 1.0
 */
public class Garchomp extends Pokemon
{
    
    /**
     * Constructs a Garchomp with its base stats and moves.
     */    
    public Garchomp(){
        super("Garchomp", Types.DRAGON, Types.GROUND, 350,310,220,200,220,260,"Dragon Claw", "Earthquake", "Slash", "Crunch");
    }   
    
    /**
     * Dragon claw - Physical dragon type move that has 90 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move1(Pokemon opp){      
        setCurrentMoveType(Types.DRAGON);
        return 90;
    }
    /**
     * Earthquake - Physical ground type move that has 100 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move2(Pokemon opp){    
        setCurrentMoveType(Types.GROUND);
        return 100;
    }
    /**
     * Slash - Physical normal type move that has 80 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move3(Pokemon opp){
        setCurrentMoveType(Types.NORMAL);
        return 80;   
    }
    /**
     * Crunch - Physical dark type move that has 90 powre.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move4(Pokemon opp){
        setCurrentMoveType(Types.DARK);
        return 90;
    }     
    
}
