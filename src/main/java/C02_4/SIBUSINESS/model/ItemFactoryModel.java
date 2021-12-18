package C02_4.SIBUSINESS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "itemfactory")

public class ItemFactoryModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = true)
    private Integer status;

    @NotNull
    @Column(nullable = false)
    private Integer stock;

    @NotNull
    @Column(nullable = false)
    private Integer price;

    @NotNull
    @Column(nullable = false)
    private Integer category;

    // Relasi dengan user
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "approver", referencedColumnName = "uuid", nullable = true)
    private UserModel approver;

//    @ManyToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="approver_id", unique= false, nullable=true, insertable=true, updatable=true)
//    private UserModel approver;

}
