package net.withrage.wildlifejournal.item.custom;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.withrage.wildlifejournal.WildlifeJournalTrophy;
import net.withrage.wildlifejournal.block.custom.ModBlocks;


public class ModItemGroups {
    public static final ItemGroup WILDLIFE_TROPHY = Registry.register(Registries.ITEM_GROUP,
            new Identifier(WildlifeJournalTrophy.MOD_ID, "wildlife-journal-trophy"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mod_title"))
                    .icon(() -> new ItemStack(ModItems.ICON_TROPHY))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.WILDLIFE_JOURNAL_TROPHY);
                        entries.add(ModItems.ICON_TROPHY);
                        entries.add(ModItems.ICON_PAW);
                        entries.add(ModItems.ICON_FISH);
                        entries.add(ModItems.ICON_FEATHER);
                        entries.add(ModItems.REWARD_ICON_PAW);
                        entries.add(ModItems.REWARD_ICON_FISH);
                        entries.add(ModItems.REWARD_ICON_FEATHER);
                    }).build());

    public static void registerItemGroups() {
        WildlifeJournalTrophy.LOGGER.info("Registering Item Groups for Wildlife Journal");
    }
}
