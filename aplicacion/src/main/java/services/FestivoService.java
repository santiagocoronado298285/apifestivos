package services;

import java.util.List;

import org.springframework.stereotype.Service;

import entities.Festivo;
import repositories.IFestivoRepositorio;

@Service
public class FestivoService implements IFestivoService {

    private IFestivoRepositorio repositorio;

    public FestivoService(IFestivoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Festivo> obtenerFestivos() {
        return repositorio.findAll();
    }

    @Override
    public Festivo agregarFestivo(Festivo festivo) {
        return repositorio.save(festivo);
    }

    @Override
    public boolean eliminarFestivo(int id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return !repositorio.existsById(id); 
        }
        return false;
    }

    @Override
    public Festivo actualizarFestivo(Festivo festivo) {
        return repositorio.save(festivo);
    }

    @Override
    public List<Festivo> festivosPorPais(int id) {
        return repositorio.FestivosPorPais(id);
    }

}
