package yaw.engine;

import org.lwjgl.glfw.GLFWMouseButtonCallback;

public class MouseInput extends GLFWMouseButtonCallback {

    // ========== Attributes ==========

    private Mouse3DClickCallBack mouseCallback;

    // ========== Constructors ==========

    public MouseInput() {
        this.mouseCallback = null;
    }

    // ========== Methods ==========

    public synchronized void registerMouseCallback(Mouse3DClickCallBack mouseCallback) {
        if (this.mouseCallback != null) {
            throw new Error("Input callback already registered");
        }
        this.mouseCallback = mouseCallback;
    }

    @Override
    public void invoke(long window, int button, int action, int mods) {
        if (mouseCallback != null) {
            mouseCallback.mouse_click_callback(window, button, action, mods);
        }

    }
}
