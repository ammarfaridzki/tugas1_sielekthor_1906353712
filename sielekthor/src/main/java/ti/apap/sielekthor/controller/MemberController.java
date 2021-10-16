package ti.apap.sielekthor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ti.apap.sielekthor.model.MemberModel;
import ti.apap.sielekthor.service.MemberService;

import java.time.LocalTime;
import java.util.List;


@Controller
public class MemberController {

    @Qualifier("memberServiceImpl")
    @Autowired
    private MemberService memberService;

    @GetMapping("/member")
    public String listMember(Model model) {
        List<MemberModel> listMember = memberService.getMemberList();
        model.addAttribute("listMember",listMember);
        return "member";
    }

    @GetMapping("bonus/cari/member/paling-banyak")
    public String bonusMember(Model model) {
        List<MemberModel> listMember = memberService.getMemberList();
        model.addAttribute("listMember",listMember);
        return "member-bonus";
    }

    @GetMapping("/member/tambah")
    public String addMemberForm(Model model){
        model.addAttribute("member",new MemberModel());
        return "member-add-form";
    }

    @PostMapping("/member/tambah")
    public String addMemberSubmit(
            @ModelAttribute MemberModel member,
            Model model
    ){
        memberService.addMember(member);
        model.addAttribute("idMember", member.getIdMember());
        return "member-add";
    }

    @GetMapping("/member/ubah/{idMember}")
    public String updateMemberFrom(
            @PathVariable Long idMember,
            Model model
    ){
        MemberModel member = memberService.getMemberByIdMember(idMember);
        model.addAttribute("member", member);
        return "member-ubah-form";
    }

    @PostMapping("/member/ubah")
    public String updateMemberSubmit(
            @ModelAttribute MemberModel member,
            Model model
    ){
        memberService.updateMember(member);
        model.addAttribute("member", member);
        return "member-ubah";
    }
}