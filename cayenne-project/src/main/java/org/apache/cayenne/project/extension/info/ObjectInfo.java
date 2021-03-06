/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/

package org.apache.cayenne.project.extension.info;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.cayenne.configuration.ConfigurationNode;
import org.apache.cayenne.configuration.xml.DataChannelMetaData;

/**
 * Key-value storage for additional info associated with data map elements.
 *
 * @since 4.1
 */
public class ObjectInfo {

    public static final String COMMENT = "comment";

    private Map<String, String> infoMap = new HashMap<>();

    public static void putToMetaData(DataChannelMetaData metaData, ConfigurationNode object, String key, String value) {
        ObjectInfo info = metaData.get(object, ObjectInfo.class);
        if(info == null) {
            info = new ObjectInfo();
            metaData.add(object, info);
        }

        info.put(key, value);
    }

    public static String getFromMetaData(DataChannelMetaData metaData, ConfigurationNode object, String key) {
        ObjectInfo info = metaData.get(object, ObjectInfo.class);
        if(info == null) {
            return null;
        }

        return info.get(key);
    }

    /**
     * Package private constructor, use {@link ObjectInfo#putToMetaData(DataChannelMetaData, ConfigurationNode, String, String)}
     * to create instance.
     */
    ObjectInfo() {
    }

    public String put(String key, String value) {
        return infoMap.put(key, value);
    }

    public String get(String key) {
        return infoMap.get(key);
    }

    Map<String, String> getSortedValues() {
        return new TreeMap<>(infoMap);
    }
}
