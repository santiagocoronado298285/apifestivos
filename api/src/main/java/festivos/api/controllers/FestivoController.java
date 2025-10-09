package festivos.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTOs.FestivoDTO;
import entities.Festivo;
import services.FestivoService;


@RestController
@RequestMapping("/api/festivos")
public class FestivoController {

private FestivoService festivoService;

    public FestivoController(FestivoService festivoService) {
        this.festivoService = festivoService;
    }

    @GetMapping("/ListarFestivos")
    public List<FestivoDTO> listarFestivos() {
        List<Festivo> festivos = festivoService.obtenerFestivos();
        return festivos.stream()
                .map(festivo -> new FestivoDTO(festivo.getNombre(), festivo.getDia(), festivo.getMes(), festivo.getPais().getNombre()))
                .collect(Collectors.toList());
    }
}
