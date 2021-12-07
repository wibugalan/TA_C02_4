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
}





