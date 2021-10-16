package ti.apap.sielekthor.service;

import org.springframework.stereotype.Service;
import ti.apap.sielekthor.model.BarangModel;
import ti.apap.sielekthor.model.MemberModel;

import java.util.List;

@Service
public interface MemberService {
    List<MemberModel> getMemberList();
    MemberModel getMemberByIdMember(Long idMember);
    void addMember(MemberModel member);
    void updateMember(MemberModel member);
}
