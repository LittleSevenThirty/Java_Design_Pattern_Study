package cn.edu.tjufe.zql.lang;

/**
 *
 * @authro 钟奇林
 * @description 集合功能接口定义
 * @date 2025/3/23
 * @github https://github.com/little-seven-thirty
 */
public interface Collection<E,L> extends Iterable<E> {
    boolean add(E e);

    boolean remove(E e);

    boolean addLink(String key,L l);

    boolean removeLink(String key);

    @Override
    Iterator<E> getIterator();
}
