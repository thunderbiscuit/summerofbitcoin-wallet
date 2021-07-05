---
layout: default
title: Summer of Bitcoin Wallet
nav_order: 1
description: Summer of Bitcoin Wallet
permalink: /
---

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=JetBrains+Mono:wght@500&display=swap" rel="stylesheet"> 


<br/>
<!-- logos -->
<div style="display: flex; justify-content: space-evenly; align-items: center; margin-top: 1rem;">
  <img id="summer-logo" src="./images/summer.png" width="120px" height="120px" />
  <img id="plus-sign-0" src="./images/plus.png" width="30px" height="30px"/>
  <!-- <p>➕</p> -->
  <img id="bitcoindevkit-logo" src="./images/bitcoindevkit.svg" width="120px" />
  <img id="plus-sign-1" src="./images/plus.png" width="30px" height="30px"/>
  <!-- <p>➕</p> -->
  <img id="android-logo" src="./images/android.svg" width="120px" />
</div>

<center>
  <h1 style="font-size: 42px !important; font-family: 'JetBrains Mono'; margin-top: 4rem">Summer of Bitcoin Wallet</h1>
  <hr>
  <br/>
</center>

The _Summer of Bitcoin Wallet_ is a simple testnet Bitcoin wallet built as a reference app for how to leverage the [bitcoindevkit](https://github.com/bitcoindevkit) into Android applications. It is purposely lean on Android-specific bells and whistles in order to keep the focus on bitcoin fundamentals and the bitcoindevkit API.

This webpage is a walkthrough tutorial of the [wallet codebase](https://github.com/thunderbiscuit/summerofbitcoin-wallet). It breaks the building of the wallet into 10 distinct tasks, each with an associated tag in the codebase. You can see and run the final version of the wallet after each task by checking out a specific tag like so:
```shell
git checkout v0.1.0
```

We break the journey of building the wallet into the following 10 tasks:
1. Create a basic Android activity
2. Build multiple activities and navigate between them
3. Build fragments within the wallet activity (wallet, transaction history, receive, send, recovery phrase, about)
4. Build UI (layout files, colors, themes)
5. Create a Wallet object with the Repository design pattern
6. Implement receive and sync functionalities
7. Implement send functionality
8. Query and display transaction history
9. Display recovery phrase
10. Implement wallet recovery from BIP39 words

<br/>
<br/>
<br/>

# Prerequisites
This tutorial assumes you have a working Android development setup, including a phone you can launch the app on, or a working emulator on your development machine. It also requires you have downloaded or built the bitcoindevkit library for Android ([bdk-jni](https://github.com/bitcoindevkit/bdk-jni)). To ensure you can run through this tutorial without problems, please build both branches of the [test app](https://github.com/thunderbiscuit/summer-of-bitcoin-testapp). The readme is comprehensive and should guide you through installing the proper software and testing the app and the bitcoindevkit library.

# Tag [v0.1.0](https://github.com/thunderbiscuit/summerofbitcoin-wallet/tree/v0.1.0): Create a basic Android activity

<center>
  <img src="./images/screenshots/task-1.png" width="300px" />
</center>

Our first tag is the easiest to accomplish yet one of the more complicated one to understand if you are new to Android. While the goal of this tutorial is not to teach the Android framework in depth, we nonetheless need to go over the main pieces of the puzzle at play here. Note that almost all of the code at this point was generated automatically by Android Studio (you can created similar empty shell apps by choosing `New Project -> Empty Activity -> [Choose options...]`).

Some of the important files and directories at this point are:

#### 1. The `build.gradle.kts` files
[Gradle](https://docs.gradle.org/current/userguide/userguide.html) is the build tool used by Android to describe the compilation steps for your app. The `build.gradle.kts` files use a Kotlin Domain Specific Language (DSL) to describe those steps, and some of the configuration options.

#### 2. Files in the `app/src/main/`
The `main` directory breaks into two major parts: the Kotlin source code files and the resources files. The Kotlin source file define behavior on the application, whereas the resouces are files like layouts, colors, strings, themes, images, icons, etc.)

3. The `app/src/main/AndroidManifest.xml` file
The Android Manifest file describes the activities that are registered for the app, the permissions that the app will requires (internet, camera, etc.), as well as some other metadata information necessary for the OS to start your application.


# Tag [v0.2.0](https://github.com/thunderbiscuit/summerofbitcoin-wallet/tree/v0.2.0): Build multiple activities and navigate between them
You can think of _activities_ in Android as the base building blocks of apps. They group together multiple related "screens" (called _fragments_). Activities are more heavier and costlier than fragments, most apps do not require many activities (in fact many Android apps are single-activity applications).

Our wallet has 3 activities:
1. A `Dispatch` activity, which is the entry point of the app. The purpose of the dispatch activity is to launch the user into the proper following activity (either `Wallet` or `WalletChoice`). The dispatch activity checks if the user already has a wallet saved, and if so, launches the wallet directly. If not, it launches the `WalletChoice` activity.
2. The `WalletChoice` activity. This is where users can either create a new wallet or recover one from a BIP39 seedphrase. Once a wallet is created (or recovered), it launches the `Wallet` activity.
3. The `Wallet` activity is where the bulk of the application lives.

We start activities using `Intent`s, as in the following codeblock, which launches the `WalletActivity`:
```kotlin
// WalletChoiceActivity.kt
val intent: Intent = Intent(this, WalletActivity::class.java)
startActivity(intent)
```

# Tag [v0.3.0](https://github.com/thunderbiscuit/summerofbitcoin-wallet/tree/v0.3.0): Add fragments to the Wallet activity

<center>
  <img src="./images/screenshots/task-3.gif" width="300px" />
</center>
