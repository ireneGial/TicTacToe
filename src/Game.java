import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Table table;
    private boolean playagain;
    private ArrayList<Table> tables;

    public Game(){
        this.player1 = initPlayer(1,'X');
        this.player2 = initPlayer(2,'O');
        this.playagain=true;
        tables = new ArrayList<>();
        while(this.playagain){
            play();
        }
    }

    private void play(){
        player1.displayPlayerInfo();
        player2.displayPlayerInfo();
        tables.add(new Table());
        turn(tables.get(tables.size()-1));
    }

    public Player initPlayer(int playernum,char symbol){
        
        Scanner scanner = new Scanner(System.in);
        String name="";
        int age=0;

        System.out.print("Welcome Player "+playernum+"! Please type your name: ");
      
        while(true){
            try {
                
                    name = scanner.nextLine();
                    if (!name.matches("[a-zA-Z]+") && name!="") { // Only letters allowed
                        name="";
                        throw new IllegalArgumentException("Invalid name! Use only letters.");
                    }
                    if(name==""){
                        throw new IllegalArgumentException("The name cannot be empty.");
                    }
                        break;

            } catch (Exception e) {
                
                System.out.print(e.getMessage()+" Please type again your name:");
            }
        }
            
        System.out.print("Now please type your age:");
        while (true) { 
                try {
                    String input = scanner.nextLine().trim();
                    if (input==""){
                        throw new IllegalArgumentException("Age cannot be empty.");
                    }
                    if (input.matches("-?\\d+")) {  
                        age = Integer.parseInt(input); 
                    if (age <= 0) {
                        throw new IllegalArgumentException("Age must be a positive number."); // Check if the age is positive
                    }
                    break;
                }else{
                    throw new IllegalArgumentException("Age must be an Integer.");
                }
             }catch (Exception e) {
                    System.out.print(e.getMessage()+" Please type again your age:");
                }
            }
                System.out.println("Ok! You will get the "+symbol+" symbol");
                return new Player(name,age,symbol);    
    }

    void turn(Table table){
        table.printTable();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String answer="";
        int row=-1;
        int column=-1;
        while (flag == true){
        
        System.out.print("Please type the value of the row (1 to 3): ");
        
        while (true){
            try {
                String input = scanner.nextLine().trim();
                if (input==""){
                    throw new IllegalArgumentException("Row cannot be empty.");
                }
                if (input.matches("-?\\d+")) {  
                    row = Integer.parseInt(input); 
                
                if (row < 1 || row >3 ) {
                    throw new IllegalArgumentException("Row must be between 1 and 3"); 
                }
            }
                break;
                

            } catch (Exception e) {
                System.out.print(e.getMessage()+" Please type again the value:");
            }

        }
        while (true){
            try {
                System.out.print("Please type the value of the column (1 to 3): ");
               
                String input = scanner.nextLine().trim();
                if (input==""){
                    throw new IllegalArgumentException("Column cannot be empty.");
                }
                if (input.matches("-?\\d+")) {  
                    column = Integer.parseInt(input); 
                
                if (column < 1 || column >3 ) {
                    throw new IllegalArgumentException("Column must be between 1 and 3"); 
                }
            }
                break;

            } catch (Exception e) {
                System.out.print(e.getMessage()+" Please type again the value:");
            }

        }
        if(table.validAction(table.getCurrentPlayer(),row-1,column-1)){
            System.out.println("egine move sto "+(row-1)+","+(column-1));
            flag=false;
            if(table.isWinner(table.getCurrentPlayer()))
            {
                if(table.getCurrentPlayer()=='X'){
                    System.out.println("Congratulations! "+player1.getName());
                    player1.setScore(player1.getScore()+1);
                }else{
                    System.out.println("Congratulations! "+player2.getName());
                    player2.setScore(player2.getScore()+1);
                } 
                System.out.println("Want to play again?(YES/NO)");
                answer = scanner.nextLine();
                if(answer.equals("no")||answer.equals("NO")){
                    compareScores();
                    this.playagain = false;
                    return;
                }
                break;
            }else
            table.changePlayer();
        }
    }
}
void compareScores(){
    if(player1.getScore()>player2.getScore()){
       System.out.println("Game is Finished! "+player1.getName()+" is the Winner!!");
       
    }else if(player1.getScore()<player2.getScore()){
    System.out.println("Game is Finished! "+player2.getName()+" is the Winner!!");
    }
    else 
    System.out.println("It's a tie!");
    player1.displayPlayerInfo();
    player2.displayPlayerInfo();
}

}
