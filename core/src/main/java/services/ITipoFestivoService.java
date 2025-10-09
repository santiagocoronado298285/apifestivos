package services;
import java.util.List;

import entities.TipoFestivo;

public interface ITipoFestivoService {

    public List<TipoFestivo> obtenerTiposFestivo();
    public TipoFestivo agregarTipoFestivo(TipoFestivo tipoFestivo);
    public void eliminarTipoFestivo(int id);
    public TipoFestivo actualizarTipoFestivo(TipoFestivo tipoFestivo);
    public TipoFestivo obtenerTipoFestivoPorNombre(String nombre);
}
