package com.example.Spring.boot.project.controller;

import com.example.Spring.boot.project.model.BankModel;
import com.example.Spring.boot.project.repo.BankRepository;
import com.example.Spring.boot.project.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String registrationForm(Model model){
        model.addAttribute("user", new BankModel());
        return "register";
    }

    @PostMapping("/register/save")
    public String registerUser(@ModelAttribute BankModel bankModel){
        bankService.registerUser( bankModel);
        return "redirect:/success";
    }

    @GetMapping("/deposit")
    public String depositPage() {
        return "deposit";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountNumber, @RequestParam double amount) {
        bankService.deposit(accountNumber, amount);
        return "redirect:/success";
    }

    @GetMapping("/balance/{accountNumber}")
    @ResponseBody
    public double checkBalance(@PathVariable String accountNumber) {
        return bankService.checkBalance(accountNumber);
    }

    @GetMapping("/withdraw")
    public String withdrawPage() {
        return "withdraw";
    }
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
        try {
            bankService.withdraw(accountNumber, amount);
            return "redirect:/success";
        } catch (RuntimeException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
