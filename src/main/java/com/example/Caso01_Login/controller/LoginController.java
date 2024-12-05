
package com.example.Caso01_Login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Mostrar el formulario de login
    @GetMapping("/login")
    public String mostrarFormulario() {
        return "login"; // Archivo login.html
    }

    // Procesar los datos enviados desde el formulario
    @PostMapping("/validarLogin")
    public String validarLogin(@RequestParam("usuario") String usuario,
                               @RequestParam("password") String password,
                               Model model) {
        if ("admin".equals(usuario) && "admin".equals(password)) {
            // Redirigir a la página de éxito si las credenciales son correctas
            return "exito"; // Archivo exito.html
        } else {
            // Mostrar mensaje de error en la misma pantalla
            model.addAttribute("error", "Usuario o contraseña incorrectos.");
            return "login"; // Volver a login.html con el mensaje de error
        }
    }
}