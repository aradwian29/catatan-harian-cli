import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== CATATAN HARIAN ===");
        System.out.println("1. Tambah Catatan");
        System.out.println("2. Lihat Catatan");
        System.out.println("3. Keluar");

        System.out.print("Pilih menu: ");
        int pilihan = input.nextInt();

        System.out.println("Kamu memilih menu: " + pilihan);
    }
}