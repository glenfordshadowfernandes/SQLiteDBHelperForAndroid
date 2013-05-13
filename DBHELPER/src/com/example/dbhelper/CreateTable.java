
package com.example.dbhelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CreateTable
{
	SQLiteDatabase	_database;
	String			_tableName;
	StringBuilder	_queryString	= new StringBuilder();

	CreateTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void createTable(SQLiteDatabase db, MakeTable table)
	{

		_database = db;
		_tableName = table.get_tableName();
		Set<Entry<String, Object>> s = table.valueSet();
		Iterator<Entry<String, Object>> itr = s.iterator();

		_queryString.append("CREATE TABLE IF NOT EXISTS ");
		_queryString.append(_tableName + " (");

		while (itr.hasNext())
		{
			Map.Entry me = (Map.Entry) itr.next();
			String key = me.getKey().toString();
			Object value = me.getValue().toString();

			_queryString.append(key + " " + value);
			if (itr.hasNext())
			{
				_queryString.append(",");
			}
		}
		_queryString.append(");");

		Log.i("DBHELPER", "QUERY STRING: " + _queryString);
		_database.execSQL(_queryString.toString());

	}
	
	public void createTables(SQLiteDatabase db, ArrayList<MakeTable> tables){
		
		_database = db;
		
		for (MakeTable _makeTable : tables)
		{
			StringBuilder _queryStrings = new StringBuilder();
			_tableName = _makeTable.get_tableName();
			Set<Entry<String, Object>> s = _makeTable.valueSet();
			Iterator<Entry<String, Object>> itr = s.iterator();
	
			_queryStrings.append("CREATE TABLE IF NOT EXISTS ");
			_queryStrings.append(_tableName + " (");
	
			while (itr.hasNext())
			{
				Map.Entry me = (Map.Entry) itr.next();
				String key = me.getKey().toString();
				Object value = me.getValue().toString();
	
				_queryStrings.append(key + " " + value);
				if (itr.hasNext())
				{
					_queryStrings.append(",");
				}
			}
			_queryStrings.append(");");
	
			Log.i("DBHELPER", "QUERY STRING: " + _queryStrings);
			_database.execSQL(_queryStrings.toString());
			itr.remove();
			s.clear();
		}
	}
}
