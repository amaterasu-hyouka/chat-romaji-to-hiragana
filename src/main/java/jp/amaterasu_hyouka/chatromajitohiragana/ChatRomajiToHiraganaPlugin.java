package jp.amaterasu_hyouka.chatromajitohiragana;

import jp.amaterasu_hyouka.chatromajitohiragana.util.Log;
import jp.amaterasu_hyouka.chatromajitohiragana.util.Task;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatRomajiToHiraganaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Log.setLogger(this);
        Log.info("ChatRomajiToHiraganaPluginを起動中...");
        Task.init(this);
        RomajiToHiraganaConverter.convert("static load");
        Bukkit.getServer().getPluginManager().registerEvents(AsyncChatListener.getInstance(), this);
        Log.info("ChatRomajiToHiraganaPluginを起動しました");
    }

    @Override
    public void onDisable() {
        Log.info("ChatRomajiToHiraganaPluginを停止中...");
        Log.info("ChatRomajiToHiraganaPluginを停止しました");
    }
}
