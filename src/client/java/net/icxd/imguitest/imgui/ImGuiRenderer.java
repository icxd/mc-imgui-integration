package net.icxd.imguitest.imgui;

import imgui.ImGui;
import imgui.ImGuiStyle;
import imgui.flag.ImGuiCol;
import imgui.flag.ImGuiConfigFlags;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import imgui.internal.ImGuiContext;
import net.icxd.imguitest.utils.Color;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImGuiRenderer {
    private static ImGuiRenderer INSTANCE = null;

    public static ImGuiRenderer getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ImGuiRenderer();
        return INSTANCE;
    }

    private final List<ImGuiCall> preDrawCalls = new ArrayList<>();
    private final List<ImGuiCall> drawCalls = new ArrayList<>();
    private final ImGuiImplGlfw imGuiGlfw = new ImGuiImplGlfw();
    private final ImGuiImplGl3 imGuiGl = new ImGuiImplGl3();

    private ImGuiRenderer() {
    }

    public void init() {
        init(() -> {
        });
    }

    public void init(ImGuiCall config) {
        ImGuiContext context = ImGui.createContext();
        ImGui.setCurrentContext(context);
        config.execute();
        imGuiGlfw.init(Minecraft.getInstance().getWindow().getWindow(), false);
        imGuiGl.init();

        ImGuiStyle style = getImGuiStyle();
        // style.setColor(ImGuiCol.Border, Color.White.toInt());
        // style.setColor(ImGuiCol.Text, Color.White.toInt());
        // style.setColor(ImGuiCol.TextDisabled, Color.White.toInt());
        // style.setColor(ImGuiCol.WindowBg, Color.White.toInt());
        // style.setColor(ImGuiCol.ChildBg, Color.White.toInt());
        // style.setColor(ImGuiCol.PopupBg, Color.White.toInt());
        // style.setColor(ImGuiCol.Border, Color.White.toInt());
        // style.setColor(ImGuiCol.BorderShadow, Color.White.toInt());
        // style.setColor(ImGuiCol.FrameBg, Color.White.toInt());
        // style.setColor(ImGuiCol.FrameBgHovered, Color.White.toInt());
        // style.setColor(ImGuiCol.FrameBgActive, Color.White.toInt());
        // style.setColor(ImGuiCol.TitleBg, Color.White.toInt());
        // style.setColor(ImGuiCol.TitleBgActive, Color.White.toInt());
        // style.setColor(ImGuiCol.TitleBgCollapsed, Color.White.toInt());
        // style.setColor(ImGuiCol.MenuBarBg, Color.White.toInt());
        // style.setColor(ImGuiCol.ScrollbarBg, Color.White.toInt());
        // style.setColor(ImGuiCol.ScrollbarGrab, Color.White.toInt());
        // style.setColor(ImGuiCol.ScrollbarGrabHovered, Color.White.toInt());
        // style.setColor(ImGuiCol.ScrollbarGrabActive, Color.White.toInt());
        // style.setColor(ImGuiCol.CheckMark, Color.White.toInt());
        // style.setColor(ImGuiCol.SliderGrab, Color.White.toInt());
        // style.setColor(ImGuiCol.SliderGrabActive, Color.White.toInt());
        // style.setColor(ImGuiCol.Button, Color.White.toInt());
        // style.setColor(ImGuiCol.ButtonHovered, Color.White.toInt());
        // style.setColor(ImGuiCol.ButtonActive, Color.White.toInt());
        // style.setColor(ImGuiCol.Header, Color.White.toInt());
        // style.setColor(ImGuiCol.HeaderHovered, Color.White.toInt());
        // style.setColor(ImGuiCol.HeaderActive, Color.White.toInt());
        // style.setColor(ImGuiCol.Separator, Color.White.toInt());
        // style.setColor(ImGuiCol.SeparatorHovered, Color.White.toInt());
        // style.setColor(ImGuiCol.SeparatorActive, Color.White.toInt());
        // style.setColor(ImGuiCol.ResizeGrip, Color.White.toInt());
        // style.setColor(ImGuiCol.ResizeGripHovered, Color.White.toInt());
        // style.setColor(ImGuiCol.ResizeGripActive, Color.White.toInt());
        // style.setColor(ImGuiCol.Tab, Color.White.toInt());
        // style.setColor(ImGuiCol.TabHovered, Color.White.toInt());
        // style.setColor(ImGuiCol.TabActive, Color.White.toInt());
        // style.setColor(ImGuiCol.TabUnfocused, Color.White.toInt());
        // style.setColor(ImGuiCol.TabUnfocusedActive, Color.White.toInt());
        // style.setColor(ImGuiCol.DockingPreview, Color.White.toInt());
        // style.setColor(ImGuiCol.DockingEmptyBg, Color.White.toInt());
        // style.setColor(ImGuiCol.PlotLines, Color.White.toInt());
        // style.setColor(ImGuiCol.PlotLinesHovered, Color.White.toInt());
        // style.setColor(ImGuiCol.PlotHistogram, Color.White.toInt());
        // style.setColor(ImGuiCol.PlotHistogramHovered, Color.White.toInt());
        // style.setColor(ImGuiCol.TableHeaderBg, Color.White.toInt());
        // style.setColor(ImGuiCol.TableBorderStrong, Color.White.toInt());
        // style.setColor(ImGuiCol.TableBorderLight, Color.White.toInt());
        // style.setColor(ImGuiCol.TableRowBg, Color.White.toInt());
        // style.setColor(ImGuiCol.TableRowBgAlt, Color.White.toInt());
        // style.setColor(ImGuiCol.TextSelectedBg, Color.White.toInt());
        // style.setColor(ImGuiCol.DragDropTarget, Color.White.toInt());
        // style.setColor(ImGuiCol.NavHighlight, Color.White.toInt());
        // style.setColor(ImGuiCol.NavWindowingHighlight, Color.White.toInt());
        // style.setColor(ImGuiCol.NavWindowingDimBg, Color.White.toInt());
        // style.setColor(ImGuiCol.ModalWindowDimBg, Color.White.toInt());
    }

    private static @NotNull ImGuiStyle getImGuiStyle() {
        ImGuiStyle style = ImGui.getStyle();
        style.setFramePadding(8, 4);

        style.setWindowBorderSize(0);
        style.setChildBorderSize(0);
        style.setPopupBorderSize(0);
        style.setFrameBorderSize(0);
        style.setTabBorderSize(0);

        style.setWindowRounding(6);
        style.setChildRounding(4);
        style.setFrameRounding(4);
        style.setPopupRounding(4);
        style.setScrollbarRounding(12);
        style.setGrabRounding(4);
        style.setTabRounding(4);
        return style;
    }

    public void preDraw(ImGuiCall call) {
        preDrawCalls.add(call);
    }

    public void draw(ImGuiCall call) {
        drawCalls.add(call);
    }

    public void render() {
        for (ImGuiCall call : preDrawCalls)
            call.execute();
        preDrawCalls.clear();

        imGuiGlfw.newFrame();
        ImGui.newFrame();

        for (ImGuiCall call : drawCalls)
            call.execute();
        drawCalls.clear();

        ImGui.render();
        imGuiGl.renderDrawData(Objects.requireNonNull(ImGui.getDrawData()));

        if (ImGui.getIO().hasConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            final long backupWindowPtr = GLFW.glfwGetCurrentContext();
            ImGui.updatePlatformWindows();
            ImGui.renderPlatformWindowsDefault();
            GLFW.glfwMakeContextCurrent(backupWindowPtr);
        }
    }
}
