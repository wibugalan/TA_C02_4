package C02_4.SIBUSINESS.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDetail {

//    @JsonProperty("id")
//    private Long id;
//
//    @JsonProperty("name")
//    private String name;
//
//    @JsonProperty("status")
//    private Integer status;
//
//    @JsonProperty("stock")
//    private Integer stock;
//
//    @JsonProperty("price")
//    private Integer price;
//
//    @JsonProperty("category")
//    private Integer category;
//
//    @JsonProperty("cluster")
//    private String cluster;

    //    api

//    @JsonProperty("uuid")
//    private String uuid;
//
//    @JsonProperty("nama")
//    private String nama;
//
//    @JsonProperty("harga")
//    private Integer harga;
//
//    @JsonProperty("stok")
//    private Integer stok;
//
//    @JsonProperty("kategori")
//    private String kategori;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    JsonNode result;


// get set
public JsonNode getResult() {
    return result;
}

    public void setResult(JsonNode result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}





