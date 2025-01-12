package bettercommandblockui.mixin;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.OrderedText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Mixin(TextFieldWidget.class)
public interface TextFieldWidgetAccessor {
    @Invoker("drawsBackground")
    boolean invokeDrawsBackground();

    @Invoker("drawSelectionHighlight")
    void invokeDrawSelectionHighlight(DrawContext context, int x1, int y1, int x2, int y2);

    @Invoker("getMaxLength")
    int invokeGetMaxLength();

    @Invoker
    void invokeErase(int i);

    @Invoker
    int invokeGetCursorPosWithOffset(int characterOffset);

    @Accessor
    boolean getEditable();

    @Accessor
    boolean getFocusUnlocked();

    @Accessor
    int getEditableColor();

    @Accessor
    int getUneditableColor();

    @Accessor
    int getSelectionStart();

    @Accessor
    int getSelectionEnd();

    @Accessor
    int getFirstCharacterIndex();

    @Accessor
    long getLastSwitchFocusTime();

    @Accessor
    String getText();

    @Accessor("text")
    void setTextVariable(String text);

    @Accessor
    String getSuggestion();

    @Accessor
    static String getHORIZONTAL_CURSOR() {
        throw new AssertionError();
    }

    @Accessor
    Predicate<String> getTextPredicate();

    @Accessor
    TextRenderer getTextRenderer();

    @Accessor
    Consumer<String> getChangedListener();

    @Accessor
    BiFunction<String, Integer, OrderedText> getRenderTextProvider();
}
