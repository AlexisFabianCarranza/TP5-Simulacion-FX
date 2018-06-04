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
import java.util.HashSet;
import java.util.Set;
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
    
    //Objetos Permanentes
    private Tanque tanque1;
    private Tanque tanque2;
    private Tanque tanque3;
    private Tanque tanque4;
    private Tanque tanque5;
    //Vector para poder recorrer los tanques(servidores) (permanentes)
    private Tanque[] tanques;
    //Atributo para alamacenar los vectores estados que se van a mostrar en la tabla
    private ObservableList<VectorEstadoView> vectoresEstados;
    //Atributos para saber desde y hasta que fila mostrar
    private double horaDesdeVER;
    private double horaHastaVER;
    //Atributo que se utiliza para cortar la simulacion en una hora determinada
    private double horaHasta;
    //Atributo que se utiliza para contar las filas, para poder mostrar luego
    
    public GestorSimulacion(double desde , double hasta, double horaHasta) {
        System.out.println("se esta inicializando la wea");
        this.rnd = new Random();
        this.vectoresEstados = FXCollections.observableArrayList();
        this.horaHasta = horaHasta;
        this.horaDesdeVER = desde;
        this.horaHastaVER = hasta;
        this.reloj = 0;
        this.cola = 0;
        this.llegadaBuque = new LlegadaBuque();
        this.llegadaBuque.setProximaLllegada(0);//Condicion inicial;
        this.ingresoPuerto = new IngresoPuerto();
        //Inicializo los tanques con los valores por defecto del problema
        this.tanque1 = new Tanque(70000,"L");
        this.tanque2 = new Tanque(70000,"L");
        this.tanque3 = new Tanque(0,"D");
        this.tanque3.setFinDescarga(8);
        //this.tanque4 = new Tanque(45000, "C");
        /*
        cambiado para que luego de los 12 minutos quede con una carga de 45000
        */
        this.tanque4 = new Tanque(165000, "C");
        this.tanque4.setFinCarga(12);
        // this.tanque5 = new Tanque(25000, "C");
        /*
        cambiado para que después de los 3 minutos de la descarga quede con 25000
        */
        this.tanque5 = new Tanque(55000, "C");
        this.tanque5.setFinCarga(3.5);
        //ArrayList de tanque para generar el evento que sigue
        this.tanques = new Tanque[5];
        this.tanques[0] = tanque1;
        this.tanques[1] = tanque2;
        this.tanques[2] = tanque3;
        this.tanques[3] = tanque4;
        this.tanques[4] = tanque5;
    }
    
    //Metodo separado, ya que en todos los casos son iguales
    private void simularLlegada(){
        double rndLlegada = this.rnd.nextDouble();
        double tiempoLlegada = this.llegadaBuque.generarTiempoLlegada(rndLlegada);
        double proximaLlegada = this.reloj + tiempoLlegada;
        this.llegadaBuque.setProximaLllegada(proximaLlegada);
        this.llegadaBuque.setRndLLegadaBuque(rndLlegada);
        this.llegadaBuque.setTiempoLLegadaBuque(tiempoLlegada);
    }
    //Metodo separado, ya que en todos los casos son iguales
    private void simularIngresoPuerto(){
        double rndContenidoBuque = this.rnd.nextDouble();
        double cargaBuque = this.ingresoPuerto.generarCarga(rndContenidoBuque);
        this.ingresoPuerto.setCargaActual(cargaBuque);
        this.ingresoPuerto.setRndContenido(rndContenidoBuque);
    }
    
    private void simularEventoFinDescarga(Tanque tanque){
        //Eze hay que ver si el tanque esta referenciado a un buque, osea, no tiene que pasar uno nuevo, tiene que reanudar la carga
       
    }
    
    private void simularEventoFinCarga(Tanque tanque){
        //Nico
        this.reloj = tanque.getFinCarga();
        System.out.println("CAPACIDAD DEL TANQUE LIBRE ANTES DE SETEO::: " + tanque.getCapacidadLibre());
        
        if (tanque.getCapacidadLibre() == 0) {
            /*
            manda al tanque a la refineria en caso de llegar a su capacidad
            limite
            */
           Buque buque = tanque.getBuqueEnAtencion();
           double tiempoCargando = tanque.getFinCarga() - tanque.getInicioCarga() - 0.5;
           double cargaRemanente = buque.getCargaActual() - tiempoCargando*10000.0 ;
           buque.setCargaActual(cargaRemanente);
           if(buque.getCargaActual() > 0){
               buque.ponerEsperandoReanudacion();
           }
           else{
               tanque.hundirBuque();
           }
           this.mandarRefineria(tanque);
           
        }
        else {
            System.out.println("TIEMPO FIN DE CARGA:::  " + tanque.getFinCarga() + "   ---- TIEMPO INICIO DE CARGA::: " + tanque.getInicioCarga());
            double tiempoCargando = tanque.getFinCarga() - tanque.getInicioCarga() - 0.5;
            System.out.println("TIEMPO QUE CARGO (SIN INCLUIR ENCENDIDO DE BOMBA) :::: " + tiempoCargando);
            double cargaLibre = tanque.getCapacidadLibre() - tiempoCargando*10000.0 ;
            tanque.setCapacidadLibre(cargaLibre);

            if (this.cola == 0) {
                tanque.ponerLibre();
            }
            else {
                Buque buqueNuevo = new Buque();
                this.simularIngresoPuerto();
                buqueNuevo.setCargaActual(this.ingresoPuerto.getCargaActual());
                double finCarga = this.generarFinCarga(tanque, buqueNuevo);
                tanque.setInicioCarga(this.reloj);
                tanque.setFinCarga(finCarga);
                tanque.ponerCargando();
                tanque.setBuqueEnAtencion(buqueNuevo);
                this.cola -= 1;
            }
        }
        this.actualizarVectorEstadoActual();
        this.llegadaBuque.setRndLLegadaBuque(-1);
        this.llegadaBuque.setTiempoLLegadaBuque(-1);
        
    }
    
    
    private void mandarRefineria(Tanque tanque){
        /*
        setea los atributos necesario cuando el tanque es mandado a refineria
        */
        tanque.ponerDescargando();
        tanque.setFinDescarga(this.reloj + 17.5);
    }
    
    private double generarFinCarga(Tanque tanqueLibre, Buque buqueNuevo){
        //Metodo que genera el fin de carga dependiendo si el tanque tiene espacio para todo
        double carga;
        if(tanqueLibre.getCapacidadLibre() < buqueNuevo.getCargaActual()){
            carga = tanqueLibre.getCapacidadLibre();
            System.out.println("CARGA TOMADA DESDE LIMITE DE TANQUE::: " + carga);
        }
        else{
            carga = buqueNuevo.getCargaActual();
            System.out.println("CARGA TOMADA DESDE CAPACIDAD DE BUQUE:::" + carga);
        }
        double FinCarga = (0.5 + carga / 10000.0) + this.reloj;
        System.out.println("PROXIMO FIN DE CARGA SERÄ EN:: " + FinCarga);
        return Math.round(FinCarga * 100.0) / 100.0;
    }
    
    private void simularEventoLlegadaBuque() {
        //Seteo del reloj
        this.reloj = this.vectorEstadoActual.getProximaLlegada();
        
        //EVENTO LLEGADA DEL Proximo buque BUQUE
        this.simularLlegada();
        
        //EVENTO Ingreso Buque ; PRimero me fijo si hay tanque libre
        Tanque tanqueLibre = this.getTanqueLibre();
        if (tanqueLibre == null) {
            this.cola += 1;
         }
        else {
            this.simularIngresoPuerto();
            Buque buqueNuevo = new Buque();
            buqueNuevo.ponerSiendoAtendido();
            buqueNuevo.setCargaActual(this.ingresoPuerto.getCargaActual());
            
            double finCarga = this.generarFinCarga(tanqueLibre, buqueNuevo);
            //coloca el buque en la casilla del tanque, osea tanque1 con buque1 ...
            tanqueLibre.setInicioCarga(this.reloj);
            tanqueLibre.setFinCarga(finCarga);
            tanqueLibre.ponerCargando();
            tanqueLibre.setBuqueEnAtencion(buqueNuevo);
        }
       this.actualizarVectorEstadoActual();
       this.llegadaBuque.setRndLLegadaBuque(-1);
       this.llegadaBuque.setTiempoLLegadaBuque(-1);
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
               this.llegadaBuque.getTiempoLLegadaBuque(),this.llegadaBuque.getProximaLlegada(),
               this.ingresoPuerto.getRndContenido() , this.ingresoPuerto.getCargaActual(), 
               this.tanque1.getInicioCarga(), this.tanque1.getFinCarga(), this.tanque1.getFinDescarga(), this.tanque1.getCapacidadLibre(), this.tanque1.getEstado(),
               this.tanque2.getInicioCarga(), this.tanque2.getFinCarga(), this.tanque2.getFinDescarga(), this.tanque2.getCapacidadLibre(), this.tanque2.getEstado(),
               this.tanque3.getInicioCarga(), this.tanque3.getFinCarga(), this.tanque3.getFinDescarga(), this.tanque3.getCapacidadLibre(), this.tanque3.getEstado(),
               this.tanque4.getInicioCarga(), this.tanque4.getFinCarga(), this.tanque4.getFinDescarga(), this.tanque4.getCapacidadLibre(), this.tanque4.getEstado(),
               this.tanque5.getInicioCarga(), this.tanque5.getFinCarga(), this.tanque5.getFinDescarga(), this.tanque5.getCapacidadLibre(), this.tanque5.getEstado(),
                b1.getCargaActual(),  b2.getCargaActual(),  b3.getCargaActual(),  b4.getCargaActual(),  b5.getCargaActual(),
                b1.getEstado(), b2.getEstado(), b3.getEstado(), b4.getEstado(), b5.getEstado(),
               this.cola
        );
    }
    
    
    public ObservableList<VectorEstadoView> simular()
    {
        //Seteo el vector estado Actual en la posicion 0 del reloj
        this.actualizarVectorEstadoActual();
        while (this.reloj <= this.horaHasta){
            System.out.println("");
            System.out.println("");
            System.out.println("simulando, por favor espera :) ");
            //ACA DEBERIA IR TODA LA LOGICA DE LA SIMULACION
            //ACa se deberia buscar cual es el evento siguiente
            this.ingresoPuerto.setCargaActual(-1);
            this.ingresoPuerto.setRndContenido(-1);
            double horaEvento = this.vectorEstadoActual.getProxEventoHora();
            
            for(Tanque i:this.tanques){
                if ( this.llegadaBuque.getProximaLlegada() == horaEvento){
                    System.out.println("Llegada de buque");
                    this.simularEventoLlegadaBuque();
                    break;
                }
                if(i.getFinCarga() == horaEvento){
                    System.out.println("finCarga");
                    this.simularEventoFinCarga(i);
                    break;
                }
                if(i.getFinDescarga() == horaEvento){
                    System.out.println("FinDescarga");
                    this.simularEventoFinDescarga(i);
                    break;
                }
            }          
            //Al final de cada ciclo para almacenar los que se deben mostrar
//            if ( this.reloj >= this.horaDesdeVER && this.reloj<= this.horaHastaVER) {
//                VectorEstado v = this.vectorEstadoActual;
//                this.vectoresEstados.add(v);
//            }
            if ( this.reloj >= this.horaDesdeVER && this.reloj<= this.horaHastaVER) {
                VectorEstadoView v = new VectorEstadoView(this.vectorEstadoActual);
                this.vectoresEstados.add(v);
            }
            
        }
        
        return this.vectoresEstados;
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
