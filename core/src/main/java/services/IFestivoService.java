package services;
import entities.Festivo;
import java.util.List;

public interface IFestivoService {
    
    public List<Festivo> obtenerFestivos();
    public Festivo agregarFestivo(Festivo festivo);
    public void eliminarFestivo(int id);
    public Festivo actualizarFestivo(int id, Festivo festivo);
    public Festivo obtenerFestivoPorId(int id);
}
