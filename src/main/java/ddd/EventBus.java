package ddd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * EventBus
 *
 * @author jingqingyun
 * @date 2021/1/25
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class EventBus {

    private volatile static EventBus instance = null;

    private final Map<String, List<DomainEventListener>> listeners;

    private EventBus() {
        this.listeners = new ConcurrentHashMap<>();
    }

    public static EventBus instance() {
        if (instance == null) {
            synchronized (EventBus.class) {
                if (instance == null) {
                    instance = new EventBus();
                }
            }
        }
        return instance;
    }

    public void register(DomainEventListener listener) {
        String tag = Objects.requireNonNull(listener.tag(), "Domain event listerner tag must not be null");
        this.listeners.computeIfAbsent(tag, k -> new ArrayList<>()).add(listener);
    }

    public <E extends DomainEvent> void dispatch(E event) {
        String tag = Objects.requireNonNull(event.tag(), "Domain event tag must not be null");
        List<DomainEventListener> listeners = this.listeners.get(tag);
        if (listeners == null || listeners.isEmpty()) {
            return;
        }
        listeners.forEach(item -> item.onEvent(event));
    }

}
