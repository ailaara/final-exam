package data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.MainFrame;

public class SepedaGowes extends Sepeda implements Database {

    private String jenis;
    private String ban;

    public SepedaGowes() {
    }

    public SepedaGowes(String kode, String tipe, String merk, double harga, int stok, String jenis, String ban) {
        super(kode, tipe, merk, harga, stok, "Gowes");
        this.jenis = jenis;
        this.ban = ban;
    }

    @Override
    public void getData(String kode) {
        try {
            Connection cn = koneksi.getKoneksi();
            stm = cn.createStatement();
            String sql = "SELECT * FROM sepeda_gowes WHERE kode = %s";
            sql = String.format(sql, kode);
            result = stm.executeQuery(sql);
            while (result.next()) {
                this.kode = kode;
                this.tipe = result.getString("tipe");
                this.merk = result.getString("merk");
                this.harga = result.getDouble("harga");
                this.stok = result.getInt("stok");
                this.jenis = result.getString("jenis");
                this.ban = result.getString("ban");
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
        return this.jenis;
    }

    @Override
    public String getFitur2() {
        return this.ban;
    }
    
    @Override
    public void updateData() {
        try {
            // Membuat query update
            String sql = "UPDATE sepeda_gowes SET tipe='%s',merk='%s',harga=%f,stok=%d,jenis='%s',ban='%s' WHERE kode=%s";
            // string format : memasukan data ke dalam string
            // %s : untuk data bertipe string
            // %d : untuk data bertipe int
            // %f : untuk data bertipe float / double
            sql = String.format(sql, this.tipe,
                    this.merk,
                    this.harga,
                    this.stok,
                    this.jenis,
                    this.ban,
                    this.kode);
            Connection cn = koneksi.getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah data : " + ex);
            System.out.println(ex);
        } finally {
            try {
                pst.close(); // menutup statement yang sudah dijalankan
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updateData(String tipe, String merk, String harga, String stok, String fitur1, String fitur2) {
        try {
            // Membuat query update
            String sql = "UPDATE sepeda_gowes SET tipe='%s',merk='%s',harga=%s,stok=%s,jenis='%s',ban='%s' WHERE kode=%s";
            // string format : memasukan data ke dalam string
            // %s : untuk data bertipe string
            // %d : untuk data bertipe int
            // %f : untuk data bertipe float / double
            sql = String.format(sql, tipe, merk, harga, stok, fitur1, fitur2, this.kode);
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
    
    // setter & getter
    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    

}
