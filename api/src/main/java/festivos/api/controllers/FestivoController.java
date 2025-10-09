package festivos.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.FestivoService;


@RestController
@RequestMapping("/api/festivos")
public class FestivoController {

private FestivoService festivoService;

    public FestivoController(FestivoService festivoService) {
        this.festivoService = festivoService;
    }

    @GetMapping("/ListarFestivos")
    public String listarFestivos() {
        return "Lista de festivos";
    }
}
