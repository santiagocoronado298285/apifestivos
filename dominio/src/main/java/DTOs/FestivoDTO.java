package DTOs;

public class FestivoDTO {
    private String nombre;
    private int dia;
    private int mes;
    private String pais;
    private String tipofestivo;

    public FestivoDTO() {}

    public FestivoDTO(String nombre, int dia, int mes, String pais, String tipofestivo) {
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.pais = pais;
        this.tipofestivo = tipofestivo;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipofestivo() {
        return tipofestivo;
    }

    public void setTipofestivo(String tipofestivo) {
        this.tipofestivo = tipofestivo;
    }

}
