/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.simulacion.Class.Eventos.Simulacion;

/**
 *
 * @author nicolastomassi
 */
public class VectorEstado {
    
    private double reloj;
    
    /*
    llegada de buque
    */
    private double rndLlegadaBuque;
    private double tiempoLlegadaBuque;
    private double proximaLlegada;
    
    /*
    ingreso a puerto
    */
    private double rndCarga;
    private double cargaBuque;
   
    //tanques costeros
    
    private double tiempoInicioCargaT1, tiempoFinCargaT1, tiempoFinDescargaT1, capacidadLibreT1;
    private double tiempoInicioCargaT2, tiempoFinCargaT2, tiempoFinDescargaT2, capacidadLibreT2;
    private double tiempoInicioCargaT3, tiempoFinCargaT3, tiempoFinDescargaT3, capacidadLibreT3;
    private double tiempoInicioCargaT4, tiempoFinCargaT4, tiempoFinDescargaT4, capacidadLibreT4;
    private double tiempoInicioCargaT5, tiempoFinCargaT5, tiempoFinDescargaT5, capacidadLibreT5;
    
    private String estadoT1;
    private String estadoT2;
    private String estadoT3;
    private String estadoT4;
    private String estadoT5;
    
    // buques
    
    private double cargaActualB1;
    private double cargaActualB2;
    private double cargaActualB3;
    private double cargaActualB4;
    private double cargaActualB5;
    
    
    private String estadoB1;
    private String estadoB2;
    private String estadoB3;
    private String estadoB4;
    private String estadoB5;
    
    // cola
    
    private int cola;
     
    //Vector que ayuda para ver cual es el proximo evento
    private double[] eventos;
    
    
    public VectorEstado(double reloj, double rndLlegada, double tiempoLlegada, double proxLlegada,
            double rndCarga, double cargaBuque,
            double inicioT1, double finT1, double finDescargaT1, double capacidadT1, String estadoT1,
            double inicioT2, double finT2, double finDescargaT2, double capacidadT2, String estadoT2,
            double inicioT3, double finT3, double finDescargaT3, double capacidadT3, String estadoT3,
            double inicioT4, double finT4, double finDescargaT4, double capacidadT4, String estadoT4,
            double inicioT5, double finT5, double finDescargaT5, double capacidadT5, String estadoT5,
            double cargaActualB1, double cargaActualB2, double cargaActualB3, double cargaActualB4, double cargaActualB5,
            String estadoB1, String estadoB2, String estadoB3, String estadoB4, String estadoB5, int cola) {
        this.reloj = reloj;
        this.rndLlegadaBuque = rndLlegada;
        this.tiempoLlegadaBuque = tiempoLlegada;
        this.proximaLlegada = proxLlegada;
        this.rndCarga = rndCarga;
        this.cargaBuque = cargaBuque;
        this.tiempoInicioCargaT1 = inicioT1;
        this.tiempoInicioCargaT2 = inicioT2;
        this.tiempoInicioCargaT3 = inicioT3;
        this.tiempoInicioCargaT4 = inicioT4;
        this.tiempoInicioCargaT5 = inicioT5;
        this.tiempoFinCargaT1 = finT1;
        this.tiempoFinCargaT2 = finT2;
        this.tiempoFinCargaT3 = finT3;
        this.tiempoFinCargaT4 = finT4;
        this.tiempoFinCargaT5 = finT5;
        this.tiempoFinDescargaT1 = finDescargaT1;
        this.tiempoFinDescargaT2 = finDescargaT2;
        this.tiempoFinDescargaT3 = finDescargaT3;
        this.tiempoFinDescargaT4 = finDescargaT4;
        this.tiempoFinDescargaT5 = finDescargaT5;
        this.capacidadLibreT1 = capacidadT1;
        this.capacidadLibreT2 = capacidadT2;
        this.capacidadLibreT3 = capacidadT3;
        this.capacidadLibreT4 = capacidadT4;
        this.capacidadLibreT5 = capacidadT5;
        this.estadoT1 = estadoT1;
        this.estadoT2 = estadoT2;
        this.estadoT3 = estadoT3;
        this.estadoT4 = estadoT4;
        this.estadoT5 = estadoT5;
        this.cargaActualB1 = cargaActualB1;
        this.cargaActualB2 = cargaActualB2;
        this.cargaActualB3 = cargaActualB3;
        this.cargaActualB4 = cargaActualB4;
        this.cargaActualB5 = cargaActualB5;
        this.estadoB1 = estadoB1;
        this.estadoB2 = estadoB2;
        this.estadoB3 = estadoB3;
        this.estadoB4 = estadoB4;
        this.estadoB5 = estadoB5;
        this.cola = cola;
    }

