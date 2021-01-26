package ddd;

import java.util.List;

/**
 * TestAggregateRoot
 *
 * @author jingqingyun
 * @date 2021/1/25
 */
public class BookListEntity implements AggregateRoot<Long> {

    private List<Long> books;

    @Override
    public Long getId() {
        return null;
    }

}
