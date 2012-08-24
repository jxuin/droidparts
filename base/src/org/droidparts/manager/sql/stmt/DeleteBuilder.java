/**
 * Copyright 2012 Alex Yanchenko
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
package org.droidparts.manager.sql.stmt;

import java.util.Arrays;

import org.droidparts.util.L;

import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

public class DeleteBuilder extends StatementBuilder {

	public DeleteBuilder(SQLiteDatabase db, String tableName) {
		super(db, tableName);
	}

	//

	@Override
	public DeleteBuilder where(String column, Is operator, Object... values) {
		return (DeleteBuilder) super.where(column, operator, values);
	}

	public int execute() {
		Pair<String, String[]> selection = buildSelection();
		L.d("TableName: '" + tableName + "', selection: '" + selection.first
				+ "', selectionArgs: '" + Arrays.toString(selection.second)
				+ "'.");
		return db.delete(tableName, selection.first, selection.second);
	}

}
