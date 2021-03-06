Xatkit Chat Platform
=====

[![License Badge](https://img.shields.io/badge/license-EPL%202.0-brightgreen.svg)](https://opensource.org/licenses/EPL-2.0)
[![Wiki Badge](https://img.shields.io/badge/doc-wiki-blue)](https://github.com/xatkit-bot-platform/xatkit/wiki/Xatkit-Chat-Platform)

Generic messaging actions which can be deployed on various platforms.

## Known Concrete Platforms

The chat platform is **abstract**, meaning that its providers and actions must be bound to a concrete platform when deploying the bot (this binding is done in the [configuration options](#options)). The known concrete platforms extending the chat platform are provided below:
- [Xatkit Slack Platform](https://github.com/xatkit-bot-platform/xatkit-slack-platform): deploy the bot on [Slack](https://slack.com)
- [Xatkit Discord Platform](https://github.com/xatkit-bot-platform/xatkit-discord-platform): deploy the bot on [Discord](https://discordapp.com)
- [Xatkit React Platform](https://github.com/xatkit-bot-platform/xatkit-react-platform): deploy the bot in a [web-based chat box](https://github.com/xatkit-bot-platform/xatkit-react)

## Providers

The chat platform defines the following providers:

| Provider                   | Type  | Context Parameters | Description                                                  |
| -------------------------- | ----- | ------------------ | ------------------------------------------------------------ |
| ChatProvider | Intent | - `chat.channel`: the identifier of the channel that sent the message<br/> - `chat.username`: the name of the user that sent the message<br/> - `chat.rawMessage`: the raw message sent by the user (before NLP processing) | Receive messages from a communication channel and translate them into Xatkit-compatible intents |

**Note**: the context parameters defined in the *ChatProvider* are also defined in the *ChatProvider* implementations of concrete platforms extending *ChatPlatform*.

## Actions

| Action | Parameters                                                   | Return                         | Return Type | Description                                                 |
| ------ | ------------------------------------------------------------ | ------------------------------ | ----------- | ----------------------------------------------------------- |
| PostMessage | - `message`(**String**): the message to post<br/> - `channel` (**String**): the identifier of the channel to post the message to | The posted message | String | Posts the provided `message` to the given `channel` |
| Reply | - `message` (**String**): the message to post as a reply | The posted message | String | Posts the provided `message` as a reply to a received message |

## Options

The chat platform supports the following configuration options

| Key                  | Values | Description                                                  | Constraint    |
| -------------------- | ------ | ------------------------------------------------------------ | ------------- |
| `xatkit.platforms.abstract.ChatPlatform` | String | The *path* attribute of the concrete *ChatPlatform* implementation to use to deploy the bot | **Mandatory** |

**Note**: additional configuration options may be required based on the concrete platform used to deploy the bot. See the [related platform documentation](#known-concrete-platforms) for more information.
