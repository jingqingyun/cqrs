package ddd;

import java.util.Objects;

/**
 * LocalEventPublisher
 *
 * @author jingqingyun
 * @date 2020/10/14
 */
public class EventPublisherDelegate implements EventPublisher {

    private volatile static EventPublisherDelegate INSTANCE;

    private EventPublisher publisher;

    private EventPublisherDelegate(){
    }

    public static EventPublisherDelegate instance() {
        if (INSTANCE == null) {
            synchronized (EventPublisherDelegate.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EventPublisherDelegate();
                }
            }
        }
        return INSTANCE;
    }

    public void delegate(EventPublisher  publisher) {
        Objects.requireNonNull(publisher, "EventPublisher must not be null");
        this.publisher = publisher;
    }

    @Override
    public void publish(Event e) {
        if (publisher == null) {
            throw new IllegalStateException("No delegated EventPublisher");
        }
        publisher.publish(e);
    }

}
