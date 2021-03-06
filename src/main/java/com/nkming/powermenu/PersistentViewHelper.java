/*
 * PersistentViewHelper.java
 *
 * Author: Ming Tsang
 * Copyright (c) 2015 Ming Tsang
 * Refer to LICENSE for details
 */

package com.nkming.powermenu;

import android.content.Context;
import android.content.SharedPreferences;

public class PersistentViewHelper
{
	public static void startIfNecessary(Context context)
	{
		SharedPreferences pref = context.getSharedPreferences(context.getString(
				R.string.pref_file), Context.MODE_PRIVATE);
		if (pref.getBoolean(context.getString(R.string.pref_persistent_view_key),
				false) && !PersistentService.isRunning())
		{
			Log.d(LOG_TAG + ".startIfNecessary", "Starting service");
			PersistentService.start(context);
		}
	}

	private static final String LOG_TAG =
			PersistentViewHelper.class.getCanonicalName();
}
