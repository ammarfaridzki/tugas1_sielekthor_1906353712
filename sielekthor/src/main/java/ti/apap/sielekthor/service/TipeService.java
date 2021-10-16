package ti.apap.sielekthor.service;

import org.springframework.stereotype.Service;
import ti.apap.sielekthor.model.PembelianModel;
import ti.apap.sielekthor.model.TipeModel;

import java.util.List;

@Service
public interface TipeService {
    List<TipeModel> getTipeList();
    TipeModel getTipeByIdTipe(Long idTipe);
//    BarangModel getBarangByIdBarang(Long idBarang);
//    void addBarang(BarangModel barang);
}
