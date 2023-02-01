package may_10;

import java.util.Arrays;

public class ColumnTest {
    public static void main(String[] args) {
        Column [] ColunmArray = {new Column(5,3),new Column(2,4),
        new Column(4,3),new Column(2,3),new Column(4,6)};
        Arrays.sort(ColunmArray);
        for (Column column : ColunmArray){
            System.out.println(column.toString());
        }
    }
}
