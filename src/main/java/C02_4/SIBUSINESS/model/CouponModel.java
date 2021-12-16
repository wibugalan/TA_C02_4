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

//    @Size(max = 200)
//    @Column(nullable = false)
//    private String creator;

    // Relasi dengan user
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
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
}