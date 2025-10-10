package festivos.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Pais;
import services.PaisService;

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

        try {
            if (pais.getNombre() == null || pais.getNombre().isEmpty()) {
                throw new IllegalArgumentException("El nombre del país no puede estar vacío.");
                
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al agregar el país: " + e.getMessage());
        }
        return paisService.agregarPais(pais);
    }


}