



public class Table {

    private char table [][];
    private char currentPlayer='X';

    public  Table(){
        int num =1;
        this.table = new char[3][3];
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                this.table[i][j]=' ';
            }
        }
        
      
    }

    public void printTable(){
        int num =1;
        System.out.println("+++++++++++++");
        System.out.println("+---+---+---+");
        for(int i =0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++){
                System.out.print(" "+this.table[i][j]+" |");
            }
            System.out.println();
            System.out.println("+---+---+---+");
        }
    }

    public void setAction2Board(char symbol,int row,int column){
        this.table[row][column]=symbol;
        this.printTable();
        changePlayer();
    }

    public void changePlayer (){
        if(this.currentPlayer == 'X'){
            this.currentPlayer = 'O';
        }else{
            this.currentPlayer = 'X';
        }

    }

    public char getCurrentPlayer(){
        return this.currentPlayer;
    }
    public boolean validAction(char symbol,int row,int column){
         boolean winner;
        if(this.table[row][column]==' '){
            setAction2Board(symbol,row,column);
            changePlayer();
            return true;
        }
        return false;
    }

    public boolean isWinner(char symbol){

            for(int i = 0 ; i<3;i++){
                if(table[i][0]==symbol && table[i][1]==symbol&& table[i][2]==symbol){
                    return true;
                }
                if(table[0][i]==symbol && table[1][i]==symbol&& table[2][i]==symbol){
                    return true;
                }
            }
            if(table[0][0]==symbol && table[1][1]==symbol&& table[2][2]==symbol){
                return true;
            }

            if(table[0][2]==symbol && table[1][1]==symbol&& table[2][0]==symbol){
                return true;
            }

        
    return false;
    }



}
