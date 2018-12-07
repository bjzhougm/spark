package chapter01;

import java.io.Serializable;
import java.util.Comparator;

public class MyComparator implements Comparator<Integer>, Serializable {
    public int compare(Integer x, Integer y) {
        return -(y-x);
    }
}