package net.icxd.imguitest.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.logging.LogUtils;
import imgui.ImGui;
import imgui.flag.ImGuiConfigFlags;
import net.icxd.imguitest.imgui.ImGuiRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderSystem.class, remap = false)
public class RenderSystemMixin {
    @Inject(at = @At(value = "TAIL", remap = false), method = "initRenderer(IZ)V")
    private static void initRenderer(int flags, boolean enable, CallbackInfo callbackInfo) {
        RenderSystem.assertOnRenderThread();
        LogUtils.getLogger().info("Initializing ImGui");
        ImGuiRenderer.getInstance().init(() -> ImGui.getIO().addConfigFlags(ImGuiConfigFlags.DockingEnable));
    }

    @Inject(at = @At(value = "HEAD", remap = false), method = "flipFrame(J)V")
    private static void flipFrame(long window, CallbackInfo callbackInfo) {
        RenderSystem.recordRenderCall(() -> ImGuiRenderer.getInstance().render());
    }
}
