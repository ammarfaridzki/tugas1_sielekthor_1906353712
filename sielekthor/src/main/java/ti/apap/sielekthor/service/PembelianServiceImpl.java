package ti.apap.sielekthor.service;

import ti.apap.sielekthor.model.BarangModel;
import ti.apap.sielekthor.model.MemberModel;
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

    @Override
    public PembelianModel getPembelianByIdPembelian(Long idPembelian){
        Optional<PembelianModel> pembelian = pembelianDb.findByIdPembelian(idPembelian);
        if(pembelian.isPresent()){
            return pembelian.get();
        }
        return null;
    }

    @Override
    public List<PembelianModel> getPembelianByMember(MemberModel member) {
        List<PembelianModel> pembelian = pembelianDb.findByMember(member);
        return pembelian;
    }

    @Override
    public void deletePembelian(PembelianModel pembelian) {
        pembelianDb.delete(pembelian);
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
