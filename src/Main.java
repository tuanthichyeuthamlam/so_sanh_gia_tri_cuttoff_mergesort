import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println("Tạo mảng ngẫu nhiên gồm " + n + " phần tử...");

    Comparable[] original = generateRandomArray(n, 1, 1000000);

    // Nhân bản mảng gốc để 2 lần test sử dụng dữ liệu đầu vào Y HỆT NHAU
    Comparable[] arrayTest7 = original.clone();
    Comparable[] arrayTest10 = original.clone();

    // Warm-up để JVM nạp hết class vào bộ nhớ
    MergeSort7.mergeSort(arrayTest7.clone());
    MergeSort10.mergeSort(arrayTest10.clone());

    // 1. Đo thời gian CUTOFF = 7
    long start7 = System.nanoTime();
    MergeSort7.mergeSort(arrayTest7);
    long end7 = System.nanoTime();
    double time7 = (end7 - start7) / 1_000_000.0; // Đổi sang ms

    // 2. Đo thời gian CUTOFF = 10
    long start10 = System.nanoTime();
    MergeSort10.mergeSort(arrayTest10);
    long end10 = System.nanoTime();
    double time10 = (end10 - start10) / 1_000_000.0; // Đổi sang ms

    System.out.printf("Thời gian chạy với CUTOFF = 7  : %.3f ms\n", time7);
    System.out.printf("Thời gian chạy với CUTOFF = 10 : %.3f ms\n", time10);
}

private static Comparable[] generateRandomArray(int n, int min, int max) {
    Random random = new Random();
    Comparable[] a = new Comparable[n];

    for (int i = 0; i < n; i++) {
        // Sinh số ngẫu nhiên trong khoảng [min, max]
        a[i] = random.nextInt(max - min + 1) + min;
    }

    return a;
}