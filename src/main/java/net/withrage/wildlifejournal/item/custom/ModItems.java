package net.withrage.wildlifejournal.item.custom;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.wildlifejournal.WildlifeJournalTrophy;
import net.withrage.wildlifejournal.block.custom.ModBlocks;

public class ModItems {

    public static final Item WILDLIFE_JOURNAL_TROPHY_ITEM = registerItem(
            "wildlife_journal_trophy",
            new BlockItem(ModBlocks.WILDLIFE_JOURNAL_TROPHY, new Item.Settings())
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier("wildlife-journal-trophy", name), item);
    }

    public static void registerModItems() {
        WildlifeJournalTrophy.LOGGER.info("Registering the final trophy item.");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModItems.WILDLIFE_JOURNAL_TROPHY_ITEM);
        });
    }
}
