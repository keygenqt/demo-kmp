/**
 * SPDX-FileCopyrightText: Copyright 2023 Open Mobile Platform LLC <community@omp.ru>
 * SPDX-License-Identifier: BSD-3-Clause
 */
addEventListener("DOMContentLoaded", function (e1) {
    e1.originalTarget.addEventListener(
        "framescript:log",
        function (e2) {
            sendAsyncMessage("webview:action", e2.detail)
        }
    );
});
