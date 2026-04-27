import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CatatanGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Catatan harian GUI");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Catatan harian", SwingConstants.CENTER);
        frame.add(title, BorderLayout.NORTH);

        JTextArea areaCatatan = new JTextArea();
        areaCatatan.setEditable(false);
        loadCatatan(areaCatatan);

        frame.add(new JScrollPane(areaCatatan), BorderLayout.CENTER);
        
        JPanel panelInput = new JPanel();
        JTextField inputCatatan = new JTextField(20);
        JButton tombolTambah = new JButton("Tambah");
        JButton tombolHapus = new JButton("Hapus");
    

        panelInput.add(inputCatatan);

        panelInput.add(tombolTambah);
        tombolTambah.addActionListener(e ->{
            String isi = inputCatatan.getText().trim();

            if (!isi.isEmpty()) {
                inputCatatan.setText("");

                try {
                    FileWriter writer = new FileWriter ("Catatan.txt", true);
                    writer.write(isi + "\n");
                    writer.close();
                    loadCatatan(areaCatatan);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Gagal menyimpan catatan.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "!Catatan tidak boleh kosong!");
            }
        });

        panelInput.add(tombolHapus);
        tombolHapus.addActionListener(e-> {
            String input = JOptionPane.showInputDialog(frame, "Masukkan nomor catatan: ");
            if (input == null || input.trim().isEmpty()) {
                return;
            }

            try {
                int nomor = Integer.parseInt(input.trim());

                String[] semuaCatatan = areaCatatan.getText().split("\n");
                 
                if (nomor >= 1 && nomor <= semuaCatatan.length) {
                    int konfirmasi = JOptionPane.showConfirmDialog(frame, "Yakin mau hapus catatan ini?", "Konfirmasi hapus.", JOptionPane.YES_NO_OPTION);
                    if (konfirmasi != JOptionPane.YES_OPTION) {
                        return;
                    }
                    StringBuilder hasil = new StringBuilder();

                    for (int i = 0; i < semuaCatatan.length; i++) {
                        if (i != nomor - 1) {
                            hasil.append(semuaCatatan[i]).append("\n");
                        }
                    }
                    areaCatatan.setText(hasil.toString());

                    try {
                    FileWriter writer = new FileWriter ("Catatan.txt");
                    for (String baris : hasil.toString().split("\n")) {
                        String bersih = baris.replaceFirst("^\\d+\\.\\s*", "");
                        writer.write(bersih + "\n");
                    }
                    writer.close();
                    loadCatatan(areaCatatan);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "!Gagal update file!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Nomor catatan tidak valid!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Input harus angka!");
            }
        });
        frame.add(panelInput, BorderLayout.SOUTH);

        frame.setVisible(true);
    
    }
    public static void loadCatatan(JTextArea areaCatatan) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Catatan.txt"));
            String line;

            StringBuilder tampilan = new StringBuilder();
            int nomor = 1;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                tampilan.append(nomor + ". " + (line) + "\n");
                nomor++;
            }

            areaCatatan.setText(tampilan.toString());
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal membaca file.");
        }
    }
    }
