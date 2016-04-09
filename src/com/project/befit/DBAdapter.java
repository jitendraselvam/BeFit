package com.project.befit;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
	static final String KEY_ROWID="_id";
	static final String KEY_EXERCISE="exercise";
	static final String KEY_CALORIES="calories";
	static final String KEY_DATE="date";
	static final String TAG = "DBAdapter";
	
	static final String DATABASE_NAME ="MyDB";
	static final String DATABASE_TABLE="workout";
	static final int DATABASE_VERSION=1;
	
	static final String DATABASE_CREATE = "create table workout (_id integer primary key autoincrement, "+ "exercise text not null,date text not null, calories integer not null);";
	
	final Context context;
	
	DatabaseHelper DBHelper;
	 SQLiteDatabase db;
	
	public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

		@Override
		public void onUpgrade(SQLiteDatabase db	, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w(TAG,"Upgrading database from"+oldVersion + "to"+ newVersion+"which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS workout");
			onCreate(db);
			
		}
    }
		
		//---opens the database---
	    public DBAdapter open() throws SQLException 
	    {
	        db = DBHelper.getWritableDatabase();
	        return this;
	    }

	    //---closes the database---
	    public void close() 
	    {
	        DBHelper.close();
	    }
	    
	    public long insertExercise(String exercise,String date,String calories){
	    	ContentValues initialValues = new ContentValues();
	    	initialValues.put(KEY_EXERCISE, exercise);
	        initialValues.put(KEY_DATE, date);
	        initialValues.put(KEY_CALORIES, calories);
	        return db.insert(DATABASE_TABLE, null, initialValues);
	    }
	    
	    //---retrieves a particular contact---
	    public Cursor getContact(long rowId) throws SQLException 
	    {
	        Cursor mCursor =
	                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
	                KEY_EXERCISE, KEY_DATE,KEY_CALORIES}, KEY_ROWID + "=" + rowId, null,
	                null, null, null, null);
	        if (mCursor != null) {
	            mCursor.moveToFirst();
	        }
	        return mCursor;
	    }
	    public Cursor getAll()
	    {
	    	return db.query(DATABASE_TABLE, new String[] {KEY_ROWID,KEY_EXERCISE,KEY_DATE,KEY_CALORIES},null,null,null,null,null);
	    }
        
        

    }

