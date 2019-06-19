package me.maiz.ds.emall.web;

import lombok.extern.slf4j.Slf4j;
import me.maiz.ds.emall.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class PayController {

    @RequestMapping("pay")
    public String toPay(){
        return "pay";
    }

}
