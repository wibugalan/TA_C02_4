package C02_4.SIBUSINESS.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultItemDetail {
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("nama")
    private String nama;

    @JsonProperty("harga")
    private Integer harga;

    @JsonProperty("stok")
    private Integer stok;

    @JsonProperty("kategori")
    private String kategori;
}
