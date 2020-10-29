package cqrs;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * CommandGateway
 *
 * @author jingqingyun
 * @date 2020/10/10
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class CommandGateway {

    private final Map<String, CommandHandler> handlers;

    public CommandGateway(List<CommandHandler> commandHandlers) {
        this.handlers = commandHandlers.stream()
                .collect(Collectors.toMap(CommandHandler::tag, Function.identity()));
    }

    public void register(CommandHandler handler) {
        if (handler == null) {
            throw new CqrsException("Command handler must not be null");
        }
        handlers.put(handler.tag(), handler);
    }

    public <T extends Command, R> R dispatch(T command) {
        if (command == null) {
            throw new CqrsException("Command must not be null");
        }
        CommandHandler<T, R> handler = Optional.ofNullable(handlers.get(command.tag()))
                .orElseThrow(() -> new CqrsException("No such handler of tag: " + command.tag()));
        return handler.handle(command);
    }

}
