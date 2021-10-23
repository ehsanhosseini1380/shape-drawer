package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    @FXML
    private Button Exit;
    @FXML
    private Button Start;
    @FXML
    private Button Help;
    @FXML
    public void OnButtonClicked(ActionEvent event) throws IOException {
        if(event.getSource().equals(Exit)){
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        }else if(event.getSource().equals(Help)){
            Parent Page1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene p1 = new Scene(Page1,1000,800);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VBox vBox = new VBox();
            String help = "Start : By Clicking This Button,The Program Will Draw\n\nThe Shapes That You Entered In The Text File Named shapes.txt .\n\n\n\n" +
                    "Edit : This Button Will Take You To The Editor Page\n\nWhere You Can Edit The Size , Color or Position\n\nYou Can Also Delete The Shape That You Selected !\n\n\n\n" +
                    "Exit : By Clicking The Exit Button The Program Will Be Closed .\n\n\n\n\n\n\n";
            Label label = new Label(help);
            label.setStyle("-fx-font-size: 18.5");
            Button button = new Button("Back");
            button.setStyle("-fx-background-color: lightgray");
            button.setTextFill(Paint.valueOf("Black"));
            button.setOnAction(e->{window.setScene(p1);window.setTitle("Menu");});
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().add(label);
            vBox.getChildren().add(button);
            Scene scene = new Scene(vBox,1000 , 1000);
            scene.setFill(Paint.valueOf("lightsteelblue"));
            window.setTitle("Help");
            window.setScene(scene);
            window.show();
        }
    }
    @FXML
    private Button Edit;

    @FXML
    public void ChangeScene(ActionEvent event) throws IOException {
        if (event.getSource().equals(Start)) {
            Group group=new Group();

            for(circle c:Handle.circles){
                Circle ci=new Circle(c.xpos,c.ypos,c.radius);
                ci.setFill(Paint.valueOf(c.color));
                group.getChildren().add(ci);
            }
            for(rectangle r:Handle.rectangles){
                Rectangle re=new Rectangle(r.xpos,r.ypos,r.length,r.height);
                re.setFill(Paint.valueOf(r.color));
                group.getChildren().add(re);
            }
            for(square s:Handle.squares){
                Rectangle sq=new Rectangle(s.xpos,s.ypos,s.length,s.length);
                sq.setFill(Paint.valueOf(s.color));
                group.getChildren().add(sq);
            }
            for(ellipse e:Handle.ellipses){
                Ellipse el=new Ellipse(e.xpos,e.ypos,e.radius1,e.radius2);
                el.setFill(Paint.valueOf(e.color));
                group.getChildren().add(el);
            }
            Scene page3scene=new Scene(group,1000,800);
            page3scene.setFill(Paint.valueOf("lightsteelblue"));
            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            HBox h=new HBox();
            Button button=new Button("Edit");
            Button button1=new Button("Menu");
            button.setStyle("-fx-background-color: lightgray");
            button1.setStyle("-fx-background-color: lightgray");
            button.setTextFill(Paint.valueOf("Black"));
            button1.setTextFill(Paint.valueOf("Black"));
            button.setAlignment(Pos.TOP_CENTER);
            button.setAlignment(Pos.BOTTOM_RIGHT);
            button1.setAlignment(Pos.BOTTOM_RIGHT);
            h.getChildren().add(button);
            h.getChildren().add(button1);
            h.setAlignment(Pos.BOTTOM_RIGHT);
            h.setSpacing(10);
            group.getChildren().add(h);
            Parent p2=FXMLLoader.load((getClass().getResource("page2.fxml")));
            Parent p1=FXMLLoader.load((getClass().getResource("sample.fxml")));
            Scene page1=new Scene(p1,1000,800);
            Scene page2=new Scene(p2,1000,800);
            button.setOnAction(e->{ window.setScene(page2);window.setTitle("Editor"); });
            button1.setOnAction(e->{ window.setScene(page1);window.setTitle("Menu"); });
            window.setTitle("Draw");
            window.setScene(page3scene);
            window.show();

        } else if (event.getSource().equals(Edit)) {
            Parent page2 = FXMLLoader.load((getClass().getResource("page2.fxml")));
            Scene page2scene = new Scene(page2, 1000, 800);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Editor");
            window.setScene(page2scene);
            window.show();
        }
    }
}
