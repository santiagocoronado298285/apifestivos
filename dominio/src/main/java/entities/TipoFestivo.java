package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipofestivo")
public class TipoFestivo {
    @Id
    private int id;

    @Column(name = "tipo")
    private String tipo;

    public TipoFestivo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoFestivo(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

}
