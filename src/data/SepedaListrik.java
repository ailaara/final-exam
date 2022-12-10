package data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.MainFrame;

public class SepedaListrik extends Sepeda implements Database{

    private String kecepatan;
    private String baterai;

    public SepedaListrik() {
    }

    public SepedaListrik(String kode, String tipe, String merk, double harga, int stok, String kecepatan, String baterai) {
        super(kode, tipe, merk, harga, stok, "Listrik");
        this.kecepatan = kecepatan;
        this.baterai = baterai;
    }

    @Override
    public void getData(String kode) {
        try {
            Connection cn = koneksi.getKoneksi();
            stm = cn.createStatement();
            String sql = "SELECT * FROM sepeda_listrik WHERE kode = %s";
            sql = String.format(sql, kode);
            result = stm.executeQuery(sql);
            while (result.next()) {
                this.kode = kode;
                this.tipe = result.getString("tipe");
                this.merk = result.getString("merk");
                this.harga = result.getDouble("harga");
                this.stok = result.getInt("stok");
                this.kecepatan = result.getString("kecepatan");
                this.baterai = result.getString("baterai");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                result.close();
                stm.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error set data : " + ex);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String getFitur1() {
        return this.kecepatan;
    }

    @Override
    public String getFitur2() {
        return this.baterai;
    }

    @Override
    public void updateData(String tipe,String merk, String harga, String stok,String fitur1, String fitur2) {
        try {
            // Membuat query update
            String sql = "UPDATE sepeda_listrik SET tipe='%s',merk='%s',harga=%s,stok=%s,kecepatan='%s',baterai='%s' WHERE kode=%s";
            // string format : memasukan data ke dalam string
            // %s : untuk data bertipe string
            // %d : untuk data bertipe int
            // %f : untuk data bertipe float / double
            sql = String.format(sql, tipe, merk, harga, stok, fitur1, fitur2,this.kode);
            Connection cn = koneksi.getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah data : " + ex);
        } finally {
            try {
                pst.close(); // menutup statement yang sudah dijalankan
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public void updateData() {
        try {
            // Membuat query update
            String sql = "UPDATE sepeda_listrik SET tipe='%s',merk='%s',harga=%f,stok=%d,kecepatan='%s',baterai='%s' WHERE kode=%s";
            // string format : memasukan data ke dalam string
            // %s : untuk data bertipe string
            // %d : untuk data bertipe int
            // %f : untuk data bertipe float / double
            sql = String.format(sql,this.tipe, 
                    this.merk,
                    this.harga,
                    this.stok,
                    this.kecepatan,
                    this.baterai,
                    this.kode);
            Connection cn = koneksi.getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah data : " + ex);
        } finally {
            try {
                pst.close(); // menutup statement yang sudah dijalankan
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Setter & Getter
    public String getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(String kecepatan) {
        this.kecepatan = kecepatan;
    }

    public String getBaterai() {
        return baterai;
    }

    public void setBaterai(String baterai) {
        this.baterai = baterai;
    }
}
