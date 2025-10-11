package festivos.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import DTOs.FestivoDTO;
import entities.Festivo;
import entities.Pais;
import entities.TipoFestivo;
import services.FestivoService;
import services.PaisService;
import services.TipoFestivoService;


@RestController
@RequestMapping("/api/festivos")
public class FestivoController {

private FestivoService festivoService;
private final PaisService paisService;
private final TipoFestivoService tipoFestivoService;

    public FestivoController(FestivoService festivoService, PaisService paisService, TipoFestivoService tipoFestivoService) {
        this.festivoService = festivoService;
        this.paisService = paisService;
        this.tipoFestivoService = tipoFestivoService;
    }

    @GetMapping("/listarfestivos")
    public List<FestivoDTO> listarFestivos() {
        List<Festivo> festivos = festivoService.obtenerFestivos();
        return festivos.stream()
                .map(festivo -> new FestivoDTO(festivo.getNombre(), festivo.getDia(), festivo.getMes(), festivo.getPais().getNombre(), festivo.getTipoFestivo().getTipo()))
                .collect(Collectors.toList());
    }

    @PostMapping("/agregarfestivo")
    public Festivo agregarFestivo(@RequestBody Festivo festivo) {

        try{
            Pais pais = paisService.obtenerPaisPorId(festivo.getPais().getId());
            TipoFestivo tipoFestivo = tipoFestivoService.obtenerTipoFestivo(festivo.getTipoFestivo().getId());
            festivo.setPais(pais);
            festivo.setTipoFestivo(tipoFestivo);
            return festivoService.agregarFestivo(festivo);
        }
        catch(IllegalArgumentException e){
            throw new RuntimeException("Error al agregar el festivo: " + e.getMessage());
        }
       
    }

    @PostMapping("/eliminarfestivo/{id}")
    public boolean eliminarFestivo(@PathVariable int id) {

        return festivoService.eliminarFestivo(id);
    }
    
}
