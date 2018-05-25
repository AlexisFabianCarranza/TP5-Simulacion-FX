/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.simulacion.Class.Eventos.Simulacion;

import Eventos.IngresoPuerto;
import Eventos.LlegadaBuque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tp5.simulacion.Class.Objetos.Buque;
import tp5.simulacion.Class.Objetos.Tanque;
import distribuciones.*;
/**
 *
 * @author aleex
 */
public class GestorSimulacion {
    //Para el caso de las celdas que van a quedar vacias, se coloca el valor -1 por defecto
    private double reloj;
    private VectorEstado vectorEstadoActual;
    //Random para manejar la generacion de random 
    private Random rnd;
    private int cola;
    //Eventos 
    private LlegadaBuque llegadaBuque;
    private IngresoPuerto ingresoPuerto;
    
    private ArrayList<Buque> buques;
    //Objetos Permanentes
    private Tanque tanque1;
    private Tanque tanque2;
    private Tanque tanque3;
    private Tanque tanque4;
    private Tanque tanque5;
    //ArrayList para poder recorrer los tanques(servidores) (permanentes)
    private ArrayList<Tanque> tanques;
    //Atributo para alamacenar los vectores estados que se van a mostrar en la tabla
    private ObservableList<VectorEstadoView> vectoresEstados;
    //Atributos para saber desde y hasta que fila mostrar
    private double horaDesdeVER;
    private double horaHastaVER;
    //Atributo que se utiliza para cortar la simulacion en una hora determinada
    private double horaHasta;
    //Atributo que se utiliza para contar las filas, para poder mostrar luego
    
    public GestorSimulacion(double desde , double hasta, double horaHasta) {
        this.rnd = new Random();
        this.vectoresEstados = FXCollections.observableArrayList();
        this.horaHasta = horaHasta;
        this.horaDesdeVER = desde;
        this.horaHastaVER = hasta;
        this.reloj = 0;
        this.cola = 0;
        this.llegadaBuque = new LlegadaBuque();
        this.ingresoPuerto = new IngresoPuerto();
        //Inicializo los tanques con los valores por defecto del problema
        this.tanque1 = new Tanque(70000,"L");
        this.tanque2 = new Tanque(70000,"L");
        this.tanque3 = new Tanque(0,"D");
        this.tanque4 = new Tanque(45000, "C");
        this.tanque5 = new Tanque(25000, "C");
        //ArrayList de tanque para generar el evento que sigue
        this.tanques = new ArrayList();
        this.tanques.add(tanque1);
        this.tanques.add(tanque2);
        this.tanques.add(tanque3);
        this.tanques.add(tanque4);
        this.tanques.add(tanque5);
    }
    
    
    private void simularEventoFinCarga(double finCarga){
        this.reloj = this.vectorEstadoActual.getReloj() + finCarga;
        
    }
    
    private void simularLlegadaBuque() {
        //Seteo del reloj
        this.reloj = this.vectorEstadoActual.getReloj() + this.vectorEstadoActual.getProximaLllegada();
        
        //EVENTO LLEGADA DEL Proximo buque BUQUE
        double rndLlegada = this.rnd.nextDouble();
        this.llegadaBuque.generarTiempoLlegada(rndLlegada);
        double proximaLlegada = this.reloj + this.llegadaBuque.getTiempoLLegadaBuque();
        this.llegadaBuque.setProximaLllegada(proximaLlegada);
        
        //EVENTO Ingreso Buque ; PORQUE VINO UN BUQUE
        Buque buqueNuevo = new Buque();
        double rndContenidoBuque = this.rnd.nextDouble();
        this.ingresoPuerto.generarCarga(rndContenidoBuque);
        buqueNuevo.setCargaActual(this.ingresoPuerto.getCargaActual());
        Tanque tanqueLibre = this.getTanqueLibre();
        if (tanqueLibre == null) {
            this.cola += 1;
            this.vectorEstadoActual.setCola(this.cola);
         }
        else {
            double finCarga = this.generarFinCarga(buqueNuevo.getCargaActual());
            tanqueLibre.setFinCarga(finCarga);
            tanqueLibre.setEstado("C");
            tanqueLibre.setBuqueEnAtencion(buqueNuevo);
            
            //Si remanente de carga es distinto de menos 1, es porque se lleno el tanque y hay que generar una descarga
            //para ese tanque
        }
    }
    
