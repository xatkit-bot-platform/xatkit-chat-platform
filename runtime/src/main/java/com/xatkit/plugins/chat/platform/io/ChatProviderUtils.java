package com.xatkit.plugins.chat.platform.io;

import com.xatkit.execution.StateContext;
import com.xatkit.intent.EventInstance;
import com.xatkit.plugins.chat.ChatUtils;

import java.util.Map;

import static fr.inria.atlanmod.commons.Preconditions.checkState;
import static java.util.Objects.nonNull;

/**
 * Provides utility methods to check session contents.
 */
public class ChatProviderUtils {

    /**
     * Checks that the entries defined in {@link ChatUtils} are correctly set in the {@code event}'s platform data.
     * <p>
     * This method is called when sending the event to the {@link com.xatkit.core.XatkitBot} component, and ensures
     * that each concrete implementation of the {@link com.xatkit.plugins.chat.platform.ChatPlatform} sets the same
     * context variable.
     *
     * @param event the {@link EventInstance} to check
     * @throws IllegalStateException if an entry is missing in the provided {@code event}'s platform data
     * @see EventInstance#getPlatformData()
     */
    protected static void checkEventInstance(EventInstance event) {
        Map<String, Object> platformData = event.getPlatformData();
        checkState(platformData.containsKey(ChatUtils.CHAT_CHANNEL_CONTEXT_KEY), "Cannot send the %s %s: the platform" +
                        " data does not contain an entry for %s", event.getClass().getSimpleName(),
                event.getDefinition().getName(), ChatUtils.CHAT_CHANNEL_CONTEXT_KEY);
        checkState(platformData.containsKey(ChatUtils.CHAT_USERNAME_CONTEXT_KEY), "Cannot send the %s %s: the " +
                        "platform data does not contain an entry for %s", event.getClass().getSimpleName(),
                event.getDefinition().getName(), ChatUtils.CHAT_USERNAME_CONTEXT_KEY);
        checkState(platformData.containsKey(ChatUtils.CHAT_RAW_MESSAGE_CONTEXT_KEY), "Cannot send the %s %s: the " +
                        "platform data does not contain an entry for %s", event.getClass().getSimpleName(),
                event.getDefinition().getName(), ChatUtils.CHAT_RAW_MESSAGE_CONTEXT_KEY);
    }

}
