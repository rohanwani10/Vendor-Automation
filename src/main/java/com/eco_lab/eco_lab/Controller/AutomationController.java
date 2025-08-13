package com.eco_lab.eco_lab.Controller;

import com.eco_lab.eco_lab.Entity.User;
import com.eco_lab.eco_lab.Service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verify")
public class AutomationController {

    @Autowired
    private AutomationService automationService;

    @GetMapping("/getData")
    public User getMyData() {
        return automationService.findUser();
    }

    @GetMapping("/getVendor")
    public User getUserData(@RequestParam("email") String Email) {
        System.out.println(Email);
        return automationService.getVendorUser(Email);
    }
}
