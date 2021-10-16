package ti.apap.sielekthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ti.apap.sielekthor.model.MemberModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberDb extends JpaRepository<MemberModel,Long> {
    Optional<MemberModel> findByIdMember(Long idMember);
}
