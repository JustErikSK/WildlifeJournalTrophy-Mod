package net.withrage.wildlifejournal;

import net.fabricmc.api.ModInitializer;

import net.withrage.wildlifejournal.block.custom.ModBlocks;
import net.withrage.wildlifejournal.item.custom.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WildlifeJournalTrophy implements ModInitializer {
	public static final String MOD_ID = "wildlife-journal-trophy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}
}