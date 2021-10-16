package ti.apap.sielekthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ti.apap.sielekthor.model.BarangModel;
import ti.apap.sielekthor.model.MemberModel;
import ti.apap.sielekthor.model.PembelianModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface PembelianDb extends JpaRepository<PembelianModel,Long> {
    Optional<PembelianModel> findByIdPembelian(Long idPembelian);
    List<PembelianModel> findByMember(MemberModel member);
}
