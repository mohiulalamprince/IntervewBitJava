import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSudoku {
    static ArrayList<ArrayList<Character>> result = new ArrayList<>();
    static boolean flag = false;
    public int isValidSudoku(final List<String> A) {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ArrayList<Character> sample = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                sample.add(A.get(i).charAt(j));
            }
            a.add(sample);
        }
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                if (!isBlockOk(i, j, a) || !isRowColOk(i, j, a)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String args[]) {
        ArrayList<String> sample = new ArrayList<>(Arrays.asList(
                "....5..1.",
                ".4.3.....",
                ".....3..1",
                "8......2.",
                "..2.7....",
                ".15......",
                ".....2...",
                ".2.9.....",
                "..4......"));

        /*ArrayList<String> sample = new ArrayList<>(Arrays.asList("53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"));*/

        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (char c : sample.get(i).toCharArray()) {
                row.add(c);
            }
            board.add(row);
        }
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                if (!isBlockOk(i, j, board)) {
                    System.out.println(i + " " + j + " " + "not a valid");
                }
                if (!isRowColOk(i, j, board)) {
                    System.out.println(i + " " + j + " " + "rowcol not a valid");
                }
            }
        }
    }

    public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
        //dfs(0, 0, a);

        if (result.size() > 0) {
            a.clear();
            for (int i = 0; i < 9; i++) {
                a.add(result.get(i));
            }
        }
        print(a);
    }

    public static void print(ArrayList<ArrayList<Character>> a) {
        a.forEach(x -> {
            System.out.println(x);
        });
    }
    public static void copy(ArrayList<ArrayList<Character>> a) {
        a.forEach(x -> {
            result.add(new ArrayList<>(x));
        });
    }

    /*public static void dfs(int row, int col, ArrayList<ArrayList<Character>> a) {
        if (flag == true) return;
        if (row > 8) {
            copy(a);
            flag = true;
            return;
        }

        int i = row;
        int j = col;
        if (a.get(i).get(j) == '.') {
            boolean flag = false;
            for (int k = 1; k <= 9; k++) {
                if (isRowColOk(i, j, k, a) && isBlockOk(i, j, k, a)) {
                    a.get(i).set(j, (char)(k+48));
                    a.set(i, a.get(i));

                    if (col + 1 > 8)
                        dfs(row + 1, 0, a);
                    else
                        dfs(row, col + 1, a);
                    a.get(i).set(j, '.');
                }
            }
            if (flag == false) return;
        } else {
            if (col + 1 > 8)
                dfs(row + 1, 0, a);
            else
                dfs(row, col + 1, a);
        }
    }*/

    public static boolean isRowColOk(int row, int col, ArrayList<ArrayList<Character>> a) {
        int numbers[] = new int[10];

        for (int i = 8; i >= 0; i--) {
            if (a.get(i).get(col) != '.' && ++numbers[a.get(i).get(col) - 48] > 1) return false;
        }

        for (int i = 0; i <= 9; i++) numbers[i] = 0;

        for (int i = 8; i >= 0; i--) {
            if (a.get(row).get(i) != '.' && ++numbers[a.get(row).get(i) - 48] > 1) return false;
        }
        return true;
    }

    public static boolean isBlockOk(int row, int col, ArrayList<ArrayList<Character>> a) {
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
