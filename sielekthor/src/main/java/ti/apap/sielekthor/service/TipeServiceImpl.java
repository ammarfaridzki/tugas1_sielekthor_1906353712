package ti.apap.sielekthor.service;

import ti.apap.sielekthor.model.PembelianModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ti.apap.sielekthor.repository.PembelianDb;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PembelianServiceImpl implements PembelianService {
    @Autowired
    PembelianDb pembelianDb;

    @Override
    public List<PembelianModel> getPembelianList() {
        return pembelianDb.findAll();
    }

//    @Override
//    public BarangModel getBarangByIdBarang(Long idBarang){
//        Optional<BarangModel> barang = barangDb.findByIdBarang(idBarang);
//        if(barang.isPresent()){
//            return  barang.get();
//        }
//        return null;
//    }
//
//    @Override
//    public void addBarang(BarangModel barang){
//        barangDb.save(barang);
//    }
}
