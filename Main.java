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

        if (pilihan == 1) {
            System.out.println("Kamu pilih Tambah Catatan");
        } else if (pilihan == 2) {
            System.out.println("Kamu pilih Lihat Catatan");
        } else if (pilihan == 3) {
            System.out.println("Program selesai");
        } else {
            System.out.println("Pilihan tidak valid");
        }

        System.out.println("Kamu memilih menu: " + pilihan);
    }
}