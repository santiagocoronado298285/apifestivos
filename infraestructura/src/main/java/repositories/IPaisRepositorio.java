package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import entities.Pais;

@Repository
public interface IPaisRepositorio extends JpaRepository<Pais, Integer> {

    @Query("SELECT p FROM Pais p WHERE p.id = ?1")
    public List<Pais> BuscarPais(int id);

}
