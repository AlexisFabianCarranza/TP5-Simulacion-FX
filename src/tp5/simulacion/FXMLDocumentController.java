/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.simulacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import tp5.simulacion.Class.Eventos.Simulacion.VectorEstado;

/**
 *
 * @author aleex
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
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
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
