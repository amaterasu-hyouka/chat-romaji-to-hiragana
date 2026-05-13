package jp.amaterasu_hyouka.chatromajitohiragana;

import org.bukkit.plugin.java.JavaPlugin;

public class ChatRomajiToHiraganaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Log.setLogger(this);
        Log.info("ChatRomajiToHiraganaPluginを起動中...");
        Log.info("ChatRomajiToHiraganaPluginを起動しました");
    }

    @Override
    public void onDisable() {
        Log.info("ChatRomajiToHiraganaPluginを停止中...");
        Log.info("ChatRomajiToHiraganaPluginを停止しました");
    }
}
