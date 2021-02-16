package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    String[] currencies = {"USD","EUR","DZD","GBP"};
    @FXML
    TextField inputTF;
    @FXML
    Text resultTF;
    @FXML
    ComboBox combo1;
    @FXML
    ComboBox combo2;
    @FXML
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnPoint,btnDelete;


    public void initialize(URL location, ResourceBundle resources) {
        combo1.getItems().addAll(currencies);
        combo1.getSelectionModel().select(0);
        combo2.getItems().addAll(currencies);
        combo2.getSelectionModel().select(0);
        System.out.println("Initialized");
    }



    public void refresh(){
        boolean scan=true;
        String input = inputTF.getText();
        String numbers = "0123456789.";
        for(int i=0;i<input.length();i++){
            if ((int)input.charAt(i)>57||(int)input.charAt(i)<48){
                scan=false;
                inputTF.setText(input.substring(0,inputTF.getText().length()-1));
                inputTF.positionCaret(inputTF.getLength());
            }
        }
        if(scan){
            resultTF.setText(recalculate());
        }

    }

    String recalculate(){
        String from = combo1.getValue().toString();
        String to = combo2.getValue().toString();
        DecimalFormat df = new DecimalFormat("#.0000");
        double input = 0;
        double result = 0.0;
        if (inputTF.getText().length()>0){
            try {
                input = Double.parseDouble(inputTF.getText());
            } catch (NumberFormatException exception){
                System.out.println("Please input numbers only!");
                result = Double.parseDouble(inputTF.getText().substring(0,inputTF.getText().length()-1));

            }

        }

        switch (from){
            case "USD":
                switch (to){
                    case "USD":
                        result = input * 1;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "EUR": {
                        result = input * 0.82;
                        result = Double.parseDouble(df.format(result));
                        break;
                    }
                    case "GBP":
                        result = input * 0.73;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "DZD":
                        result = input * 132.60;
                        result = Double.parseDouble(df.format(result));
                        break;
                }
                break;
            case "EUR":
                switch (to){
                    case "USD":
                        result = input * 1.21;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "EUR":
                        result = input * 1;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "GBP":
                        result = input * 0.89;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "DZD":
                        result = input * 160.98;
                        result = Double.parseDouble(df.format(result));
                        break;
                }
                break;
            case "GBP":
                switch (to){
                    case "USD":
                        result = input * 1.37;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "EUR":
                        result = input * 1.13;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "GBP":
                        result = input * 1;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "DZD":
                        result = input * 181.16;
                        result = Double.parseDouble(df.format(result));
                        break;
                }
                break;
            case "DZD":
                switch (to){
                    case "USD":
                        result = input * 0.0075;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "EUR":
                        result = input * 0.0062;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "GBP":
                        result = input * 0.0055;
                        result = Double.parseDouble(df.format(result));
                        break;
                    case "DZD":
                        result = input * 1;
                        result = Double.parseDouble(df.format(result));
                        break;
                }
                break;
        }
        return String.valueOf(result);
    }
    public void btn1p(){
        inputTF.setText(inputTF.getText().concat("1"));
        resultTF.setText(recalculate());
    }
    public void btn2p(){
        inputTF.setText(inputTF.getText().concat("2"));
        resultTF.setText(recalculate());
    }
    public void btn3p(){
        inputTF.setText(inputTF.getText().concat("3"));
        resultTF.setText(recalculate());
    }
    public void btn4p(){
        inputTF.setText(inputTF.getText().concat("4"));
        resultTF.setText(recalculate());
    }
    public void btn5p(){
        inputTF.setText(inputTF.getText().concat("5"));
        resultTF.setText(recalculate());
    }
    public void btn6p(){
        inputTF.setText(inputTF.getText().concat("6"));
        resultTF.setText(recalculate());
    }
    public void btn7p(){
        inputTF.setText(inputTF.getText().concat("7"));
        resultTF.setText(recalculate());
    }
    public void btn8p(){
        inputTF.setText(inputTF.getText().concat("8"));
        resultTF.setText(recalculate());
    }
    public void btn9p(){
        inputTF.setText(inputTF.getText().concat("9"));
        resultTF.setText(recalculate());
    }
    public void btn0p(){
        inputTF.setText(inputTF.getText().concat("0"));
        resultTF.setText(recalculate());
    }
    public void btnPointP(){
        if (inputTF.getText().length()>1){
            if (!inputTF.getText().contains(".")) {
                inputTF.setText(inputTF.getText().concat("."));
                resultTF.setText(recalculate());
            }
        } else {
            inputTF.setText("0.");
            resultTF.setText(recalculate());
        }
    }
    public void btnDeleteP(){
        if (inputTF.getText().length()>0) {
            inputTF.setText(inputTF.getText().substring(0, inputTF.getText().length() - 1));
            resultTF.setText(recalculate());
        }
    }

}
