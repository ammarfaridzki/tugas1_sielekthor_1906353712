package ti.apap.sielekthor.service;

import org.springframework.stereotype.Service;
import ti.apap.sielekthor.model.BarangModel;
import ti.apap.sielekthor.model.PembelianModel;

import java.util.List;

@Service
public interface PembelianService {
    List<PembelianModel> getPembelianList();
//    BarangModel getBarangByIdBarang(Long idBarang);
//    void addBarang(BarangModel barang);
}
