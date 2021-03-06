package moe.exusiai.schwarz.mixin;

import com.mojang.brigadier.CommandDispatcher;
import moe.exusiai.schwarz.command.Command;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CommandManager.class)
public class MixinCommandManager {
    @Shadow @Final private CommandDispatcher<ServerCommandSource> dispatcher;
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onRegister(CommandManager.RegistrationEnvironment environment, CallbackInfo callbackInfo) {
        Command.registerCommand(dispatcher);
    }
}
