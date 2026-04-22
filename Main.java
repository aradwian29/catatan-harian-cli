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
        System.out.println("===========================");
        System.out.println("\n      CATATAN HARIAN      ");
        System.out.println("\n===========================");
        System.out.println("\n1. Tambah Catatan");
        System.out.println("2. Lihat Catatan");
        System.out.println("3. Hapus Catatan");
        System.out.println("4. Edit Catatan");
        System.out.println("5. Cari Catatan");
        System.out.println("6. Keluar");
        System.out.println("\n===========================");

        System.out.print("\nPilih menu: ");
        String inputUser = input.nextLine();

        int pilihan;
        try {
            pilihan = Integer.parseInt(inputUser);
        } catch (NumberFormatException e) {
            System.out.println("Input harus angka!");
            continue;
        }
        if (pilihan == 1) {
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
                System.out.println("\n---- DAFTAR CATATAN ----");
                for (int i = 0; i < catatan.size(); i++) {
                    System.out.println((i + 1) + ". " + catatan.get(i));
                }
            }
        } else if (pilihan == 3) {
            if (catatan.isEmpty()) {
                System.out.println("Belum ada catatan yang bisa dihapus");
            } else {
                System.out.println("Daftar Catatan:");
                for (int i = 0; i < catatan.size(); i++) {
                    System.out.println((i + 1) + ". " + catatan.get(i));
                }
                System.out.println("Pilih nomor catatan yang mau dihapus:");
            String inputHapus = input.nextLine();
            int nomorHapus;
            try {
                nomorHapus = Integer.parseInt(inputHapus);
            } catch (NumberFormatException e) {
            System.out.println("Input harus angka!");
            continue;
            }
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
                String inputEdit = input.nextLine();

                int nomorEdit;
                try {
                    nomorEdit = Integer.parseInt(inputEdit);
                } catch (NumberFormatException e) {
                    System.out.println("Imput harus angka!");
                    continue;
                }
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
            if (catatan.isEmpty()) {
                System.out.println("Belum ada catatan");
            } else {
                System.out.print("Masukkan kata kunci:");
                String keyword = input.nextLine().toLowerCase();

                boolean ditemukan = false;

                System.out.println("Hasil pencarian:");
                for (int i = 0; i < catatan.size(); i++) {
                    if (catatan.get(i).toLowerCase().contains(keyword)) {
                        System.out.println((i + 1) + ". " + catatan.get(i));
                        ditemukan = true;
                    }
                }
                if (!ditemukan) {
                    System.out.println("Catatan tidak ditemukan.");
                }
            }
        } else if (pilihan == 6) {
            System.out.println("Program selesai");
            input.close();
            break;
        } else {
            System.out.println("Pilihan tidak valid");
        }
    }
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