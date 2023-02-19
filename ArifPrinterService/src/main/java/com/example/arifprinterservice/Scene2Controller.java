package com.example.arifprinterservice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Scene2Controller {
    @FXML
    Label topWelcomeLabel;
    @FXML
    ImageView docxImageView;
    @FXML
    RadioButton rButton1,rButton2,rButton3;
    @FXML
    TextField pageNumberTextField;
    @FXML
    CheckBox tapeBindingButton;

    private Stage stage;
    private Parent root;
    private Scene scene;
    String name;
    public void displayWelcomeMessage (String s)
        {
            topWelcomeLabel.setText("Hi "+s+", please drop your file.");
            name=s;
        }
    double bill=0;

    public void handelDragOver(DragEvent event)
    {
        if(event.getDragboard().hasFiles())
        {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
    public void handelDragDropped(DragEvent event)
    {
       List<File> files =event.getDragboard().getFiles();
       try{
           Files.copy(new FileInputStream(files.get(0)), Path.of("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+name+"\\Document.docx"));
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
    }
    public void handelDragOverPdf(DragEvent event)
    {
        if(event.getDragboard().hasFiles())
        {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
    public void handelDragDroppedPdf(DragEvent event)
    {
        List<File> files =event.getDragboard().getFiles();
        try{
            Files.copy(new FileInputStream(files.get(0)), Path.of("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+name+"\\Document.pdf"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void setBill() throws Exception
    {

        int pageNo=Integer.parseInt(pageNumberTextField.getText());
        if(rButton1.isSelected()) {
            bill=pageNo*2;
            FileWriter fw=new FileWriter("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+name+"\\Instruction.txt",true);
            fw.write("\n65 GSM");
            fw.close();
        }
        if (rButton2.isSelected()) {
            bill = pageNo * 2.5;
            FileWriter fw=new FileWriter("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+name+"\\Instruction.txt",true);
            fw.write("\n80 GSM Black&White");
            fw.close();
        }
        if(rButton3.isSelected()) {
            bill = pageNo * 3;
            FileWriter fw=new FileWriter("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+name+"\\Instruction.txt",true);
            fw.write("\n80 GSM Color");
            fw.close();
        }

    }
    public void tapeBinding(ActionEvent event) throws Exception
    {
        if(tapeBindingButton.isSelected()) bill+=25;
        FileWriter fw=new FileWriter("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+name+"\\Instruction.txt",true);
        fw.write("\n**Tape Binding**");
        fw.close();
    }

    public void change(ActionEvent event) throws Exception
    {

            FXMLLoader loader=new FXMLLoader(getClass().getResource("Scene3.fxml"));
            root=loader.load();
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(root);
            Scene3Controller scene3Controller=loader.getController();
            scene3Controller.displayBill(bill,name);
            stage.setScene(scene);
            stage.show();


    }





}
