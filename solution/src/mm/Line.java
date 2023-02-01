package mm;

public class Line {
    private double b;
    private double k;

    public Point jiaodian(Line line2) {
        if (k == line2.k) return null;
        return new Point((line2.b - b) / (k - line2.k), (k * line2.b - b * line2.k) / (k - line2.k));
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public Line() {
    }

    public Line(double b, double k) {
        this.b = b;
        this.k = k;
    }
}
