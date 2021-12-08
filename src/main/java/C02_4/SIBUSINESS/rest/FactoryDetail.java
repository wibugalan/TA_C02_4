package C02_4.SIBUSINESS.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FactoryDetail {


    @JsonProperty("id_mesin")
    private Integer idMesin;

    @JsonProperty("nama")
    private String nama;

    @JsonProperty("id_kategori")
    private Integer idKategori;

    @JsonProperty("tanggal_dibuat")
    private Date tanggalDibuat;

    @JsonProperty("kapasitas")
    private Integer kapasitas;

    public Integer getIdMesin() {
        return idMesin;
    }

    public void setIdMesin(Integer idMesin) {
        this.idMesin = idMesin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(Integer idKategori) {
        this.idKategori = idKategori;
    }

    public Date getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(Date tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    public Integer getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(Integer kapasitas) {
        this.kapasitas = kapasitas;
    }
}





