package com.greazi.bottemplate.actions.buttons;

import com.greazi.discordbotfoundation.handlers.buttons.SimpleButton;
import com.greazi.discordbotfoundation.utils.SimpleEmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class TicketButtons {

	public static class TicketButton extends SimpleButton {

		public TicketButton() {
			super("button");
			emoji(Emoji.fromUnicode("❗"));
			label("SOME BUTTON");
			buttonStyle(ButtonStyle.SUCCESS);
			disabled(false);
			mainGuildOnly();
		}

		@Override
		protected void onButtonInteract(final @NotNull ButtonInteractionEvent event) {

			event.replyEmbeds(new SimpleEmbedBuilder("SUCCESS")
					.text("You pressed the button!")
					.build())
					.setEphemeral(true)
					.queue();
		}
	}
}
