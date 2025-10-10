package festivos.api.controllers;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DTOs.FestivosPais;
import entities.Festivo;
import services.FestivoService;
import services.PaisService;


@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {

    private PaisService paisService;
    private FestivoService festivoService;
    

    public CalendarioController(PaisService paisService, FestivoService festivoService) {
        this.paisService = paisService;
        this.festivoService = festivoService;
    }

    public void CalcularFechaFestivos(){


    }
    @PostMapping("/caldomingopascua")
    public List<FestivosPais> festivospaisanio(@RequestParam int anio, @RequestParam int  pais) {

        List<Festivo> festivos = festivoService.festivosPorPais(pais);
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
                if(festivo.getTipoFestivo().getId() == 1){
                    festivoPais.setFecha(LocalDate.of(anio, festivo.getMes(), festivo.getDia()));
                }
                else if(festivo.getTipoFestivo().getId() == 2){
                    LocalDate fecha = LocalDate.of(anio, festivo.getMes(), festivo.getDia());
                    while(fecha.getDayOfWeek().getValue() != 1){
                        fecha = fecha.plusDays(1);
                    }
                    festivoPais.setFecha(fecha);
                }
                else if (festivo.getTipoFestivo().getId() == 3){
                    switch (festivo.getNombre()) {
                        case "Viernes Santo" -> festivoPais.setFecha(pascua.minusDays(2));
                        case "Jueves Santo" -> festivoPais.setFecha(pascua.minusDays(3));
                        case "Domingo de Pascua" -> festivoPais.setFecha(pascua);
                        case "Carnaval 1" -> festivoPais.setFecha(pascua.minusDays(43));
                        case "Carnaval 2" -> festivoPais.setFecha(pascua.minusDays(42));
                        default -> {
                        }
                    }
                }
                else if (festivo.getTipoFestivo().getId() == 4){
                    LocalDate fecha = pascua;
                   switch (festivo.getNombre()) {
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
                           break;
                   }
                  while (fecha.getDayOfWeek().getValue() != 1) { 
                      fecha = fecha.plusDays(1);
                  }
                  festivoPais.setFecha(fecha);
                }
               
                festivosPais.add(festivoPais);
        }

        return festivosPais;
    }
}