    public double getProxEventoHora(){
        
        this.eventos = new double[11];
        this.eventos[0] = this.proximaLlegada;
        this.eventos[1] = this.tiempoFinCargaT1;
        this.eventos[2] = this.tiempoFinCargaT2;
        this.eventos[3] = this.tiempoFinCargaT3;
        this.eventos[4] = this.tiempoFinCargaT4;
        this.eventos[5] = this.tiempoFinCargaT5;
        this.eventos[6] = this.tiempoFinDescargaT1;
        this.eventos[7] = this.tiempoFinDescargaT2;
        this.eventos[8] = this.tiempoFinDescargaT3;
        this.eventos[9] = this.tiempoFinDescargaT4;
        this.eventos[10] = this.tiempoFinDescargaT5;
        double menor = this.proximaLlegada;
        for ( int i = 1; i< eventos.length ; i++){
            if ( i < menor && i >= 0 ){
                menor = i;
            } 
        }
        System.out.println("EL menor es : "+ menor);
        return menor;
    }
    public double getReloj() {
        return reloj;
    }

    public void setReloj(double reloj) {
        this.reloj = reloj;
    }

    public double getRndLlegadaBuque() {
        return rndLlegadaBuque;
    }

    public void setRndLlegadaBuque(double rndLLegadaBuque) {
        this.rndLlegadaBuque = rndLLegadaBuque;
    }

    public double getTiempoLlegadaBuque() {
        return tiempoLlegadaBuque;
    }

    public void setTiempoLlegadaBuque(double tiempoLLegadaBuque) {
        this.tiempoLlegadaBuque = tiempoLLegadaBuque;
    }

    public double getProximaLllegada() {
        return proximaLlegada;
    }

    public void setProximaLllegada(double proximaLllegada) {
        this.proximaLlegada = proximaLllegada;
    }

    public double getRndCarga() {
        return rndCarga;
    }

    public void setRndCarga(double rndCarga) {
        this.rndCarga = rndCarga;
    }

    public double getCargaBuque() {
        return cargaBuque;
    }

    public void setCargaBuque(double cargaBuque) {
        this.cargaBuque = cargaBuque;
    }

    public double getTiempoInicioCargaT1() {
        return tiempoInicioCargaT1;
    }

    public void setTiempoInicioCargaT1(double tiempoInicioCargaT1) {
        this.tiempoInicioCargaT1 = tiempoInicioCargaT1;
    }

    public double getTiempoFinCargaT1() {
        return tiempoFinCargaT1;
    }

    public void setTiempoFinCargaT1(double tiempoFinCargaT1) {
        this.tiempoFinCargaT1 = tiempoFinCargaT1;
    }

    public double getTiempoFinDescargaT1() {
        return tiempoFinDescargaT1;
    }

    public void setTiempoFinDescargaT1(double tiempoFinDescargaT1) {
        this.tiempoFinDescargaT1 = tiempoFinDescargaT1;
    }

    public double getCapacidadLibreT1() {
        return capacidadLibreT1;
    }

    public void setCapacidadLibreT1(double capacidadLibreT1) {
        this.capacidadLibreT1 = capacidadLibreT1;
    }

    public double getTiempoInicioCargaT2() {
        return tiempoInicioCargaT2;
    }

    public void setTiempoInicioCargaT2(double tiempoInicioCargaT2) {
        this.tiempoInicioCargaT2 = tiempoInicioCargaT2;
    }

    public double getTiempoFinCargaT2() {
        return tiempoFinCargaT2;
    }

    public void setTiempoFinCargaT2(double tiempoFinCargaT2) {
        this.tiempoFinCargaT2 = tiempoFinCargaT2;
    }

    public double getTiempoFinDescargaT2() {
        return tiempoFinDescargaT2;
    }

    public void setTiempoFinDescargaT2(double tiempoFinDescargaT2) {
        this.tiempoFinDescargaT2 = tiempoFinDescargaT2;
    }

    public double getCapacidadLibreT2() {
        return capacidadLibreT2;
    }

    public void setCapacidadLibreT2(double capacidadLibreT2) {
        this.capacidadLibreT2 = capacidadLibreT2;
    }

    public double getTiempoInicioCargaT3() {
        return tiempoInicioCargaT3;
    }

    public void setTiempoInicioCargaT3(double tiempoInicioCargaT3) {
        this.tiempoInicioCargaT3 = tiempoInicioCargaT3;
    }

    public double getTiempoFinCargaT3() {
        return tiempoFinCargaT3;
    }

    public void setTiempoFinCargaT3(double tiempoFinCargaT3) {
        this.tiempoFinCargaT3 = tiempoFinCargaT3;
    }

    public double getTiempoFinDescargaT3() {
        return tiempoFinDescargaT3;
    }

    public void setTiempoFinDescargaT3(double tiempoFinDescargaT3) {
        this.tiempoFinDescargaT3 = tiempoFinDescargaT3;
    }

