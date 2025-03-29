package cn.edu.tjufe.zql.lang;

/**
 *
 * @authro 钟奇林
 * @description 迭代器类
 * @date 2025/3/23
 * @github https://github.com/little-seven-thirty
 *
 * E: Entity
 */
public interface Iterator<E> {
    boolean hasNext();      // 判断是否有next

    E getNext();            // 获取next
}
