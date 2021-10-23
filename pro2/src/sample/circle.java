package sample;

class circle extends shape{
    int radius;
    final String type="circle";
    public circle(){
        this.radius = 100;
        this.color="Black";
        this.xpos=500;
        this.ypos=500;
    }
    public String getType() {
        return type;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public int getRadius() {
        return radius;
    }
}
