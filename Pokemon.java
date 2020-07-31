import javax.swing.JLabel;
import java.awt.Color;
/**
 * Represents the species of Pokemon, which can be inherited to create specific pokemons. 
 *
 * @author Kush Khanna
 * @version 1.0
 */
public abstract class Pokemon   
{

    public enum Types{NORMAL, FIRE, WATER, GRASS, FIGHTING, BUG, POISON, GROUND, ROCK, STEEL, GHOST, ICE, DRAGON, DARK, PSYCHIC, FLYING, ELECTRIC, NONE};
    public enum StatusEffect{NEUTRAL, CONFUSED, POISONED, SLEEP, PARALYSIS, FROZEN, BURN};
    
    private String name;    
    private Types[] types;
    private int[] stats; //Attack, Special Attack, Defense, Special Defense, Speed
    private int[] hp; //Current HP & Starting HP
    private StatusEffect status;
    private String[] moveList;
    private Types currentMoveType;
    private double modifier;
    
    /**
     * Constucts a pokemon with the given information.
     * @param name the name of the pokemon.
     * @param type1 the first type of the pokemon.
     * @param type2 the second type of the pokemon.
     * @param hp the total health of the pokemon.
     * @param att the attack stat of the pokemon.
     * @param speAtt the special attack stat of the pokemon.
     * @param def the defense stat of the pokemon.
     * @param speDef the special defense stat of the pokemon
     * @param spe the speed stat of the pokemon
     * @param move1 the name of the first move of the pokemon
     * @param move2 the name of the second move of the pokemon
     * @param move3 the name of the third move of the pokemon
     * @param move4 the name of the fourth move of the pokemon
     */
    public Pokemon(String name,Types type1, Types type2, int hp, int att, int speAtt, int def, int speDef, int spe, String move1, String move2, String move3, String move4){
        this.name = name;
        types = new Types[] {type1, type2};
        stats = new int[] {att, speAtt, def, speDef, spe};
        this.hp = new int[] {hp,hp};
        status = StatusEffect.NEUTRAL;
        moveList = new String[] {move1, move2, move3, move4};
        currentMoveType = Types.NONE;
        modifier = 1.0;
    }
    
    /**
     * Gets the name.
     * @return the name of the pokemon.
     */
    public String getName(){return name;}
    
    /**
     * Gets the types of the pokemon.
     * @return an array of the types of the pokemon.
     */
    public Types[] getTypes(){return types;}
    
    /**
     * Gets the stats of the pokemon. If the stat is speed and the pokemon is paralyzed, return half the speed.
     * @param index the index to put into the array for the stats.
     * @return the selected stat.
     */
    public int getStats(int index){
        if(index < stats.length && index >=0){
            if(index == stats.length-1 && status == StatusEffect.PARALYSIS){
                return (int)(stats[stats.length-1]*0.5);
            }
            else{
                return stats[index];
            }    
        }
        else{return 0;}
    }
    
    /**
     * Gets the current hp of the pokemon. If the hp is less then or equal to 0, make it 0.
     * @return the current hp of the pokemon
     */
    public int[] getHP(){if(hp[0] <= 0){
        hp[0] = 0;}
        return this.hp;
    } 
    
    /**
     * Gets the status of the pokemon.
     * @return the status of the pokemon.
     */
    public StatusEffect getStatus(){return status;}
    
    /**
     * Gets the list of moves of the pokemon.
     * @return the list of moves.
     */
    public String[] getMoveList(){return moveList;}
    
    /**
     * Gets the current move type of the pokemon.
     * @return the current move type.
     */
    public Types getCurrentMoveType(){return currentMoveType;}
    
    /**
     * Returns the modifier for attacks of the pokemon.
     * @return the modifier
     */
    public double getModifier(){return modifier;}
    
