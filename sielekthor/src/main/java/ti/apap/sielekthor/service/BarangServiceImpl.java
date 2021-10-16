package ti.apap.sielekthor.service;

import ti.apap.sielekthor.model.BarangModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ti.apap.sielekthor.model.PembelianModel;
import ti.apap.sielekthor.model.TipeModel;
import ti.apap.sielekthor.repository.BarangDb;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BarangServiceImpl implements BarangService {
    @Autowired
    BarangDb barangDb;

    @Override
    public List<BarangModel> getBarangList() {
        return barangDb.findAll();
    }

    @Override
    public BarangModel getBarangByIdBarang(Long idBarang){
        Optional<BarangModel> barang = barangDb.findByIdBarang(idBarang);
        if(barang.isPresent()){
            return  barang.get();
        }
        return null;
    }

    @Override
    public void addBarang(BarangModel barang){
        barangDb.save(barang);
    }

    @Override
    public void updateBarang(BarangModel barang){
        barangDb.save(barang);
    }

    @Override
    public List<BarangModel> getBarangByTipe(TipeModel tipe) {
        List<BarangModel> barang = barangDb.findByTipe(tipe);
        return barang;
    }
}
