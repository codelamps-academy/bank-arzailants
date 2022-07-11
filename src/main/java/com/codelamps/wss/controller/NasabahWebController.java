package com.codelamps.wss.controller;

import com.codelamps.wss.entity.Nasabah;
import com.codelamps.wss.service.NasabahService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Nama : Andre Rizaldi Brillianto
 * Project : nasabah-webservice-app
 * Email: andrerizaldib@gmail.com
 * Date: 8/07/22
 */
@Controller
@AllArgsConstructor
public class NasabahWebController {

    private NasabahService nasabahService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("nasabah", nasabahService.getAllNasabah());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("nasabah", new Nasabah());
        return "formNasabah";
    }

//    @GetMapping("/ktp/{ktp}")
//    public String getNasabahByKTP(String ktp, Model model){
//        model.addAttribute("nasabah", nasabahService.findByKTP(ktp));
//        return "redirect:/";
//    }

    @PostMapping(value = "/create")
    public String tambahNasabah(Model model, Nasabah nasabah){
        model.addAttribute("nasabah", nasabahService.save(nasabah));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        model.addAttribute("nasabah", nasabahService.findById(id));
        return "formNasabah";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusNasabah(@PathVariable Long id){
        nasabahService.deleteById(id);
        return "redirect:/";
    }
}
