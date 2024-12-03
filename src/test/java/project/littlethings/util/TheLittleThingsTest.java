package project.littlethings.util;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class TheLittleThingsTest {
    @Test
    public void testGrappleCooldown() {
        // Create mock objects
        PlayerEntityMock player = new PlayerEntityMock();
        WorldMock world = new WorldMock();

        // Simulate first grapple
        long initialTime = System.currentTimeMillis();
        UUID playerUUID = player.getUuid();

        // First grapple should be successful
        assertTrue(attemptGrapple(player, world, initialTime),
                "First grapple should be successful");

        // Attempt grapple before cooldown expires
        assertFalse(attemptGrapple(player, world, initialTime + 500),
                "Grapple should be on cooldown");

        // Attempt grapple after cooldown
        assertTrue(attemptGrapple(player, world, initialTime + 1500),
                "Grapple should be allowed after cooldown");
    }

    // Simplified grapple action simulation
    private boolean attemptGrapple(PlayerEntityMock player, WorldMock world, long currentTime) {
        // Simplified version of the grapple cooldown logic
        UUID playerUUID = player.getUuid();
        HashMap<UUID, Long> cooldowns = new HashMap<>();

        Long lastGrappleTime = cooldowns.get(playerUUID);

        // If no previous grapple or cooldown has expired
        if (lastGrappleTime == null ||
                (currentTime - lastGrappleTime >= 1000)) {

            cooldowns.put(playerUUID, currentTime);
            return true;
        }

        return false;
    }

    // Mock Player class
    private static class PlayerEntityMock {
        private final UUID uuid;

        public PlayerEntityMock() {
            this.uuid = UUID.randomUUID();
        }

        public UUID getUuid() {
            return uuid;
        }
    }

    // Mock World class
    private static class WorldMock {
        public boolean isClient() {
            return false;
        }
    }
}