    public void actualizarVectorEstadoActual(){
        //LA idea es que en este metodo se actualize todos los atributos del vector estado, 
        //con los valores actuales de los objetos
        Buque b1 = this.tanque1.getBuqueEnAtencion();
        Buque b2 = this.tanque2.getBuqueEnAtencion();
        Buque b3 = this.tanque3.getBuqueEnAtencion();
        Buque b4 = this.tanque4.getBuqueEnAtencion();
        Buque b5 = this.tanque5.getBuqueEnAtencion();
        this.vectorEstadoActual = new VectorEstado(this.reloj, this.llegadaBuque.getRndLLegadaBuque(), 
               this.llegadaBuque.getTiempoLLegadaBuque(),this.llegadaBuque.getProximaLllegada(),
               this.ingresoPuerto.getRndContenido() , this.ingresoPuerto.getCargaActual(), 
               this.tanque1.getCapacidadLibre(), this.tanque1.getEstado(), this.tanque1.getProximaInterrupcion(), this.tanque1.getFinDescarga(),
               this.tanque2.getCapacidadLibre(), this.tanque2.getEstado(), this.tanque2.getProximaInterrupcion(), this.tanque1.getFinDescarga(),
               this.tanque3.getCapacidadLibre(), this.tanque3.getEstado(), this.tanque3.getProximaInterrupcion(), this.tanque1.getFinDescarga(),
               this.tanque4.getCapacidadLibre(), this.tanque4.getEstado(), this.tanque4.getProximaInterrupcion(), this.tanque1.getFinDescarga(),
               this.tanque5.getCapacidadLibre(), this.tanque5.getEstado(), this.tanque5.getProximaInterrupcion(), this.tanque1.getFinDescarga(),
               b1.getCargaActual() , b1.getEstado(), b1.getTiempoRemanenteCarga(), "tanque 1",
               b2.getCargaActual() , b2.getEstado(), b2.getTiempoRemanenteCarga(), "tanque 2",
               b3.getCargaActual() , b3.getEstado(), b3.getTiempoRemanenteCarga(), "tanque 3",
               b4.getCargaActual() , b4.getEstado(), b4.getTiempoRemanenteCarga(), "tanque 4",
               b5.getCargaActual() , b5.getEstado(), b5.getTiempoRemanenteCarga(), "tanque 5",
               this.cola
        );
    }
    
    public ObservableList<VectorEstadoView> simular()
    {
        //Seteo el vector estado Actual en la posicion 0 del reloj
       
        
        while (this.reloj <= this.horaHasta){
            //ACA DEBERIA IR TODA LA LOGICA DE LA SIMULACION
            //ACa se deberia buscar cual es el evento siguiente
            /*FinCarga fc = this.proximoFinCarga();
            if (fc.getFinCarga() < fd.getHoraFinDescarga() && fc.getFinCarga() < this.llegadaBuque.getProxLlegada()){
                
            }*/
          
            //Al final de cada ciclo para almacenar los que se deben mostrar
            //if ( this.filaActual <= this.filaHasta && this.filaActual >= this.filaDesde) {
            //    VectorEstadoView v = new VectorEstadoView(this.vectorEstadoActual);
            //    this.vectoresEstados.add(v);
            //}
        }
        
        return this.vectoresEstados;
    }
    
    public double generarFinCarga(double cargaBuque){
        double aux = 0.5 + cargaBuque / 10000.0;
        aux = Math.round(aux * 100.0) / 100.0;
        return aux;
    }
    
    
    
    private Tanque getTanqueLibre(){
        for (Object tanque: this.tanques){
            Tanque tanqueAux = (Tanque) tanque;
            if (tanqueAux.getEstado() == "L"){
                return tanqueAux;
            }
        }
        return null;
    }
}
