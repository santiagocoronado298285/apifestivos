package services;
import java.util.List;

import entities.Festivo;

public interface IFestivoService {
    
    public List<Festivo> obtenerFestivos();
    public Festivo agregarFestivo(Festivo festivo);
    public boolean eliminarFestivo(int id);
    public Festivo actualizarFestivo(Festivo festivo);
    public List<Festivo> festivosPorPais(int id);
    public Festivo festivoPorId(int id);

}
