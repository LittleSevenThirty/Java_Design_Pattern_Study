### `StringBuilder` 类快速指南

#### ‌**概述**‌

`StringBuilder` 是 Java 中用于高效操作字符串的类（‌**可变字符序列**‌），适合频繁修改字符串的场景（如拼接、插入、删除等），避免频繁创建新字符串对象，提升性能。

------

### ‌**常用方法速记**‌

#### 1. ‌**`append()` 方法**‌

‌**作用**‌：向字符串末尾追加内容（支持多种数据类型）。
‌**返回值**‌：返回 `this`，可链式调用。

```java
javaCopy Code
StringBuilder sb = new StringBuilder();
sb.append("Hello");         // 追加字符串
sb.append(123);             // 追加整数
sb.append(true);            // 追加布尔值
System.out.println(sb);     // 输出: Hello123true
```

#### 2. ‌**`insert()` 方法**‌

‌**作用**‌：在指定位置插入内容（索引从 0 开始）。
‌**语法**‌：`insert(int index, 数据)`

```java
javaCopy Code
StringBuilder sb = new StringBuilder("World");
sb.insert(0, "Hello ");     // 在索引 0 处插入
sb.insert(5, 123);          // 在索引 5 处插入数字
System.out.println(sb);     // 输出: Hello123World
```

------

### ‌**其他常用方法**‌

- ‌**`toString()`**‌：将 `StringBuilder` 转为 `String`。
- ‌**`reverse()`**‌：反转字符串。
- ‌**`delete(int start, int end)`**‌：删除指定区间的字符。
- ‌**`replace(int start, int end, String str)`**‌：替换区间内容。

------

### ‌**示例代码**‌

```java
javaCopy Code
public class Main {
    public static void main(String[] args) {
        // 使用 append
        StringBuilder sb = new StringBuilder();
        sb.append("Java").append(" ").append("Rocks!");
        System.out.println(sb);  // 输出: Java Rocks!

        // 使用 insert
        sb.insert(5, "真的");
        System.out.println(sb);  // 输出: Java真的 Rocks!
    }
}
```

------

### ‌**注意事项**‌

1. ‌**非线程安全**‌：`StringBuilder` 不是线程安全的，多线程环境下需用 `StringBuffer`。
2. ‌**初始容量**‌：默认初始容量为 16 字符，超出时自动扩容（无需手动管理）。
3. ‌**何时使用**‌：频繁修改字符串时优先选择 `StringBuilder`；单次操作直接使用 `+` 拼接即可。