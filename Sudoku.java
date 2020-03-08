import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {
    static int visit[][] = new int[100][100];
    static int counter = 81;

    public static void main(String args[]) {
        ArrayList<String> sample = new ArrayList<>(Arrays.asList("53..7....",
        "6..195...",
        ".98....6.",
        "8...6...3",
        "4..8.3..1",
        "7...2...6",
        ".6....28.",
        "...419..5",
        "....8..79"));

        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (char c : sample.get(i).toCharArray()) {
                if (c != '.') {
                    counter--;
                }
                row.add(c);
            }
            board.add(row);
        }
        solveSudoku(board);
        print(board);
    }

    public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                visit[i][j] = 0;
        dfs(0, 0, a);
    }

    public static void print(ArrayList<ArrayList<Character>> a) {
        a.forEach(x -> {
            x.forEach(y -> System.out.print(y));
            System.out.println();
        });
    }

    public static void dfs(int row, int col, ArrayList<ArrayList<Character>> a) {
        if (col >= 9) return;
        if (counter == 0) {
            return;
        }

        for (int i = row; i < a.size(); i++) {
            for (int j = col; j < a.size(); j++) {
                if (visit[i][j] == 0 && a.get(i).get(j) == '.') {
                    boolean flag = false;
                    for (int k = 1; k <= 9; k++) {
                        if (isRowColOk(i, j, k, a) && isBlockOk(i, j, k, a)) {
                            visit[i][j] = 1;
                            counter--;
                            a.get(i).set(j, (char)(k+48));
                            a.set(i, a.get(i));
                            //print(a);
                            dfs(row, col + 1, a);
                            a.get(i).set(j, '.');
                            counter++;
                            visit[i][j] = 0;
                        }
                    }
                    if (flag == false) return;
                }
            }
        }
    }

    public static boolean isRowColOk(int row, int col, int value, ArrayList<ArrayList<Character>> a) {
        for (int i = row; i >= 0; i--) {
            if (a.get(i).get(col) - 48 == value) {
                return false;
            }
        }
        for (int i = col; i >= 0; i--) {
            if (a.get(row).get(i) - 48 == value) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlockOk(int row, int col, int value, ArrayList<ArrayList<Character>> a) {
        int blockNumber = 0;
        int bRow = row / 3;
        int bCol = col / 3;
        int [] block = new int[]{0, 0, 0, 3, 0, 6, 3, 0, 3, 3, 3, 6, 6, 0, 6, 3, 6, 6};
        int numbers[] = new int[10];

        int startRow = bRow * 3;
        int startCol = bCol * 3;

        for (int i = startRow; i <= (startRow) + 2; i++) {
            for (int j = startCol; j <= (startCol) + 2; j++) {
                if (a.get(i).get(j) != '.')
                    numbers[a.get(i).get(j)-48]++;
            }
        }
        for (int i = 0; i < 10; i++) if (numbers[i] > 1) return false;
        return true;
    }
}
