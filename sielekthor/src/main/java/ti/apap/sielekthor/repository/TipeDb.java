package ti.apap.sielekthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ti.apap.sielekthor.model.TipeModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipeDb extends JpaRepository<TipeModel,Long> {
    Optional<TipeModel> findByIdTipe(Long idTipe);
}
