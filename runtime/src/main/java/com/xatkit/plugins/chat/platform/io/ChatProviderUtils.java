package com.xatkit.plugins.chat.platform.io;

import com.xatkit.execution.StateContext;
import com.xatkit.plugins.chat.ChatUtils;

import java.util.Map;

import static fr.inria.atlanmod.commons.Preconditions.checkState;
import static java.util.Objects.nonNull;

/**
 * Provides utility methods to check session contents.
 */
public class ChatProviderUtils {

    /**
     * Checks that the context variables defined in {@link ChatUtils} have been set in the given {@code context}.
     * <p>
     * This method is called when sending the event to the {@link com.xatkit.core.XatkitCore} component, and ensures
     * that each concrete implementation of the {@link com.xatkit.plugins.chat.platform.ChatPlatform} sets the same
     * context variables.
     *
     * @param context the {@link StateContext} to check
     * @throws IllegalStateException if a context or context variable has not been set in the session
     */
    protected static void checkSession(StateContext context) {
        Map<String, Object> contextVariables = context.getNlpContext().get(ChatUtils.CHAT_CONTEXT_KEY);
        checkState(nonNull(contextVariables), "The context %s has not been defined by the intent provider",
                ChatUtils.CHAT_CONTEXT_KEY);
        checkState(nonNull(contextVariables.get(ChatUtils.CHAT_CHANNEL_CONTEXT_KEY)), "The context variable %s" +
                        ".%s has not been defined by the intent provider", ChatUtils.CHAT_CONTEXT_KEY,
                ChatUtils.CHAT_CHANNEL_CONTEXT_KEY);
        checkState(nonNull(contextVariables.get(ChatUtils.CHAT_USERNAME_CONTEXT_KEY)), "The context variable %s" +
                        ".%s has not been defined by the intent provider",
                ChatUtils.CHAT_CONTEXT_KEY, ChatUtils.CHAT_USERNAME_CONTEXT_KEY);
        checkState(nonNull(contextVariables.get(ChatUtils.CHAT_RAW_MESSAGE_CONTEXT_KEY)), "The context variable %s" +
                        ".%s has not been defined by the intent provider", ChatUtils.CHAT_CONTEXT_KEY,
                ChatUtils.CHAT_RAW_MESSAGE_CONTEXT_KEY);
    }
}
