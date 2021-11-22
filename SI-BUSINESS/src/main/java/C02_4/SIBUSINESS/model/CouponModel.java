package C02_4.SIBUSINESS.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
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
    @OneToMany(mappedBy = "coupon", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserModel> listCreator;

    // Relasi dengan Coupon Type
    @ManyToMany
    @JoinTable(
            name = "coupon_coupontype",
            joinColumns = @JoinColumn(name = "id_coupon"),
            inverseJoinColumns = @JoinColumn(name = "id_coupontype"))
    List<CouponTypeModel> listCoupontype;
}
