package ti.apap.sielekthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ti.apap.sielekthor.model.BarangModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface BarangDb extends JpaRepository<BarangModel,Long> {
    Optional<BarangModel> findByIdBarang(Long idBarang);
}