    /**
     * Check how effective a move is, based on the Pokemon Games, given the current move type and the enemy Pokemon
     * @param opp the enemy Pokemon
     * @return the effectiveness of the move
     */
    public double effectivenessChecker(Pokemon opp){
        Types[] opponentTypes = opp.getTypes();
        double[] effectiveness = {1.0,1.0};
        for(int i = 0; i < opponentTypes.length; i++)   
            switch(currentMoveType){
                    case NORMAL:
                    if(opponentTypes[i] == Types.ROCK || opponentTypes[i] == Types.STEEL){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.GHOST){effectiveness[i] = 0;}
                    break;
                    case FIRE:
                    if(opponentTypes[i] == Types.FIRE || opponentTypes[i] == Types.WATER || opponentTypes[i] == Types.ROCK || opponentTypes[i] == Types.DRAGON){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.GRASS || opponentTypes[i] == Types.ICE || opponentTypes[i] == Types.BUG || opponentTypes[i] == Types.STEEL){effectiveness[i] = 2;}
                    break;
                    case WATER:
                    if(opponentTypes[i] == Types.WATER || opponentTypes[i] == Types.GRASS || opponentTypes[i] == Types.DRAGON){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.FIRE || opponentTypes[i] == Types.GROUND || opponentTypes[i] == Types.ROCK){effectiveness[i] = 2;}                
                    break;
                    case GRASS:
                    if(opponentTypes[i] == Types.FIRE || opponentTypes[i] == Types.GRASS || opponentTypes[i] == Types.POISON || opponentTypes[i] == Types.FLYING || opponentTypes[i] == Types.BUG || opponentTypes[i] == Types.DRAGON || opponentTypes[i] == Types.STEEL){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.WATER || opponentTypes[i] == Types.GROUND || opponentTypes[i] == Types.ROCK){effectiveness[i] = 2;}                    
                    break;
                    case FIGHTING:
                    if(opponentTypes[i] == Types.POISON || opponentTypes[i] == Types.FLYING || opponentTypes[i] == Types.PSYCHIC || opponentTypes[i] == Types.BUG){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.NORMAL || opponentTypes[i] == Types.ICE || opponentTypes[i] == Types.ROCK || opponentTypes[i] == Types.DARK || opponentTypes[i] == Types.STEEL){effectiveness[i] = 2;}                           
                    if(opponentTypes[i] == Types.GHOST){effectiveness[i] = 0;}
                    break;
                    case BUG:
                    if(opponentTypes[i] == Types.FIRE || opponentTypes[i] == Types.FIGHTING || opponentTypes[i] == Types.POISON || opponentTypes[i] == Types.GHOST || opponentTypes[i] == Types.STEEL){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.GRASS || opponentTypes[i] == Types.PSYCHIC || opponentTypes[i] == Types.DARK){effectiveness[i] = 2;}                        
                    break;
                    case POISON:
                    if(opponentTypes[i] == Types.POISON || opponentTypes[i] == Types.GROUND || opponentTypes[i] == Types.ROCK || opponentTypes[i] == Types.GHOST){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.GRASS){effectiveness[i] = 2;}      
                    if(opponentTypes[i] == Types.STEEL){effectiveness[i] = 0;}
                    break;
                    case GROUND: 
                    if(opponentTypes[i] == Types.GRASS || opponentTypes[i] == Types.BUG){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.FIRE || opponentTypes[i] == Types.ELECTRIC || opponentTypes[i] == Types.POISON || opponentTypes[i] == Types.ROCK || opponentTypes[i] == Types.STEEL){effectiveness[i] = 2;}      
                    if(opponentTypes[i] == Types.FLYING){effectiveness[i] = 0;}                    
                    break;
                    case ROCK:
                    if(opponentTypes[i] == Types.FIGHTING || opponentTypes[i] == Types.GROUND || opponentTypes[i] == Types.STEEL){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.FIRE || opponentTypes[i] == Types.ICE || opponentTypes[i] == Types.BUG || opponentTypes[i] == Types.FLYING){effectiveness[i] = 2;}
                    break;
                    case STEEL:
                    if(opponentTypes[i] == Types.FIRE || opponentTypes[i] == Types.WATER || opponentTypes[i] == Types.ELECTRIC || opponentTypes[i] == Types.STEEL){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.ICE || opponentTypes[i] == Types.ROCK){effectiveness[i] = 2;}
                    break;
                    case GHOST:   
                    if(opponentTypes[i] == Types.DARK){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.PSYCHIC || opponentTypes[i] == Types.GHOST){effectiveness[i] = 2;}      
                    if(opponentTypes[i] == Types.NORMAL){effectiveness[i] = 0;}   
                    break;
                    case ICE:
                    if(opponentTypes[i] == Types.FIRE || opponentTypes[i] == Types.WATER || opponentTypes[i] == Types.STEEL || opponentTypes[i] == Types.ICE){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.GRASS || opponentTypes[i] == Types.GROUND || opponentTypes[i] == Types.FLYING || opponentTypes[i] == Types.DRAGON){effectiveness[i] = 2;}                    
                    break;
                    case DRAGON:   
                    if(opponentTypes[i] == Types.STEEL){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.DRAGON){effectiveness[i] = 2;}      
                    break;
                    case DARK:
                    if(opponentTypes[i] == Types.FIGHTING || opponentTypes[i] == Types.DARK){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.PSYCHIC || opponentTypes[i] == Types.GHOST){effectiveness[i] = 2;}                    
                    break;
                    case PSYCHIC:
                    if(opponentTypes[i] == Types.PSYCHIC || opponentTypes[i] == Types.STEEL){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.FIGHTING || opponentTypes[i] == Types.POISON){effectiveness[i] = 2;}      
                    if(opponentTypes[i] == Types.DARK){effectiveness[i] = 0;}                      
                    break;
                    case FLYING:    
                    if(opponentTypes[i] == Types.ELECTRIC || opponentTypes[i] == Types.ROCK || opponentTypes[i] == Types.STEEL ){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.GRASS || opponentTypes[i] == Types.FIGHTING || opponentTypes[i] == Types.BUG){effectiveness[i] = 2;}                        
                    break;
                    case ELECTRIC:
                    if(opponentTypes[i] == Types.ELECTRIC || opponentTypes[i] == Types.GRASS || opponentTypes[i] == Types.DRAGON){effectiveness[i] = 0.5;}
                    if(opponentTypes[i] == Types.WATER || opponentTypes[i] == Types.FLYING){effectiveness[i] = 2;}      
                    if(opponentTypes[i] == Types.GROUND){effectiveness[i] = 0;}                        
                    break;
                }
        return effectiveness[0] * effectiveness[1];
    }
    
