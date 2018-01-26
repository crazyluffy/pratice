public class Cost {
    private String name;
    private String  time;
    private Double value;

    public Cost(String name, String time, double value) {
        this.name = name;
        this.time = time;
        this.value = value;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return time;
    }

    public void setDate(String time) {
        this.time = time;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
