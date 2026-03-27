public class ArrayUtils {

    /**
     * Find last index of element
     *
     * @param x array to search
     * @param y value to look for
     * @return last index of y in x; -1 if absent
     * @throws NullPointerException if x is null
     */
    public static int findLast(int[] x, int y) {
        for (int i = x.length - 1; i >= 0; i--) {
            if (x[i] == y) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Count odd or positive elements
     *
     * @param x array to search
     * @return count of odd/positive values in x
     * @throws NullPointerException if x is null
     */
    public static int oddOrPos(int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] % 2 != 0 || x[i] > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Count occurrences of a target value in an array
     *
     * @param x      array to search
     * @param target value to count
     * @return number of times target appears in x
     * @throws NullPointerException if x is null
     */
    public static int countOf(int[] x, int target) {
        int count = 0;
        for (int a : x) {
            count = a == target ? count + 1 : count;
        }
        return count;
    }
}
