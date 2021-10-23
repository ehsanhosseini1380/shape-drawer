package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
public class Page2 {
    @FXML
    private TextField Name;

    @FXML
    private CheckBox Delete;

    @FXML
    private Button Select;

    @FXML
    private Label Info;

    @FXML
    private TextField Color;

    @FXML
    private TextField rSize;

    @FXML
    private TextField rHeight;

    @FXML
    private TextField rWidth;

    @FXML
    private TextField sLength;

    @FXML
    private TextField fRadius;

    @FXML
    private TextField sRadius;

    @FXML
    private TextField xComponent;

    @FXML
    private TextField yComponent;

    @FXML
    private Button Back;

    @FXML
    private Label GeneralInfo;

    @FXML
    private Button Save;

    @FXML
    public void gInfo(){
        String str="";
        for (circle c : Handle.circles){
            str=str+c.name+",";
        }
        for (rectangle r : Handle.rectangles){
            str=str+r.name+",";
        }
        for (square s : Handle.squares){
            str=str+s.name+",";
        }
        for (ellipse e : Handle.ellipses){
            str=str+e.name+",";
        }
        GeneralInfo.setText(str);
    }
    @FXML
    public void gInfo2(){
        GeneralInfo.setText("");
    }
    @FXML
    public void Change(ActionEvent event) throws IOException {
        if (event.getSource().equals(Save)) {
            String text = Name.getText();
            for (circle c : Handle.circles) {
                if (c.name.equals(text)) {
                    if(Delete.isSelected()) {
                        Handle.circles.remove(c);
                        break;
                    }
                    if(Color.getText().trim().equalsIgnoreCase("black") || Color.getText().trim().equalsIgnoreCase("white") || Color.getText().trim().equalsIgnoreCase("red") || Color.getText().trim().equalsIgnoreCase("blue") || Color.getText().trim().equalsIgnoreCase("green") || Color.getText().trim().equalsIgnoreCase("yellow") || Color.getText().trim().equalsIgnoreCase("gray") || Color.getText().trim().equalsIgnoreCase("brown")) {
                        c.setColor(Color.getText().trim());
                    }
                    if(!rSize.getText().isEmpty())
                    c.setRadius(Integer.parseInt(rSize.getText()));
                    if(!xComponent.getText().isEmpty())
                    c.setXpos(Integer.parseInt(xComponent.getText()));
                    if(!yComponent.getText().isEmpty())
                    c.setYpos(Integer.parseInt(yComponent.getText()));
                }
            }
            for (rectangle r : Handle.rectangles) {
                if (r.name.equals(text)) {
                    if(Delete.isSelected()) {
                        Handle.rectangles.remove(r);
                        break;
                    }
                    if(Color.getText().trim().equalsIgnoreCase("black") || Color.getText().trim().equalsIgnoreCase("white") || Color.getText().trim().equalsIgnoreCase("red") || Color.getText().trim().equalsIgnoreCase("blue") || Color.getText().trim().equalsIgnoreCase("green") || Color.getText().trim().equalsIgnoreCase("yellow") || Color.getText().trim().equalsIgnoreCase("gray") || Color.getText().trim().equalsIgnoreCase("brown")) {
                        r.setColor(Color.getText().trim());
                    }
                    if(!xComponent.getText().isEmpty())
                    r.setXpos(Integer.parseInt(xComponent.getText()));
                    if(!yComponent.getText().isEmpty())
                    r.setYpos(Integer.parseInt(yComponent.getText()));
                    if(!rHeight.getText().isEmpty())
                    r.setHeight(Integer.parseInt(rHeight.getText()));
                    if(!rWidth.getText().isEmpty())
                    r.setLength(Integer.parseInt(rWidth.getText()));
                }
            }
            for (square s : Handle.squares) {
                if (s.name.equals(text)) {
                    if(Delete.isSelected()) {
                        Handle.squares.remove(s);
                        break;
                    }
                    if(Color.getText().trim().equalsIgnoreCase("black") || Color.getText().trim().equalsIgnoreCase("white") || Color.getText().trim().equalsIgnoreCase("red") || Color.getText().trim().equalsIgnoreCase("blue") || Color.getText().trim().equalsIgnoreCase("green") || Color.getText().trim().equalsIgnoreCase("yellow") || Color.getText().trim().equalsIgnoreCase("gray") || Color.getText().trim().equalsIgnoreCase("brown")) {
                        s.setColor(Color.getText().trim());
                    }
                    if(!sLength.getText().isEmpty())
                    s.setLength(Integer.parseInt(sLength.getText()));
                    if(!xComponent.getText().isEmpty())
                    s.setXpos(Integer.parseInt(xComponent.getText()));
                    if(!yComponent.getText().isEmpty())
                    s.setYpos(Integer.parseInt(yComponent.getText()));
                }
            }
            for (ellipse e : Handle.ellipses) {
                if (e.name.equals(text)) {
                    if(Delete.isSelected()) {
                        Handle.ellipses.remove(e);
                        break;
                    }
                    if(Color.getText().trim().equalsIgnoreCase("black") || Color.getText().trim().equalsIgnoreCase("white") || Color.getText().trim().equalsIgnoreCase("red") || Color.getText().trim().equalsIgnoreCase("blue") || Color.getText().trim().equalsIgnoreCase("green") || Color.getText().trim().equalsIgnoreCase("yellow") || Color.getText().trim().equalsIgnoreCase("gray") || Color.getText().trim().equalsIgnoreCase("brown")) {
                        e.setColor(Color.getText().trim());
                    }
                    if(!fRadius.getText().isEmpty())
                    e.setRadius1(Integer.parseInt(fRadius.getText()));
                    if(!sRadius.getText().isEmpty())
                    e.setRadius2(Integer.parseInt(sRadius.getText()));
                    if(!xComponent.getText().isEmpty())
                    e.setXpos(Integer.parseInt(xComponent.getText()));
                    if(!yComponent.getText().isEmpty())
                    e.setYpos(Integer.parseInt(yComponent.getText()));
                }

            }
        } else if (event.getSource().equals(Back)) {
            Parent page1 = FXMLLoader.load((getClass().getResource("sample.fxml")));
            Scene page1scene = new Scene(page1, 1000, 800);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Menu");
            window.setScene(page1scene);
            window.show();
        }
    }

