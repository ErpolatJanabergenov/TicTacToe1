import java.util.Scanner;

public class Dost {

    static Scanner scanNum = new Scanner(System.in);
    static int player = 1;
    static int count = 1;
    static char[][] board = {{' ', ' ', ' '},
                             {' ', ' ', ' '},
                             {' ', ' ', ' '}};

    public static void main(String[] args) {

        int num;

        while (true) {
            System.out.println("1. Play\t0. Exit");
            num = scanNum.nextInt();

                switch (num) {
                    case 1 -> {

                        while (true) {
                            int result = play(board);
                            if (result == 0) {
                                play(board);
                            } else if (result == 'o') {
                                System.out.println("Player 2 (o) won");
                                findBoard(board);
                                cleanBoard();
                                break;
                            } else if (result == 'x') {
                                System.out.println("Player 1 (x) won");
                                findBoard(board);
                                cleanBoard();
                                break;
                            } else {
                                System.out.println("Draw");
                                findBoard(board);
                                cleanBoard();
                                break;
                            }
                        }
                    }
                    case 0 -> {return;}
                    default -> System.out.println("wrong input ,try again");
            }
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
    public static int checkResult() {
        if(board[0][0] != ' ' && board[0][0] == board[0][1] && board[0][0] == board[0][2]) {
            return board[0][0];
        }
        else if(board[1][0] != ' ' && board[1][0] == board[1][1] && board[1][0] == board[1][2]) {
            return board[1][0];
        }
        else if(board[2][0] != ' ' && board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
            return board[2][0];
        }
        else if(board[0][0] != ' ' && board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
            return board[0][0];
        }
        else if(board[0][1] != ' ' && board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
            return board[0][1];
        }
        else if(board[0][2] != ' ' && board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
            return board[0][2];
        }
        else if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return board[0][0];
        } else if (board[2][0] != ' ' && board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
            return board[2][0];
        }

        if(count < 9) {
            return 0;
        } else {
            return 2;
        }
    }
    public static void cleanBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        count = 1;
    }

    public static int play(char[][] board) {
        System.out.println("Player 1 -> X Player 2 -> O\n\n");
             char sim = ' ';
            if (player == 1) {
                System.out.println("Player 1 qaysi katakcha: ");
                sim = sim;
            }else if (player == -1) {
                System.out.println("Player 2 qaysi katakcha: ");
                sim = 'o';
            }
                findBoard(board);
        int input;
        while (true) {
            input = scanNum.nextInt();
            if (checkSpaceAvailable(board,input)) {
                break;
            }else {
                System.out.println("Cell is not empty. Try again");
            }
        }
        insertValue(board, sim, input);
         return checkResult();
    }

    public static void insertValue(char[][] board, char sim, int input) {
        switch (input) {
            case 1 -> {

                    board[0][0] = sim;
                    player *= -1;
                    count++;
            }
            case 2 -> {

                    board[0][1] = sim;
                    player *= -1;
                    count++;
            }
            case 3 -> {

                    board[0][2] = sim;
                    player *= -1;
                    count++;
            }
            case 4 -> {

                    board[1][0] = sim;
                    player *= -1;
                    count++;
            }
            case 5 -> {

                    board[1][1] = sim;
                    player *= -1;
                    count++;
            }
            case 6 -> {

                    board[1][2] = sim;
                    player *= -1;
                    count++;
            }
            case 7 -> {

                    board[2][0] = sim;
                    player *= -1;
                    count++;
            }
            case 8 -> {

                    board[2][1] = sim;
                    player *= -1;
                    count++;
            }
            case 9 -> {

                    board[2][2] = sim;
                    player *= -1;
                    count++;
            }
            default -> System.out.println("🙁");
        }
    }


    public static void findBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }
}