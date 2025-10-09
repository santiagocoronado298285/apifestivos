package festivos.api.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import services.PaisService;
import entities.Pais;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

    private PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping("/listarpaises")
    public List<Pais> listarPaises() {
        List<Pais> paises = paisService.obtenerPaises();
        return paises.stream()
        .map(pais -> new Pais(pais.getId(), pais.getNombre()))
        .collect(Collectors.toList());
    }

    @PostMapping("/agregarpais")
    public Pais agregarPais(@RequestBody Pais pais) {
        return paisService.agregarPais(pais);
    }


}