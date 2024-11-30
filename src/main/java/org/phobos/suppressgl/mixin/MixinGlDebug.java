package org.phobos.suppressgl.mixin;

import net.minecraft.client.gl.GlDebug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GlDebug.class)
public abstract class MixinGlDebug {
    @Inject(method = "info", at = @At("HEAD"), cancellable = true)
    private static void infoHook(int source, int type, int id, int severity, int messageLength, long message, long l, CallbackInfo ci) {
        ci.cancel();
    }
}
