/**
 * 
 */
package com.asksven.mytrack.utils;

import com.asksven.android.common.utils.DateUtils;
import com.google.gson.annotations.SerializedName;

import android.location.Location;

/**
 * @author sven
 *
 */
public class TrackEntry
{
	@SerializedName("latitude")
	private double m_latitude;

	@SerializedName("longiude")
	private double m_longitude;

	@SerializedName("altitude")
	private double m_altitude;

	@SerializedName("accuracy")
	private float m_accuracy;

	@SerializedName("timestamp")
	private String m_time;

	@SerializedName("provider")
	private String m_provider;
	
	public TrackEntry(Location location)
	{
		m_latitude = location.getLatitude();
		m_longitude = location.getLongitude();
		m_altitude = location.getAltitude();
		m_accuracy = location.getAccuracy();
		m_time = DateUtils.format(location.getTime());
		m_provider = location.getProvider();
		
		
		
	}

}
