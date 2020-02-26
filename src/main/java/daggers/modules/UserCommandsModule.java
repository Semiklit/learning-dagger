package daggers.modules;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import daggers.commands.DepositCommand;
import daggers.commands.common.Command;

@Module
public abstract class UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract Command depositCommand(DepositCommand command);
}