    public double getCapacidadLibreT3() {
        return capacidadLibreT3;
    }

    public void setCapacidadLibreT3(double capacidadLibreT3) {
        this.capacidadLibreT3 = capacidadLibreT3;
    }

    public double getTiempoInicioCargaT4() {
        return tiempoInicioCargaT4;
    }

    public void setTiempoInicioCargaT4(double tiempoInicioCargaT4) {
        this.tiempoInicioCargaT4 = tiempoInicioCargaT4;
    }

    public double getTiempoFinCargaT4() {
        return tiempoFinCargaT4;
    }

    public void setTiempoFinCargaT4(double tiempoFinCargaT4) {
        this.tiempoFinCargaT4 = tiempoFinCargaT4;
    }

    public double getTiempoFinDescargaT4() {
        return tiempoFinDescargaT4;
    }

    public void setTiempoFinDescargaT4(double tiempoFinDescargaT4) {
        this.tiempoFinDescargaT4 = tiempoFinDescargaT4;
    }

    public double getCapacidadLibreT4() {
        return capacidadLibreT4;
    }

    public void setCapacidadLibreT4(double capacidadLibreT4) {
        this.capacidadLibreT4 = capacidadLibreT4;
    }

    public double getTiempoInicioCargaT5() {
        return tiempoInicioCargaT5;
    }

    public void setTiempoInicioCargaT5(double tiempoInicioCargaT5) {
        this.tiempoInicioCargaT5 = tiempoInicioCargaT5;
    }

    public double getTiempoFinCargaT5() {
        return tiempoFinCargaT5;
    }

    public void setTiempoFinCargaT5(double tiempoFinCargaT5) {
        this.tiempoFinCargaT5 = tiempoFinCargaT5;
    }

    public double getTiempoFinDescargaT5() {
        return tiempoFinDescargaT5;
    }

    public void setTiempoFinDescargaT5(double tiempoFinDescargaT5) {
        this.tiempoFinDescargaT5 = tiempoFinDescargaT5;
    }

    public double getCapacidadLibreT5() {
        return capacidadLibreT5;
    }

    public void setCapacidadLibreT5(double capacidadLibreT5) {
        this.capacidadLibreT5 = capacidadLibreT5;
    }

    public String getEstadoT1() {
        return estadoT1;
    }

    public void setEstadoT1(String estadoT1) {
        this.estadoT1 = estadoT1;
    }

    public String getEstadoT2() {
        return estadoT2;
    }

    public void setEstadoT2(String estadoT2) {
        this.estadoT2 = estadoT2;
    }

    public String getEstadoT3() {
        return estadoT3;
    }

    public void setEstadoT3(String estadoT3) {
        this.estadoT3 = estadoT3;
    }

    public String getEstadoT4() {
        return estadoT4;
    }

    public void setEstadoT4(String estadoT4) {
        this.estadoT4 = estadoT4;
    }

    public String getEstadoT5() {
        return estadoT5;
    }

    public void setEstadoT5(String estadoT5) {
        this.estadoT5 = estadoT5;
    }

    public double getCargaActualB1() {
        return cargaActualB1;
    }

    public void setCargaActualB1(double cargaActualB1) {
        this.cargaActualB1 = cargaActualB1;
    }

    public double getCargaActualB2() {
        return cargaActualB2;
    }

    public void setCargaActualB2(double cargaActualB2) {
        this.cargaActualB2 = cargaActualB2;
    }

    public double getCargaActualB3() {
        return cargaActualB3;
    }

    public void setCargaActualB3(double cargaActualB3) {
        this.cargaActualB3 = cargaActualB3;
    }

    public double getCargaActualB4() {
        return cargaActualB4;
    }

    public void setCargaActualB4(double cargaActualB4) {
        this.cargaActualB4 = cargaActualB4;
    }

    public double getCargaActualB5() {
        return cargaActualB5;
    }

    public void setCargaActualB5(double cargaActualB5) {
        this.cargaActualB5 = cargaActualB5;
    }

    public String getEstadoB1() {
        return estadoB1;
    }

    public void setEstadoB1(String estadoB1) {
        this.estadoB1 = estadoB1;
    }

    public String getEstadoB2() {
        return estadoB2;
    }

    public void setEstadoB2(String estadoB2) {
        this.estadoB2 = estadoB2;
    }

    public String getEstadoB3() {
        return estadoB3;
    }

    public void setEstadoB3(String estadoB3) {
        this.estadoB3 = estadoB3;
    }

    public String getEstadoB4() {
        return estadoB4;
    }

    public void setEstadoB4(String estadoB4) {
        this.estadoB4 = estadoB4;
    }

    public String getEstadoB5() {
        return estadoB5;
    }

    public void setEstadoB5(String estadoB5) {
        this.estadoB5 = estadoB5;
    }

    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }


 
}

