package C02_4.SIBUSINESS.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "coupon")
public class CouponModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private boolean status;

    @NotNull
    @Size(max = 16)
    @Column(nullable = false)
    private String coupon_code;

    @NotNull
    @Size(max = 20)
    @Column(nullable = false)
    private String coupon_name;

    @NotNull
    @Column(nullable = false)
    private float discountAmount;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date expiryDate;

    // Relasi dengan user
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator", referencedColumnName = "uuid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserModel creator;

    // Relasi dengan Coupon Type
    @ManyToMany
    @JoinTable(
            name = "coupon_coupontype",
            joinColumns = @JoinColumn(name = "id_coupon"),
            inverseJoinColumns = @JoinColumn(name = "id_coupontype"))
    List<CouponTypeModel> listCoupontype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }

    public String getCoupon_name() {
        return coupon_name;
    }

    public void setCoupon_name(String coupon_name) {
        this.coupon_name = coupon_name;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public UserModel getCreator() {
        return creator;
    }

    public void setCreator(UserModel creator) {
        this.creator = creator;
    }

    public List<CouponTypeModel> getListCoupontype() {
        return listCoupontype;
    }

    public void setListCoupontype(List<CouponTypeModel> listCoupontype) {
        this.listCoupontype = listCoupontype;
    }
}