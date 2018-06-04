/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.simulacion.Class.Eventos.Simulacion;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author aleex
 */
public class VectorEstadoView {



    private String reloj;
    
    /*
    llegada de buque
    */
    private String rndLlegadaBuque;
    private String tiempoLlegadaBuque;
    private String proximaLlegada;
    
    /*
    ingreso a puerto
    */
    private String rndCarga;
    private String cargaBuque;
   
    //tanques costeros
    
    private String tiempoInicioCargaT1, tiempoFinCargaT1, tiempoFinDescargaT1, capacidadLibreT1;
    private String tiempoInicioCargaT2, tiempoFinCargaT2, tiempoFinDescargaT2, capacidadLibreT2;
    private String tiempoInicioCargaT3, tiempoFinCargaT3, tiempoFinDescargaT3, capacidadLibreT3;
    private String tiempoInicioCargaT4, tiempoFinCargaT4, tiempoFinDescargaT4, capacidadLibreT4;
    private String tiempoInicioCargaT5, tiempoFinCargaT5, tiempoFinDescargaT5, capacidadLibreT5;
    
    private String estadoT1;
    private String estadoT2;
    private String estadoT3;
    private String estadoT4;
    private String estadoT5;
    
    // buques
    
    private String cargaActualB1;
    private String cargaActualB2;
    private String cargaActualB3;
    private String cargaActualB4;
    private String cargaActualB5;
    
    
    private String estadoB1;
    private String estadoB2;
    private String estadoB3;
    private String estadoB4;
    private String estadoB5;
    
    // cola
    
    private String cola;

    public VectorEstadoView(VectorEstado v){
        
        double reloj = Math.round(v.getReloj()*100.0)/100.0;
        this.reloj = String.valueOf(reloj);
        
        if (v.getRndLlegadaBuque() <= 0.0){
            this.rndLlegadaBuque = "";
            //this.rndLlegadaBuque = "";
            this.tiempoLlegadaBuque = "";
        }
        else{
            this.rndLlegadaBuque = String.valueOf(v.getRndLlegadaBuque());
            //this.rndLlegadaBuque = String.valueOf(v.getTiempoLlegadaBuque());
            this.tiempoLlegadaBuque = String.valueOf(v.getTiempoLlegadaBuque());
        }
        
        this.proximaLlegada = String.valueOf(v.getProximaLlegada());
        
        if (v.getRndCarga() <= 0.0) {
            this.rndCarga = "";
            this.cargaBuque = "";
        }
        else {
            this.rndCarga = String.valueOf(v.getRndCarga());
            this.cargaBuque = String.valueOf(v.getCargaBuque());
        }
        
        if (v.getTiempoInicioCargaT1() < 0.0) {
            this.tiempoInicioCargaT1 = "";
            this.tiempoFinCargaT1 = "";
        }
        else {
            this.tiempoInicioCargaT1 = String.valueOf(v.getTiempoInicioCargaT1());
            this.tiempoFinCargaT1 = String.valueOf(v.getTiempoFinCargaT1());
        }
        
        if (v.getTiempoInicioCargaT2() < 0.0) {
            this.tiempoInicioCargaT2 = "";
            this.tiempoFinCargaT2 = "";
        }
        else {
            this.tiempoInicioCargaT2 = String.valueOf(v.getTiempoInicioCargaT2());
            this.tiempoFinCargaT2 = String.valueOf(v.getTiempoFinCargaT2());
        }
        
        if (v.getTiempoInicioCargaT3() < 0.0) {
            this.tiempoInicioCargaT3 = "";
            this.tiempoFinCargaT3 = "";
        }
        else {
            this.tiempoInicioCargaT3 = String.valueOf(v.getTiempoInicioCargaT3());
            this.tiempoFinCargaT3 = String.valueOf(v.getTiempoFinCargaT3());
        }
        
        if (v.getTiempoInicioCargaT4() < 0.0) {
            this.tiempoInicioCargaT4 = "";
            this.tiempoFinCargaT4 = "";
        }
        else {
            this.tiempoInicioCargaT4 = String.valueOf(v.getTiempoInicioCargaT4());
            this.tiempoFinCargaT4 = String.valueOf(v.getTiempoFinCargaT4());
        }
        
        if (v.getTiempoInicioCargaT5() < 0.0) {
            this.tiempoInicioCargaT5 = "";
            this.tiempoFinCargaT5 = "";
        }
        else {
            this.tiempoInicioCargaT5 = String.valueOf(v.getTiempoInicioCargaT5());
            this.tiempoFinCargaT5 = String.valueOf(v.getTiempoFinCargaT5());
        }
        
        if (v.getTiempoFinDescargaT1() <= 0.0) {
            this.tiempoFinDescargaT1 = "";
        }
        else {
            this.tiempoFinDescargaT1 = String.valueOf(v.getTiempoFinDescargaT1());
        }
        
        if (v.getTiempoFinDescargaT2() <= 0.0) {
            this.tiempoFinDescargaT2 = "";
        }
        else {
            this.tiempoFinDescargaT2 = String.valueOf(v.getTiempoFinDescargaT2());
        }
        
        if (v.getTiempoFinDescargaT3() <= 0.0) {
            this.tiempoFinDescargaT3 = "";
        }
        else {
            this.tiempoFinDescargaT3 = String.valueOf(v.getTiempoFinDescargaT3());
        }
        
        if (v.getTiempoFinDescargaT4() <= 0.0) {
            this.tiempoFinDescargaT4 = "";
        }
        else {
            this.tiempoFinDescargaT4 = String.valueOf(v.getTiempoFinDescargaT4());
        }
        
        if (v.getTiempoFinDescargaT5() <= 0.0) {
            this.tiempoFinDescargaT5 = "";
        }
        else {
            this.tiempoFinDescargaT5 = String.valueOf(v.getTiempoFinDescargaT5());
        }
        
        this.capacidadLibreT1 = String.valueOf(v.getCapacidadLibreT1());        
        this.capacidadLibreT2 = String.valueOf(v.getCapacidadLibreT2());        
        this.capacidadLibreT3 = String.valueOf(v.getCapacidadLibreT3());        
        this.capacidadLibreT4 = String.valueOf(v.getCapacidadLibreT4());        
        this.capacidadLibreT5 = String.valueOf(v.getCapacidadLibreT5());        
        
        this.estadoB1 = v.getEstadoB1();
        this.estadoB2= v.getEstadoB2();
        this.estadoB3 = v.getEstadoB3();
        this.estadoB4 = v.getEstadoB4();
        this.estadoB5 = v.getEstadoB5();
        
        this.estadoT1 = v.getEstadoT1();
        this.estadoT2= v.getEstadoT2();
        this.estadoT3 = v.getEstadoT3();
        this.estadoT4 = v.getEstadoT4();
        this.estadoT5 = v.getEstadoT5();
        
        this.cargaActualB1 = String.valueOf(v.getCargaActualB1());
        this.cargaActualB2 = String.valueOf(v.getCargaActualB2());
        this.cargaActualB3 = String.valueOf(v.getCargaActualB3());
        this.cargaActualB4 = String.valueOf(v.getCargaActualB4());
        this.cargaActualB5 = String.valueOf(v.getCargaActualB5());
        
        this.cola = String.valueOf(v.getCola());
                    
   
        
    }

