package cn.edu.tjufe.zql.lang;


/**
 *
 * @authro 钟奇林
 * @description 可迭代接口
 * @date 2025/3/23
 * @github https://github.com/little-seven-thirty
 */
public interface Iterable<E> {
    Iterator<E> getIterator();  // 获取迭代器
}
