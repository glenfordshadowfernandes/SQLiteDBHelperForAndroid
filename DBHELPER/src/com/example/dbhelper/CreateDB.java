
package com.example.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CreateDB
{

	SQLiteDatabase	_database;
	String			_dbName;
	int				_mode;
	Context			_context;

	/**
	 * @param _mode
	 * @param _dbName
	 * @return
	 */
	CreateDB(int _mode, String _dbName, Context c) {
		super();
		this._mode = _mode;
		this._dbName = _dbName;
		this._context = c;
	}

	public SQLiteDatabase create()
	{
		// TODO Auto-generated method stub
		_database = _context.openOrCreateDatabase(_dbName, _mode, null);
		return _database;
	}

}
