package C02_4.SIBUSINESS.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CabangDetail {

    @JsonProperty("nama")
    private String nama;

    @JsonProperty("alamat")
    private String alamat;

    @JsonProperty("ukuran")
    private Long ukuran;

    @JsonProperty("noTelp")
    private String noTelp;

    @JsonProperty("status")
    private Long status;
}
