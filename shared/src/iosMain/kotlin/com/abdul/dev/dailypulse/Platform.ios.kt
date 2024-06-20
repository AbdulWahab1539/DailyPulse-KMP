package com.abdul.dev.dailypulse

//import platform.Foundation.NSLog
//import platform.UIKit.UIDevice
//import platform.UIKit.UIScreen
/**
 * Because we are not on Mac that's why
 * we don't have access to platform classes
 * */
actual class Platform() {
    actual val osName: String
        get() = "UIDevice.currentDevice.systemName"
    actual val osVersion: String
        get() = "UIDevice.currentDevice.systemVersion"
    actual val deviceModel: String
        get() = "UIDevice.currentDevice.model"
    actual val density: Int
        get() = 0

    //    UIScreen.mainScreen.scale.toInt()
    actual fun logSystemInfo() {
//        NSLog(
        "($osName, $osVersion, $deviceModel, $density)"
//        )
    }
}