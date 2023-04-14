package com.greazi.bottemplate.actions.modals;

import com.greazi.discordbotfoundation.handlers.modals.SimpleModal;
import com.greazi.discordbotfoundation.handlers.modals.SimpleTextInput;
import com.greazi.discordbotfoundation.utils.SimpleEmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import org.jetbrains.annotations.NotNull;

public class TicketModal extends SimpleModal {

	/**
	 * Set the modal details
	 */
	public TicketModal(final String discord_id) {
		super("modal:" + discord_id);
		mainGuildOnly();
		title("Some title");

		final SimpleTextInput supportQuestion = new SimpleTextInput("question", "Your question");
		supportQuestion.setRequired();
		supportQuestion.setParagraph();

		textInputs(supportQuestion);
	}

	/**
	 * The execution once the modal has been submitted
	 *
	 * @param event ModalInteractionEvent
	 */
	@Override
	protected void onModalInteract(@NotNull final ModalInteractionEvent event) {
		final User user = event.getUser();

		final String target_id = event.getModalId().split(":")[1];

		if (!user.getId().equals(target_id)) {
			event.reply("You can't fill in a modal that is meant for someone else").setEphemeral(true).queue();
			return;
		}

		final MessageEmbed embed = new SimpleEmbedBuilder("SUCCESS")
				.text("You have done it")
				.build();

		event.replyEmbeds(embed).setEphemeral(true).queue();
	}
}
