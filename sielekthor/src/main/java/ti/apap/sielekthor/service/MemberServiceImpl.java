package ti.apap.sielekthor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ti.apap.sielekthor.model.BarangModel;
import ti.apap.sielekthor.model.MemberModel;
import ti.apap.sielekthor.repository.BarangDb;
import ti.apap.sielekthor.repository.MemberDb;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDb memberDb;

    @Override
    public List<MemberModel> getMemberList() {
        return memberDb.findAll();
    }

    @Override
    public MemberModel getMemberByIdMember(Long idMember) {
        Optional<MemberModel> member = memberDb.findByIdMember(idMember);
        if(member.isPresent()){
            return member.get();
        }
        return null;
    }

    @Override
    public void addMember(MemberModel member) {
        memberDb.save(member);
    }

    @Override
    public void updateMember(MemberModel member){
        memberDb.save(member);
    }
}
