package cqrs;

/**
 * CommandHandler
 *
 * @author jingqingyun
 * @date 2020-08-28
 */
public interface CommandHandler<T extends Command, R> extends Tag {

    R handle(T command);

}
