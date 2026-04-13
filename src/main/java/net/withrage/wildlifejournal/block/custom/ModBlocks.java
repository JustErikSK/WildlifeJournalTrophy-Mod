package net.withrage.wildlifejournal.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.wildlifejournal.WildlifeJournalTrophy;

public class ModBlocks {

    public static final Block WILDLIFE_JOURNAL_TROPHY = registerBlock(
            "wildlife_journal_trophy",
            new Block(AbstractBlock.Settings
                    .copy(Blocks.GOLD_BLOCK)
                    .strength(1.5f)
                    .nonOpaque()
            )
    );

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier("wildlife_journal", name), block);
    }

    public static void registerModBlocks() {
        WildlifeJournalTrophy.LOGGER.info("Registering the final trophy block.");
    }
}
