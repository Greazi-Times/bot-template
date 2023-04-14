package com.greazi.bottemplate.actions.menus;

import com.greazi.bottemplate.settings.Settings;
import com.greazi.discordbotfoundation.handlers.roles.SimpleRoles;
import com.greazi.discordbotfoundation.handlers.selectmenu.SimpleSelectMenu;
import com.greazi.discordbotfoundation.utils.SimpleEmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectInteraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SelfRolesMenu extends SimpleSelectMenu {

	public SelfRolesMenu() {
		super("selfRolesMenu");
		placeholder("Select the roles you want to get pings for");

		minMax(0, 6);

		options(
				SelectOption.of("Test", "test")
						.withEmoji(Emoji.fromFormatted("✳️"))
						.withDescription("Just a option"),
				SelectOption.of("Test 2", "test2")
						.withEmoji(Emoji.fromFormatted("🌲"))
						.withDescription("Another test option")
		);
	}

	@Override
	protected void onMenuInteract(final StringSelectInteraction event) {
		final List<SelectOption> options = event.getSelectedOptions();

		for (final SelectOption option : options) {
			event.reply(option.getValue()).setEphemeral(true).queue();
		}

	}
}
