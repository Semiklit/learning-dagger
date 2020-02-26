package daggers.commands;

import daggers.Database;
import daggers.commands.common.BigDecimalCommand;
import daggers.modules.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;


public class DepositCommand extends BigDecimalCommand {
    private final Outputter outputter;
    private final Database.Account account;

    @Inject
    DepositCommand(Outputter outputter, Database.Account account) {
        super(outputter);
        this.outputter = outputter;
        this.account = account;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        account.deposit(amount);
        outputter.output(account.username() + " now has: " + account.balance());
    }
}
