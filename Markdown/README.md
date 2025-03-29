# 设计模式学习与总结 🎯

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
![Progress](https://img.shields.io/badge/Progress-23%20Patterns%20Covered-green)

一套设计模式学习总结，包含代码示例、实际应用场景分析。适合面向对象设计和架构设计的参考指南。

---

## 目录 📚
1. [设计模式分类](#设计模式分类)
2. [常用模式速查表](.\总结.md)
3. [代码示例](#代码示例)

---

## 设计模式分类

### 1. 创建型模式（5种）
| 模式名称   | 核心思想           |
| ---------- | ------------------ |
| 单例模式   | 全局唯一实例       |
| 工厂方法   | 子类决定对象创建   |
| 抽象工厂   | 创建产品族         |
| 建造者模式 | 分步骤构建复杂对象 |
| 原型模式   | 克隆对象           |

### 2. 结构型模式（7种）
| 模式名称   | 核心思想     | 应用场景   |
| ---------- | ------------ | ---------- |
| 适配器模式 | 接口转换     | 旧系统整合 |
| 装饰器模式 | 动态添加职责 | Java I/O流 |
| 代理模式   | 控制访问     | Spring AOP |
| 组合模式   | 树形结构处理 | UI组件嵌套 |

### 3. 行为型模式（11种）
| 模式名称   | 核心思想     | 典型案例     |
| ---------- | ------------ | ------------ |
| 观察者模式 | 事件通知机制 | GUI事件监听  |
| 策略模式   | 算法互换     | 支付方式选择 |
| 模板方法   | 定义算法骨架 | JdbcTemplate |
| 责任链模式 | 请求传递链   | 审批流程     |

---

## 常用模式速查表 🚀
| 使用频率 | 模式名称   | 一句话应用场景             |
| -------- | ---------- | -------------------------- |
| ⭐⭐⭐⭐⭐    | 单例模式   | 需要全局唯一访问点的场景   |
| ⭐⭐⭐⭐     | 工厂方法   | 需要解耦对象创建过程的场景 |
| ⭐⭐⭐⭐     | 观察者模式 | 事件驱动或消息通知场景     |
| ⭐⭐⭐⭐     | 策略模式   | 需要动态切换算法的场景     |

---

## 代码示例 💻
### 单例模式（双重检查锁）
```java
public class Singleton {
    private static volatile Singleton instance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```
更多示例查看 [examples目录](./examples)

---

## 学习资源 📖
- 经典书籍：《设计模式：可复用面向对象软件的基础》
- 在线教程：
  - [Refactoring.Guru 设计模式](https://refactoring.guru/design-patterns)
  - [Java Design Patterns](https://java-design-patterns.com/)
- UML工具：[PlantUML](https://plantuml.com/) 绘制类图

---

## 贡献指南 🤝
欢迎提交Issue或PR完善以下内容：
1. 补充模式的应用场景案例
2. 添加更多编程语言实现（如Python/C++）
3. 完善UML图
