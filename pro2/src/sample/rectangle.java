package sample;

class rectangle extends shape {
    int length, height;
    final String type="rectangle";
    public rectangle(){
        this.length=400;
        this.height=300;
        this.color="Black";
        this.xpos=250;
        this.ypos=250;
    }

    public String getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
