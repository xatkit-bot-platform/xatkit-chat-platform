package com.xatkit.plugins.chat.platform.io;

import com.xatkit.core.platform.io.WebhookEventProvider;
import com.xatkit.core.server.RestHandler;
import com.xatkit.core.session.XatkitSession;
import com.xatkit.intent.EventInstance;
import com.xatkit.plugins.chat.ChatUtils;
import com.xatkit.plugins.chat.platform.ChatPlatform;
import org.apache.commons.configuration2.Configuration;

/**
 * An abstract chat intent provider that extracts intents from received Json payloads.
 * <p>
 * This class is designed to be extended by concrete providers extracting user intents from received Json payloads.
 * The class provides utility methods to navigate the Json payload and the received HTTP headers. To receive chat
 * from third-party libraries check and {@link ChatIntentProvider}.
 *
 * @param <T> the concrete {@link ChatPlatform} that contains this provider
 * @see ChatIntentProvider
 */
public abstract class WebhookChatIntentProvider<T extends ChatPlatform, H extends RestHandler> extends WebhookEventProvider<T,
        H> {

    /**
     * Constructs a new {@link WebhookChatIntentProvider} with the provided {@code runtimePlatform} and {@code
     * configuration}.
     *
     * @param runtimePlatform the {@link ChatPlatform} containing this provider
     * @param configuration   the {@link Configuration} used to initialize this provider
     */
    public WebhookChatIntentProvider(T runtimePlatform, Configuration configuration) {
        super(runtimePlatform, configuration);
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method checks that the context variables defined in {@link ChatUtils} have been initialized by the
     * concrete provider. This ensures that all the providers extending {@link ChatIntentProvider} set the same set
     * of variables and can be used transparently in execution models.
     */
    @Override
    public void sendEventInstance(EventInstance eventInstance, XatkitSession session) {
        /*
         * TODO should we set this override as final?
         */
        ChatProviderUtils.checkSession(session);
        super.sendEventInstance(eventInstance, session);
    }
}
