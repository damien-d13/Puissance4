import java.util.Scanner;

public class Puissance4Test {

    public static boolean win = false;

    public static void main(String[] args) {
        String[][] table4 = {{"|", "1", "2", "3", "4", "5", "6", "7", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"}, {"|", ".", ".", ".", ".", ".", ".", ".", "|"}};
        printTable(table4);
        int tokenPlay = 0;
        String joueur1 ;
        String joueur2 ;





        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du joueur 1 :");
        joueur1 = sc.nextLine();
        System.out.println("Entrer le nom du joueur 2 :");
        joueur2 = sc.nextLine();

        while (tokenPlay <= 42 ) {

            choiceColumn(joueur1, table4, 1);
            printTable(table4);
            if(win){
                break;
            }
            choiceColumn(joueur2, table4, 2);
            printTable(table4);
            if(win){
                break;
            }

            tokenPlay++;
        }
        System.out.println("Vous avez gagné !");

    }

    private static void printTable(String[][] table4) {
        for (String[] strings : table4) {
            System.out.println(String.join(" ", strings));
        }
    }


    private static void choiceColumn(String joueur, String[][] table4, int numJoueur) {
        System.out.println(joueur + ", veuilez renseigner la colonne de votre jeton :");
        Scanner sc = new Scanner(System.in);
        int columnPlay = sc.nextInt();
        boolean temp = false;
        int[] positionToken = {0,0};
        String playerPiece;
        if (numJoueur == 1){
            playerPiece = "X";
        } else {
            playerPiece = "O";
        }

        if (columnPlay > 0 && columnPlay < 8) {
            for (int j = 6; j >= 0; j--) {
//                System.out.println(temp);
//                || table4[j][columnPlay].equals("X") || table4[j][columnPlay].equals("O")
                if (temp) {
                    break;
                } else if (table4[j][columnPlay].equals("1") || table4[j][columnPlay].equals("2") || table4[j][columnPlay].equals("3") || table4[j][columnPlay].equals("4") || table4[j][columnPlay].equals("5") || table4[j][columnPlay].equals("6") || table4[j][columnPlay].equals("7")) {
                    System.out.println("Vous ne pouvez plus jouer cette colonne.");
                    choiceColumn(joueur, table4, numJoueur);
                    break;
                }

                for (int k = 0; k <= table4[j].length; k++) {
                    if (table4[j][columnPlay].equals(".")) {
                        if (numJoueur == 1) {
                            table4[j][columnPlay] = "X";
                            temp = true;
                            positionToken[0] = j;
                            positionToken[1] = columnPlay;
                            checkWin(positionToken[0], positionToken[1], table4, playerPiece);
//                            System.out.println(positionToken[1]);
                            break;
                        } else if (numJoueur == 2) {
                            table4[j][columnPlay] = "O";
                            temp = true;
                            positionToken[0] = k;
                            positionToken[1] = j;
                            break;
                        }
                    }

                }
            }
        }else {
            System.out.println(" Le numéro reanseigner doit etre compris entre 1 et 7. Merci");
            choiceColumn(joueur, table4, numJoueur);
        }


    }

    private static void checkWin(int row, int col,String[][] table4,String playerPiece) {
        checkRow(row, table4, playerPiece);
        checkCol(col, table4, playerPiece);
//        System.out.println("row" + row);
//        System.out.println("col" + col);
    }

    private static void checkCol(int col, String[][] table4, String playerPiece) {

        for (int r = 0; r < 3; r++){
            int tokenGood = 0;
            for (int s = r; s < r + 5; s++){
//                System.out.println(s);
                System.out.println("colonne" + col + "row" + s);
                if(table4[s][col].equals(playerPiece)){
                    tokenGood++;
                    System.out.println(tokenGood);
                }
            }
            if (tokenGood == 4){
                win = true;
                break;

            }
        }
    }

    private static void checkRow(int col, String[][] table4, String playerPiece) {



        for (int q = 0; q < 3; q++){
            int tokenGood = 0;
            for (int o = q; o < q + 4; o++){
                if(table4[col][o].equals(playerPiece)){
                    tokenGood++;
//                    System.out.println(tokenGood);
                }
            }
            if (tokenGood == 4){
                win = true;
                break;

            }
        }
    }



}
