package daggers.commands.common;

import daggers.CommandRouter;

import java.util.List;
import java.util.Optional;

public interface Command {

    Result handleInput(List<String> input);

    class Result {
        private final Status status;
        private final Optional<CommandRouter> nestedCommandRouter;

        Result(Status status, Optional<CommandRouter> nestedCommandRouter) {
            this.status = status;
            this.nestedCommandRouter = nestedCommandRouter;
        }

        public static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
            return new Result(Status.HANDLED, Optional.of(nestedCommandRouter));
        }

        public Status getStatus() {
            return status;
        }

        public Optional<CommandRouter> getNestedCommandRouter() {
            return nestedCommandRouter;
        }

        public static Result invalid() {
            return new Result(Status.INVALID, Optional.empty());
        }

        public static Result handled() {
            return new Result(Status.HANDLED, Optional.empty());
        }
    }

    enum Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}
