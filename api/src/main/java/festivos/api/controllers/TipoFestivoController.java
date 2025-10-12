package festivos.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import entities.TipoFestivo;
import services.TipoFestivoService;

@RestController
@RequestMapping("api/tiposfestivo")
public class TipoFestivoController {

    private final TipoFestivoService tipoFestivoService;

    public TipoFestivoController(TipoFestivoService tipoFestivoService) {
        this.tipoFestivoService = tipoFestivoService;
    }

    @GetMapping("/listartiposfestivos")
    public List<TipoFestivo> listarTiposFestivos() {
        return tipoFestivoService.obtenerTiposFestivo();
    }

    @PostMapping("/agregartipofestivo")
    public TipoFestivo agregarTipoFestivo(@RequestBody TipoFestivo tipoFestivo) {
        return tipoFestivoService.agregarTipoFestivo(tipoFestivo);
    }

    @DeleteMapping("/eliminartipofestivo/{id}")
    public void eliminarTipoFestivo(@PathVariable int id) {
        tipoFestivoService.eliminarTipoFestivo(id);
    }

    @PutMapping("/actualizartipofestivo/{id}")
    public TipoFestivo actualizarTipoFestivo(@PathVariable int id, @RequestBody TipoFestivo tipoFestivo) {
        TipoFestivo tipofestivoupdate = tipoFestivoService.obtenerTipoFestivo(id);
        tipofestivoupdate.setTipo(tipoFestivo.getTipo());
        return tipoFestivoService.actualizarTipoFestivo(tipofestivoupdate);
    }
}
