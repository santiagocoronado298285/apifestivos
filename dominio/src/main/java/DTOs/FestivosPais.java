package DTOs;

import java.time.LocalDate;
import java.util.List;

import entities.Festivo;


public class FestivosPais {

   public String nombre;
   public LocalDate fecha;

    public FestivosPais() {
    }

    public FestivosPais(LocalDate fecha, String nombre) {
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }



}
