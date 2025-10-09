package festivos.api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public String hello() {
        return "¡Hola desde el endpoint de prueba!";
    }

    @PostMapping
    public String echo(@RequestBody String mensaje) {
        return "Recibido: " + mensaje;
    }
}
