/**
 * 
 */
package com.asksven.mytrack.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.asksven.andoid.common.contrib.Util;
import com.asksven.android.common.utils.DataStorage;
import com.asksven.android.common.utils.DateUtils;

/**
 * @author sven
 *
 */
public class LocationWriter
{
	private static final String TAG = "LocationWriter";
	private static final String FILENAME = "MyTrack.txt";
	
	public static void LogLocationToFile(Context context, Location myLoc)
	{
		Uri fileUri = null;
		SharedPreferences sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(context);

		if (!DataStorage.isExternalStorageWritable())
		{
			Log.e(TAG, "External storage can not be written");
			Toast.makeText(context, "External Storage can not be written",
					Toast.LENGTH_SHORT).show();
		}
		try
		{
			// open file for writing
			File root;

			try
			{
				root = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
			}
			catch (Exception e)
			{
				root = Environment.getExternalStorageDirectory();
			}

			String path = root.getAbsolutePath();
			// check if file can be written
			if (root.canWrite())
			{
				String timestamp = DateUtils.now("yyyy-MM-dd_HHmmssSSS");
				File dumpFile = new File(root, FILENAME);

				FileWriter fw = new FileWriter(dumpFile);
				BufferedWriter out = new BufferedWriter(fw);
				out.write(timestamp + ": " 
						+ "LAT=" + myLoc.getLatitude()
						+ "LONG=" + myLoc.getLongitude());
				out.close();
			}
			else
			{
				Log.i(TAG,
						"Write error. "
								+ Environment.getExternalStorageDirectory()
								+ " couldn't be written");
			}
		} catch (Exception e)
		{
			Log.e(TAG, "Exception: " + e.getMessage());
		}
	}

}
