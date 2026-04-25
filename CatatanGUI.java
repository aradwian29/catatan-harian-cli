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
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Catatan.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                areaCatatan.append(line + "\n");
            }
            reader.close();
        } catch (IOException e) {

        }
        frame.add(new JScrollPane(areaCatatan), BorderLayout.CENTER);
        
        JPanel panelInput = new JPanel();
        JTextField inputCatatan = new JTextField(20);
        JButton tombolTambah = new JButton("Tambah");

        panelInput.add(inputCatatan);
        panelInput.add(tombolTambah);
        tombolTambah.addActionListener(e ->{
            String isi = inputCatatan.getText();

            if (!isi.isEmpty()) {
                areaCatatan.append(isi + "\n");
                inputCatatan.setText("");

                try {
                    FileWriter writer = new FileWriter ("Catatan.txt", true);
                    writer.write(isi + "\n");
                    writer.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Gagal menyimpan catatan.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "!Catatan tidak boleh kosong!");
            }
        });

        frame.add(panelInput, BorderLayout.SOUTH);

        frame.setVisible(true);
    
    }
}