    public String getReloj() {
        return reloj;
    }

    public void setReloj(String reloj) {
        this.reloj = reloj;
    }

    public String getRndLlegadaBuque() {
        return rndLlegadaBuque;
    }

    public void setRndLlegadaBuque(String rndLlegadaBuque) {
        this.rndLlegadaBuque = rndLlegadaBuque;
    }

    public String getTiempoLlegadaBuque() {
        return tiempoLlegadaBuque;
    }

    public void setTiempoLlegadaBuque(String tiempoLlegadaBuque) {
        this.tiempoLlegadaBuque = tiempoLlegadaBuque;
    }

    public String getProximaLlegada() {
        return proximaLlegada;
    }

    public void setProximaLlegada(String proximaLlegada) {
        this.proximaLlegada = proximaLlegada;
    }

    public String getRndCarga() {
        return rndCarga;
    }

    public void setRndCarga(String rndCarga) {
        this.rndCarga = rndCarga;
    }

    public String getCargaBuque() {
        return cargaBuque;
    }

    public void setCargaBuque(String cargaBuque) {
        this.cargaBuque = cargaBuque;
    }

    public String getTiempoInicioCargaT1() {
        return tiempoInicioCargaT1;
    }

    public void setTiempoInicioCargaT1(String tiempoInicioCargaT1) {
        this.tiempoInicioCargaT1 = tiempoInicioCargaT1;
    }

    public String getTiempoFinCargaT1() {
        return tiempoFinCargaT1;
    }

    public void setTiempoFinCargaT1(String tiempoFinCargaT1) {
        this.tiempoFinCargaT1 = tiempoFinCargaT1;
    }

    public String getTiempoFinDescargaT1() {
        return tiempoFinDescargaT1;
    }

    public void setTiempoFinDescargaT1(String tiempoFinDescargaT1) {
        this.tiempoFinDescargaT1 = tiempoFinDescargaT1;
    }

    public String getCapacidadLibreT1() {
        return capacidadLibreT1;
    }

    public void setCapacidadLibreT1(String capacidadLibreT1) {
        this.capacidadLibreT1 = capacidadLibreT1;
    }

    public String getTiempoInicioCargaT2() {
        return tiempoInicioCargaT2;
    }

