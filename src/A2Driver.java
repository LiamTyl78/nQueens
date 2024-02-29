public class A2Driver {
    private static StringBuilder result = new StringBuilder();
    private static int completestates = 0, solutions = 0;
    private static long partialstates = 0, arraycomps = 0;
    
    public static void main(String[] args) throws Exception {
        long start_time = System.currentTimeMillis();
        int board[] = new int[Integer.valueOf(args[1])];
        boolean one = false;
        if (!(args[0].equals("one")) && !(args[0].equals("all"))) {
            System.err.println("Improper parameters, either 'one' or 'all' is accepted");
            return;
        }
        if (args[0].equals("one")) {
            one = true;
        }
        for (int i = 0; i < board.length - 1; i++) {
            board[i] = -1;
        }
        int i = 0;
        while (board[0] < board.length) {
            if (one && solutions > 0) {
                break;
            }
            if (board[i] < board.length - 1) {
                board[i]++;
                if (isViable(board, i)) {
                    if (i!=board.length-1) {
                        i++;
                    }
                    else{
                        collect(board);
                        solutions++;
                    }
                }   
            }
            else{
                if (i > 0) {
                    board[i] = -1;
                    i--;
                }
                else{
                    break;
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start_time + " milliseconds.");
        System.out.println(result);
        System.out.println("For a board of size " + board.length + ": " +  solutions + " solutions have been found");
        System.out.println("Total number of partial states explored: " + partialstates);
        System.out.println("Total number of complete states explored: " + completestates);
        System.out.println("Total number of array entry comparisons performed: " + arraycomps);
    } 
    public static boolean isViable(int[] list, int indx){
        int diagx = (list[indx] - indx), diagy = (list[indx] + indx);
        partialstates++;
        if (indx==list.length-1) {
            completestates++;
        }
        for (int j = (indx - 1); j > -1; j--) {
            arraycomps++;
            if (list[indx] == list[j]) {
                return false;
            }
            arraycomps++;
            if (diagx == (list[j] - j)) {
                return false;
            }
            arraycomps++;
            if (diagy == list[j] + j) {
                return false;
            }
        }
        return true;
    }
    public static void collect(int list[]) {
        result.append("\nVisual solution #" + (solutions + 1) + " for a "+ list.length + "-dimensional board is:\n");
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
    }
}
