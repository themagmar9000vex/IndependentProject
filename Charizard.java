/**
 * The pokemon Charizard.
 *
 * @author Kush Khanna.
 * @version 1.0
 */
public class Charizard extends Pokemon
{
    
    /**
     * Constructs a Charizard with its base stats and moves.
     */
    public Charizard(){
        super("Charizard", Types.FIRE, Types.FLYING, 300,215,205,265,215,250,"Flamethrower", "Wing Attack", "Dragon Claw", "Scary Face");
    }
    
    /**
     * Flamethrower - Special fire type move that returns 90 power. Has a chance to burn the enemy.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move1(Pokemon opp){
        if(RNG.sideStatus()){opp.setStatus(StatusEffect.BURN);}
        setCurrentMoveType(Types.FIRE);
        return -90;
    }
    /**
     * Wing attack - Physical flying type move that returns 60 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move2(Pokemon opp){
        setCurrentMoveType(Types.FLYING);
        return 60;
    }
    /**
     * Dragon Claw - Physical dragon type move that returns 90 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move3(Pokemon opp){
        setCurrentMoveType(Types.DRAGON);
        return 90;  
    }
    /**
     * Scary Face - Status normal type move that lowers the enemy's speed.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move4(Pokemon opp){
        setCurrentMoveType(Types.NORMAL);
        opp.lowerSpeed();
        return 0;
    }     
    
}
