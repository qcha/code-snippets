package qcha.how2.xml.dom;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(new XmlParser().parse(Test.class.getResourceAsStream("test.xml")));
    }
}
