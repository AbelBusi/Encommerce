package com.Encommerce.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cesar
 */
@Controller
@RequestMapping("/administrador")
public class AdministadorController {

    @GetMapping("")
    public String home() {

        return "administrador/home.html";
    }

}
