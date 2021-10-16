package ti.apap.sielekthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ti.apap.sielekthor.model.BarangModel;
import ti.apap.sielekthor.model.TipeModel;
import ti.apap.sielekthor.model.PembelianModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface BarangDb extends JpaRepository<BarangModel,Long> {
    Optional<BarangModel> findByIdBarang(Long idBarang);
    List<BarangModel> findByTipe(TipeModel tipe);
}
