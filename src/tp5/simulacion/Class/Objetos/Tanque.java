/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.simulacion.Class.Objetos;

/**
 *
 * @author aleex
 */
public class Tanque {
    private String estado; // Los estados pueden ser 'L' 'C' 'D'
    private double capacidadLibre;
    
    private double inicioCarga;
    private double finCarga;
    private double finDescarga;
    private double tiempoInterrupcion;
    private double rndFinCarga;
    private double proximaInterrupcion;
    
    
    
   
    private Buque buqueEnAtencion;//Puntero para manejar el buque que esta siendo atendido

    public Tanque() {
        this.estado = "L";
        this.capacidadLibre = 70000;
        this.rndFinCarga = -1;
        this.finCarga = -1;
        this.finDescarga = -1;
        this.tiempoInterrupcion = -1;
    }

    public Tanque(double capacidadLibre, String estado) {
        this.estado = estado;
        this.capacidadLibre = capacidadLibre;
        this.finCarga = -1;
        this.finDescarga = -1;
        this.tiempoInterrupcion = -1;
    }
    
    public void ponerCargando(){
        this.estado = "C";
    }
    
    public void ponerLibre(){
        this.estado = "L";
    }
    
    public void ponerDescargando(){
        this.estado = "D";
    }
    
    public boolean estaLibre(){
        if(this.estado == "L"){
            return true;
        }
        return false;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCapacidadLibre(double capacidadLibre) {
        this.capacidadLibre = capacidadLibre;
    }

    public void setFinCarga(double finCarga) {
        this.finCarga = finCarga;
    }

    public void setFinDescarga(double finDescarga) {
        this.finDescarga = finDescarga;
    }

    public String getEstado() {
        return estado;
    }

    public double getCapacidadLibre() {
        return capacidadLibre;
    }

    public double getFinCarga() {
        return finCarga;
    }

    public double getFinDescarga() {
        return finDescarga;
    }

    public double getTiempoInterrupcion() {
        return tiempoInterrupcion;
    }

    public double getRndFinCarga() {
        return rndFinCarga;
    }

    public double getProximaInterrupcion() {
        return proximaInterrupcion;
    }

    public Buque getBuqueEnAtencion() {
        return buqueEnAtencion;
    }

    public void setTiempoInterrupcion(double tiempoInterrupcion) {
        this.tiempoInterrupcion = tiempoInterrupcion;
    }

    public void setRndFinCarga(double rndFinCarga) {
        this.rndFinCarga = rndFinCarga;
    }

    public void setProximaInterrupcion(double proximaInterrupcion) {
        this.proximaInterrupcion = proximaInterrupcion;
    }

    public void setBuqueEnAtencion(Buque buqueEnAtencion) {
        this.buqueEnAtencion = buqueEnAtencion;
    }

    public double getInicioCarga() {
        return inicioCarga;
    }

    public void setInicioCarga(double inicioCarga) {
        this.inicioCarga = inicioCarga;
    }

    
    
    
    
    
    
    
    
}
