
package com.example.dbhelper;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SQLiteDatabase myDb = new CreateDB(MODE_PRIVATE, "testDB", this).create();

		MakeTable table = new MakeTable("TestTableOne");
		table.putColumn("name", "VARCHAR");
		table.putColumn("address", "VARCHAR");
		table.putColumn("phone", "VARCHAR");

		MakeTable table2 = new MakeTable("TestTableTwo");
		table2.putColumn("name", "VARCHAR");
		table2.putColumn("address", "VARCHAR");
		table2.putColumn("phone", "VARCHAR");

		MakeTable table3 = new MakeTable("TestTable3");
		table3.putColumn("name", "VARCHAR");
		table3.putColumn("address", "VARCHAR");
		table3.putColumn("phone", "VARCHAR");

		MakeTable table4 = new MakeTable("TestTableFour");
		table4.putColumn("name", "VARCHAR");
		table4.putColumn("address", "VARCHAR");
		table4.putColumn("phone", "VARCHAR");

		ArrayList<MakeTable> tables = new ArrayList<MakeTable>();
		tables.add(table);
		tables.add(table2);
		tables.add(table3);
		tables.add(table4);

		new CreateTable().createTables(myDb, tables);
		// new CreateTable().createTable(myDb, table);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
