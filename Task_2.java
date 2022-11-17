import java.util.Random;
import java.util.Scanner;
public class Main{
    public static char[][] a;
    public static final int b = 3; 
    public static final int c = 3;
    public static final char d = '.';
    public static final char X = 'X';
    public static final char O = 'O';
    public static void main(String[] args) {
	    inita();
		printa(); 
		while (true) {         
		    human();         
		    printa();         
		    if (check(X)) {             
		        System.out.println("Победил человек");             
		        break;}         
		        if (isMapFull()) {             
		            System.out.println("Ничья");             
		            break;         }         
		      ai();         
		      printa();         
		      if (check(O)) {             
		          System.out.println("Победил Искуственный Интеллект");             
		          break;         }         
		      if (isMapFull()) {             
		          System.out.println("Ничья");             
		          break;         }     }     
		      System.out.println("Игра закончена"); 
    }	        
	public static void inita() {     
        a = new char [b][b];     
        for (int i = 0; i < b; i++) {         
            for (int j = 0; j < b; j++) {             
                a[i][j] = d;}     
            } 
	    }
     
    public static void printa() {         
        for (int i = 0; i <= b; i++) {             
            System.out.print(i + " ");}         
            System.out.println();         
            for (int i = 0; i < b; i++) {             
                System.out.print((i + 1) + " ");             
                for (int j = 0; j < b; j++) {                 
                    System.out.print(a[i][j] + " ");}             
                    System.out.println();}         
                    System.out.println();} 
    public static Scanner scanner = new Scanner(System.in); 
    public static void human() {     
        int x, y;     
        do{         
            System.out.println("Введите координаты в формате X Y");         
            x = scanner.nextInt() - 1;         
            y = scanner.nextInt() - 1;     } 
        while (!isCellValid(x, y));     
        a[y][x] = X; }
    public static boolean isCellValid(int x, int y) {     
        if (x < 0 || x >= b || y < 0 || y >= b) return false;     
        if (a[y][x] == d) return true;     
        return false; }
    public static Random rand = new Random(); 
    public static void ai() {     
        int x, y;         
        do {             
            x = rand.nextInt(b);             
            y = rand.nextInt(b);} 
            while (!isCellValid(x, y));     
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));     
            a[y][x] = O; }
    public static boolean check(char symb) { 
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 1; j++){
                if (a[i][j] == symb && a[i][j+1] == symb && a[i][j+2] == symb) return true;
            }
       }
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 3; j++){
                if (a[i][j] == symb && a[i+1][j] == symb && a[i+2][j] == symb) return true;}
        }
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 1; j++){
                if (a[i][i] == symb && a[i+1][i+1] == symb && a[i+2][i+2] == symb) return true;
            }
        }
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 1; j++){
                if (a[i+2][i] == symb && a[i+1][i+1] == symb && a[i][i+2] == symb) return true;
            }
        }
        return false;
    }
        
    
    public static boolean isMapFull() {         
        for (int i = 0; i < b; i++) {             
            for (int j = 0; j < b; j++) {                 
                if (a[i][j] == d) return false;}         
            }         
            return true;     }
}
