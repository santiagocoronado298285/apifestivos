package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import entities.TipoFestivo;

@Repository
public interface ITipoFestivoRepositorio extends JpaRepository<TipoFestivo, Integer> {

    @Query("SELECT t FROM TipoFestivo t WHERE t.id = ?1")
    public TipoFestivo BuscarTipoFestivo(int id);

}
