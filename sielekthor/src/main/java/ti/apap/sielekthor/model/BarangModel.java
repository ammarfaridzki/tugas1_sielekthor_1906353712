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
@Table(name = "barang")
public class BarangModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBarang;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama_barang", nullable = false)
    private String namaBarang;

    @NotNull
    @Size(max = 255)
    @Column(name = "kode_barang", nullable = false)
    private String kodeBarang;

    @NotNull
    @Size(max = 255)
    @Column(name = "merk_barang", nullable = false)
    private String merkBarang;

    @NotNull
    @Size(max = 255)
    @Column(name = "deskripsi_barang", nullable = false)
    private String deskripsiBarang;

    @NotNull
    @Column(name = "stok", nullable = false)
    private int stok;

    @NotNull
    @Column(name = "jumlah_garansi", nullable = false)
    private int jumlahGaransi;

    @NotNull
    @Column(name = "harga_barang", nullable = false)
    private int hargaBarang;

    //Relasi dengan Pembelian Barang
    @OneToMany(mappedBy = "pembelian", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<PembelianBarangModel> listPembelianBarang;

    //Relasi dengan Tipe
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idTipe", referencedColumnName = "idTipe", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TipeModel tipe;
}