import java.util.Random;
import java.util.Scanner;

public class Computer {

    static Scanner scanner = new Scanner(System.in);
    static char[][] board = {{' ', ' ', ' '},
                             {' ', ' ', ' '},
                             {' ', ' ', ' '}};


    public static void main(String[] args) {
        int num;
        while (true) {
            System.out.println("1. Play\t0. Exit");
            num = scanner.nextInt();
            switch (num) {
                case 1 -> {
                    while (true) {
                        play();
                    }
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Wrong input, try again😑");
            }
        }
    }

    private static void playerComputer() {
        Random ran = new Random();
        int computerPlay;
        while (true) {
            computerPlay = ran.nextInt(9) + 1;
             if (checkSpaceAvailable(board,computerPlay)) {
                 break;
             }
        }
        insertValue(board,'o',computerPlay);
    }

    private static void play() {
        if (isGameFinished(board)) {
          return;
         }
        playerTurn();
        playerComputer();
    }

    private static void playerTurn() {
        System.out.println("You X X moves (1-9)");
        findBoard();

        int input;
        while (true) {
             input = scanner.nextInt();
        if (checkSpaceAvailable(board,input)) {
            break;
        }else {
            System.out.println("Cell is not empty. Try again");
           }
        }
        insertValue(board, 'x', input);
        findBoard();
    }


    public static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board,'o')) {
            findBoard();
            System.out.println("Computer wins");
            cleanBoard();
            return true;
        }

        if (hasContestantWon(board,'x')) {
            findBoard();
            System.out.println("Player wins");
            cleanBoard();
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        findBoard();
        System.out.println("Ended in a draw");
        cleanBoard();
        return true;
    }
    public static void cleanBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static boolean hasContestantWon(char[][] board, char simbil) {
        if((board[0][0] == simbil && board[0][1] == simbil && board[0][2] ==simbil) ||
                (board[1][0] == simbil && board[1][1] == simbil && board[1][2] ==simbil) ||
                (board[2][0] == simbil && board[2][1] == simbil && board[2][2] ==simbil) ||

                (board[0][0] == simbil && board[1][0] == simbil && board[2][0] ==simbil) ||
                (board[0][1] == simbil && board[1][1] == simbil && board[2][1] ==simbil) ||
                (board[0][2] == simbil && board[1][2] == simbil && board[2][2] ==simbil) ||

                (board[0][0] == simbil && board[1][1] == simbil && board[2][2] ==simbil) ||
                (board[0][2] == simbil && board[1][1] == simbil && board[2][0] ==simbil)) {
            return true;
        }
        return false;
    }

    public static void insertValue(char[][] board, char sim, int input) {
        switch (input) {
            case 1 -> {
                    board[0][0] = sim;
            }
            case 2 -> {
                    board[0][1] = sim;
            }
            case 3 -> {
                    board[0][2] = sim;
            }
            case 4 -> {
                    board[1][0] = sim;
            }
            case 5 -> {
                    board[1][1] = sim;
            }
            case 6 -> {
                   board[1][2] = sim;
            }
            case 7 -> {
                   board[2][0] = sim;
            }
            case 8 -> {
                    board[2][1] = sim;
            }
            case 9 -> {
                    board[2][2] = sim;
            }
            default -> System.out.println("🙁");
        }
    }

    public static boolean checkSpaceAvailable(char[][] board , int position) {
        switch (position) {
            case 1 -> {
                return board[0][0] == ' ';}
            case 2 -> {
                return board[0][1] == ' ';}
            case 3 -> {
                return board[0][2] == ' ';}
            case 4 -> {
                return board[1][0] == ' ';}
            case 5 -> {
                return board[1][1] == ' ';}
            case 6 -> {
                return board[1][2] == ' ';}
            case 7 -> {
                return board[2][0] == ' ';}
            case 8 -> {
                return board[2][1] == ' ';}
            case 9 -> {
                return board[2][2] == ' ';}
            default -> {
                return false;
            }
        }
    }

    public static void findBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }
}

