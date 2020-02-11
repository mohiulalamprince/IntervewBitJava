import java.util.Vector;

public class JustifiedText {
    public static void main(String args[]) {
        //String[] A = {"This", "is", "an", "example", "of", "text", "justification.", "recursions....", "this", "is"};
        String[] A = {"am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui", "tnzegzuzn", "kuiwdc", "fofjkkkm", "ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv", "uurcazjc", "earsrvrq", "qlq", "lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy"};
        String[] ret = fullJustify(A, 14);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }

    public static String[] fullJustify(String[] A, int B) {

        int length = 0;
        int size = 0;
        boolean left = false;
        for (int i = 0; i < A.length; i++) {
            left = true;
            length += A[i].length();
            if (length > B) {
                size ++;
                left = false;
                length = A[i].length();
            }
        }
        if (left == true) size++;

        if (length == 0) return new String[0];

        String[] ret = new String[size + 1];

        int counter = 0;
        Vector<String> dummy = new Vector<String>();
        dummy.add(A[0]);
        length = dummy.get(0).length();
        for (int i = 1; i < A.length; i++) {
            length += A[i].length() + 1;
            if (length > B) {
                String formated = format(dummy, B, false);
                ret[counter++] = formated;
                dummy.clear();
                length = A[i].length();
            }
            dummy.add(A[i]);
        }
        if (dummy.size() > 0) {
            String retStr = format(dummy, B, true);
            int remainSize = B - retStr.length();
            String padding = "";
            for (int i = 0; i < remainSize; i++) {
                padding += " ";
            }
            ret[counter++] = retStr + padding;
        }
        return ret;
    }

    public static String format(Vector<String> sb, int B, boolean last) {
        String s = "";
        int length = 0;
        for (int i = 0; i < sb.size(); i++) {
            length += sb.get(i).length();
        }
        int remainSize = B - length;

        int fillSpace = 0;
        boolean odd = false;
        if (remainSize % 2 == 0) {
            int gap = (sb.size() - 1) > 0 ? (sb.size()-1) : 1;
            fillSpace = remainSize / gap;
        } else {
            int gap = (sb.size()-1) > 0 ? (sb.size()-1) : 1;
            fillSpace = remainSize / gap;
            odd = true;
        }

        for (int i = 0; i < sb.size(); i++) {
            s += sb.get(i);
            String padding = "";
            for (int j = 0; j < fillSpace; j++) {
                if (last == false) {
                    if (odd == true) {
                        padding += " ";
                        odd = false;
                    }
                    padding += " ";
                }
            }
            if (last == true) padding = " ";
            if (i != sb.size() -1)
                s += padding;
        }
        return s;
    }
}
