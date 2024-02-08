/**
 * SPDX-FileCopyrightText: Copyright 2023 Open Mobile Platform LLC <community@omp.ru>
 * SPDX-License-Identifier: BSD-3-Clause
 */
import QtQuick 2.0
import Sailfish.WebView 1.0
import Sailfish.WebEngine 1.0

Item {
    id: root

    property var _listeners: ({})

    signal completed()

    function run(method, result, error) {
        if (method.indexOf("return") === -1) {
            webview.runJavaScript("return " + method, function(data) {
                root._listeners[data] = [result, error]
            }, error);
        } else {
            webview.runJavaScript(method, result, error);
        }
    }

    WebView {
        id: webview
        height: parent.height
        width: parent.width
        privateMode: true
        url: Qt.resolvedUrl("index.html")
        visible: false

        onViewInitialized: {
            webview.loadFrameScript(Qt.resolvedUrl("framescript.js"))
            webview.addMessageListener("webview:action")
        }

        onRecvAsyncMessage: {
            switch (message) {
            case "webview:action":
                try {
                    if (data.caller === 'Init') {
                        root.completed()
                    } else if (root._listeners[data.caller] !== undefined) {
                        if (data.response !== undefined) {
                            // success
                            root._listeners[data.caller][0](data.response)
                        } else {
                            // error
                            root._listeners[data.caller][1](data.error)
                        }
                    }
                } catch (e) {
                    // If something went wrong
                    root._listeners[data.caller][1](qsTr("An unexpected error occurred, please try again later"))
                }
                break
            }
       }


        Component.onCompleted: {
            WebEngineSettings.setPreference(
                        "security.disable_cors_checks",
                        true,
                        WebEngineSettings.BoolPref)
        }
    }
}
