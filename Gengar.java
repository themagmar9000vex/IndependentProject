/**
 * The pokemon Gengar.
 *
 * @author Kush Khanna.
 * @version 1.0
 */
public class Gengar extends Pokemon
{

    /**
     * Constructs a Gengar with its base stats and moves.
     */
    public Gengar(){
        super("Gengar", Types.GHOST, Types.POISON, 275,180,180,310,200,270,"Shadow Ball", "Sludge Bomb", "Hypnosis", "Confuse Ray");
    }   
    
    /**
     * Shadow Ball - Special ghost type move that has 90 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move1(Pokemon opp){      
        setCurrentMoveType(Types.GHOST);
        return -90;
    }
    /**
     * Sludge Bomb - Special poison type move that has 90 power. Has a change to poison the enemy.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move2(Pokemon opp){
        if(RNG.sideStatus()){opp.setStatus(StatusEffect.POISONED);}        
        setCurrentMoveType(Types.POISON);
        return -90;
    }
    /**
     * Hypnosis  - Status psychic type move that puts the enemy to sleep.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move3(Pokemon opp){
        opp.setStatus(StatusEffect.SLEEP);
        setCurrentMoveType(Types.PSYCHIC);
        return 0;   
    }
    /**
     * Confuse Ray - Status ghost type move that confuses the enemy.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move4(Pokemon opp){
        opp.setStatus(StatusEffect.CONFUSED);
        setCurrentMoveType(Types.GHOST);
        return 0;
    }     
    
}
