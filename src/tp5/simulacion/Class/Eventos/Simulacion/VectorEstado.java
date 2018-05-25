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
    private double rndLLegadaBuque;
    private double tiempoLLegadaBuque;
    private double proximaLllegada;
    private double rndCarga;
    private double cargaBuque;
   
    //tanques costeros
    
    private double capacidadLibreT1;
    private String estadoT1;
    private double tiempoProximaInterrupcionT1;
    private double tiempoDescargaT1;
    private double capacidadLibreT2;
    private String estadoT2;
    private double tiempoProximaInterrupcionT2;
    private double tiempoDescargaT2;
    private double capacidadLibreT3;
    private String estadoT3;
    private double tiempoProximaInterrupcionT3;
    private double tiempoDescargaT3;
    private double capacidadLibreT4;
    private String estadoT4;
    private double tiempoProximaInterrupcionT4;
    private double tiempoDescargaT4;
    private double capacidadLibreT5;
    private String estadoT5;
    private double tiempoProximaInterrupcionT5;
    private double tiempoDescargaT5;

    // buques
    
    private double cargaRemanenteB1;
    private String estadoB1;
    private double finCargaB1;
    private String enTanqueB1;
    private double cargaRemanenteB2;
    private String estadoB2;
    private double finCargaB2;
    private String enTanqueB2;
    private double cargaRemanenteB3;
    private String estadoB3;
    private double finCargaB3;
    private String enTanqueB3;
    private double cargaRemanenteB4;
    private String estadoB4;
    private double finCargaB4;
    private String enTanqueB4;
    private double cargaRemanenteB5;
    private String estadoB5;
    private double finCargaB5;
    private String enTanqueB5;
    
    // cola
    
    private int cola;
    
    /*public VectorEstado(double reloj, double rndLlBuque, double tiempoLlBuque, double proxLlBuque, double rndCarga, int carga, double capacidadLibre[], String estadoTank[], double tiempoInterrupcion[], double tiempoDescarga[], 
            double cargaRemanente[], String estadoBuque[], double finCarga[], String enTanque[], int cola){
        
        this.reloj = reloj;
        this.rndLLegadaBuque = rndLlBuque;
        this.proximaLllegada = proxLlBuque;
        this.rndCarga = rndCarga;
        this.cargaBuque = carga;
        this.cola = cola;
        
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                this.capacidadLibreT1 = capacidadLibre[i];
                this.tiempoProximaInterrupcionT1 = tiempoInterrupcion[i];
                this.estadoT1 = estadoTank[i];
                this.tiempoDescargaT1 = tiempoDescarga[i];
                this.cargaRemanenteB1 = cargaRemanente[i];
                this.estadoB1 = estadoBuque[i];
                this.finCargaB1 = finCarga[i];
                this.enTanqueB1 = enTanque[i];
                continue;
            }
            if (i == 1) {
                this.capacidadLibreT2 = capacidadLibre[i];
                this.tiempoProximaInterrupcionT2 = tiempoInterrupcion[i];
                this.estadoT2 = estadoTank[i];
                this.tiempoDescargaT2 = tiempoDescarga[i];
                this.cargaRemanenteB2 = cargaRemanente[i];
                this.estadoB2 = estadoBuque[i];
                this.finCargaB2 = finCarga[i];
                this.enTanqueB2 = enTanque[i];
                continue;
            }
            if (i == 2) {
                this.capacidadLibreT3 = capacidadLibre[i];
                this.tiempoProximaInterrupcionT3 = tiempoInterrupcion[i];
                this.estadoT3 = estadoTank[i];
                this.tiempoDescargaT3 = tiempoDescarga[i];
                this.cargaRemanenteB3 = cargaRemanente[i];
                this.estadoB3 = estadoBuque[i];
                this.finCargaB3 = finCarga[i];
                this.enTanqueB3 = enTanque[i];
                continue;
            }
            if (i == 3) {
                this.capacidadLibreT4 = capacidadLibre[i];
                this.tiempoProximaInterrupcionT4 = tiempoInterrupcion[i];
                this.estadoT4 = estadoTank[i];
                this.tiempoDescargaT4 = tiempoDescarga[i];
                this.cargaRemanenteB4 = cargaRemanente[i];
                this.estadoB4 = estadoBuque[i];
                this.finCargaB4 = finCarga[i];
                this.enTanqueB4 = enTanque[i];
                continue;
            }
            if (i == 4) {
                this.capacidadLibreT5 = capacidadLibre[i];
                this.tiempoProximaInterrupcionT5 = tiempoInterrupcion[i];
                this.estadoT5 = estadoTank[i];
                this.tiempoDescargaT5 = tiempoDescarga[i];
                this.cargaRemanenteB5 = cargaRemanente[i];
                this.estadoB5 = estadoBuque[i];
                this.finCargaB5 = finCarga[i];
                this.enTanqueB5 = enTanque[i];
                continue;
            }
        }
        
    }*/

    public VectorEstado(double reloj, double rndLLegadaBuque, double tiempoLLegadaBuque, double proximaLllegada, 
                        double rndCarga, double cargaBuque, 
                        double capacidadLibreT1, String estadoT1, double tiempoProximaInterrupcionT1, double tiempoDescargaT1, 
                        double capacidadLibreT2, String estadoT2, double tiempoProximaInterrupcionT2, double tiempoDescargaT2, 
                        double capacidadLibreT3, String estadoT3, double tiempoProximaInterrupcionT3, double tiempoDescargaT3, 
                        double capacidadLibreT4, String estadoT4, double tiempoProximaInterrupcionT4, double tiempoDescargaT4, 
                        double capacidadLibreT5, String estadoT5, double tiempoProximaInterrupcionT5, double tiempoDescargaT5, 
                        double cargaRemanenteB1, String estadoB1, double finCargaB1, String enTanqueB1, 
                        double cargaRemanenteB2, String estadoB2, double finCargaB2, String enTanqueB2, 
                        double cargaRemanenteB3, String estadoB3, double finCargaB3, String enTanqueB3, 
                        double cargaRemanenteB4, String estadoB4, double finCargaB4, String enTanqueB4, 
                        double cargaRemanenteB5, String estadoB5, double finCargaB5, String enTanqueB5, int cola) {
        this.reloj = reloj;
        this.rndLLegadaBuque = rndLLegadaBuque;
        this.tiempoLLegadaBuque = tiempoLLegadaBuque;
        this.proximaLllegada = proximaLllegada;
        this.rndCarga = rndCarga;
        this.cargaBuque = cargaBuque;
        this.capacidadLibreT1 = capacidadLibreT1;
        this.estadoT1 = estadoT1;
        this.tiempoProximaInterrupcionT1 = tiempoProximaInterrupcionT1;
        this.tiempoDescargaT1 = tiempoDescargaT1;
        this.capacidadLibreT2 = capacidadLibreT2;
        this.estadoT2 = estadoT2;
        this.tiempoProximaInterrupcionT2 = tiempoProximaInterrupcionT2;
        this.tiempoDescargaT2 = tiempoDescargaT2;
        this.capacidadLibreT3 = capacidadLibreT3;
        this.estadoT3 = estadoT3;
        this.tiempoProximaInterrupcionT3 = tiempoProximaInterrupcionT3;
        this.tiempoDescargaT3 = tiempoDescargaT3;
        this.capacidadLibreT4 = capacidadLibreT4;
        this.estadoT4 = estadoT4;
        this.tiempoProximaInterrupcionT4 = tiempoProximaInterrupcionT4;
        this.tiempoDescargaT4 = tiempoDescargaT4;
        this.capacidadLibreT5 = capacidadLibreT5;
        this.estadoT5 = estadoT5;
        this.tiempoProximaInterrupcionT5 = tiempoProximaInterrupcionT5;
        this.tiempoDescargaT5 = tiempoDescargaT5;
        this.cargaRemanenteB1 = cargaRemanenteB1;
        this.estadoB1 = estadoB1;
        this.finCargaB1 = finCargaB1;
        this.enTanqueB1 = enTanqueB1;
        this.cargaRemanenteB2 = cargaRemanenteB2;
        this.estadoB2 = estadoB2;
        this.finCargaB2 = finCargaB2;
        this.enTanqueB2 = enTanqueB2;
        this.cargaRemanenteB3 = cargaRemanenteB3;
        this.estadoB3 = estadoB3;
        this.finCargaB3 = finCargaB3;
        this.enTanqueB3 = enTanqueB3;
        this.cargaRemanenteB4 = cargaRemanenteB4;
        this.estadoB4 = estadoB4;
        this.finCargaB4 = finCargaB4;
        this.enTanqueB4 = enTanqueB4;
        this.cargaRemanenteB5 = cargaRemanenteB5;
        this.estadoB5 = estadoB5;
        this.finCargaB5 = finCargaB5;
        this.enTanqueB5 = enTanqueB5;
        this.cola = cola;
    }


    
    

    public double getReloj() {
        return reloj;
    }

    public double getRndLLegadaBuque() {
        return rndLLegadaBuque;
    }

    public double getTiempoLLegadaBuque() {
        return tiempoLLegadaBuque;
    }

    public double getProximaLllegada() {
        return proximaLllegada;
    }

    public double getRndCarga() {
        return rndCarga;
    }

    public double getCargaBuque() {
        return cargaBuque;
    }

    public double getCapacidadLibreT1() {
        return capacidadLibreT1;
    }

    public String getEstadoT1() {
        return estadoT1;
    }

    public double getTiempoProximaInterrupcionT1() {
        return tiempoProximaInterrupcionT1;
    }

    public double getTiempoDescargaT1() {
        return tiempoDescargaT1;
    }

    public double getTiempoDescargaT2() {
        return tiempoDescargaT2;
    }

    public String getEstadoT2() {
        return estadoT2;
    }

    public double getTiempoProximaInterrupcionT2() {
        return tiempoProximaInterrupcionT2;
    }

    public double getCapacidadLibreT2() {
        return capacidadLibreT2;
    }

    public double getCapacidadLibreT3() {
        return capacidadLibreT3;
    }

    public String getEstadoT3() {
        return estadoT3;
    }

    public double getTiempoProximaInterrupcionT3() {
        return tiempoProximaInterrupcionT3;
    }

    public double getTiempoDescargaT3() {
        return tiempoDescargaT3;
    }

    public double getCapacidadLibreT4() {
        return capacidadLibreT4;
    }

    public String getEstadoT4() {
        return estadoT4;
    }

    public double getTiempoProximaInterrupcionT4() {
        return tiempoProximaInterrupcionT4;
    }

    public double getTiempoDescargaT4() {
        return tiempoDescargaT4;
    }

    public double getCapacidadLibreT5() {
        return capacidadLibreT5;
    }

    public String getEstadoT5() {
        return estadoT5;
    }

    public double getTiempoProximaInterrupcionT5() {
        return tiempoProximaInterrupcionT5;
    }

    public double getTiempoDescargaT5() {
        return tiempoDescargaT5;
    }

    public double getCargaRemanenteB1() {
        return cargaRemanenteB1;
    }

    public String getEstadoB1() {
        return estadoB1;
    }

    public double getFinCargaB1() {
        return finCargaB1;
    }

    public String getEnTanqueB1() {
        return enTanqueB1;
    }

    public double getCargaRemanenteB2() {
        return cargaRemanenteB2;
    }

    public String getEstadoB2() {
        return estadoB2;
    }

    public double getFinCargaB2() {
        return finCargaB2;
    }

    public String getEnTanqueB2() {
        return enTanqueB2;
    }

    public double getCargaRemanenteB3() {
        return cargaRemanenteB3;
    }

    public String getEstadoB3() {
        return estadoB3;
    }

    public double getFinCargaB3() {
        return finCargaB3;
    }

    public String getEnTanqueB3() {
        return enTanqueB3;
    }

    public double getCargaRemanenteB4() {
        return cargaRemanenteB4;
    }

    public String getEstadoB4() {
        return estadoB4;
    }

    public double getFinCargaB4() {
        return finCargaB4;
    }

    public String getEnTanqueB4() {
        return enTanqueB4;
    }

    public double getCargaRemanenteB5() {
        return cargaRemanenteB5;
    }

    public String getEstadoB5() {
        return estadoB5;
    }

    public double getFinCargaB5() {
        return finCargaB5;
    }

    public String getEnTanqueB5() {
        return enTanqueB5;
    }

    public int getCola() {
        return cola;
    }

    public void setReloj(double reloj) {
        this.reloj = reloj;
    }

    public void setRndLLegadaBuque(double rndLLegadaBuque) {
        this.rndLLegadaBuque = rndLLegadaBuque;
    }

    public void setTiempoLLegadaBuque(double tiempoLLegadaBuque) {
        this.tiempoLLegadaBuque = tiempoLLegadaBuque;
    }

    public void setProximaLllegada(double proximaLllegada) {
        this.proximaLllegada = proximaLllegada;
    }

    public void setRndCarga(double rndCarga) {
        this.rndCarga = rndCarga;
    }

    public void setCargaBuque(int cargaBuque) {
        this.cargaBuque = cargaBuque;
    }

    public void setCapacidadLibreT1(double capacidadLibreT1) {
        this.capacidadLibreT1 = capacidadLibreT1;
    }

    public void setEstadoT1(String estadoT1) {
        this.estadoT1 = estadoT1;
    }

    public void setTiempoProximaInterrupcionT1(double tiempoProximaInterrupcionT1) {
        this.tiempoProximaInterrupcionT1 = tiempoProximaInterrupcionT1;
    }

    public void setTiempoDescargaT1(double tiempoDescargaT1) {
        this.tiempoDescargaT1 = tiempoDescargaT1;
    }

    public void setTiempoDescargaT2(double tiempoDescargaT2) {
        this.tiempoDescargaT2 = tiempoDescargaT2;
    }

    public void setEstadoT2(String estadoT2) {
        this.estadoT2 = estadoT2;
    }

    public void setTiempoProximaInterrupcionT2(double tiempoProximaInterrupcionT2) {
        this.tiempoProximaInterrupcionT2 = tiempoProximaInterrupcionT2;
    }

    public void setCapacidadLibreT2(double capacidadLibreT2) {
        this.capacidadLibreT2 = capacidadLibreT2;
    }

    public void setCapacidadLibreT3(double capacidadLibreT3) {
        this.capacidadLibreT3 = capacidadLibreT3;
    }

    public void setEstadoT3(String estadoT3) {
        this.estadoT3 = estadoT3;
    }

    public void setTiempoProximaInterrupcionT3(double tiempoProximaInterrupcionT3) {
        this.tiempoProximaInterrupcionT3 = tiempoProximaInterrupcionT3;
    }

    public void setTiempoDescargaT3(double tiempoDescargaT3) {
        this.tiempoDescargaT3 = tiempoDescargaT3;
    }

    public void setCapacidadLibreT4(double capacidadLibreT4) {
        this.capacidadLibreT4 = capacidadLibreT4;
    }

    public void setEstadoT4(String estadoT4) {
        this.estadoT4 = estadoT4;
    }

    public void setTiempoProximaInterrupcionT4(double tiempoProximaInterrupcionT4) {
        this.tiempoProximaInterrupcionT4 = tiempoProximaInterrupcionT4;
    }

    public void setTiempoDescargaT4(double tiempoDescargaT4) {
        this.tiempoDescargaT4 = tiempoDescargaT4;
    }

    public void setCapacidadLibreT5(double capacidadLibreT5) {
        this.capacidadLibreT5 = capacidadLibreT5;
    }

    public void setEstadoT5(String estadoT5) {
        this.estadoT5 = estadoT5;
    }

    public void setTiempoProximaInterrupcionT5(double tiempoProximaInterrupcionT5) {
        this.tiempoProximaInterrupcionT5 = tiempoProximaInterrupcionT5;
    }

    public void setTiempoDescargaT5(double tiempoDescargaT5) {
        this.tiempoDescargaT5 = tiempoDescargaT5;
    }

    public void setCargaRemanenteB1(double cargaRemanenteB1) {
        this.cargaRemanenteB1 = cargaRemanenteB1;
    }

    public void setEstadoB1(String estadoB1) {
        this.estadoB1 = estadoB1;
    }

    public void setFinCargaB1(double finCargaB1) {
        this.finCargaB1 = finCargaB1;
    }

    public void setEnTanqueB1(String enTanqueB1) {
        this.enTanqueB1 = enTanqueB1;
    }

    public void setCargaRemanenteB2(double cargaRemanenteB2) {
        this.cargaRemanenteB2 = cargaRemanenteB2;
    }

    public void setEstadoB2(String estadoB2) {
        this.estadoB2 = estadoB2;
    }

    public void setFinCargaB2(double finCargaB2) {
        this.finCargaB2 = finCargaB2;
    }

    public void setEnTanqueB2(String enTanqueB2) {
        this.enTanqueB2 = enTanqueB2;
    }

    public void setCargaRemanenteB3(double cargaRemanenteB3) {
        this.cargaRemanenteB3 = cargaRemanenteB3;
    }

    public void setEstadoB3(String estadoB3) {
        this.estadoB3 = estadoB3;
    }

    public void setFinCargaB3(double finCargaB3) {
        this.finCargaB3 = finCargaB3;
    }

    public void setEnTanqueB3(String enTanqueB3) {
        this.enTanqueB3 = enTanqueB3;
    }

    public void setCargaRemanenteB4(double cargaRemanenteB4) {
        this.cargaRemanenteB4 = cargaRemanenteB4;
    }

    public void setEstadoB4(String estadoB4) {
        this.estadoB4 = estadoB4;
    }

    public void setFinCargaB4(double finCargaB4) {
        this.finCargaB4 = finCargaB4;
    }

    public void setEnTanqueB4(String enTanqueB4) {
        this.enTanqueB4 = enTanqueB4;
    }

    public void setCargaRemanenteB5(double cargaRemanenteB5) {
        this.cargaRemanenteB5 = cargaRemanenteB5;
    }

    public void setEstadoB5(String estadoB5) {
        this.estadoB5 = estadoB5;
    }

    public void setFinCargaB5(double finCargaB5) {
        this.finCargaB5 = finCargaB5;
    }

    public void setEnTanqueB5(String enTanqueB5) {
        this.enTanqueB5 = enTanqueB5;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }
    
    
    
    
}

