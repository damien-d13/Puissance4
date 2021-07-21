import java.util.Arrays;
import java.util.Scanner;

public class Puissance4 {
    public static void main(String[] args) {
        String[][] table4 = {{"|", "1", "2", "3", "4", "5", "6", "7", "|"},{"|", ".", ".", ".", ".", ".", ".", ".", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"},};
        int tokenPlay = 0;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < table4.length; i++){
            System.out.println(String.join(" ", table4[i]));
        }

        while(tokenPlay <= 42) {
            System.out.println("Joueur 1, veuilez renseigner la colonne de votre jeton :");
            int columnPlay = sc.nextInt();
            boolean temp = false;
            tokenPlay++;

            for (int j = 6; j >= 0; j--){
//                System.out.println(temp);
//                || table4[j][columnPlay].equals("X") || table4[j][columnPlay].equals("O")
                if(temp == true ){
                    break;
                }

                for (int k = 0; k <= table4[j].length; k++){
                    if(table4[j][columnPlay].equals(".")){
                        table4[j][columnPlay] = "X";
                        temp = true;
                        break;
                    }

                }

            }
            for (int i = 0; i < table4.length; i++){
                System.out.println(String.join(" ", table4[i]));
            }

            System.out.println("Joueur 2, veuilez renseigner la colonne de votre jeton :");
            int columnPlay2 = sc.nextInt();
            boolean temps = false;
            tokenPlay++;

            for (int j = 6; j >= 0; j--){
//                System.out.println(temp);
//                || table4[j][columnPlay].equals("X") || table4[j][columnPlay].equals("O")
                if(temps == true ){
                    break;
                }

                for (int k = 0; k <= table4[j].length; k++){
                    if(table4[j][columnPlay].equals(".")){
                        table4[j][columnPlay] = "O";
                        temps = true;
                        break;
                    }

                }

            }
            for (int i = 0; i < table4.length; i++){
                System.out.println(String.join(" ", table4[i]));
            }
        }

    }
}
