package data;

public interface Database {
    // fungsi yang ada di class interface juga termasuk abstract class
    // fungsi yang ada di class interface secara langsung menjadi class abstract
    // tanpa harus menuliskan keyword abstract lagi
    public void updateData(String tipe,String merk, String harga, String stok,String fitur1, String fitur2);
}
