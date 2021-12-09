package C02_4.SIBUSINESS.rest;

public class ItemDTO {
    public Integer harga;
    public Integer kategori;
    public String nama;
    public Integer stok;

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getKategori() {
        return kategori;
    }

    public void setKategori(Integer kategori) {
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

}