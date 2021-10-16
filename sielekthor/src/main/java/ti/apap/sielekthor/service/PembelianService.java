package ti.apap.sielekthor.service;

import org.springframework.stereotype.Service;
import ti.apap.sielekthor.model.BarangModel;
import ti.apap.sielekthor.model.MemberModel;
import ti.apap.sielekthor.model.PembelianModel;

import java.util.List;

@Service
public interface PembelianService {
    List<PembelianModel> getPembelianList();
    PembelianModel getPembelianByIdPembelian(Long idPembelian);
    List<PembelianModel> getPembelianByMember(MemberModel member);
//    BarangModel getBarangByIdBarang(Long idBarang);
    void deletePembelian(PembelianModel pembelian);
}
