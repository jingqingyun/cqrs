package ddd;

/**
 * BookCreatedEventListerer
 *
 * @author jingqingyun
 * @date 2021/1/25
 */
public class BookCreatedEventListener implements DomainEventListener<BookCreatedEvent> {

    public BookCreatedEventListener() {
        EventBus.instance().register(this);
    }

    @Override
    public String tag() {
        return "reading.content.book.created";
    }

    @Override
    public void onEvent(BookCreatedEvent e) {
        long bookId = e.getBookId();
        System.out.println(bookId);
    }

}
