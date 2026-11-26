public class MergeSort7 {
    public static final int cutOff = 7;
    public static void mergeSort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0, a.length - 1);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        int i = lo;
        int j  = mid + 1;
        for(int k = lo; k <= hi; k++){
            if(i > mid){
                a[k] = aux[j++];
            }
            else if (j>hi) {
                a[k] = aux[i++];
            }
            else if (less(aux[j],aux[i])){
                a[k] = aux[j++];
            }
            else{
                a[k] = aux[i++];
            }
        }
    }

    public static boolean less(Comparable i, Comparable j){
        if(i. compareTo(j) < 0){
            return true;
        }
        else return false;
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if(hi <= lo + cutOff -1){
            InsertionSort.insertionSort(a, lo, hi);
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
}