package code;

import java.util.Comparator;

/**
 * @author :  sardor.matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 01 апр. 2025
 **/
public class Child extends Parent implements Comparator<Child> {
    @Override
    public String name() {
        return "Child";
    }

    @Override
    public int compare(Child child, Child t1) {
        return 0;
    }
}
