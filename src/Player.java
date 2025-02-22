public class Player {
    private String name ;
    private int age;
    private int score;
    private char symbol;

    public Player(String name, int age, char symbol) {
        this.name = name;
        this.age = age;
        this.score = 0;
        this.symbol = symbol;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
    public char getSymbol() {
        return symbol;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }



    // Increase score by 1
    public void increaseScore() {
        this.score++;
    }

    // Display player details
    public void displayPlayerInfo() {
        System.out.println("Player: " + name +", Symbol: "+ symbol +", Age: " + age + ", Score: " + score);
    }
    
}
