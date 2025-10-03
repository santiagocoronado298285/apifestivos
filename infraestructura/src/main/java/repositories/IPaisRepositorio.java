package repositories;

import entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaisRepositorio extends JpaRepository<Pais, Integer> {

    @Query("SELECT p FROM Pais p WHERE p.codigo = ?1")
    public Pais BuscarPais(String codigo);

}
