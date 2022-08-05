package entities;

public class PartidoEntity {

    private String player1;
    private String player2;
    private String nombreTorneo;
    private Integer cantidadSets;
    private Double probabilidadPlayer1;
    private Double probabilidadPlayer2;

    public PartidoEntity() {
    }

    public PartidoEntity(String player1, String player2, String nombreTorneo, Integer cantidadSets, Double probabilidadPlayer1, Double probabilidadPlayer2) {
        this.player1 = player1;
        this.player2 = player2;
        this.nombreTorneo = nombreTorneo;
        this.cantidadSets = cantidadSets;
        this.probabilidadPlayer1 = probabilidadPlayer1;
        this.probabilidadPlayer2 = probabilidadPlayer2;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }


    public String getNombreTorneo() {
        return nombreTorneo;
    }


    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }


    public Integer getCantidadSets() {
        return cantidadSets;
    }


    public void setCantidadSets(Integer cantidadSets) {
        this.cantidadSets = cantidadSets;
    }

    public Double getProbabilidadPlayer1() {
        return probabilidadPlayer1;
    }

    public void setProbabilidadPlayer1(Double probabilidadPlayer1) {
        this.probabilidadPlayer1 = probabilidadPlayer1;
    }

 
    public Double getProbabilidadPlayer2() {
        return probabilidadPlayer2;
    }


    public void setProbabilidadPlayer2(Double probabilidadPlayer2) {
        this.probabilidadPlayer2 = probabilidadPlayer2;
    }
    
    

 
}
