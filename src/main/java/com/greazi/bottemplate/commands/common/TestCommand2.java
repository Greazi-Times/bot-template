package com.greazi.bottemplate.commands.common;

import com.greazi.discordbotfoundation.handlers.commands.SimpleSlashCommand;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TestCommand2 extends SimpleSlashCommand {

	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";

	public TestCommand2() {
		// Set the command
		super("google");
		// Set the description of the command
		description("Google some things on the web");
		// Set the options for the command
		options(new OptionData(OptionType.STRING, "search", "Your search phrase", true),
				new OptionData(OptionType.INTEGER, "results", "How many results need to be shown?", true),
				new OptionData(OptionType.USER, "member", "Is the search for someone els?", false));
		// Set to only the main guild
		mainGuildOnly();
	}

	@Override
	protected void onCommand(final SlashCommandInteractionEvent event) {

		String search = event.getOption("search").getAsString();
		final int count = event.getOption("results").getAsInt();
		final User user = event.getOption("member").getAsUser();

		if (user != null) {
			try {
				//URL encode string in JAVA to use with Google search
				System.out.println("Searching for: " + search);
				search = search.trim();
				search = URLEncoder
						.encode(search, StandardCharsets.UTF_8.toString());
				final String queryUrl = "https://www.google.com/search?q=" + search + "&num=10";

				event.getChannel().sendMessage(user.getAsMention() + " hi I have googled something for you; " + queryUrl).queue();
			} catch (final Exception exception) {
				exception.printStackTrace();
			}
		} else {
			try {
				//URL encode string in JAVA to use with google search
				System.out.println("Searching for: " + search);
				search = search.trim();
				search = URLEncoder
						.encode(search, StandardCharsets.UTF_8.toString());
				final String queryUrl = "https://www.google.com/search?q=" + search + "&num=10";
				event.reply(queryUrl).queue();
			} catch (final Exception exception) {
				exception.printStackTrace();
			}
		}


	}
}
