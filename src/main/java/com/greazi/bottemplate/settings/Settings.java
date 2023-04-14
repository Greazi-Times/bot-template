package com.greazi.bottemplate.settings;

import com.greazi.discordbotfoundation.settings.SimpleSettings;

import java.util.List;

/**
 * A very ugly way to create an settings file
 * This is TEMPORARILY a better settings system
 * will arrive later
 */
public class Settings extends SimpleSettings {

	public static class Database {

		static String mainPath = "Database.";

		public static class Preorder {

			static String preorderPath = mainPath + "Preorder.";

			public static String username = getString(preorderPath + "Username");

			public static String password = getString(preorderPath + "Password");
		}


	}
}
