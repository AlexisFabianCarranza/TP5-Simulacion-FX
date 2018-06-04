/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.simulacion;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tp5.simulacion.Class.Eventos.Simulacion.GestorSimulacion;
import tp5.simulacion.Class.Eventos.Simulacion.VectorEstado;

/**
 *
 * @author aleex
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtHorasSimulacion;
    @FXML
    private Button btnSimular;
    @FXML
    private TextField txtHoraDesde;
    @FXML
    private TextField txtHoraHasta;
    
    private double horasSimulacion;
    private double horaDesde;
    private double horaHasta;
    @FXML
    private TableColumn<VectorEstado, Double> relojColumn;
    @FXML
    private TableColumn<VectorEstado, Double> rndLlegadaColumn;
    @FXML
    private TableColumn<VectorEstado, Double> tiempoLlegadaColumn;
    @FXML
    private TableColumn<VectorEstado, Double> proximaLlegadaColumn;
    @FXML
    private TableColumn<VectorEstado, Double> rndCargaColumn;
    @FXML
    private TableColumn<VectorEstado, Integer> cargaColumn;
    @FXML
    private TableColumn<VectorEstado, Double> inicioCargaT1Column;
    @FXML
    private TableColumn<VectorEstado, Double> finCargaT1Column;
    @FXML
    private TableColumn<VectorEstado, Double> inicioCargaT2Column;
    @FXML
    private TableColumn<VectorEstado, Double> finCargaT2Column;
    @FXML
    private TableColumn<VectorEstado, Double> inicioCargaT3Column;
    @FXML
    private TableColumn<VectorEstado, Double> finCargaT3Column;
    @FXML
    private TableColumn<VectorEstado, Double> inicioCargaT4Column;
    @FXML
    private TableColumn<VectorEstado, Double> finCargaT4Column;
    @FXML
    private TableColumn<VectorEstado, Double> inicioCargaT5Column;
    @FXML
    private TableColumn<VectorEstado, Double> finCargaT5Column;
    @FXML
    private TableColumn<VectorEstado, Double> finDescargaT1Column;
    @FXML
    private TableColumn<VectorEstado, Double> finDescargaT2Column;
    @FXML
    private TableColumn<VectorEstado, Double> finDescargaT3Column;
    @FXML
    private TableColumn<VectorEstado, Double> finDescargaT4Column;
    @FXML
    private TableColumn<VectorEstado, Double> finDescargaT5Column;
    @FXML
    private TableColumn<VectorEstado, Integer> colaColumn;
    @FXML
    private TableColumn<VectorEstado, String> estadoT1Column;
    @FXML
    private TableColumn<VectorEstado, Double> capacidadLibreT1Column;
    @FXML
    private TableColumn<VectorEstado, String> estadoT2Column;
    @FXML
    private TableColumn<VectorEstado, Double> capacidadLibreT2Column;
    @FXML
    private TableColumn<VectorEstado, String> estadoT3Column;
    @FXML
    private TableColumn<VectorEstado, Double> capacidadLibreT3Column;
    @FXML
    private TableColumn<VectorEstado, String> estadoT4Column;
    @FXML
    private TableColumn<VectorEstado, Double> capacidadLibreT4Column;
    @FXML
    private TableColumn<VectorEstado, String> estadoT5Column;
    @FXML
    private TableColumn<VectorEstado, Double> capacidadLibreT5Column;
    @FXML
    private TableView<VectorEstado> tableVectorEstado;
    @FXML
    private TableColumn<VectorEstado, String> estadoB1Column;
    @FXML
    private TableColumn<VectorEstado, Double> cargaActualB1Column;
    @FXML
    private TableColumn<VectorEstado, String> estadoB2Column;
    @FXML
    private TableColumn<VectorEstado, Double> cargaActualB2Column;
    @FXML
    private TableColumn<VectorEstado, String> estadoB3Column;
    @FXML
    private TableColumn<VectorEstado, Double> cargaActualB3Column;
    @FXML
    private TableColumn<VectorEstado, String> estadoB4Column;
    @FXML
    private TableColumn<VectorEstado, Double> cargaActualB4Column;
    @FXML
    private TableColumn<VectorEstado, String> estadoB5Column;
    @FXML
    private TableColumn<VectorEstado, Double> cargaActualB5Column;
    
    private GestorSimulacion simulador;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.relojColumn.setCellValueFactory(new PropertyValueFactory<>("reloj"));
        this.rndLlegadaColumn.setCellValueFactory(new PropertyValueFactory<>("rndLLegadaBuque"));
        this.tiempoLlegadaColumn.setCellValueFactory(new PropertyValueFactory("tiempoLlegadaBuque"));
        this.proximaLlegadaColumn.setCellValueFactory(new PropertyValueFactory("proximaLlegada"));
        this.rndCargaColumn.setCellValueFactory(new PropertyValueFactory("rndCarga"));
        this.cargaColumn.setCellValueFactory(new PropertyValueFactory("cargaBuque"));
        this.inicioCargaT1Column.setCellValueFactory(new PropertyValueFactory("tiempoInicioCargaT1"));
        this.inicioCargaT2Column.setCellValueFactory(new PropertyValueFactory("tiempoInicioCargaT2"));
        this.inicioCargaT3Column.setCellValueFactory(new PropertyValueFactory("tiempoInicioCargaT3"));
        this.inicioCargaT4Column.setCellValueFactory(new PropertyValueFactory("tiempoInicioCargaT4"));
        this.inicioCargaT5Column.setCellValueFactory(new PropertyValueFactory("tiempoInicioCargaT5"));
        this.finCargaT1Column.setCellValueFactory(new PropertyValueFactory("tiempoFinCargaT1"));
        this.finCargaT2Column.setCellValueFactory(new PropertyValueFactory("tiempoFinCargaT2"));
        this.finCargaT3Column.setCellValueFactory(new PropertyValueFactory("tiempoFinCargaT3"));
        this.finCargaT4Column.setCellValueFactory(new PropertyValueFactory("tiempoFinCargaT4"));
        this.finCargaT5Column.setCellValueFactory(new PropertyValueFactory("tiempoFinCargaT5"));
        this.finDescargaT1Column.setCellValueFactory(new PropertyValueFactory("tiempoFinDescargaT1"));
        this.finDescargaT2Column.setCellValueFactory(new PropertyValueFactory("tiempoFinDescargaT2"));
        this.finDescargaT3Column.setCellValueFactory(new PropertyValueFactory("tiempoFinDescargaT3"));
        this.finDescargaT4Column.setCellValueFactory(new PropertyValueFactory("tiempoFinDescargaT4"));
        this.finDescargaT5Column.setCellValueFactory(new PropertyValueFactory("tiempoFinDescargaT5"));
        this.capacidadLibreT1Column.setCellValueFactory(new PropertyValueFactory("capacidadLibreT1"));
        this.capacidadLibreT2Column.setCellValueFactory(new PropertyValueFactory("capacidadLibreT2"));
        this.capacidadLibreT3Column.setCellValueFactory(new PropertyValueFactory("capacidadLibreT3"));
        this.capacidadLibreT4Column.setCellValueFactory(new PropertyValueFactory("capacidadLibreT4"));
        this.capacidadLibreT5Column.setCellValueFactory(new PropertyValueFactory("capacidadLibreT5"));
        this.estadoT1Column.setCellValueFactory(new PropertyValueFactory("estadoT1"));
        this.estadoT2Column.setCellValueFactory(new PropertyValueFactory("estadoT2"));
        this.estadoT3Column.setCellValueFactory(new PropertyValueFactory("estadoT3"));
        this.estadoT4Column.setCellValueFactory(new PropertyValueFactory("estadoT4"));
        this.estadoT5Column.setCellValueFactory(new PropertyValueFactory("estadoT5"));
        this.cargaActualB1Column.setCellValueFactory(new PropertyValueFactory("cargaActualB1"));
        this.cargaActualB2Column.setCellValueFactory(new PropertyValueFactory("cargaActualB2"));
        this.cargaActualB3Column.setCellValueFactory(new PropertyValueFactory("cargaActualB3"));
        this.cargaActualB4Column.setCellValueFactory(new PropertyValueFactory("cargaActualB4"));
        this.cargaActualB5Column.setCellValueFactory(new PropertyValueFactory("cargaActualB5"));
        this.estadoB1Column.setCellValueFactory(new PropertyValueFactory("estadoB1"));
        this.estadoB2Column.setCellValueFactory(new PropertyValueFactory("estadoB2"));
        this.estadoB3Column.setCellValueFactory(new PropertyValueFactory("estadoB3"));
        this.estadoB4Column.setCellValueFactory(new PropertyValueFactory("estadoB4"));
        this.estadoB5Column.setCellValueFactory(new PropertyValueFactory("estadoB5"));
        this.colaColumn.setCellValueFactory(new PropertyValueFactory("cola"));
        
    }    
    
    private boolean validarDatos(){
        
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("ERROR");
        try{
            horasSimulacion = Double.parseDouble(txtHorasSimulacion.textProperty().get());
            horaDesde = Double.parseDouble(txtHoraDesde.textProperty().get());
            horaHasta = Double.parseDouble(txtHoraHasta.textProperty().get());
        }
        catch (NumberFormatException e){
            dialog.setHeaderText("Debe cargar números");
            dialog.showAndWait();
            return false;
        }
        
        if (horasSimulacion < 0 || horaDesde < 0 || horaHasta < 0) {
            dialog.setHeaderText("Los números deben ser superiores a 0");
            dialog.showAndWait();
            return false;
        }
        
        if (horaDesde >= horaHasta) {
            dialog.setHeaderText("Intervalo invalido");
            dialog.showAndWait();
            return false;
        }
        
        
        
        return true;
    }

    @FXML
    private void clickBtnSimular(MouseEvent event) {
        
        if (validarDatos()) {
           simulador = new GestorSimulacion(this.horaDesde, this.horaHasta, this.horasSimulacion);
            
            
            
        }
                
        
    }
    
}
