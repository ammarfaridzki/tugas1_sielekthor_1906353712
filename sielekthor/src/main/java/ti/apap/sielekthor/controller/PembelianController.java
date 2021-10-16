package ti.apap.sielekthor.controller;

//import apap.tutorial.emsidi.model.CabangModel;
//import apap.tutorial.emsidi.model.MenuModel;
//import apap.tutorial.emsidi.model.PegawaiModel;
//import apap.tutorial.emsidi.repository.CabangDb;
//import apap.tutorial.emsidi.service.CabangService;
//import apap.tutorial.emsidi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ti.apap.sielekthor.model.MemberModel;
import ti.apap.sielekthor.model.PembelianBarangModel;
import ti.apap.sielekthor.model.PembelianModel;
import ti.apap.sielekthor.service.MemberService;
import ti.apap.sielekthor.service.PembelianService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PembelianController {

    @Qualifier("pembelianServiceImpl")
    @Autowired
    private PembelianService pembelianService;

    @Qualifier("memberServiceImpl")
    @Autowired
    private MemberService memberService;

    @GetMapping("/pembelian")
    public String listPembelian(Model model) {
        List<PembelianModel> listPembelian = pembelianService.getPembelianList();
        model.addAttribute("listPembelian",listPembelian);
        return "pembelian-view";
    }

    @GetMapping("/pembelian/tambah")
    public String addPembelianForm(Model model){
        model.addAttribute("pembelian",new PembelianModel());
        return "pembelian-add-form";
    }

    @GetMapping("/pembelian/{idPembelian}")
    public String viewDetailPembelian(
            @PathVariable Long idPembelian,
            Model model
    ){
        PembelianModel pembelian = pembelianService.getPembelianByIdPembelian(idPembelian);
        List<PembelianBarangModel> listPembelianBarang = pembelian.getListPembelianBarang();
        model.addAttribute("listPembelianBarang", listPembelianBarang);
        model.addAttribute("pembelian", pembelian);
        return "pembelian-detail";
    }

    @GetMapping("/pembelian/hapus/{idPembelian}")
    public String deletePembelian(
            @PathVariable Long idPembelian,
            Model model
    ) {
        PembelianModel pembelian = pembelianService.getPembelianByIdPembelian(idPembelian);
        model.addAttribute("pembelian", pembelian);
        pembelianService.deletePembelian(pembelian);
        return "pembelian-delete";
    }

    @GetMapping("/cari/pembelian")
    public String cariPembelian(
            @RequestParam(value = "idMember", required = false) Long idMember,
            @RequestParam(value = "isCash", required = false) Long isCash,
            Model model
    ) {
        List<MemberModel> listMember = memberService.getMemberList();
        List<PembelianModel> listPembelian = new ArrayList<>();
        if (idMember != null){
            MemberModel member = memberService.getMemberByIdMember(idMember);
            listPembelian = pembelianService.getPembelianByMember(member);
        }
        if (isCash != null){
            if (isCash == 0){
                for (int i = 0; i < listPembelian.size(); i++) {
                    if (listPembelian.get(i).isCash() == Boolean.TRUE) {
                        listPembelian.remove(listPembelian.get(i));
                    }
                }
            } else {
                for (int i = 0; i < listPembelian.size(); i++) {
                    if (listPembelian.get(i).isCash() == Boolean.FALSE) {
                        listPembelian.remove(listPembelian.get(i));
                    }
                }
            }
        }
        model.addAttribute("listPembelian",listPembelian);
        model.addAttribute("listMember",listMember);
        return "filter";
    }
}
