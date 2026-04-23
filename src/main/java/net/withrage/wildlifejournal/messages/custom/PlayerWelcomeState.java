package net.withrage.wildlifejournal.messages.custom;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerWelcomeState extends PersistentState {

    public static class PlayerData {
        public boolean welcomeShown = false;
    }

    private final Map<UUID, PlayerData> players = new HashMap<>();

    public static PlayerWelcomeState fromNbt(NbtCompound nbt) {
        PlayerWelcomeState state = new PlayerWelcomeState();

        NbtCompound playersNbt = nbt.getCompound("players");

        for (String key : playersNbt.getKeys()) {
            try {
                UUID uuid = UUID.fromString(key);
                NbtCompound playerNbt = playersNbt.getCompound(key);

                PlayerData data = new PlayerData();
                data.welcomeShown = playerNbt.getBoolean("welcomeShown");

                state.players.put(uuid, data);
            } catch (Exception ignored) {}
        }

        return state;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        NbtCompound playersNbt = new NbtCompound();

        for (Map.Entry<UUID, PlayerData> entry : players.entrySet()) {
            NbtCompound playerNbt = new NbtCompound();
            playerNbt.putBoolean("welcomeShown", entry.getValue().welcomeShown);
            playersNbt.put(entry.getKey().toString(), playerNbt);
        }

        nbt.put("players", playersNbt);
        return nbt;
    }

    public static PlayerWelcomeState getServerState(MinecraftServer server) {
        PersistentStateManager manager =
                server.getWorld(World.OVERWORLD).getPersistentStateManager();

        return manager.getOrCreate(
                PlayerWelcomeState::fromNbt,
                PlayerWelcomeState::new,
                "cozywildlifejournal_welcome"
        );
    }

    public static PlayerData getPlayerState(MinecraftServer server, UUID uuid) {
        PlayerWelcomeState state = getServerState(server);
        return state.players.computeIfAbsent(uuid, id -> new PlayerData());
    }

    public static void markDirty(MinecraftServer server) {
        getServerState(server).markDirty();
    }
}