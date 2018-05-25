/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

/**
 *
 * @author aleex
 */
public class IngresoPuerto {
    private double rndContenido;
    private double cargaActual;

    public IngresoPuerto() {
        this.rndContenido = -1;
        this.cargaActual = -1;
    }
    
    public void generarCarga(double rnd){
        this.rndContenido = rnd;
        if (this.rndContenido <= 0.33){
            this.cargaActual = 15000.0;
            return;
        }
        if(this.rndContenido <= 0.66){
            this.cargaActual = 20000.0;
        }
        if(this.rndContenido <= 0.99){
            this.cargaActual = 25000.0;
        }
    }

    public double getRndContenido() {
        return rndContenido;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public void setRndContenido(double rndContenido) {
        this.rndContenido = rndContenido;
    }

    public void setCargaActual(double cargaActual) {
        this.cargaActual = cargaActual;
    }
    
    
}
