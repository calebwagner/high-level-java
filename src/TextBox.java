public class TextBox extends UIControl {
    private String text = "";

    public TextBox() {
        super(true); // calls base class constructor
        System.out.println("TextBox");
    }

    @Override
    public String toString() {
        return text;
    }

    public void setText(String text) {this.text = text;}

    public void clear() {text = "";}
}
