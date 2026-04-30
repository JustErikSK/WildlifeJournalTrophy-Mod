package net.withrage.wildlifejournal;

import net.fabricmc.api.ModInitializer;
import net.withrage.wildlifejournal.block.custom.ModBlocks;
import net.withrage.wildlifejournal.events.ModEvents;
import net.withrage.wildlifejournal.item.custom.ModItemGroups;
import net.withrage.wildlifejournal.item.custom.ModItems;
import net.withrage.wildlifejournal.messages.custom.PlayerWelcomeState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class WildlifeJournalTrophy implements ModInitializer {
	public static final String MOD_ID = "wildlife-journal-trophy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModEvents.registerEvents();
		ModItemGroups.registerItemGroups();

		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			ServerPlayerEntity player = handler.getPlayer();

			server.execute(() -> {
				PlayerWelcomeState.PlayerData data = PlayerWelcomeState.getPlayerState(server, player.getUuid());

				if (!data.welcomeShown) {
					if (player.getServer().isDedicated()) {
						return;
					}

					player.sendMessage(Text.empty(), false);

					player.sendMessage(
							Text.literal("✦ Welcome to Cozy Wildlife Journal ✦")
									.formatted(Formatting.GOLD, Formatting.BOLD),
							false
					);

					player.sendMessage(
							Text.literal("Explore your world, find all the animals, and complete your journal!")
									.formatted(Formatting.YELLOW),
							false
					);

					player.sendMessage(
							Text.literal("Want to enjoy discovering animals with your friend?")
									.formatted(Formatting.GRAY),
							false
					);

					player.sendMessage(
							Text.literal("Use our code 'withrage' for 25% off on BisectHosting")
									.setStyle(Style.EMPTY
											.withColor(Formatting.AQUA)
											.withUnderline(true)
											.withClickEvent(new ClickEvent(
													ClickEvent.Action.OPEN_URL,
													"https://www.bisecthosting.com/withrage"
											))),
							false
					);

					player.sendMessage(Text.empty(), false);

					data.welcomeShown = true;
					PlayerWelcomeState.markDirty(server);
				}
			});
		});
	}
}