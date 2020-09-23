package com.xatkit.plugins.chat;

/**
 * An utility class that holds Chat-related helpers and context variable keys.
 */
public interface ChatUtils {

    /**
     * The name of the platform data entry prefix used to store chat-related information.
     */
    String CHAT_CONTEXT_KEY = "chat";

    /**
     * The name of the platform data entry used to store chat channel information.
     */
    String CHAT_CHANNEL_CONTEXT_KEY = CHAT_CONTEXT_KEY + ".channel";

    /**
     * The name of the platform data entry used to store chat username information.
     */
    String CHAT_USERNAME_CONTEXT_KEY = CHAT_CONTEXT_KEY + ".username";

    /**
     * The name of the platform data entry used to store chat raw message information.
     */
    String CHAT_RAW_MESSAGE_CONTEXT_KEY = CHAT_CONTEXT_KEY + ".rawMessage";
}
