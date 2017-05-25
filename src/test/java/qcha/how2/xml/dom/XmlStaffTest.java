package qcha.how2.xml.dom;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

public class XmlStaffTest {
    @Test
    public void parseTestExmlAndGetTwoStaffs() throws Exception {
        XmlParser parser = new XmlParser();
        List<Staff> staffs = parser.parse(XmlStaffTest.class.getResourceAsStream("test.xml"));

        Assert.assertEquals(true, Objects.nonNull(staffs));
        Assert.assertEquals(2, staffs.size());

        Staff first = staffs.get(0);
        Assert.assertEquals("Aleksandr", first.getFirstname());
        Assert.assertEquals("Kuchuk", first.getLastname());
        Assert.assertEquals("aarexer", first.getNickname());
        Assert.assertEquals("11", first.getId());
        Assert.assertEquals(100000, first.getSalary());

        Staff second = staffs.get(1);
        Assert.assertEquals("Hello", second.getFirstname());
        Assert.assertEquals("World", second.getLastname());
        Assert.assertEquals("hell", second.getNickname());
        Assert.assertEquals("23", second.getId());
        Assert.assertEquals(2000, second.getSalary());
    }
}
