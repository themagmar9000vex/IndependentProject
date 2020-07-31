/**
 * The pokemon Tyranitar.
 *
 * @author Kush Khanna.
 * @version 1.0
 */
public class Tyranitar extends Pokemon
{

    /**
     * Constructs a Tyranitar with its base stats and moves.
     */
    public Tyranitar(){
        super("Tyranitar", Types.ROCK, Types.DARK, 350,300,300,260,290,150,"Earthquake", "Crunch", "Stone Edge", "Screech");
    }   
    
    /**
     * Earthquake - Physical ground type move that has 100 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move1(Pokemon opp){  
        setCurrentMoveType(Types.GROUND);
        return 100;
    }
    /**
     * Crunch - Physical dark type move that has 80 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move2(Pokemon opp){  
        setCurrentMoveType(Types.DARK);
        return 80;
    }
    /**
     * Stone Edge - Physical rock type move that has 90 power.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move3(Pokemon opp){
        setCurrentMoveType(Types.ROCK);
        return 90;   
    }
    /**
     * Screech - Status normal type move that lowers the enemy's defense.
     * @param opp the enemy pokemon
     * @return the power of the move
     */
    public int move4(Pokemon opp){
        opp.lowerDef();
        setCurrentMoveType(Types.NORMAL);
        return 0;
    }     
    
}
