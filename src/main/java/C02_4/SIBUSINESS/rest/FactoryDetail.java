package C02_4.SIBUSINESS.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FactoryDetail {

    @JsonProperty("id_mesin")
    private Integer idMesin;

    @JsonProperty("nama")
    private String nama;

    @JsonProperty("kategori")
    private String kategori;

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

    public String getIdKategori() {
        return kategori;
    }

    public void setIdKategori(String idKategori) {
        this.kategori = idKategori;
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





