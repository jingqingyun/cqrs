package ddd;

/**
 * EventSubcriber
 *
 * @author jingqingyun
 * @date 2020/11/24
 */
public interface DomainEventListener<E extends DomainEvent> {

    String tag();

    void onEvent(E e);

}