    @FXML
    private Label Wrong;

    @FXML
    public void Disable(ActionEvent event) {
        boolean flag=false;
        String text = Name.getText();
        if (text.isEmpty() || text.trim().isEmpty()) {
            Wrong.setText("Invalid Name");
            Save.setDisable(true);
            Delete.setDisable(true);
            Color.setDisable(true);
            rSize.setDisable(true);
            rHeight.setDisable(true);
            rWidth.setDisable(true);
            sLength.setDisable(true);
            fRadius.setDisable(true);
            sRadius.setDisable(true);
            xComponent.setDisable(true);
            yComponent.setDisable(true);
        } else {
            for (circle c : Handle.circles) {
                if (c.name.equals(text)) {
                    if (c.type.equals("circle")) {
                        Wrong.setText("");
                        flag=true;
                        Info.setText(("Type: "+c.type+"/Circle Name: "+c.name+"/Circle Color: "+c.color+"/Circle Radius: "+c.radius+"/Circle x pos: "+c.xpos+"/Circle y pos: "+c.ypos));
                        Save.setDisable(false);
                        xComponent.setDisable(false);
                        yComponent.setDisable(false);
                        Color.setDisable(false);
                        Delete.setDisable(false);
                        rSize.setDisable(false);
                        rHeight.setDisable(true);
                        rWidth.setDisable(true);
                        sLength.setDisable(true);
                        fRadius.setDisable(true);
                        sRadius.setDisable(true);
                    }
                }
            }
            for (rectangle r : Handle.rectangles) {
                if (r.name.equals(text)) {
                    if (r.type.equals("rectangle")) {
                        Wrong.setText("");
                        flag=true;
                        Info.setText(("Type: "+r.type+"/Rectangle Name: "+r.name+"/Rectangle Color:"+r.color+"/Rectangle length: "+r.length+"/Rectangle Height: "+r.height+"/Rectangle x pos: "+r.xpos+"/Rectangle y pos: "+r.ypos));
                        Save.setDisable(false);
                        rHeight.setDisable(false);
                        rWidth.setDisable(false);
                        Color.setDisable(false);
                        Delete.setDisable(false);
                        xComponent.setDisable(false);
                        yComponent.setDisable(false);
                        rSize.setDisable(true);
                        sLength.setDisable(true);
                        fRadius.setDisable(true);
                        sRadius.setDisable(true);
                    }
                }
            }
            for (square s : Handle.squares) {
                if (s.name.equals(text)) {
                    if (s.type.equals("square")) {
                        Wrong.setText("");
                        flag=true;
                        Info.setText(("Type: "+s.type+"/Square Name: "+s.name+"/Square Color: "+s.color+"/Square length: "+s.length+"/Square x pos: "+s.xpos+"/Square y pos: "+s.ypos));
                        Save.setDisable(false);
                        sLength.setDisable(false);
                        Color.setDisable(false);
                        Delete.setDisable(false);
                        xComponent.setDisable(false);
                        yComponent.setDisable(false);
                        rSize.setDisable(true);
                        rHeight.setDisable(true);
                        rWidth.setDisable(true);
                        fRadius.setDisable(true);
                        sRadius.setDisable(true);
                    }
                }
            }
            for (ellipse e : Handle.ellipses) {
                if (e.name.equals(text)) {
                    if (e.type.equals("ellipse")) {
                        Wrong.setText("");
                        flag=true;
                        Info.setText(("Type: "+e.type+"/Ellipse Name: "+e.name+"/Ellipse Color: "+e.color+"/Ellipse first radius: "+e.radius1+"/Ellipse second radius: "+e.radius2+"/Ellipse x pos: "+e.xpos+"/Ellipse y pos: "+e.ypos));
                        Save.setDisable(false);
                        Color.setDisable(false);
                        Delete.setDisable(false);
                        xComponent.setDisable(false);
                        yComponent.setDisable(false);
                        fRadius.setDisable(false);
                        sRadius.setDisable(false);
                        rSize.setDisable(true);
                        rHeight.setDisable(true);
                        rWidth.setDisable(true);
                        sLength.setDisable(true);
                    }
                }

            }
        }if(!flag) {
            Wrong.setText("Invalid Name");
            Save.setDisable(true);
            Delete.setDisable(true);
            Color.setDisable(true);
            rSize.setDisable(true);
            rHeight.setDisable(true);
            rWidth.setDisable(true);
            sLength.setDisable(true);
            fRadius.setDisable(true);
            sRadius.setDisable(true);
            xComponent.setDisable(true);
            yComponent.setDisable(true);
        }



    }


}

