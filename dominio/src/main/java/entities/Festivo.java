package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "festivo")
public class Festivo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
