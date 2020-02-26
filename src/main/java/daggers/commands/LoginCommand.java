package daggers.commands;

import daggers.Database;
import daggers.commands.common.Command;
import daggers.commands.common.SingleArgCommand;
import daggers.components.subcomponents.UserCommandRouter;
import daggers.modules.Outputter;

import javax.inject.Inject;

public class LoginCommand extends SingleArgCommand {
    private final Outputter outputter;
    private final Database database;
    private final UserCommandRouter.Factory userCommandRouterFactory;

    @Inject
    LoginCommand(Outputter outputter, Database database, UserCommandRouter.Factory userCommandRouterFactory) {
        this.outputter = outputter;
        this.database = database;
        this.userCommandRouterFactory = userCommandRouterFactory;
    }

    @Override
    public Command.Result handleArg(String username) {
        Database.Account account = database.getAccount(username);
        outputter.output(username + " is Logged in with balance: " + account.balance());
        return Command.Result.enterNestedCommandSet(userCommandRouterFactory.create(account).router());
    }
}
