package services;

import entities.Pais;
import java.util.List;

public interface IPaisService {

    public List<Pais> obtenerPaises();
    public Pais agregarPais(Pais pais);
    public void eliminarPais(int id);
    public Pais actualizarPais(int id, Pais pais);
    public Pais obtenerPaisPorId(int id);
}
