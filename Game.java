import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
    
/** 
* Runs the Pokemon battle.
*
* @author Kush Khanna
* @version 1.0
*/
public class Game
    {
    
        Thread t;
        
        // Decide the dimension of the window
        private static final int FRAME_WIDTH = 838;
        private static final int FRAME_HEIGHT = 465;
        private static final double EPSILON = 1E-14;
        
        private static final String POKEMON = "Charizard, Venasaur, Blastoise, Garchomp,\n Raichu, Heracross, Metagross, Gengar, Tyranitar, Arceus";
        
        public static void checkStatus(Pokemon checked){
            switch(checked.getStatus()){
                case POISONED:
                System.out.println(checked.getName() + " is poisoned!");
                break;
                case CONFUSED:
                System.out.println(checked.getName() + " is confused!");
                break;
                case SLEEP:
                System.out.println(checked.getName() + " is asleep!");
                break;
                case PARALYSIS:
                System.out.println(checked.getName() + " is paralyzed!");
                break;
                case FROZEN:
                System.out.println(checked.getName() + " is frozen!");
                break;
                case BURN:
                System.out.println(checked.getName() + " is burned!");
                break;
            }
        }
        
        public static void applyStatus(Pokemon checked){
            switch(checked.getStatus()){
                case POISONED:
                System.out.println(checked.getName() + " is badly poisoned!");
                checked.removeHP(30);
                break;
                case CONFUSED:
                System.out.println(checked.getName() + " hit himself!");
                checked.removeHP((int)(checked.getStats(0) * 0.25));
                break;
                case SLEEP:
                System.out.println(checked.getName() + " slept through is turn!");
                break;
                case PARALYSIS:
                System.out.println(checked.getName() + " cannot move!");
                break;
                case FROZEN:
                System.out.println(checked.getName() + " is frozen solid!");
                break;
                case BURN:
                System.out.println(checked.getName() + " is burning!");
                checked.removeHP(15);
                break;
            }
        }
        
        public static void main(String[] args) throws Exception{
            
                Scanner in = new Scanner(System.in);
                JFrame frame = new JFrame();    
                frame.setLayout(null);
                
                int setTrainer = RNG.pickTrainer();
                java.io.File trainerInformation = new java.io.File("Trainer"+setTrainer+".txt");              
                Scanner fileIn = new Scanner(trainerInformation);
                String opponentName = "";
                String opponentDefeatLine = "";
                while(fileIn.hasNext()){
                    opponentName = fileIn.nextLine();
                    opponentDefeatLine = fileIn.nextLine();
                }
                
                String[] chosenPokemon = new String[2]; //Your Pokemon name, then Computer Pokemon name
                Pokemon[] pokemon = new Pokemon[2];  //Your Pokemon, then Computer Pokemon
                  
                System.out.print("Choose your Pokemon (List of Pokemon - " + POKEMON + "): ");
                chosenPokemon[0] = in.next().trim().toLowerCase();
                System.out.print("Choose your opponent's Pokemon (Do not select the same pokemon!)\n(List of Pokemon - " + POKEMON + "): ");
                chosenPokemon[1] = in.next().trim().toLowerCase(); 
              
                if(chosenPokemon[0].equals(chosenPokemon[1])){
                    System.out.println("\nDo not pick the same pokemon!");
                    System.exit(1);
                }
                
                for(int i = 0; i < chosenPokemon.length; i++){
                    switch(chosenPokemon[i]){
                        case "charizard":
                        pokemon[i] = new Charizard();
                        break;
                        case "venasaur":
                        pokemon[i] = new Venasaur();
                        break;      
                        case "blastoise":
                        pokemon[i] = new Blastoise();
                        break;
                        case "garchomp":
                        pokemon[i] = new Garchomp();
                        break;
                        case "raichu":
                        pokemon[i] = new Raichu();
                        break;       
                        case "heracross":
                        pokemon[i] = new Heracross();
                        break;
                        case "metagross":
                        pokemon[i] = new Metagross();
                        break;
                        case "gengar":
                        pokemon[i] = new Gengar();
                        break;
                        case "tyranitar":
                        pokemon[i] = new Tyranitar();
                        break;
                        case "arceus":
                        pokemon[i] = new Arceus();
                        break;
                        
                    }
                }           
    
                if(pokemon[0] == null || pokemon[1] == null){
                    System.out.println("\nPlease select valid Pokemon!");
                    System.exit(1);
                }
                
                System.out.println("\nYou are challenged by " + opponentName + "!\n" + opponentName + " sends out " + pokemon[1].getName() + "!\nGo " + pokemon[0].getName() + "!");
                
                JPanel panel = new PokemonBackground(chosenPokemon[0],chosenPokemon[1]);            
                JPanel panel2 = new JPanel();
                panel.setBounds(0,0,838,381);
                panel2.setBounds(0,382,838,218);
              
                JButton move1 = new JButton(pokemon[0].getMoveList()[0]);
                JButton move2 = new JButton(pokemon[0].getMoveList()[1]);
                JButton move3 = new JButton(pokemon[0].getMoveList()[2]);
                JButton move4 = new JButton(pokemon[0].getMoveList()[3]);
              
                panel2.add(move1);
                panel2.add(move2);
                panel2.add(move3);
                panel2.add(move4);
              
                JLabel userPokemonName = new JLabel(pokemon[0].getName());
                userPokemonName.setBounds(507,213,300,150);
                userPokemonName.setForeground(Color.WHITE);
                userPokemonName.setFont(new Font("Serif", Font.BOLD,30));
              
                JLabel oppPokemonName = new JLabel(pokemon[1].getName());
                oppPokemonName.setBounds(15,13,300,150);
                oppPokemonName.setForeground(Color.WHITE);
                oppPokemonName.setFont(new Font("Serif", Font.BOLD,30));
              
                JLabel userPokemonHP = new JLabel(pokemon[0].getHP()[0] +  "/" + pokemon[0].getHP()[1]);
                userPokemonHP.setBounds(748,218,300,150);
                userPokemonHP.setForeground(Color.GREEN);
                userPokemonHP.setFont(new Font("Serif", Font.BOLD,20));
              
                JLabel oppPokemonHP = new JLabel(pokemon[1].getHP()[0] +  "/" + pokemon[1].getHP()[1]);
                oppPokemonHP.setBounds(266,20,300,150);
                oppPokemonHP.setForeground(Color.GREEN);
                oppPokemonHP.setFont(new Font("Serif", Font.BOLD,20));
                
                JLabel[] pokemonHP = new JLabel[]{userPokemonHP,oppPokemonHP};
              
                class ClickListener implements ActionListener { 
                    public void actionPerformed(ActionEvent event) { 
                      //soundPiece.play();
                      Object obj = event.getSource();          
                      if (obj == move1) {
                         UserMoveSelector.setSelectedMove(1);
                      }
                      else if (obj == move2) {
                         UserMoveSelector.setSelectedMove(2);
                      }
                      else if(obj == move3){
                         UserMoveSelector.setSelectedMove(3);
                      }
                      else if(obj == move4){
                         UserMoveSelector.setSelectedMove(4);
                      }
                      else{
                         UserMoveSelector.setSelectedMove(0);
                      }
                    }
                } 
              
                ActionListener listener = new ClickListener();  
                
                int[] order = new int[]{0,1,0};
                if(pokemon[1].getStats(4) > pokemon[0].getStats(4)){order = new int[]{1,0,1};}      
                                 
                String[] pokemonPossesion = new String[]{"\nYour ", "\nThe enemy's "};//0 for User, 1 for Opponent
                  
                double critAppliance = 0;
                double effectivenessAppliance = 0;   
                
                frame.add(userPokemonName);
                frame.add(oppPokemonName);
                frame.add(userPokemonHP);
                frame.add(oppPokemonHP);          
                frame.add(panel2); 
                  frame.add(panel); 
                  
                frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                
                while(pokemon[0].getHP()[0] > 0 && pokemon[1].getHP()[0] > 0){
                  System.out.println("\n------------------------------------------");   
                  System.out.println("\nWhat will " + pokemon[0].getName() + " do?\n");                        
                  
                  Thread.sleep(1000);
                  if(UserMoveSelector.getSelectedMove() != 0){
                      UserMoveSelector.setSelectedMove(0);
                  }
                  while(true){    
                      move1.addActionListener(listener);
                      move2.addActionListener(listener);
                      move3.addActionListener(listener);
                      move4.addActionListener(listener);          
                      if(UserMoveSelector.getSelectedMove() != 0){break;}
                    }
                      
                  int[]selectedMoves = new int[]{UserMoveSelector.getSelectedMove(), RNG.pickMove()}; //0 for User, 1 for Opponent  
                  int[]movesDMG = new int[]{0,0}; //0 for User, 1 for Opponent   
                  
                  for(int i = 0; i < order.length-1; i++){
                          if(pokemon[order[i]].getStatus() != Pokemon.StatusEffect.NEUTRAL){
                                   if(RNG.applyStatus()){
                                        applyStatus(pokemon[order[i]]);
                                        pokemon[order[i]].reDrawHealth(pokemonHP[order[i]]);
                                        }
                                   else{
                                        System.out.println(pokemon[order[i]].getName() + " is cured!");
                                        pokemon[order[i]].setStatus(Pokemon.StatusEffect.NEUTRAL);
                                        }
                          }
                          if(pokemon[0].getHP()[0] == 0 || pokemon[1].getHP()[0] == 0){break;}
                          
                          if(pokemon[order[i]].getStatus() == Pokemon.StatusEffect.SLEEP || pokemon[order[i]].getStatus() == Pokemon.StatusEffect.PARALYSIS || pokemon[order[i]].getStatus() == Pokemon.StatusEffect.FROZEN || pokemon[order[i]].getStatus() == Pokemon.StatusEffect.CONFUSED)
                          {selectedMoves[order[i]] = 0;}
                          
                          switch(selectedMoves[order[i]]){
                            case 1:
                            movesDMG[order[i]] = pokemon[order[i]].move1(pokemon[order[i+1]]);
                            System.out.println(pokemonPossesion[order[i]] + pokemon[order[i]].getName() + " used " + pokemon[order[i]].getMoveList()[0] + "!");
                            break;
                            case 2:
                            movesDMG[order[i]] = pokemon[order[i]].move2(pokemon[order[i+1]]);
                            System.out.println(pokemonPossesion[order[i]] + pokemon[order[i]].getName() + " used " + pokemon[order[i]].getMoveList()[1] + "!");                
                            break;
                            case 3:
                            movesDMG[order[i]] = pokemon[order[i]].move3(pokemon[order[i+1]]);
                            System.out.println(pokemonPossesion[order[i]] + pokemon[order[i]].getName() + " used " + pokemon[order[i]].getMoveList()[2] + "!");                
                            break;
                            case 4:
                            movesDMG[order[i]] = pokemon[order[i]].move4(pokemon[order[i+1]]);
                            System.out.println(pokemonPossesion[order[i]] + pokemon[order[i]].getName() + " used " + pokemon[order[i]].getMoveList()[3] + "!");                
                            break;                
                          }
                            
                          critAppliance = RNG.isCrit();
                          effectivenessAppliance = pokemon[order[i]].effectivenessChecker(pokemon[order[i+1]]);
                          pokemon[order[i]].setModifier(critAppliance, effectivenessAppliance);
                          
                          if(movesDMG[order[i]] > 0){pokemon[order[i+1]].takePhysicalDMG(movesDMG[order[i]],pokemon[order[i]]);}
                          else{pokemon[order[i+1]].takeSpecialDMG(movesDMG[order[i]],pokemon[order[i]]);}
                          
                          if(critAppliance > 1 && movesDMG[order[i]] != 0){System.out.println("It's a critical hit!");}
                          if(effectivenessAppliance > 1 && movesDMG[order[i]] != 0){System.out.println("It's super effective!");}
                          else if(effectivenessAppliance < 1 && effectivenessAppliance > 0 && movesDMG[order[i]] != 0){System.out.println("It's not very effective.");}
                          else if(Math.abs(effectivenessAppliance - 0) <= EPSILON && movesDMG[order[i]] != 0){System.out.println("It's not effective at all!");}
                          pokemon[order[i+1]].reDrawHealth(pokemonHP[order[i+1]]);
                          checkStatus(pokemon[order[i+1]]);
                          if(pokemon[0].getHP()[0] == 0 || pokemon[1].getHP()[0] == 0){break;}
                          }     
           }
           
           if(pokemon[0].getHP()[0] > pokemon[1].getHP()[0]){System.out.println("\nYou defeated " + opponentName + "!\n" + opponentName + ": " + opponentDefeatLine);}
           else{System.out.println("\nYour pokemon has fainted!\nYou blacked out and rushed over to the nearest Pokemon Center!");}
    }
    
}
