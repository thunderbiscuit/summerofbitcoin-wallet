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
  <img id="summer-logo" src="./images/summer.jpg" width="120px" height="120px" />
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

We break the journey of building the wallet into these 10 tasks:
1. Create a basic Android activity
2. Build multiple activities and navigate between them
3. Build fragments within the wallet activity (wallet, transaction history, receive, send, settings)
4. Build UI (layout files, colors, themes)
5. Create a Wallet object with the Repository design pattern
6. Implement receive and sync functionalities
7. Implement send functionality
8. Query and display transaction history
9. Display recovery phrase
10. Implement wallet recovery from BIP39 words

# Prerequisites

# Tag [v0.1.0](https://github.com/thunderbiscuit/summerofbitcoin-wallet/tree/v0.1.0): Create a basic Android activity

# Tag [v0.2.0](https://github.com/thunderbiscuit/summerofbitcoin-wallet/tree/v0.2.0): Build multiple activities and navigate between them
