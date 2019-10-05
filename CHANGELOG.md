# Changelog

All notable changes for the Chat platform will be documented in this file.

Note that there is no changelog available for the initial release of the platform (2.0.0), you can find the release notes [here](https://github.com/xatkit-bot-platform/xatkit-chat-platform/releases).

The changelog format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres to [Semantic Versioning](

## Unreleased

### Added

- Class `com.xatkit.plugins.chat.platform.io.WebhookChatIntentProvider`: an abstract class that can be extended by concrete chat platforms to receive user inputs through REST endpoints.

### Changed

- `ChatIntentProvider` now uses the new intent provider hierarchy  (see [xatkit-runtime/#221](https://github.com/xatkit-bot-platform/xatkit-runtime/issues/221)). This change requires to use the latest version of [xatkit-runtime](https://github.com/xatkit-bot-platform/xatkit-runtime).

## [2.0.0] - 2019-08-20 

See the release notes [here](https://github.com/xatkit-bot-platform/xatkit-slack-platform/releases).