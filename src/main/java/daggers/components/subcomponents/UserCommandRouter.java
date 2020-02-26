package daggers.components.subcomponents;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;
import daggers.CommandRouter;
import daggers.Database;
import daggers.modules.UserCommandsModule;

@Subcomponent(modules = UserCommandsModule.class)
public
interface UserCommandRouter {
    CommandRouter router();

    @Subcomponent.Factory
    interface Factory {
        UserCommandRouter create(@BindsInstance Database.Account account);
    }

    @Module(subcomponents = UserCommandRouter.class)
    interface InstallationModule {
    }

}
