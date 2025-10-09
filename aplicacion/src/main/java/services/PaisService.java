package services;

import java.util.List;

import org.springframework.stereotype.Service;

import entities.Pais;
import repositories.IPaisRepositorio;

@Service
public class PaisService implements IPaisService {

    private IPaisRepositorio repositorio;

   
    public PaisService(IPaisRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Pais> obtenerPaises() {
        return repositorio.findAll();
    }

    @Override
    public Pais agregarPais(Pais pais) {
        pais.setId(0);
        return repositorio.save(pais);
    }

    @Override
    public boolean eliminarPais(int id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Pais actualizarPais(Pais pais) {
        if (!repositorio.existsById(pais.getId())) {
            return null;
        }
        return repositorio.save(pais);
    }

    @Override
    public Pais obtenerPaisPorId(int id) {
        List<Pais> paises = repositorio.BuscarPais(id);
        return paises.isEmpty() ? null : paises.get(0);
    }

}
