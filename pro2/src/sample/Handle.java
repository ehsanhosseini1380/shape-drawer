package sample;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class Handle {
    public static ArrayList<String> Fileread(String path) {
        File file = new File(path);
        BufferedReader bufferedReader;
        String line;
        ArrayList<String> Lines = new ArrayList<String>();
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(file.getPath()));
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] lines = line.split("\n");
                    for (String L : lines) {
                        Lines.add(L);
                    }
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Lines;
    }
    public static ArrayList<ellipse> GetEllipses(){
        ArrayList<String> lines = Fileread("shapes.txt");
        ArrayList<ellipse> ellipses = new ArrayList<>();
        mainloop:
        for (String line : lines){
            String str = line;
            for (int j = 0; j < str.length() - 5; j++) {
                if (str.substring(j, j + 5).equals("type=")) {
                    for (int k = j + 5; k < str.length(); k++) {
                        if (str.charAt(k) == ' ') {
                            if (str.substring(j + 5, k).equals("ellipse")) {
                                ellipse ell = new ellipse();
                                ellipses.add(ell);
                                for (int p = 0; p < str.length() - 5; p++) {
                                    if (str.substring(p, p + 5).equals("name=")) {
                                        for (int q = p + 5; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                ell.setName(str.substring(p + 5, q));
                                                break;
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length() - 6; p++) {
                                    if (str.substring(p, p + 6).equals("color=")) {
                                        for (int q = p + 6; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                ell.setColor(str.substring(p + 6, q));
                                                break;
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length(); p++) {
                                    if (str.charAt(p) == '(') {
                                        for (int q = p + 1; q < str.length(); q++) {
                                            if (str.charAt(q) == ',') {
                                                if (p + 1 != q) {
                                                    ell.setXpos(Integer.parseInt(str.substring(p + 1, q)));
                                                    for (int r = q; r < str.length(); r++) {
                                                        if (str.charAt(r) == ')') {
                                                            if (q + 1 != r) {
                                                                ell.setYpos(Integer.parseInt(str.substring(q + 1, r)));
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length() - 8; p++) {
                                    if (str.substring(p, p + 8).equals("radius1=")) {
                                        for (int q = p + 8; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                ell.setRadius1(Integer.parseInt(str.substring(p + 8, q)));
                                                break;
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length() - 8; p++) {
                                    if (str.substring(p, p + 8).equals("radius2=")) {
                                        for (int q = p + 8; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                ell.setRadius2(Integer.parseInt(str.substring(p + 8, q)));
                                                continue mainloop;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ellipses;
    }
    public static ArrayList<rectangle> GetRectangles(){
        ArrayList<String> lines = Fileread("shapes.txt");
        ArrayList<rectangle> rectangles = new ArrayList<>();
        mainloop:
        for (String line : lines){
            String str = line;
            for (int j = 0; j < str.length() - 5; j++) {
                if (str.substring(j, j + 5).equals("type=")) {
                    for (int k = j + 5; k < str.length(); k++) {
                        if (str.charAt(k) == ' ') {
                            if (str.substring(j + 5, k).equals("rectangle")) {
                                rectangle rec = new rectangle();
                                rectangles.add(rec);
                                for (int p = 0; p < str.length() - 5; p++) {
                                    if (str.substring(p, p + 5).equals("name=")) {
                                        for (int q = p + 5; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                rec.setName(str.substring(p + 5, q));
                                                break;
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length() - 6; p++) {
                                    if (str.substring(p, p + 6).equals("color=")) {
                                        for (int q = p + 6; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                rec.setColor(str.substring(p + 6, q));
                                                break;
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length(); p++) {
                                    if (str.charAt(p) == '(') {
                                        for (int q = p + 1; q < str.length(); q++) {
                                            if (str.charAt(q) == ',') {
                                                if (p + 1 != q) {
                                                    rec.setXpos(Integer.parseInt(str.substring(p + 1, q)));
                                                    for (int r = q; r < str.length(); r++) {
                                                        if (str.charAt(r) == ')') {
                                                            if (q + 1 != r) {
                                                                rec.setYpos(Integer.parseInt(str.substring(q + 1, r)));
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length() - 7; p++) {
                                    if (str.substring(p, p + 7).equals("length=")) {
                                        for (int q = p + 7; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                rec.setLength(Integer.parseInt(str.substring(p + 7, q)));
                                                break;
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length() - 7; p++) {
                                    if (str.substring(p, p + 7).equals("height=")) {
                                        for (int q = p + 7; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                rec.setHeight(Integer.parseInt(str.substring(p + 7, q)));
                                                continue mainloop;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return rectangles;
    }
    public static ArrayList<square> GetSquares(){
        ArrayList<String> lines = Fileread("shapes.txt");
        ArrayList<square> squares = new ArrayList<>();
        mainloop:
        for (String line : lines){
            String str = line;
            for (int j = 0; j < str.length() - 5; j++) {
                if (str.substring(j, j + 5).equals("type=")) {
                    for (int k = j + 5; k < str.length(); k++) {
                        if (str.charAt(k) == ' ') {
                            if (str.substring(j + 5, k).equals("square")) {
                                square squ = new square();
                                squares.add(squ);
                                for (int p = 0; p < str.length() - 5; p++) {
                                    if (str.substring(p, p + 5).equals("name=")) {
                                        for (int q = p + 5; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                squ.setName(str.substring(p + 5, q));
                                                break;
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length() - 6; p++) {
                                    if (str.substring(p, p + 6).equals("color=")) {
                                        for (int q = p + 6; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                squ.setColor(str.substring(p + 6, q));
                                                break;
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length(); p++) {
                                    if (str.charAt(p) == '(') {
                                        for (int q = p + 1; q < str.length(); q++) {
                                            if (str.charAt(q) == ',') {
                                                if (p + 1 != q) {
                                                    squ.setXpos(Integer.parseInt(str.substring(p + 1, q)));
                                                    for (int r = q; r < str.length(); r++) {
                                                        if (str.charAt(r) == ')') {
                                                            if (q + 1 != r) {
                                                                squ.setYpos(Integer.parseInt(str.substring(q + 1, r)));
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length() - 7; p++) {
                                    if (str.substring(p, p + 7).equals("length=")) {
                                        for (int q = p + 7; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                squ.setLength(Integer.parseInt(str.substring(p + 7, q)));
                                                continue mainloop;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return squares;
    }
    public static ArrayList<circle> GetCircles(){
        ArrayList<String> lines = Fileread("shapes.txt");
        ArrayList<circle> circles = new ArrayList<>();
        mainloop:
        for (String line : lines){
            String str = line;
            for (int j = 0; j < str.length() - 5; j++) {
                if (str.substring(j, j + 5).equals("type=")) {
                    for (int k = j + 5; k < str.length(); k++) {
                        if (str.charAt(k) == ' ') {
                            if (str.substring(j + 5, k).equals("circle")) {
                                circle cir = new circle();
                                circles.add(cir);
                                for (int p = 0; p < str.length() - 5; p++) {
                                    if (str.substring(p, p + 5).equals("name=")) {
                                        for (int q = p + 5; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                cir.setName(str.substring(p + 5, q));
                                                break;
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length() - 6; p++) {
                                    if (str.substring(p, p + 6).equals("color=")) {
                                        for (int q = p + 6; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                cir.setColor(str.substring(p + 6, q));
                                                break;
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length(); p++) {
                                    if (str.charAt(p) == '(') {
                                        for (int q = p + 1; q < str.length(); q++) {
                                            if (str.charAt(q) == ',') {
                                                if (p + 1 != q) {
                                                    cir.setXpos(Integer.parseInt(str.substring(p + 1, q)));
                                                    for (int r = q; r < str.length(); r++) {
                                                        if (str.charAt(r) == ')') {
                                                            if (q + 1 != r) {
                                                                cir.setYpos(Integer.parseInt(str.substring(q + 1, r)));
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                for (int p = 0; p < str.length() - 7; p++) {
                                    if (str.substring(p, p + 7).equals("radius=")) {
                                        for (int q = p + 7; q < str.length(); q++) {
                                            if (str.charAt(q) == ' ') {
                                                cir.setRadius(Integer.parseInt(str.substring(p + 7, q)));
                                                continue mainloop;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return circles;
    }
    public static ArrayList<circle> circles=GetCircles();
    public static ArrayList<ellipse> ellipses=GetEllipses();
    public static ArrayList<rectangle> rectangles=GetRectangles();
    public static ArrayList<square> squares=GetSquares();
}

