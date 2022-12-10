package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaksi {
    private Sepeda sepeda;
    private String nama;
    private int jumlah;
    private String tanggal;
    private double kembalian;
    private double pembayaran;
    private double total;
    
    public Transaksi(Sepeda sepeda) {
        this.sepeda = sepeda;
        buatTanggal();
    }
    public Transaksi(Sepeda sepeda, String nama, int jumlah) {
        this.sepeda = sepeda;
        this.nama = nama;
        this.jumlah = jumlah;
        buatTanggal();
    }
    private void buatTanggal(){
        setTanggal(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    public String hitungTotal(){
        this.total = this.sepeda.getHarga() * this.jumlah;
        return String.valueOf(this.total);
    }
    
    public String getKembalian(double uang){
        this.kembalian = uang - this.total;
        return String.valueOf(this.kembalian);
    }

    public double getKembalian() {
        return kembalian;
    }

    public void setKembalian(double kembalian) {
        this.kembalian = kembalian;
    }
    
    public double getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(double pembayaran) {
        this.pembayaran = pembayaran;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setSepeda(Sepeda sepeda) {
        this.sepeda = sepeda;
    }

    public Sepeda getSepeda() {
        return sepeda;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return tanggal;
    }
}
