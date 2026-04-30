package net.withrage.wildlifejournal.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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

    public static final Item ICON_PAW = registerItem("icon_paw", new Item(new FabricItemSettings()));
    public static final Item ICON_FISH = registerItem("icon_fish", new Item(new FabricItemSettings()));
    public static final Item ICON_FEATHER = registerItem("icon_feather", new Item(new FabricItemSettings()));
    public static final Item ICON_TROPHY = registerItem("icon_trophy", new Item(new FabricItemSettings()));
    public static final Item REWARD_ICON_PAW = registerItem("reward_icon_paw", new Item(new FabricItemSettings()));
    public static final Item REWARD_ICON_FISH = registerItem("reward_icon_fish", new Item(new FabricItemSettings()));
    public static final Item REWARD_ICON_FEATHER = registerItem("reward_icon_feather", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier("wildlife-journal-trophy", name), item);
    }

    public static void registerModItems() {
        WildlifeJournalTrophy.LOGGER.info("Registering the final trophy item.");
    }
}
