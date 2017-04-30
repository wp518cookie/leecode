package medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ping.wu on 2017/1/18.
 */

public class Flatten_Nested_List_Iterator_341 implements Iterator<Integer> {
    private Iterator<Integer> it ;
    private List<Integer> list = new LinkedList<>();
    public Flatten_Nested_List_Iterator_341(List<NestedInteger> nestedList) {
        getValue(nestedList);
        it = list.iterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    public List<Integer> getValue(List<NestedInteger> t_list) {
        Iterator<NestedInteger> it = t_list.iterator();
        while (it.hasNext()) {
            NestedInteger nestedInteger = it.next();
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                getValue(nestedInteger.getList());
            }
        }
        return null;
    }
}
