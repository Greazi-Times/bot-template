package com.greazi.bottemplate;

import com.greazi.bottemplate.commands.common.*;
import com.greazi.bottemplate.modules.*;
import com.greazi.discordbotfoundation.Common;
import com.greazi.discordbotfoundation.SimpleBot;
import com.greazi.discordbotfoundation.utils.color.ConsoleColor;

import java.sql.SQLException;

public final class BotTemplate extends SimpleBot {

	/**
	 * A very ugly way of starting the bot but there is no other way
	 * of doing this. This might get fixed in the feature
	 *
	 * @param args Arguments passed to the bot
	 */
	public static void main(final String[] args) {
		// The method that starts the whole bot
		new SimpleBot() {

			@Override
			public void onPreLoad() {

			}

			@Override
			protected void onBotLoad() {
				Common.log(Common.consoleLine(),
						ConsoleColor.CYAN + "            Starting the bot " + SimpleBot.getName() + " V" + getVersion(),
						Common.consoleLine()
				);

				//Database.MEMBERS.createTable();
			}

			@Override
			protected void onBotStart() {
			}

			@Override
			protected void onReloadableStart() {

				/*
				 * Register all commands here
				 */
				registerCommands(
						new TestCommand2()
				);

				/*
				 * Add all events here
				 */
				getJDA().addEventListener(new PrivateMessageReceiveModule());
				getJDA().addEventListener(new BotMentionModule());

				/*
				 * Add all console command here
				 */


				/*
				 * All other methods down here
				 */

			}
		};
	}

	@Override
	protected void onBotStart() {
	}

	@Override
	public int getFoundedYear() {
		return 2022;
	}
}
