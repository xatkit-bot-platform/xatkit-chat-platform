package com.xatkit.plugins.chat.platform;

import com.xatkit.core.platform.RuntimePlatform;
import com.xatkit.plugins.chat.platform.io.ChatIntentProvider;

/**
 * An abstract {@link RuntimePlatform} representing a chat interface.
 */
public abstract class ChatPlatform extends RuntimePlatform {

    /**
     * Initializes and returns the {@link ChatIntentProvider} managed by this platform.
     * <p>
     * This method wraps platform-specific providers into the generic {@link ChatIntentProvider}. This allows to
     * switch from one platform to another transparently:
     * <pre>
     * {@code
     * ChatPlatform platformA = new ChatPlatformA();
     * ChatIntentProvider providerA = platformA.getChatIntentProvider();
     * // Use the platform and the provider to receive intents
     *
     * ChatPlatform platformB = new ChatPlatformB();
     * ChatIntentProvider providerB = platformB.getChatIntentProvider();
     * // No need to change anything else, your bot will now receive intents from platformB's provider
     * }
     * </pre>
     *
     * @return the {@link ChatIntentProvider} managed by this platform
     */
    public abstract ChatIntentProvider<? extends ChatPlatform> getChatIntentProvider();

}