    /**
     * Raises the attack stat of the pokemon
     */
    public void raiseAtt(){stats[0] *= 1.1;}
    
    /**
     * Raises the special attack stat of the pokemon
     */
    public void raiseSpeAtt(){stats[1] *= 1.15;}
    /**
     * Raises the defense stat of the pokemon
     */    
    public void raiseDef(){stats[2] *= 1.1;}
    /**
     * Raises the special defense stat of the pokemon
     */    
    public void raiseSpeDef(){stats[3] *= 1.15;}
    /**
     * Raises the speed stat of the pokemon
     */    
    public void raiseSpeed(){stats[4] *= 1.25;}
    
     /**
     * Lowers the attack stat of the pokemon
     */
    public void lowerAtt(){stats[0] *= 0.9;}
     /**
     * Lowers the special attack stat of the pokemon
     */    
    public void lowerSpeAtt(){stats[1] *= 0.85;}
     /**
     * Lowers the defense stat of the pokemon
     */    
    public void lowerDef(){stats[2] *= 0.9;}
     /**
     * Lowers the special defense stat of the pokemon
     */    
    public void lowerSpeDef(){stats[3] *= 0.85;}
     /**
     * Lowers the speed stat of the pokemon
     */    
    public void lowerSpeed(){stats[4] *= 0.75;}
    
