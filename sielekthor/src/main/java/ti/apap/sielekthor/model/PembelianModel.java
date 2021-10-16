package ti.apap.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pembelian")
public class PembelianModel implements Serializable {
    @Id
    @Size(max = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPembelian;

    @NotNull
    @Column(name = "total", nullable = false)
    private int total;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime tanggalPembelian;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama_admin", nullable = false)
    private String namaAdmin;

    @NotNull
    @Size(max = 255)
    @Column(name = "no_invoice", nullable = false, unique = true)
    private String noInvoice;

    @NotNull
    @Column(name = "is_cash", nullable = false)
    private boolean isCash;

    //Relasi dengan Member
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idMember", referencedColumnName = "idMember", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MemberModel member;

    //Relasi dengan Pembelian Barang
    @OneToMany(mappedBy = "pembelian", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<PembelianBarangModel> listPembelianBarang;
}