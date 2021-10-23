package sample;

class ellipse extends shape{
    int radius1, radius2;
    final String type="ellipse";
    public ellipse(){
        this.radius1=400;
        this.radius2=300;
        this.color="Black";
        this.xpos=300;
        this.ypos=300;
    }

    public String getType() {
        return type;
    }

    public int getRadius1() {
        return radius1;
    }

    public int getRadius2() {
        return radius2;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }
}
