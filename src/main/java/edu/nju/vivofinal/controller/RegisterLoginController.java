package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.service.RegisterLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/registerLogin")
public class RegisterLoginController {

    @Autowired
    private RegisterLoginService registerLoginService;

    @PostMapping(value = "/sendMail")
    @ResponseBody
    public String sendMail(@RequestParam String customerMail){
        return registerLoginService.sendMail(customerMail);
    }

    @PostMapping(value = "/customerRegister")
    @ResponseBody
    public boolean customerRegister(@RequestParam String customerMail,
                                    @RequestParam String customerPassword,
                                    @RequestParam String customerName,
                                    @RequestParam String phoneNumber){
        return registerLoginService.customerRegister(customerMail, customerPassword,
                customerName, phoneNumber);
    }

    @PostMapping(value = "/restaurantRegister")
    @ResponseBody
    public String restaurantRegister(@RequestParam String restaurantName,
                                      @RequestParam String restaurantPassword){
        return registerLoginService.restaurantRegister(restaurantName, restaurantPassword);
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestParam String identity, @RequestParam String account,
                        @RequestParam String password, HttpServletRequest request){
        String res = registerLoginService.login(identity, account, password);
        HttpSession session = request.getSession(true);
        if(res.equals("success"))
            session.setAttribute("userAccount", account);
        else
            session.invalidate();
        return res;
    }

    @PostMapping(value = "/logout")
    @ResponseBody
    public boolean logout(HttpServletRequest request){
        boolean res = false;
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
            res = true;
        }
        return res;
    }
}
