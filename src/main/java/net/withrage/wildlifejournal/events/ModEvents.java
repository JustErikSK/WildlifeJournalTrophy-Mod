package net.withrage.wildlifejournal.events;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModEvents {
    public static void registerEvents() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayerEntity player = handler.player;

            server.execute(() -> {
                if (player.getCommandTags().contains("cozy_wildlife_starter_kit")) {
                    return;
                }

                giveStarterKit(player);

                player.addCommandTag("cozy_wildlife_starter_kit");
            });
        });
    }

    private static void giveStarterKit(ServerPlayerEntity player) {
        player.getServer().getCommandManager().executeWithPrefix(
                player.getCommandSource().withLevel(4).withSilent(),
                "give @s ftbquests:book 1"
        );
        player.getInventory().insertStack(new ItemStack(Items.COMPASS, 1));
        player.getInventory().insertStack(new ItemStack(Items.COOKED_BEEF, 10));
    }
}
