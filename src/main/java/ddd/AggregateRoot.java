package ddd;

import java.io.Serializable;

/**
 * Aggregate
 *
 * @author jingqingyun
 * @date 2020-08-28
 */
public interface AggregateRoot<T extends Serializable> extends Entity<T> {
}
