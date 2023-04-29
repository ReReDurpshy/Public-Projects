import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            say("Tik Tak Toes!");
            waitForResponse();

            String[] moves = new String[10];
            moves[1] = " ";
            moves[2] = " ";
            moves[3] = " ";
            moves[4] = " ";
            moves[5] = " ";
            moves[6] = " ";
            moves[7] = " ";
            moves[8] = " ";
            moves[9] = " ";
            moves[0] = " ";

            String[] board = new String[10];
            board[1] = " [" + moves[1] + "] ";
            board[2] = " [" + moves[2] + "] ";
            board[3] = " [" + moves[3] + "] ";
            board[4] = " [" + moves[4] + "] ";
            board[5] = " [" + moves[5] + "] ";
            board[6] = " [" + moves[6] + "] ";
            board[7] = " [" + moves[7] + "] ";
            board[8] = " [" + moves[8] + "] ";
            board[9] = " [" + moves[9] + "] ";
            board[0] = moves[0];

            int spot = 0;
            boolean valid = false;
            boolean[] winsX = new boolean[9];
            boolean[] winsO = new boolean[9];
            boolean[] winsTie = new boolean[1];

            boolean ggX = false;
            boolean ggO = false;
            boolean Tie = false;

            while (!ggO || !ggX || !Tie) {

                setWinValues(moves, winsX, winsO, winsTie);

                for (int x = 0; x < 9; x++) {
                    if (winsX[x]) {
                        ggX = true;
                        break;
                    } else if (winsO[x]) {
                        ggO = true;
                        break;
                    } else if (winsTie[0]) {
                        Tie = true;
                        break;
                    }
                }
                if (ggX || ggO || Tie) {
                    break;
                }

                boardPrints(board, moves);

                xMove(scanner, moves, spot, valid);

                boardPrints(board, moves);

                setWinValues(moves, winsX, winsO, winsTie);

                for (int x = 0; x < 9; x++) {
                    if (winsX[x]) {
                        ggX = true;
                        break;
                    } else if (winsO[x]) {
                        ggO = true;
                        break;
                    } else if (winsTie[0]) {
                        Tie = true;
                        break;
                    }
                }
                if (ggX || ggO || Tie) {
                    break;
                }

                oMove(scanner, moves, spot, valid);
            }
            if (ggX) {
                say("GG's X Wins!");
            } else if (ggO) {
                say("GG's O Wins!");
            } else if (Tie) {
                say("The Game was a Tie!");
            }

            say("would you like to play again?");
            if (!scanner.next().toLowerCase().equals("yes")) {
                break;
            }
        }
        say("Thank you, com again!");


    }

    private static void setWinValues(String[] moves, boolean[] winsX, boolean[] winsO, boolean[] winsTie) {
        winsX[0] = (moves[1].equals(moves[2])) && (moves[2].equals(moves[3])) && (moves[1].equals("X"));
        winsX[1] = (moves[4].equals(moves[5])) && (moves[5].equals(moves[6])) && (moves[4].equals("X"));
        winsX[2] = (moves[7].equals(moves[8])) && (moves[8].equals(moves[9])) && (moves[7].equals("X"));
        winsX[3] = (moves[1].equals(moves[4])) && (moves[4].equals(moves[7])) && (moves[1].equals("X"));
        winsX[4] = (moves[2].equals(moves[5])) && (moves[5].equals(moves[8])) && (moves[2].equals("X"));
        winsX[5] = (moves[3].equals(moves[6])) && (moves[6].equals(moves[9])) && (moves[3].equals("X"));
        winsX[6] = (moves[1].equals(moves[5])) && (moves[5].equals(moves[9])) && (moves[1].equals("X"));
        winsX[7] = (moves[3].equals(moves[5])) && (moves[5].equals(moves[7])) && (moves[3].equals("X"));
        winsX[8] = (moves[1].equals(moves[2])) && (moves[2].equals(moves[3])) && (moves[1].equals("X"));

        winsO[0] = (moves[1].equals(moves[2])) && (moves[2].equals(moves[3])) && (moves[1].equals("O"));
        winsO[1] = (moves[4].equals(moves[5])) && (moves[5].equals(moves[6])) && (moves[4].equals("O"));
        winsO[2] = (moves[7].equals(moves[8])) && (moves[8].equals(moves[9])) && (moves[7].equals("O"));
        winsO[3] = (moves[1].equals(moves[4])) && (moves[4].equals(moves[7])) && (moves[1].equals("O"));
        winsO[4] = (moves[2].equals(moves[5])) && (moves[5].equals(moves[8])) && (moves[2].equals("O"));
        winsO[5] = (moves[3].equals(moves[6])) && (moves[6].equals(moves[9])) && (moves[3].equals("O"));
        winsO[6] = (moves[1].equals(moves[5])) && (moves[5].equals(moves[9])) && (moves[1].equals("O"));
        winsO[7] = (moves[3].equals(moves[5])) && (moves[5].equals(moves[7])) && (moves[3].equals("O"));
        winsO[8] = (moves[1].equals(moves[2])) && (moves[2].equals(moves[3])) && (moves[1].equals("O"));

        winsTie[0] = !(moves[1].equals(" ")) && !(moves[2].equals(" ")) && !(moves[3].equals(" "))
                && !(moves[8].equals(" ")) && !(moves[7].equals(" ")) && !(moves[4].equals(" "))
                && !(moves[9].equals(" ")) && !(moves[6].equals(" ")) && !(moves[5].equals(" "));
    }

    private static void xMove(Scanner scanner, String[] moves, int m, boolean v) {
        while (true) {
            say("Make your move 'X'");
            m = Integer.parseInt(scanner.next());
            v = (m < 10) && (m > 0);

            if (v && (moves[m].equals(" "))) {
                moves[m] = "X";

                    break;
            } else {
                say("This is not a valid spot");
            }
        }
    }
    private static void oMove(Scanner scanner, String[] moves, int a, boolean v) {
        while (true) {
            say("Make your move 'O'");
            a = Integer.parseInt(scanner.next());
            v = (a < 10) && (a > 0);


            if (v && (moves[a].equals(" "))) {
                moves[a] = "O";
                break;
            } else {
                say("This is not a valid spot");
            }
        }
    }

    private static void boardPrints(String[] board, String[] moves) {
        board[1] = " [" + moves[1] + "] ";
        board[2] = " [" + moves[2] + "] ";
        board[3] = " [" + moves[3] + "] ";
        board[4] = " [" + moves[4] + "] ";
        board[5] = " [" + moves[5] + "] ";
        board[6] = " [" + moves[6] + "] ";
        board[7] = " [" + moves[7] + "] ";
        board[8] = " [" + moves[8] + "] ";
        board[9] = " [" + moves[9] + "] ";
        board[0] = moves[0];
        System.out.println();
        for(int row1 = 1; row1 < 4; row1++) {
            System.out.print(board[row1]);
        }
        System.out.println();
        for(int row2 = 4; row2 < 7; row2++) {
            System.out.print(board[row2]);
        }
        System.out.println();
        for(int row3 = 7; row3 < 10; row3++) {
            System.out.print(board[row3]);
        }
        System.out.print(board[0]);

        System.out.println();


    }


    private static void waitForResponse() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static void say(String message) {
        System.out.println(message);
    }
}