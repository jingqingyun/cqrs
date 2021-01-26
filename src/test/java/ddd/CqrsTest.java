package ddd;

import org.junit.Test;

/**
 * CqrsTest
 *
 * @author jingqingyun
 * @date 2021/1/26
 */
public class CqrsTest {

    @Test
    public void test1() {
        long bookId = 1234;
        BookCreatedEventListener listener = new BookCreatedEventListener();
        BookEntity entity = new BookEntity(bookId);
    }

}
