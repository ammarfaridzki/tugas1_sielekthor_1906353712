package ti.apap.sielekthor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ti.apap.sielekthor.model.MemberModel;
import ti.apap.sielekthor.model.TipeModel;
import ti.apap.sielekthor.repository.TipeDb;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipeServiceImpl implements TipeService {
    @Autowired
    TipeDb tipeDb;

    @Override
    public List<TipeModel> getTipeList() {
        return tipeDb.findAll();
    }

    @Override
    public TipeModel getTipeByIdTipe(Long idTipe) {
        Optional<TipeModel> tipe = tipeDb.findByIdTipe(idTipe);
        if(tipe.isPresent()){
            return tipe.get();
        }
        return null;
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
