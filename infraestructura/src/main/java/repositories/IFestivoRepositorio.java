package repositories;
import entities.Festivo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {
    
    @Query("SELECT f FROM Festivo f WHERE f.pais.id = ?1")
    public List<Festivo> FestivosPorPais(int idPais);

}
