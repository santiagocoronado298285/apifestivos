package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "festivo")
public class Festivo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_festivo")
    @SequenceGenerator(name = "secuencia_festivo", sequenceName = "secuencia_festivo", allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idpais", referencedColumnName = "id")
    private Pais pais;

    @Column(name = "nombre", length = 100, unique = false)
    private String nombre;

    @Column(name = "dia", length = 2, unique = false)
    private int dia;
    
    @Column(name = "mes", length = 2, unique = false)
    private int mes;
    
    @Column(name = "diaspascua", length = 2, unique = false)
    private int diaspascua;

    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private TipoFestivo tipoFestivo;

    public Festivo() {
    }

    public Festivo(int dia, int diaspascua, int id, int mes, String nombre, Pais pais, TipoFestivo tipoFestivo) {
        this.dia = dia;
        this.diaspascua = diaspascua;
        this.id = id;
        this.mes = mes;
        this.nombre = nombre;
        this.pais = pais;
        this.tipoFestivo = tipoFestivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDiaspascua() {
        return diaspascua;
    }

    public void setDiaspascua(int diaspascua) {
        this.diaspascua = diaspascua;
    }

    public TipoFestivo getTipoFestivo() {
        return tipoFestivo;
    }

    public void setTipoFestivo(TipoFestivo tipoFestivo) {
        this.tipoFestivo = tipoFestivo;
    }
}
