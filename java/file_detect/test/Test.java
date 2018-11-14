import renm;

import java.util.Iterator;
import java.util.List;

class TestNode {
    int  i;
    String str;

    public TestNode(int i, String str) {
        this.i = i;
        this.str = str;
    }

    @Override
    public String toString() {
        return "TestNode{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }
}

public class Test {
    String str;

    public void setStr(String str) {
        this.str = str;
    }

    public Test(List list) {
        System.out.println("Spring test class");
        System.currentTimeMillis();
        list.add(new TestNode(1, "test"));
        for(Iterator iterators = list.iterator(); iterators.hasNext();){
            TestNode example = (TestNode) iterators.next();//获取当前遍历的元素，指定为Example对象
            System.out.println("\t "+ example);
        }
    }

    public Test(String str, List list) {
        this(list);
        this.str = str;
        System.out.println("test.str=\"" + str + "\"");
    }
}
