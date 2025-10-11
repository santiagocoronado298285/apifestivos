package services;

import java.util.List;

import org.springframework.stereotype.Service;

import entities.TipoFestivo;
import repositories.ITipoFestivoRepositorio;

@Service
public class TipoFestivoService implements ITipoFestivoService {

    private ITipoFestivoRepositorio repositorio;

    public TipoFestivoService(ITipoFestivoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<TipoFestivo> obtenerTiposFestivo() {
        return repositorio.findAll();
    }

    @Override
    public TipoFestivo agregarTipoFestivo(TipoFestivo tipoFestivo) {
        return repositorio.save(tipoFestivo);
    }

    @Override
    public void eliminarTipoFestivo(int id) {
        repositorio.deleteById(id);
    }

    @Override
    public TipoFestivo actualizarTipoFestivo(TipoFestivo tipoFestivo) {

        return repositorio.save(tipoFestivo);
    }

    @Override
    public TipoFestivo obtenerTipoFestivo(int id) {
        return repositorio.BuscarTipoFestivo(id);
    }

}
