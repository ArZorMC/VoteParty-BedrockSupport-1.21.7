package me.clip.voteparty.util

import org.bukkit.entity.Player
import java.util.UUID

object FloodgateUtil {
    fun isBedrockPlayer(player: Player): Boolean {
        return try {
            val clazz = Class.forName("org.geysermc.floodgate.api.FloodgateApi")
            val method = clazz.getMethod("getInstance")
            val instance = method.invoke(null)
            val isFloodgateMethod = clazz.getMethod("isFloodgatePlayer", UUID::class.java)
            isFloodgateMethod.invoke(instance, player.uniqueId) as Boolean
        } catch (_: Exception) {
            false // Floodgate not installed or failed to load
        }
    }
}