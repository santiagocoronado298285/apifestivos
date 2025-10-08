package services;

import java.util.List;

import entities.Pais;

public interface IPaisService {

    public List<Pais> obtenerPaises();
    public Pais agregarPais(Pais pais);
    public boolean  eliminarPais(int id);
    public Pais actualizarPais(Pais pais);
    public Pais obtenerPaisPorId(int id);
}
