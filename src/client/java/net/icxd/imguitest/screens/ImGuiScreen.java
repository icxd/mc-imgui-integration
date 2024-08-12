package net.icxd.imguitest.screens;

import imgui.ImGui;
import imgui.extension.nodeditor.NodeEditor;
import imgui.extension.nodeditor.NodeEditorConfig;
import imgui.extension.nodeditor.NodeEditorContext;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiConfigFlags;
import net.icxd.imguitest.imgui.ImGuiRenderer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ImGuiScreen extends Screen {
    private static ImGuiScreen INSTANCE = null;
    private static final NodeEditorContext CONTEXT;

    public static ImGuiScreen getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ImGuiScreen();
        return INSTANCE;
    }

    private ImGuiScreen() {
        super(Component.literal("ImGui"));
    }

    public void init() {
        int dockSpaceId = ImGui.getID("MyDockSpace");
        ImGui.dockSpace(dockSpaceId, 0, 0, ImGuiConfigFlags.DockingEnable);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        ImGuiRenderer r = ImGuiRenderer.getInstance();
        r.draw(ImGui::showDemoWindow);
        r.draw(() -> {
            ImGui.setNextWindowSize(500, 400, ImGuiCond.Once);
            ImGui.setNextWindowPos(ImGui.getMainViewport().getPosX() + 100, ImGui.getMainViewport().getPosY() + 200, ImGuiCond.Once);
            if (ImGui.begin("Editor")) {
                NodeEditor.setCurrentEditor(CONTEXT);
                NodeEditor.begin("Editor");
                NodeEditor.suspend();

                if (NodeEditor.showBackgroundContextMenu())
                    ImGui.openPopup("context_menu");

                if (ImGui.beginPopup("context_menu")) {
                    ImGui.text("Context Menu");
                    ImGui.endPopup();
                }

                NodeEditor.resume();
                NodeEditor.end();
            }
            ImGui.end();
        });
    }

    static {
        NodeEditorConfig config = new NodeEditorConfig();
        config.setSettingsFile(null);
        CONTEXT = NodeEditor.createEditor(config);
    }
}
