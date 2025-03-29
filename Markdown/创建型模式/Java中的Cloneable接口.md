## Java中的Cloneable接口

**Cloneable**接口是Java中的一个标记接口，用于指示一个类的实例可以通过调用*Object.clone()*方法进行字段对字段的复制。如果一个类没有实现Cloneable接口，那么调用其*clone()*方法时会`CloneNotSupportedException`异常

**实现Cloneable接口**

要使一个对象可以被克隆，需要满足以下两个条件：

1. 实现*java.lang.Cloneable*接口。
2. 重写*Object*类的*clone()*方法。

以下是一个简单的示例：

```java
package com.example;

public class Info implements Cloneable {

private int id;

private String text;

public Info(int id, String text) {

this.id = id;

this.text = text;

}

@Override

protected Object clone() throws CloneNotSupportedException {

return super.clone();

}

public static void main(String[] args) throws CloneNotSupportedException {

Info info1 = new Info(1, "Hello World");

Info info2 = (Info) info1.clone();

System.out.println(info1 == info2); // false

System.out.println(info1.equals(info2)); // true

}

}
```

在这个示例中，*Info*类实现了*Cloneable*接口，并重写了*clone()*方法[2](https://www.jianshu.com/p/ea8f7b1fbbb1)。

浅克隆与深克隆

**浅克隆**（shallow clone）只复制对象本身及其基本类型字段，而不复制对象包含的引用指向的对象。**深克隆**（deep clone）不仅复制对象本身，还复制对象包含的所有引用对象[2](https://www.jianshu.com/p/ea8f7b1fbbb1)。

‌**浅克隆示例（Shallow Clone）**‌

```java
javaCopy Code
class Person implements Cloneable {
    String name;
    Address address; // 引用类型字段

    // 浅克隆：只复制地址的引用
    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone(); // 直接调用Object的clone()
    }
}
```

‌**深克隆示例（Deep Clone）**‌

```java
javaCopy Code
class Person implements Cloneable {
    String name;
    Address address;

    // 深克隆：复制地址对象本身
    @Override
    public Person clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = this.address.clone(); // 手动克隆引用对象
        return cloned;
    }
}

// Address也需要实现Cloneable
class Address implements Cloneable {
    String city;
    
    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}
```

‌**关键区别**‌：

1. ‌**浅克隆**‌

   ：只复制基础类型和引用（新对象和原对象共享内部对象）

   - 修改克隆后的 `person.address.city` 会影响原对象

2. ‌**深克隆**‌

   ：递归复制所有引用对象（完全独立的新对象）

   - 修改克隆后的 `person.address.city` ‌**不会**‌影响原对象

‌**总结**‌：

- 浅克隆：`super.clone()` 直接复制所有字段（包括引用）
- 深克隆：手动克隆每一个引用类型的字段
- 实际开发中更推荐用`拷贝构造函数`或`序列化`实现深克隆（避免`Cloneable`的设计缺陷）