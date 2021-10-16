package ti.apap.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "tipe")
public class TipeModel implements Serializable {

    @Id
    @Size(max=20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipe;

    @NotNull
    @Size(max = 255)
    @Column(name="nama_tipe", nullable = false)
    private String namaTipe;

    @NotNull
    @Size(max = 255)
    @Column(name="deskripsi_tipe", nullable = false)
    private String deskripsiTipe;

    //Relasi dengan Barang
    @OneToMany(mappedBy = "tipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BarangModel> listBarang;
}