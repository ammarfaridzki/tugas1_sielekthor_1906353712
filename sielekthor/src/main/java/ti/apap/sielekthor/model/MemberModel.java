package ti.apap.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
@Table(name = "member")
public class MemberModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMember;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private int jenisKelamin;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama_member", nullable = false)
    private String namaMember;

    @NotNull
    @Column(name = "tanggal_lahir", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalLahir;

    @NotNull
    @Column(name = "tanggal_pendaftaran", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalPendaftaran;

    //Relasi dengan List Pembelian
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<PembelianModel> listPembelian;
}