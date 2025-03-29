package cn.edu.tjufe.zql;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @authro 钟奇林
 * @description 中介者模式
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
// 抽象中介者
interface ChatRoom {
    void addUser(User user);

    void sendMessage(String message, User user);
}

// 具体中介者：聊天室
class ConcreateChatRoom implements ChatRoom {
    // 聊天室用户列表
    private List<User> userList = new ArrayList<>();

    @Override
    public void addUser(User user) {
        this.userList.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : userList) {
            // 所有非本用户全部接收消息
            if (!u.equals(user)) {
                u.receiveMessage(message);
            }
        }
    }
}

// 抽象同事类
abstract class User {
    protected String name;
    protected ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    abstract void receiveMessage(String message);

    abstract void sendMessage(String message);
}

// 具体同事类
class ConcreteUser extends User {
    public ConcreteUser(String name, ChatRoom chatRoom) {
        super(name, chatRoom);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + "received: " + message);
    }

    @Override
    public void sendMessage(String message) {
        chatRoom.sendMessage(message, this);
    }
}

public class MeditarPatternDemo {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ConcreateChatRoom();
        User alice = new ConcreteUser("Alice", chatRoom);
        User bob = new ConcreteUser("Bob", chatRoom);

        chatRoom.addUser(bob);
        chatRoom.addUser(alice);

        alice.sendMessage("Hello, Bob!");
        bob.sendMessage("Hi, Alice!");
    }
}
