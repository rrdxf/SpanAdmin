package may_10;

public class Column implements Comparable<Column>{
    private int redius;
    private int h;

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getRedius() {
        return redius;
    }

    public void setRedius(int redius) {
        this.redius = redius;
    }

    @Override
    public String toString() {
        return "Column{" +
                "redius=" + redius +
                ", h=" + h +
                '}';
    }

    public Column(int redius, int h) {
        this.redius = redius;
        this.h = h;
    }

    @Override
    public int compareTo(Column o) {
        if (this.redius == o.redius){
            return this.h - o.h;
        }
        return this.redius - o.redius;
    }
}
