package com.nova.soupofletters;

import java.util.prefs.Preferences;

public class SettingsManager {
    
    private static final Preferences prefs = Preferences.userNodeForPackage(SettingsManager.class);

    // --- Setters ---

    public static void setMusicVolume(double value) {
        prefs.putDouble("musicVolume", value);
    }

    public static void setSfxVolume(double value) {
        prefs.putDouble("sfxVolume", value);
    }

    public static void setTheme(String theme) {
        prefs.put("theme", theme);
    }

    public static void setHighlightColor(String color) {
        prefs.put("highlightColor", color);
    }

    public static void setAnimations(boolean enabled) {
        prefs.putBoolean("animations", enabled);
    }

    // --- Getters ---

    public static double getMusicVolume() {
        return prefs.getDouble("musicVolume", 70);
    }

    public static double getSfxVolume() {
        return prefs.getDouble("sfxVolume", 80);
    }

    public static String getTheme() {
        return prefs.get("theme", "Scuro");
    }

    public static String getHighlightColor() {
        return prefs.get("highlightColor", "Verde");
    }

    public static boolean isAnimations() {
        return prefs.getBoolean("animations", true);
    }

}
