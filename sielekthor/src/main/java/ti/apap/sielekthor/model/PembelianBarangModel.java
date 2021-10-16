package ti.apap.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "pembelian_barang")
public class PembelianBarangModel implements Serializable {

    @Id
    @Size(max=20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "tanggal_garansi", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalGaransi;

    @NotNull
    @Column(name="quantity", nullable = false)
    private int quantity;

    //Relasi dengan Pembelian
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idPembelian", referencedColumnName = "idPembelian", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PembelianModel pembelian;

    //Relasi dengan Barang
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idBarang", referencedColumnName = "idBarang", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BarangModel barang;
}
