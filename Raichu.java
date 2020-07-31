
/**
 * The pokemon Raichu.
 *
 * @author Kush Khanna.
 * @version 1.0
 */
public class Raichu extends Pokemon
{

    /**
     * Constructs a Raichu with its given base stats and moves.
     */
    public Raichu(){
        super("Raichu", Types.ELECTRIC, Types.NONE, 275,215,150,260,230,270,"Thunder Wave", "Thunderbolt", "Agility", "Swift");
    }   
    
    /**
     * Thunder wave - Status electric type move that paralyzes the enemy.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move1(Pokemon opp){
        opp.setStatus(StatusEffect.PARALYSIS);       
        setCurrentMoveType(Types.ELECTRIC);
        return 0;
    }
    /**
     * Thunderbolt - Special electric type move that has 90 power. Has a change to paralyze the enemy.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move2(Pokemon opp){
        if(RNG.sideStatus()){opp.setStatus(StatusEffect.PARALYSIS);}        
        setCurrentMoveType(Types.ELECTRIC);
        return -90;
    }
    /**
     * Agility - Status psychic type move that raises speed.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move3(Pokemon opp){
        raiseSpeed();
        setCurrentMoveType(Types.PSYCHIC);
        return 0;   
    }
    /**
     * Swift - Special normal type move that has 70 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move4(Pokemon opp){
        setCurrentMoveType(Types.NORMAL);
        return -70;
    }     
    
}
