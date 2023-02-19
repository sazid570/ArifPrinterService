package com.example.arifprinterservice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {
    @FXML
    TextField nameTextField;
    @FXML
    TextField phonenoTextField;

    private Stage stage;
    private Parent root;
    private Scene scene;

    public void change(ActionEvent event) throws IOException
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root=loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);

        Scene2Controller scene2Controller=loader.getController();
        scene2Controller.displayWelcomeMessage(nameTextField.getText());

        stage.setScene(scene);
        stage.show();

        File folder=new File("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+nameTextField.getText());
        folder.mkdir();
        File file=new File("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+nameTextField.getText()+"\\Instruction.txt");
        file.createNewFile();
        FileWriter fw=new FileWriter("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+nameTextField.getText()+"\\Instruction.txt",true);
        fw.write("Name: "+nameTextField.getText()+"\nPhone Number: "+phonenoTextField.getText());
        fw.close();


    }



}