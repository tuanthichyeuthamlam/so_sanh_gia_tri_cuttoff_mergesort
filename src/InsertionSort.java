public class InsertionSort {
    public static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo; j--) {
                if (less(a[j], a[j - 1])) exch(a, j, j - 1);
                else break;
            }
        }
    }
    public static boolean less(Comparable i, Comparable j){
        if(i. compareTo(j) < 0){
            return true;
        }
        else return false;
    }
     public static void exch(Comparable[] a, int i, int j ){
        Comparable cur = a[i];
        a[i] = a[j];
        a[j] = cur;
     }
}