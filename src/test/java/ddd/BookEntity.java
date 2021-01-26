package ddd;

/**
 * TestEntity
 *
 * @author jingqingyun
 * @date 2021/1/25
 */
public class BookEntity implements Entity<Long> {

    private Long bookId;

    public BookEntity(long bookId) {
        if (bookId < 0) {
            throw new IllegalArgumentException("Book id must > 0");
        }
        this.bookId = bookId;
        BookCreatedEvent event = new BookCreatedEvent(bookId);
        EventBus.instance().dispatch(event);
    }

    @Override
    public Long getId() {
        return null;
    }

}
