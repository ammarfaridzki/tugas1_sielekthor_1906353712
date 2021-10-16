package ti.apap.sielekthor.service;

import org.springframework.stereotype.Service;
import ti.apap.sielekthor.model.BarangModel;
import ti.apap.sielekthor.model.MemberModel;
import ti.apap.sielekthor.model.PembelianModel;
import ti.apap.sielekthor.model.TipeModel;

import java.util.List;

@Service
public interface BarangService {
    List<BarangModel> getBarangList();
    BarangModel getBarangByIdBarang(Long idBarang);
    void addBarang(BarangModel barang);
    void updateBarang(BarangModel barang);
    List<BarangModel> getBarangByTipe(TipeModel tipe);
}
