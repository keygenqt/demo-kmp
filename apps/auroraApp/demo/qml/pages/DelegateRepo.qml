/*
 * Copyright 2024 Vitaliy Zarubin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * SPDX-FileCopyrightText: Copyright 2023 Open Mobile Platform LLC <community@omp.ru>
 * SPDX-License-Identifier: BSD-3-Clause
 */
import QtQuick 2.0
import Sailfish.Silica 1.0
import QtGraphicalEffects 1.0

ListItem {
    id: root

    width: parent.width
    contentHeight: content.height + Theme.paddingMedium * 2

    Row {
        id: content

        anchors.centerIn: parent
        width: parent.width - Theme.paddingLarge * 2
        spacing: Theme.paddingMedium

        Column {
            id: data

            width: parent.width
            spacing: Theme.paddingMedium

            Text {
                width: parent.width
                text: model.name
                wrapMode: Text.WordWrap
                color: root.highlighted ? Theme.highlightColor : Theme.primaryColor
                textFormat: Text.StyledText
                horizontalAlignment: Qt.AlignLeft
                font.pixelSize: Theme.fontSizeLarge
                font.weight: Font.Medium
            }

            Text {
                width: parent.width
                text: Qt.formatDateTime(new Date(model.createdAt), "dd MMMM yyyy")
                color: root.highlighted ? Theme.highlightColor : Theme.primaryColor
                wrapMode: Text.WordWrap
                textFormat: Text.StyledText
                horizontalAlignment: Qt.AlignLeft
                font.pixelSize: Theme.fontSizeExtraSmall
            }
        }
    }
}

