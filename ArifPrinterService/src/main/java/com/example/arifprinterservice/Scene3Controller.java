package com.example.arifprinterservice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileWriter;

public class Scene3Controller {
    @FXML
    Label billLabel;
    @FXML
    TextField transactionIdTextField;

    String name;
    public void displayBill(Double bill,String s) throws Exception
    {
        billLabel.setText(String.valueOf(bill)+" taka");
        name=s;
        FileWriter fw=new FileWriter("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+name+"\\Instruction.txt",true);
        fw.write("\n**Bill: "+String.valueOf(bill)+" taka**");
        fw.close();
    }

    public void done(ActionEvent event) throws Exception
    {
        FileWriter fw=new FileWriter("E:\\openjfx-19_windows-x64_bin-sdk\\ArifPrinterService\\To Print\\"+name+"\\Instruction.txt",true);
        fw.write("\nTransaction Id: "+transactionIdTextField.getText());
        fw.close();
    }

}
