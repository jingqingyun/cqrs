package ddd;

import java.io.Serializable;

/**
 * Entity
 *
 * @author jingqingyun
 * @date 2020-08-28
 */
public interface Entity<T extends Serializable> {

    T getId();

    default boolean equals(Entity<T> another) {
        return this == another || this.getId().equals(another.getId());
    }

}
