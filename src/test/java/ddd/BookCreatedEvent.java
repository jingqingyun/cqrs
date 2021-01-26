package ddd;

/**
 * BoolCreatedEvent
 *
 * @author jingqingyun
 * @date 2021/1/25
 */
public class BookCreatedEvent implements DomainEvent {

    private Long bookId;

    public BookCreatedEvent(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String tag() {
        return "reading.content.book.created";
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

}
