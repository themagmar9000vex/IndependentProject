
/**
 * The pokemon Metagross.
 *
 * @author Kush Khanna.
 * @version 1.0
 */
public class Metagross extends Pokemon
{

    /**
     * Constructs a Metagross with its base stats and moves.
     */
    public Metagross(){
        super("Metagross", Types.STEEL, Types.PSYCHIC, 315,310,310,250,250,200,"Meteor Mash", "Shadow Ball", "Psychic", "Swagger");
    }   
    
    /**
     * Meteor Mash - Physical steel type move that has 100 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move1(Pokemon opp){   
        setCurrentMoveType(Types.STEEL);
        return 100;
    }
    /**
     * Shadow Ball - Special ghost type move that has 90 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move2(Pokemon opp){  
        setCurrentMoveType(Types.GHOST);
        return -90;
    }
    /**
     * Psychic - Special psychic type move that has 90 power. Has a chance of confusing the enemy.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move3(Pokemon opp){
        if(RNG.sideStatus()){opp.setStatus(StatusEffect.CONFUSED);}
        setCurrentMoveType(Types.PSYCHIC);
        return -90;   
    }
    /**
     * Swagger - Status normal   type move that raises the enemies attack, but also confuses them.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move4(Pokemon opp){
        opp.setStatus(StatusEffect.CONFUSED);
        opp.raiseAtt();
        setCurrentMoveType(Types.NORMAL);
        return 0;
    }     
    
}
