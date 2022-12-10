package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import main.KoneksiToDatabase;

public abstract class Sepeda implements Database{
    // variabel untuk melakukan query ke database
    protected PreparedStatement pst;
    protected ResultSet result;
    protected Statement stm;
    protected final KoneksiToDatabase koneksi;
    protected String kode;
    protected String tipe;
    protected String merk;
    protected String kategori;
    protected double harga;
    protected int stok;

    public Sepeda() {
         koneksi = new KoneksiToDatabase();
    }
    
    public Sepeda(String kode, String tipe, String merk, double harga, int stok, String kategori) {
        this.kode = kode;
        this.tipe = tipe;
        this.merk = merk;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
        koneksi = new KoneksiToDatabase();
    }

    public void kurangiStok(int jumlah) {
        if (jumlah < this.stok) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak cukup");
        }
    }
    
    // abstract class
    @Override
    public abstract void updateData(String tipe, String merk, String harga, String stok, String fitur1, String fitur2);
    // overloading
    public abstract void updateData();
    public abstract void getData(String kode);
    public abstract String getFitur1();
    public abstract String getFitur2();
    
    // Setter & Getter
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getHarga() {
        return harga;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getTipe() {
        return tipe;
    }

    
}
