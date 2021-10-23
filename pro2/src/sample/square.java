package sample;

class square extends shape{
    int length ;
    final String type="square";
    public square(){
        this.length=200;
        this.color="Black";
        this.xpos=100;
        this.ypos=100;
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
}