    /**
     * Removes the given hp from the current hp of the pokemon.
     * @param removedHP the amount of health that is being removed.
     */
    public void removeHP(int removedHP){
        this.hp[0] -= removedHP;
    }
    
    /**
     * Sets the status of the pokemon.
     * @param status the new status of the pokemon.
     */
    public void setStatus(StatusEffect status){
        this.status = status;
    }    
    
    /**
     * Sets the current move type of the pokemon.
     * @param moveType the new move type of the pokemon.
     */
    public void setCurrentMoveType(Types moveType){
        this.currentMoveType = moveType;
    }
    
    /**
     * Calculates and sets the new modifier to be used for calculating damage.
     * STAB - Same Type Attack Bonus, is 1.5 if pokemon and move type are the same.
     * @param crit 1 if it is not a crit, and 1.5 if it is.
     * @param effectiveness the effectiveness of the move on the enemy.
     */
    public void setModifier(double crit, double effectiveness){
        double STAB = 1;
        if(this.currentMoveType == types[0] || this.currentMoveType == types[1]){STAB = 1.5;}
        this.modifier = crit * effectiveness * STAB;
    }    
    
    /**
     * Takes physical damage from the opponent.
     * @param dmg the strength of the move taken - positive.
     * @param opp the enemy pokemon.
     */
    public void takePhysicalDMG(int dmg, Pokemon opp){
        double oppIsBurned = 1;
        if(opp.getStatus() == StatusEffect.BURN){oppIsBurned = 0.5;}
        double oppMod = opp.getModifier();
        double oppAtt = opp.getStats(0);
        hp[0] -= ((42 * dmg * ((oppAtt*1.0)/(stats[2]*1.0)))/50) * oppMod * oppIsBurned;
    }
    
    /**
     * Takes special damage from the opponent.
     * @param dmg the strength of the move taken - negative.
     * @param opp the enemy pokemon.
     */    
    public void takeSpecialDMG(int dmg, Pokemon opp){
        double oppMod = opp.getModifier();
        double oppSpeAtt = opp.getStats(1);
        hp[0] -= ((42 * Math.abs(dmg) * ((oppSpeAtt*1.0)/(stats[3]*1.0)))/50) * oppMod;
    }    
    
    /**
     * Changes the given JLabel for the health of the Pokemon based on its current HP. Sets the color to green if healthy, yellow if hurt, and red if peril.
     * @param info the JLabel of the Pokemon's health
     */
    public void reDrawHealth(JLabel info){
    
        JLabel pokemonInfo = info;        
        if(hp[0] <= 0){hp[0] = 0;}
        int currentHP = hp[0];
        int totalHP = hp[1];
        double hpPercentage = (currentHP*1.0)/(totalHP*1.0);
        if(hpPercentage > .50){pokemonInfo.setForeground(Color.GREEN);}
        else if(hpPercentage > .25){pokemonInfo.setForeground(Color.YELLOW);}
        else{pokemonInfo.setForeground(Color.RED);}
        pokemonInfo.setText(currentHP + "/" + totalHP);
        
    }
    
    /**
     * The first move of the pokemon.
     * @param opp the enemy pokemon
     * @return the strength of the move - 0 if status move, - if special move, + if physical move
     */
    public abstract int move1(Pokemon opp);
    /**
     * The second move of the pokemon.
     * @param opp the enemy pokemon
     * @return the strength of the move - 0 if status move, - if special move, + if physical move
     */
    public abstract int move2(Pokemon opp);
    /**
     * The third move of the pokemon.
     * @param opp the enemy pokemon
     * @return the strength of the move - 0 if status move, - if special move, + if physical move
     */    
    public abstract int move3(Pokemon opp);
    /**
     * The fourth move of the pokemon.
     * @param opp the enemy pokemon
     * @return the strength of the move - 0 if status move, - if special move, + if physical move
     */    
    public abstract int move4(Pokemon opp);    

}
