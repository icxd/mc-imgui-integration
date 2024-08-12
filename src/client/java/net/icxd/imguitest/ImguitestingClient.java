package net.icxd.imguitest;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.icxd.imguitest.screens.ImGuiScreen;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ImguitestingClient implements ClientModInitializer {
	private static final KeyMapping OPEN_GUI;

	@Override
	public void onInitializeClient() {
		ImGuiScreen.getInstance().init();

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (OPEN_GUI.isDown())
				client.setScreen(ImGuiScreen.getInstance());
		});
	}

	static {
		OPEN_GUI = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.imguitest.open", GLFW.GLFW_KEY_K, "key.categories.imguitest"));
	}
}