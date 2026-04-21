import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> catatan = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Catatan.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                catatan.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Belum ada file catatan");
        }

        while (true) {
        System.out.println("\n=== CATATAN HARIAN ===");
        System.out.println("1. Tambah Catatan");
        System.out.println("2. Lihat Catatan");
        System.out.println("3. Hapus Catatan");
        System.out.println("4. Edit catatan");
        System.out.println("5. Keluar");


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
            try {
                FileWriter writer = new FileWriter("Catatan.txt", true);
                writer.write(isi + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Gagal menyimpan ke file");
            }

            System.out.println("Catatan berhasil di tambahkan");
        } else if (pilihan == 2) {
            if (catatan.isEmpty()) {
                System.out.println("Belum ada catatan");
            } else {
                System.out.println("Daftar catatan:");
                for (int i = 0; i < catatan.size(); i++) {
                    System.out.println((i + 1) + ". " + catatan.get(i));
                }
            }
        } else if (pilihan == 3) {
            if (catatan.isEmpty()) {
                System.out.println("Belum ada catatan yang bisa dihapus");
            } else {
                System.out.println("Daftar catatan");
                for (int i = 0; i < catatan.size(); i++) {
                    System.out.println((i+1) + ". " + catatan.get(i));
                }
                System.out.print("Pilih nomor catatan yang mau dihapus: ");
                 if (!input.hasNextInt()) {
            System.out.println("Input harus angka!");
            input.next();
            continue;
            }
                int nomorHapus = input.nextInt();
                if (nomorHapus >= 1 && nomorHapus <= catatan.size()) {
                    catatan.remove(nomorHapus - 1);
                    System.out.println("Catatan berhasil dihapus.");
                    simpanUlangFile(catatan);
                } else {
                    System.out.println("Nomor catatan tidak valid.");
                }
            }
        } else if (pilihan == 4) {
            if (catatan.isEmpty()) {
                System.out.println("Belum ada catatan yang bisa di edit");
            } else {
                System.out.println("Daftar catatan:");
                for (int i = 0; i < catatan.size(); i++) {
                    System.out.println((i + 1) + ". " + catatan.get(i));
                }
                System.out.println("Pilih nomor catatan yang mau di edit: ");
                if (!input.hasNextInt()) {
                    System.out.println("Input harus angka!");
                    input.next();
                    continue;
                }
                int nomorEdit = input.nextInt();
                input.nextLine();
                if (nomorEdit >= 1 && nomorEdit <= catatan.size()) {
                    System.out.print("Tulis isi baru: ");
                    String isiBaru = input.nextLine();
                    catatan.set(nomorEdit - 1, isiBaru);
                    simpanUlangFile(catatan);
                    System.out.println("Catatan berhasil di update");
                } else {
                    System.out.println("Nomor tidak valid");
                }
            }
        } else if (pilihan == 5) {
            System.out.println("Program selesai");
            break;
        } else {
            System.out.println("Pilihan tidak valid");
        }
    }
    input.close();
    }
    public static void simpanUlangFile(ArrayList<String>catatan) {
        try {
            FileWriter writer = new FileWriter("Catatan.txt");
            for (String c : catatan) {
                writer.write(c + "\n");
            }
            writer.close();
            } catch (IOException e) {
                System.out.println("Gagal update file");
        }
    }
}