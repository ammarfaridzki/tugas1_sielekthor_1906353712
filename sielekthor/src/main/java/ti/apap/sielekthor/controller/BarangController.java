package ti.apap.sielekthor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ti.apap.sielekthor.model.BarangModel;
import ti.apap.sielekthor.model.MemberModel;
import ti.apap.sielekthor.model.PembelianModel;
import ti.apap.sielekthor.model.TipeModel;
import ti.apap.sielekthor.service.BarangService;
import ti.apap.sielekthor.service.TipeService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BarangController {

    @Qualifier("barangServiceImpl")
    @Autowired
    private BarangService barangService;

    @Qualifier("tipeServiceImpl")
    @Autowired
    private TipeService tipeService;

    @GetMapping("/barang")
    public String listBarang(Model model) {
        List<BarangModel> listBarang = barangService.getBarangList();
        model.addAttribute("listBarang",listBarang);
        return "barang";
    }

    @GetMapping("/barang/{idBarang}")
    public String viewDetailBarang(
            @PathVariable Long idBarang,
            Model model
    ){
        BarangModel barang = barangService.getBarangByIdBarang(idBarang);
        model.addAttribute("barang", barang);
        return "barang-detail";
    }

    @GetMapping("/barang/tambah")
    public String addBarangForm(Model model){
        model.addAttribute("barang",new BarangModel());
        List<TipeModel> listTipe = tipeService.getTipeList();
        model.addAttribute("listTipe", listTipe);
        return "barang-add-form";
    }

    @PostMapping("/barang/tambah")
    public String addBarangSubmit(
            @ModelAttribute BarangModel barang,
            Model model
    ){
        barangService.addBarang(barang);
        model.addAttribute("kodeBarang",barang.getKodeBarang());
        return "barang-add";
    }

    @GetMapping("/barang/ubah/{idBarang}")
    public String updateBarangFrom(
            @PathVariable Long idBarang,
            Model model
    ){
        BarangModel barang = barangService.getBarangByIdBarang(idBarang);
        model.addAttribute("barang", barang);
        return "barang-ubah-form";
    }

    @PostMapping("/barang/ubah")
    public String updateBarangSubmit(
            @ModelAttribute BarangModel barang,
            Model model
    ){
        barangService.updateBarang(barang);
        model.addAttribute("kodeBarang",barang.getKodeBarang());
        return "barang-ubah";
    }

    @GetMapping("/barang/cari")
    public String cariBarang(
            @RequestParam(value = "idTipe", required = false) Long idTipe,
            @RequestParam(value = "stok", required = false) Long stok,
            Model model
    ) {
        List<TipeModel> listTipe = tipeService.getTipeList();
        List<BarangModel> listBarang = new ArrayList<>();
        if (idTipe != null){
            TipeModel tipe = tipeService.getTipeByIdTipe(idTipe);
            listBarang = barangService.getBarangByTipe(tipe);
        }
        if (stok != null){
            if (stok == 0){
                for (int i = 0; i < listBarang.size(); i++) {
                    if (listBarang.get(i).getStok() != 0) {
                        listBarang.remove(listBarang.get(i));
                    }
                }
            } else {
                for (int i = 0; i < listBarang.size(); i++) {
                    if (listBarang.get(i).getStok() == 0) {
                        listBarang.remove(listBarang.get(i));
                    }
                }
            }
        }
        model.addAttribute("listBarang",listBarang);
        model.addAttribute("listTipe",listTipe);
        return "filter-stok";
    }
}