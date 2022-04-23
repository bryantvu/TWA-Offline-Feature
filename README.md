# TWA Offline Mode
## Table of Contents
- [Introduction](#introduction)
- [Demo Flow](#demo-flow)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Introduction

The purpose of this Android project is to provide an example of how a TWA app can to redirect to a placeholder activity when the device is not connected to the internet on app start up.

The network connectivity is queried using the Android [ConnectivityManger](https://developer.android.com/reference/android/net/ConnectivityManager). The user can manually check the network connectivity and attempt to reload the TWA using a button on the [OfflineActivity](https://github.com/bryantvu/TWA-Offline-Mode/blob/master/app/src/main/java/com/pictroom/android/OfflineActivity.java). Additionally, the app will automatically check by itself  based on the activity lifecycle if the user  navigates out and back.

## Demo Flow
Please use 'TwaOfflineFeature.apk' if you just want to test the demo out. Note that the TWA is launched using the Huawei Browser which does not support hiding the navigation bar at the top.

### Lifecycle Reconnect
1. Airplane mode is enabled to simulate network disconnect.
2. App seamlessly redirects from MainActivity to OfflineActivity.
3. Airplane mode is disabled and network is reconnected.
4. Navigate to homescreen and back into app.
5. Placeholder splash screen appears before finally loading into TWA.


### Reconnect Button

1. Airplane mode is enabled to simulate network disconnect.
2. App seamlessly redirects from MainActivity to OfflineActivity.
3. Airplane mode is disabled and network is reconnected.
4. "Recheck Connection" button is clicked.
5. Placeholder splash screen appears before finally loading into TWA.

## License
This Android sample code is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

## Acknowledgements
The code in this project is built on the foundation provided by [Trusted Web Activities (Android Browser Helper)](https://github.com/GoogleChrome/android-browser-helper). Their work in making this possible is greatly appreciated.