package services;
import entities.TipoFestivo;
import java.util.List;

public interface ITipoFestivoService {

    public List<TipoFestivo> obtenerTiposFestivo();
    public TipoFestivo agregarTipoFestivo(TipoFestivo tipoFestivo);
    public void eliminarTipoFestivo(int id);
    public TipoFestivo actualizarTipoFestivo(int id, TipoFestivo tipoFestivo);
    public TipoFestivo obtenerTipoFestivoPorId(int id);
}
