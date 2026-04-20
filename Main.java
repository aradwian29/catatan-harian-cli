import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> catatan = new ArrayList<>();
        catatan.add("Belajar java");
        catatan.add("Ngoding CLI");
        catatan.add("Kerjain Tugas");

        while (true) {
        System.out.println("\n=== CATATAN HARIAN ===");
        System.out.println("1. Tambah Catatan");
        System.out.println("2. Lihat Catatan");
        System.out.println("3. Hapus Catatan");
        System.out.println("4. Keluar");


        System.out.print("Pilih menu: ");
        if (!input.hasNextInt()) {
            System.out.println("Input harus angka!");
            input.next();
            continue;
        }
        int pilihan = input.nextInt();
        if (pilihan == 1) {
            input.nextLine();
            System.out.print("Tulis catatan: ");
            String isi = input.nextLine();
            catatan.add(isi);
            System.out.println("Catatan berhasil di tambahkan");
        } else if (pilihan == 2) {
            if (catatan.isEmpty()) {
                System.out.println("Belum ada catatan");
            } else {
                System.out.println("Daftar catatan:");
                for (int i = 0; i < catatan.size(); i++) {
                    System.out.println((i + 1) + "." + catatan.get(i));
                }
            }
        } else if (pilihan == 3) {
            if (catatan.isEmpty()) {
                System.out.println("Belum ada catatan yang bisa dihapus");
            } else {
                System.out.println("Daftar catatan");
                for (int i = 0; i < catatan.size(); i++) {
                    System.out.println((i+1) + "." + catatan.get(i));
                }
                System.out.println("Pilih nomor catatan yang mau dihapus: ");
                 if (!input.hasNextInt()) {
            System.out.println("Input haarus angka!");
            input.next();
            continue;
            }
                int nomorHapus = input.nextInt();
                if (nomorHapus >= 1 && nomorHapus <= catatan.size()) {
                    catatan.remove(nomorHapus - 1);
                    System.out.println("Catatan berhasil dihapus.");
                } else {
                    System.out.println("Nomor catatan tidak valid.");
                }
            }
        } else if (pilihan == 4) {
            System.out.println("Program selesai");
            break;
        } else {
            System.out.println("Pilihan tidak valid");
        }
    }
    input.close();
    }
}