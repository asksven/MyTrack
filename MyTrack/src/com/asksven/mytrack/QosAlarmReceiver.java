/*

 * Copyright (C) 2013 asksven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.asksven.mytrack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Handles alarms set for quick changes by the service
 * @author sven
 *
 */
public class QosAlarmReceiver extends BroadcastReceiver
{		 
	private static String TAG = "QosAlarmReceiver";
	
	@Override
	public void onReceive(Context context, Intent intent)
	{
		try
		{
			Log.i(TAG, "QoS alarm triggered");
			Intent serviceIntent = new Intent(context, UpdateLocationService.class);
			context.startService(serviceIntent);

		}
		catch (Exception e)
		{
			Log.e(TAG, "An error occured processing the QoS alarm: " + e.getMessage());
		}
	}
}
