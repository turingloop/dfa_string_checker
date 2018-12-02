package simdfa;

/**
 *
 * @author and copyright: Gotham Reddy
 */
public class stateObj {
    private int currentState;
    private int startingState;
    private int finalState;
    public void setStartingState(int i){
        startingState = i;
    }
    public int getStartingState(){
        return startingState;
    }
    public void setFinalState(int i){
        finalState = i;
    }
    public int getFinalState(){
        return finalState;
    }
    public void setCurrentState(int i){
        currentState = i;
    }
    public int getCurrentState(){
        return currentState;
    }
    public boolean isFinalState(){
        if(currentState == finalState){
            return true;
        } else{
            return false;
        }
    }
}
