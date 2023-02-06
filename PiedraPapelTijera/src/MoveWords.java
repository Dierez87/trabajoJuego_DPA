import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA", "LAGARTO", "SPOCK"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

    public static int checkWinner(String first, String second){
    	if (first.equals(second)) return EMPATE;
	    else if (first.equals("PIEDRA") && (second.equals("TIJERAS") || second.equals("LAGARTO"))) return GANA;
	    else if (first.equals("PAPEL") && (second.equals("PIEDRA") || second.equals("SPOCK"))) return GANA;
	    else if (first.equals("TIJERAS") && (second.equals("PAPEL") || second.equals("LAGARTO"))) return GANA;
	    else if (first.equals("SPOCK") && (second.equals("TIJERAS") || second.equals("PIEDRA"))) return GANA;
	    else if (first.equals("LAGARTO") && (second.equals("PAPEL") || second.equals("SPOCK"))) return GANA;
	    else return PIERDE;
	}
	
} 
