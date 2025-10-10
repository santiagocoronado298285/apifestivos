package festivos.api.controllers;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import DTOs.FestivosPais;
import entities.Festivo;
import services.FestivoService;
import services.PaisService;


@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {

    private final PaisService paisService;
    private final FestivoService festivoService;

    public CalendarioController(PaisService paisService, FestivoService festivoService) {
        this.paisService = paisService;
        this.festivoService = festivoService;
    }
    @PostMapping("/validar/{id}/{anio}/{mes}/{dia}")
    public ResponseEntity<String> validar(  @PathVariable int id,
        @PathVariable int anio,
        @PathVariable int mes,
        @PathVariable int dia) {

            try{
                 List<Festivo> festivos = festivoService.festivosPorPais(id);
                List<FestivosPais> festivosPais = calcularFestivos(anio, festivos);
                LocalDate fechaAValidar = LocalDate.of(anio, mes, dia);

            if (festivosPais.stream().anyMatch(f -> f.getFecha().equals(fechaAValidar))) {
                return ResponseEntity.ok("Es festivo");
            }

            return ResponseEntity.ok("No es festivo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    @PostMapping("/festivospaisanio")
    public ResponseEntity<List<FestivosPais>> festivospaisanio(@RequestParam int anio, @RequestParam int pais) {

        if (anio < 1 || pais < 1) {
            return ResponseEntity.badRequest().body(null);
        }

        try {
            List<Festivo> festivos = festivoService.festivosPorPais(pais);
            List<FestivosPais> festivosPais = calcularFestivos(anio, festivos);
            return ResponseEntity.ok(festivosPais);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private List<FestivosPais> calcularFestivos(int anio, List<Festivo> festivos) {
        List<FestivosPais> festivosPais = new ArrayList<>();

        int a = anio % 19;
        int b = anio % 4;
        int c = anio % 7;
        int d = (19 * a + 24) % 30;
        int dias = (d + (2 * b + 4 * c + 6 * d + 5) % 7);
        LocalDate ramos = LocalDate.of(anio, Month.MARCH, 15).plusDays(dias);
        LocalDate pascua = ramos.plusDays(7);

        for (Festivo festivo : festivos) {
            FestivosPais festivoPais = new FestivosPais();
            festivoPais.setNombre(festivo.getNombre());
            festivoPais.setFecha(calcularFechaFestivo(anio, festivo, pascua));
            festivosPais.add(festivoPais);
        }

        return festivosPais;
    }

    private LocalDate calcularFechaFestivo(int anio, Festivo festivo, LocalDate pascua) {
        switch (festivo.getTipoFestivo().getId()) {
            case 1:
                return LocalDate.of(anio, festivo.getMes(), festivo.getDia());
            case 2:
                return ajustarAlLunes(LocalDate.of(anio, festivo.getMes(), festivo.getDia()));
            case 3:
                return calcularFechaSemanaSanta(festivo.getNombre(), pascua);
            case 4:
                return calcularFechaMovible(festivo.getNombre(), pascua);
            default:
                throw new IllegalArgumentException("Tipo de festivo desconocido: " + festivo.getTipoFestivo().getId());
        }
    }

    private LocalDate ajustarAlLunes(LocalDate fecha) {
        while (fecha.getDayOfWeek().getValue() != 1) {
            fecha = fecha.plusDays(1);
        }
        return fecha;
    }

    private LocalDate calcularFechaSemanaSanta(String nombre, LocalDate pascua) {
        switch (nombre) {
            case "Viernes Santo":
                return pascua.minusDays(2);
            case "Jueves Santo":
                return pascua.minusDays(3);
            case "Domingo de Pascua":
                return pascua;
            case "Carnaval 1":
                return pascua.minusDays(43);
            case "Carnaval 2":
                return pascua.minusDays(42);
            default:
                throw new IllegalArgumentException("Festivo desconocido: " + nombre);
        }
    }

    private LocalDate calcularFechaMovible(String nombre, LocalDate pascua) {
        LocalDate fecha = pascua;
        switch (nombre) {
            case "Ascensión del Señor":
                fecha = fecha.plusDays(40);
                break;
            case "Corpus Christi":
                fecha = fecha.plusDays(60);
                break;
            case "Sagrado Corazón de Jesús":
                fecha = fecha.plusDays(68);
                break;
            default:
                throw new IllegalArgumentException("Festivo desconocido: " + nombre);
        }
        return ajustarAlLunes(fecha);
    }
}


