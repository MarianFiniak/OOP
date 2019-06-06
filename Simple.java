import java.io.Serializable;

public interface Simple<E> extends  Iterable<E>, Serializable {
    boolean add(E e);
    void delete(int index);
    E get(int index);
    int size();
    void update(int index,E e);
    void clear();
}
