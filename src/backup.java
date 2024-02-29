public class backup {
    // while not done
	// if Di is not exhausted
	// 	j++
	// 	if isViable and if i - n collect if one i f "one" done
	// 	else i++
	// else Di is exhausted
	// 	if i=0 done
	// 	else reset assignment for i[-1]
	// 		i--
    public static void main(String[] args) throws Exception {
        int s[] = new int[25];
        java.util.Arrays.fill(s,-1);
        int i = 0;
        while (i < s.length) {
            if (s[i] < s.length - 1) {
                s[i]++;
                if (isViable(s, i)) {
                    i++;
                }
            }
            else{
                if (i > 0) {
                    s[i] = -1;
                    i--;
                }
                else{
                    break;
                }
            }
        }
        for (int j = 0; j < s.length; j++) {
            System.out.print(s[j]);
        }
        System.out.println();
        collect(s);
    } 
    public static boolean isViable(int[] list, int indx){
        int diagx = (list[indx] - indx), diagy = (list[indx] + indx);
        for (int j = (indx - 1); j > -1; j--) {
            if (list[indx] == list[j]) {
                return false;
            }
            if (diagx == (list[j] - j)) {
                return false;
            }
            if (diagy == list[j] + j) {
                return false;
            }
        }
        return true;
    }
    public static void collect(int list[]) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[j] == i) {
                    result.append("x");
                }
                else{
                    result.append("-");
                }
                result.append(" ");
            }
            result.append("\n");
        }
        System.out.println(result);
    }
}
