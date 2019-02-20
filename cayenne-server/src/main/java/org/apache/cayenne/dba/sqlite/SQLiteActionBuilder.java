/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.dba.sqlite;

import org.apache.cayenne.access.DataNode;
import org.apache.cayenne.dba.JdbcActionBuilder;
import org.apache.cayenne.query.FluentSelect;
import org.apache.cayenne.query.SQLAction;
import org.apache.cayenne.query.SQLTemplate;
import org.apache.cayenne.query.SelectQuery;

/**
 * @since 3.0
 */
class SQLiteActionBuilder extends JdbcActionBuilder {

    SQLiteActionBuilder(DataNode dataNode) {
        super(dataNode);
    }

    @Override
    public SQLAction sqlAction(SQLTemplate query) {
        return new SQLiteSQLTemplateAction(query, dataNode);
    }

    /**
     * @since 4.1
     */
    @Override
    public <T> SQLAction objectSelectAction(SelectQuery<T> query) {
        return new SQLiteSelectAction(query, dataNode);
    }

    /**
     * @since 4.2
     */
    @Override
    public <T> SQLAction objectSelectAction(FluentSelect<T> query) {
        return new SQLiteSelectAction(query, dataNode);
    }
}
