package festivos.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

import services.IPaisService;
import entities.Pais;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

    private IPaisService paisService;

    public PaisController(IPaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping("/listarpaises")
    public List<Pais> listarPaises() {
        List<Pais> paises = paisService.obtenerPaises();
        return paises.stream()
        .map(pais -> new Pais(pais.getId(), pais.getNombre()))
        .collect(Collectors.toList());
    }


}