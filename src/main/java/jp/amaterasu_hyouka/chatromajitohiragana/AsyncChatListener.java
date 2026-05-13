package jp.amaterasu_hyouka.chatromajitohiragana;

import io.papermc.paper.event.player.AsyncChatEvent;
import jp.amaterasu_hyouka.chatromajitohiragana.util.Task;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AsyncChatListener implements Listener {

    private static final AsyncChatListener asyncChatListener = new AsyncChatListener();
    private AsyncChatListener(){}
    public static AsyncChatListener getInstance(){return asyncChatListener;}

    @EventHandler
    public void handle(AsyncChatEvent e) {
        Player p = e.getPlayer();
        e.setCancelled(true);

        String plainMessage = PlainTextComponentSerializer.plainText().serialize(e.originalMessage());
        String convertedMessage = RomajiToHiraganaConverter.convert(plainMessage);

        Component message = Component.empty()
                .append(Component.text(p.getName()))
                .append(Component.text(" > "))
                .append(Component.text(convertedMessage, NamedTextColor.WHITE))
                .append(Component.text(" (" + plainMessage + ")", NamedTextColor.GRAY));

        Task.runSync(() -> Bukkit.broadcast(message));
    }
}
