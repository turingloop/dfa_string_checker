
package simdfa;

import java.util.Scanner;

/**
 *
 * @author and copyright: Gotham Reddy
 */
public class SimDFA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of States in DFA: ");
        int numberOfStates = input.nextInt();
        System.out.print("Please enter the starting state for DFA, q: ");
        int startingState = input.nextInt();
        System.out.print("Please enter the final state for DFA, q: ");
        int finalState = input.nextInt();
        stateObj trackState = new stateObj();
        trackState.setCurrentState(startingState);
        trackState.setStartingState(startingState);
        trackState.setFinalState(finalState);
        int[] routeA = new int[numberOfStates];
        int[] routeB = new int[numberOfStates];
        int[] allStates = new int[numberOfStates];
        for(int i = 0; i < numberOfStates; i++){
            allStates[i] = i;
        }
        for(int i = 0; i < numberOfStates; i++){
            System.out.print("Enter the state that can be reached when reading \"a\" from q"+i+", q:");
            routeA[i] = input.nextInt();
            System.out.print("Enter the state that can be reached when reading \"b\" from q"+i+", q:");
            routeB[i] = input.nextInt();
        }
        System.out.print("Enter the string for testing: ");
        String testString = input.next();
        System.out.println("Initial State is: q"+startingState+" and the final state is: q"+finalState);
        System.out.println(testString);
        for(int i = 0; i < testString.length(); i++){
            if(testString.charAt(i) == 'a'){
                int forwardState = routeA[trackState.getCurrentState()];
                System.out.println("q"+trackState.getCurrentState()+", a -> q"+forwardState);
                trackState.setCurrentState(forwardState);
            }else if(testString.charAt(i) == 'b'){
                int forwardState  = routeB[trackState.getCurrentState()];
                System.out.println("q"+trackState.getCurrentState()+", b -> q"+forwardState);
                trackState.setCurrentState(forwardState);
            }else {
                  System.out.println("Unknown route found in the string input");
            }
        }
        if(trackState.isFinalState())
            System.out.println("Accepted");
        else
            System.out.println("Rejected");
    }
    
}
