/**
 * The pokemon Venasaur.
 *
 * @author Kush Khanna.
 * @version 1.0
 */
public class Venasaur extends Pokemon
{
    
    /**
     * Constructs a Venasaur with its base stats and moves.
     */
    public Venasaur(){
        super("Venasaur", Types.GRASS, Types.POISON, 315,255,300,300,300,200,"Sleep Powder", "Sludge Bomb", "Energy Ball", "Stun Spore");
    }   
    
    /**
     * Sleep powder - Status grass type move that puts the enemy to sleep.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move1(Pokemon opp){
        opp.setStatus(StatusEffect.SLEEP);       
        setCurrentMoveType(Types.GRASS);
        return 0;
    }
    /**
     * Sludge Bomb - Special poison type move that has 90 power. Has a chance to poison.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move2(Pokemon opp){
        if(RNG.sideStatus()){opp.setStatus(StatusEffect.POISONED);}        
        setCurrentMoveType(Types.POISON);
        return -90;
    }
    /**
     * Energy Ball - Special grass type move that has 90 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move3(Pokemon opp){
        setCurrentMoveType(Types.GRASS);
        return -90;   
    }
    /**
     * Stun spore - Status grass type move that paralyzes the enemy.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move4(Pokemon opp){
        opp.setStatus(StatusEffect.PARALYSIS);
        setCurrentMoveType(Types.GRASS);
        return 0;
    }     
    
}
