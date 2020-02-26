package daggers.modules;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import daggers.commands.LoginCommand;
import daggers.commands.common.Command;

@Module
public abstract class LoginCommandModule {
    @Binds
    @IntoMap
    @StringKey("login")
    abstract Command loginCommand(LoginCommand loginCommand);
}
