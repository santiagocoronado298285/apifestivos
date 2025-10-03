package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoFestivoRepositorio extends JpaRepository<TipoFestivo, Integer> {

    @Query("SELECT t FROM TipoFestivo t WHERE t.nombre = ?1")
    public TipoFestivo BuscarTipoFestivo(String nombre);

}
