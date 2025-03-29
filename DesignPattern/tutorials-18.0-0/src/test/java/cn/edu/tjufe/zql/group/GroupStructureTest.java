package cn.edu.tjufe.zql.group;

import cn.edu.tjufe.zql.lang.Iterator;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupStructureTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(GroupStructureTest.class);

    @Test
    public void test_iterator() {
        // 数据填充
        GroupStructure groupStructure = new GroupStructure("1", "小傅哥");

        // 雇员信息
        groupStructure.add(new Employee("2", "花花", "二级部门"));
        groupStructure.add(new Employee("3", "豆包", "二级部门"));
        groupStructure.add(new Employee("4", "蹦蹦", "三级部门"));
        groupStructure.add(new Employee("5", "大烧", "三级部门"));
        groupStructure.add(new Employee("6", "虎哥", "四级部门"));
        groupStructure.add(new Employee("7", "玲姐", "四级部门"));
        groupStructure.add(new Employee("8", "秋雅", "四级部门"));

        // 节点关系 1->(1,2) 2->(4,5)
        groupStructure.addLink("1", new Link("1", "2"));
        groupStructure.addLink("1", new Link("1", "3"));
        groupStructure.addLink("2", new Link("2", "4"));
        groupStructure.addLink("2", new Link("2", "5"));
        groupStructure.addLink("5", new Link("5", "6"));
        groupStructure.addLink("5", new Link("5", "7"));
        groupStructure.addLink("5", new Link("5", "8"));

        Iterator<Employee> iterator = groupStructure.getIterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.getNext();
            logger.info("{}，雇员 Id：{} Name：{}", employee.getDesc(), employee.getuId(), employee.getName());
        }
    }
}