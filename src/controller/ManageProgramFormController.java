package controller;

import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.impl.ProgramBOImpl;
import dto.ProgramDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class ManageProgramFormController {
    public TextField txtId;
    public TextField txtDuration;
    public TextField txtName;
    public TextField txtFee;

    public TableColumn<ProgramDTO,String> colId;
    public TableColumn<ProgramDTO,String> colName;
    public TableColumn<ProgramDTO,String> colDuration;
    public TableColumn<ProgramDTO,String> colFee;
    public TableView<ProgramDTO> tblProgram;
    public TextField txtId1;
    public TextField txtDuration1;
    public TextField txtName1;
    public TextField txtFee1;

    ObservableList<ProgramDTO> obList= FXCollections.observableArrayList();

    private final ProgramBO programBO= BOFactory.getInstance().getBO(BOFactory.BOType.PROGRAM);

    public void initialize(){
       // showValidation();
        try {
            viewAllPrograms();
        } catch (Exception e) {
            e.printStackTrace();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        tblProgram.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> {
                    setProgramData(newValue);
                }
        );
       // listenFieldChange(validationList);

    }

    private void viewAllPrograms() throws Exception {
        obList.clear();
        List<ProgramDTO> programs=programBO.searchAll();
        obList.addAll(programs);
        tblProgram.setItems(obList);
    }

    private void setProgramData(ProgramDTO i) {
        if(i!=null) {
            txtId.setText(i.getId());
            txtName.setText(i.getName());
            txtDuration.setText(i.getDuration());
            txtFee.setText(String.valueOf(i.getFee()));

            txtId1.setText(i.getId());
            txtName1.setText(i.getName());
            txtDuration1.setText(i.getDuration());
            txtFee1.setText(String.valueOf(i.getFee()));
        }
    }

    public void addProgramOnAction(ActionEvent actionEvent) throws Exception {
       // if (ValidationUtil.isAllValidated(validationList)){
            ProgramDTO item1 = new ProgramDTO(txtId.getText(),txtName.getText(),txtDuration.getText(),Double.parseDouble(txtFee.getText()));
            if(programBO.add(item1)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
                viewAllPrograms();
                clearFields();
            }else {
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
            }
       // }else{
          //  new Alert(Alert.AlertType.WARNING, "Fields are not filled properly..").show();
       // }
    }



    public void deleteProgramOnAction(ActionEvent actionEvent) throws Exception {
     //   if (ValidationUtil.isAllValidated(validationList)){
            if (programBO.delete(txtId1.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
                viewAllPrograms();
                clearFields();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again").show();
            }
       // }else{
          //  new Alert(Alert.AlertType.WARNING, "Fields are not filled properly..").show();
       // }
    }

    public void updateProgramOnAction(ActionEvent actionEvent) throws Exception {
       // if (ValidationUtil.isAllValidated(validationList)){
            ProgramDTO program1 = new ProgramDTO(txtId1.getText(),txtName1.getText(),txtDuration1.getText(),Double.parseDouble(txtFee1.getText()));
            if (programBO.update(program1)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated..").show();
                viewAllPrograms();
                clearFields();
            }else {
                new Alert(Alert.AlertType.WARNING, "Try Again").show();
            }
        //}else{
          //  new Alert(Alert.AlertType.WARNING, "Fields are not filled properly..").show();
        //}
    }

    public void searchIdOnAction(ActionEvent actionEvent) {
       /* String id = txtId1.getText();
        ProgramDTO item1= programBO.searchId(id);
        if (item1==null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        } else {
            setData(item1);
        }*/
    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
        txtDuration.clear();
        txtFee.clear();
        txtId1.clear();
        txtName1.clear();
        txtDuration1.clear();
        txtFee1.clear();
    }
}
