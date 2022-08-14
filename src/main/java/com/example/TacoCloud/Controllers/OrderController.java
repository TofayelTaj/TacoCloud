package com.example.TacoCloud.Controllers;

import com.example.TacoCloud.DomanObject.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(Order order){
        return "orderForm";
    }
    @PostMapping("/current")
    public String processOrder(@Valid @ModelAttribute  Order order, BindingResult  result, Model model){
        if(result.hasErrors()){
            return "orderForm";
        }
        log.info("order created " + order);
        model.addAttribute("orderConfirmMessage", "Order Successful......");

        return "home";
    }

}