    public void setTiempoInicioCargaT2(String tiempoInicioCargaT2) {
        this.tiempoInicioCargaT2 = tiempoInicioCargaT2;
    }

    public String getTiempoFinCargaT2() {
        return tiempoFinCargaT2;
    }

    public void setTiempoFinCargaT2(String tiempoFinCargaT2) {
        this.tiempoFinCargaT2 = tiempoFinCargaT2;
    }

    public String getTiempoFinDescargaT2() {
        return tiempoFinDescargaT2;
    }

    public void setTiempoFinDescargaT2(String tiempoFinDescargaT2) {
        this.tiempoFinDescargaT2 = tiempoFinDescargaT2;
    }

    public String getCapacidadLibreT2() {
        return capacidadLibreT2;
    }

    public void setCapacidadLibreT2(String capacidadLibreT2) {
        this.capacidadLibreT2 = capacidadLibreT2;
    }

    public String getTiempoInicioCargaT3() {
        return tiempoInicioCargaT3;
    }

    public void setTiempoInicioCargaT3(String tiempoInicioCargaT3) {
        this.tiempoInicioCargaT3 = tiempoInicioCargaT3;
    }

    public String getTiempoFinCargaT3() {
        return tiempoFinCargaT3;
    }

    public void setTiempoFinCargaT3(String tiempoFinCargaT3) {
        this.tiempoFinCargaT3 = tiempoFinCargaT3;
    }

    public String getTiempoFinDescargaT3() {
        return tiempoFinDescargaT3;
    }

    public void setTiempoFinDescargaT3(String tiempoFinDescargaT3) {
        this.tiempoFinDescargaT3 = tiempoFinDescargaT3;
    }

    public String getCapacidadLibreT3() {
        return capacidadLibreT3;
    }

    public void setCapacidadLibreT3(String capacidadLibreT3) {
        this.capacidadLibreT3 = capacidadLibreT3;
    }

    public String getTiempoInicioCargaT4() {
        return tiempoInicioCargaT4;
    }

    public void setTiempoInicioCargaT4(String tiempoInicioCargaT4) {
        this.tiempoInicioCargaT4 = tiempoInicioCargaT4;
    }

    public String getTiempoFinCargaT4() {
        return tiempoFinCargaT4;
    }

    public void setTiempoFinCargaT4(String tiempoFinCargaT4) {
        this.tiempoFinCargaT4 = tiempoFinCargaT4;
    }

    public String getTiempoFinDescargaT4() {
        return tiempoFinDescargaT4;
    }

    public void setTiempoFinDescargaT4(String tiempoFinDescargaT4) {
        this.tiempoFinDescargaT4 = tiempoFinDescargaT4;
    }

    public String getCapacidadLibreT4() {
        return capacidadLibreT4;
    }

    public void setCapacidadLibreT4(String capacidadLibreT4) {
        this.capacidadLibreT4 = capacidadLibreT4;
    }

    public String getTiempoInicioCargaT5() {
        return tiempoInicioCargaT5;
    }

    public void setTiempoInicioCargaT5(String tiempoInicioCargaT5) {
        this.tiempoInicioCargaT5 = tiempoInicioCargaT5;
    }

    public String getTiempoFinCargaT5() {
        return tiempoFinCargaT5;
    }

    public void setTiempoFinCargaT5(String tiempoFinCargaT5) {
        this.tiempoFinCargaT5 = tiempoFinCargaT5;
    }

    public String getTiempoFinDescargaT5() {
        return tiempoFinDescargaT5;
    }

    public void setTiempoFinDescargaT5(String tiempoFinDescargaT5) {
        this.tiempoFinDescargaT5 = tiempoFinDescargaT5;
    }

    public String getCapacidadLibreT5() {
        return capacidadLibreT5;
    }

    public void setCapacidadLibreT5(String capacidadLibreT5) {
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

    public String getCargaActualB1() {
        return cargaActualB1;
    }

    public void setCargaActualB1(String cargaActualB1) {
        this.cargaActualB1 = cargaActualB1;
    }

    public String getCargaActualB2() {
        return cargaActualB2;
    }

    public void setCargaActualB2(String cargaActualB2) {
        this.cargaActualB2 = cargaActualB2;
    }

    public String getCargaActualB3() {
        return cargaActualB3;
    }

    public void setCargaActualB3(String cargaActualB3) {
        this.cargaActualB3 = cargaActualB3;
    }

    public String getCargaActualB4() {
        return cargaActualB4;
    }

    public void setCargaActualB4(String cargaActualB4) {
        this.cargaActualB4 = cargaActualB4;
    }

    public String getCargaActualB5() {
        return cargaActualB5;
    }

    public void setCargaActualB5(String cargaActualB5) {
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

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }
    
    

}