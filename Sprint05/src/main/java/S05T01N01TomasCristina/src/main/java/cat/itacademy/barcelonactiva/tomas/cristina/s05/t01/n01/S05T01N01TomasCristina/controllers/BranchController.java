package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.controllers;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.services.imp.BranchService;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping
    public String viewBranches(Model model) {
        List<BranchDTO> branches = branchService.getAllBranches();
        List<String> countries = new ArrayList<>();
        countries.addAll(CountryAfrica.COUNTRIES);
        countries.addAll(CountryAmerica.COUNTRIES);
        countries.addAll(CountryAsia.COUNTRIES);
        countries.addAll(CountryEurope.COUNTRIES);
        countries.addAll(CountryOceania.COUNTRIES);
        model.addAttribute("branches", branches);
        model.addAttribute("countries", countries);
        return "branch";
    }

    @PostMapping("/add")
    public String addBranch(@ModelAttribute BranchDTO branchDTO) {
        branchService.addBranch(branchDTO);
        return "redirect:/branch";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        BranchDTO branchDTO = branchService.getOneBranch(id);
        model.addAttribute("branch", branchDTO);
        List<String> countries = new ArrayList<>();
        countries.addAll(CountryAfrica.COUNTRIES);
        countries.addAll(CountryAmerica.COUNTRIES);
        countries.addAll(CountryAsia.COUNTRIES);
        countries.addAll(CountryEurope.COUNTRIES);
        countries.addAll(CountryOceania.COUNTRIES);
        model.addAttribute("countries", countries);
        return "edit-branch";
    }

    @PostMapping("/update/{id}")
    public String updateBranch(@PathVariable Integer id, @ModelAttribute BranchDTO branchDTO) {
        branchService.updateBranch(id, branchDTO);
        return "redirect:/branch";
    }

    @PostMapping("/delete/{id}")
    public String deleteBranch(@PathVariable Integer id) {
        branchService.deleteBranch(id);
        return "redirect:/branch";
    }

    @GetMapping("/getOne/{id}")
    @ResponseBody
    public BranchDTO getOneBranch(@PathVariable Integer id) {
        return branchService.getOneBranch(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<BranchDTO> getAllBranches() {
        return branchService.getAllBranches();
    }
}