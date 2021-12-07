package C02_4.SIBUSINESS.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponDetail {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("coupon_code")
    private String coupon_code;

    @JsonProperty("coupon_name")
    private String coupon_name;

    @JsonProperty("discountAmount")
    private float discountAmount;

    @JsonProperty("expiryDate")
    private Date expiryDate;
}
