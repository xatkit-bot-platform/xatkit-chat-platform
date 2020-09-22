package com.xatkit.plugins.chat.platform.io;

import com.xatkit.core.platform.io.RuntimeEventProvider;
import com.xatkit.execution.StateContext;
import com.xatkit.intent.EventInstance;
import com.xatkit.plugins.chat.ChatUtils;
import com.xatkit.plugins.chat.platform.ChatPlatform;

/**
 * An abstract chat intent provider.
 * <p>
 * This class is designed to be extended by concrete providers relying on third-party libraries to receive chat
 * events (e.g. a dedicated library connecting to Slack). To receive chat events from Json webhooks check
 * {@link WebhookChatIntentProvider}.
 *
 * @param <T> the concrete {@link ChatPlatform} that contains this provider
 * @see WebhookChatIntentProvider
 */
public abstract class ChatIntentProvider<T extends ChatPlatform> extends RuntimeEventProvider<T> {

    /**
     * Constructs a {@link ChatIntentProvider} and binds it to the provided {@code chatPlatform}.
     *
     * @param chatPlatform the {@link ChatPlatform} managing this provider
     */
    public ChatIntentProvider(T chatPlatform) {
        super(chatPlatform);
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method checks that the context variables defined in {@link ChatUtils} have been initialized by the
     * concrete provider. This ensures that all the providers extending {@link ChatIntentProvider} set the same set
     * of variables and can be used transparently in execution models.
     */
    @Override
    public void sendEventInstance(EventInstance eventInstance, StateContext context) {
        /*
         * TODO should we set this override as final?
         */
        ChatProviderUtils.checkEventInstance(eventInstance);
        super.sendEventInstance(eventInstance, context);
    }
}
