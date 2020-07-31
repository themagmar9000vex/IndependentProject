/**
 * The pokemon Arceus.
 *
 * @author Kush Khanna.
 * @version 1.0
 */
public class Arceus extends Pokemon
{

    /**
     * Constructs an Arceus with its given base stats and moves.
     */
    public Arceus(){
        super("Arceus", Types.NORMAL, Types.NONE, 400,290,290,290,290,290,"Calm Mind", "Judgement", "Ice Beam", "Iron Tail");
    }   
    
    /**
     * Calm Mind - Status psychic type move that raises special attack and special defense.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move1(Pokemon opp){   
        raiseSpeAtt();
        raiseSpeDef();
        setCurrentMoveType(Types.PSYCHIC);
        return 0;
    }
    /**
     * Judgement - Special normal type move that has 100 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move2(Pokemon opp){   
        setCurrentMoveType(Types.NORMAL);
        return -100;
    }
    /**
     * Ice Beam - Special ice type move that has 90 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move3(Pokemon opp){
        setCurrentMoveType(Types.ICE);
        return -90;   
    }
    /**
     * Iron Tail - Physical steel type move that has 100 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move4(Pokemon opp){
        setCurrentMoveType(Types.STEEL);
        return 100;
    }     
    
}
