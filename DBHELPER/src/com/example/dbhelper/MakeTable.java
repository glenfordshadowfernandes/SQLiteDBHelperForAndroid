
package com.example.dbhelper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import android.os.Parcel;
import android.os.Parcelable;

public final class MakeTable implements Parcelable
{

	public static final String		TAG		= "MakeTable";
	public HashMap<String, Object>	mValues;
	String							_tableName;
	

	public String get_tableName()
	{
		return _tableName;
	}

	public MakeTable(String tableName) {

		mValues = new HashMap<String, Object>(8);
		_tableName = tableName;

	}

	public MakeTable(String tableName, int size) {

		mValues = new HashMap<String, Object>(size, 1.0f);

	}

	public MakeTable(String tableName, MakeTable from) {

		mValues = new HashMap<String, Object>(from.mValues);

	}

	public void putColumn(String colName,String colType  )
	{
		mValues.put(colName, colType);
	}

	public int size()
	{
		return mValues.size();
	}

	public void remove(String key)
	{
		mValues.remove(key);
	}

	public void clear()
	{
		mValues.clear();
	}

	public boolean containsKey(String key)
	{
		return mValues.containsKey(key);

	}

	public Set<Map.Entry<String, Object>> valueSet()
	{
		return mValues.entrySet();
	}

	@Override
	public int describeContents()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		// TODO Auto-generated method stub

	}

}
