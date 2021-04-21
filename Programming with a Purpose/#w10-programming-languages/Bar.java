
public class Bar implements Comparable<Bar> {

    private final String name;
    private final int value;
    private final String category;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null || value < 0 || category == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.value = value;
        this.category = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return this.name;
    }

    // Returns the value of this bar.
    public int getValue() {
        return this.value;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return this.category;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException();
        }
        return Integer.compare(this.value, that.value);
    }

    // Sample client (see below).
    public static void main(String[] args) {
        Bar bar = new Bar("Huu", 12, "QuangNgai");
        Bar bar2 = new Bar("Hihi", 45, "HoChiMinh");
        System.out.println(bar.getName());
        System.out.println(bar2.getValue());
        System.out.println(bar.getCategory());
        System.out.println(bar.compareTo(bar2));
    }
}
