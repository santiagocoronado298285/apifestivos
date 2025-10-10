package services;
import java.util.List;

import entities.Festivo;

public interface IFestivoService {
    
    public List<Festivo> obtenerFestivos();
    public Festivo agregarFestivo(Festivo festivo);
    public void eliminarFestivo(int id);
    public Festivo actualizarFestivo(Festivo festivo);
    public List<Festivo> festivosPorPais(int id);

}
