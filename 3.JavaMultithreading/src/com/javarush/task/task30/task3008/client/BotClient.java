package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by PBunegin on 13.09.2017.
 */
public class BotClient extends Client {

    public static void main(String[] args) {
        new BotClient().run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            if (message.contains(":")) {
                String[] tmp = message.split(": ");
                String userName = tmp[0];
                String text = tmp[1];
                Date date = new GregorianCalendar().getTime();
                String textMessage = "Информация для " + userName + ": ";
                    if (text.equalsIgnoreCase("дата"))
                        sendTextMessage(textMessage + new SimpleDateFormat("d.MM.YYYY").format(date));
                    if (text.equalsIgnoreCase("день"))
                        sendTextMessage(textMessage + new SimpleDateFormat("d").format(date));
                    if (text.equalsIgnoreCase("месяц"))
                        sendTextMessage(textMessage + new SimpleDateFormat("MMMM").format(date));
                    if (text.equalsIgnoreCase("год"))
                        sendTextMessage(textMessage + new SimpleDateFormat("YYYY").format(date));
                    if (text.equalsIgnoreCase("время"))
                        sendTextMessage(textMessage + new SimpleDateFormat("H:mm:ss").format(date));
                    if (text.equalsIgnoreCase("час"))
                        sendTextMessage(textMessage + new SimpleDateFormat("H").format(date));
                    if (text.equalsIgnoreCase("минуты"))
                        sendTextMessage(textMessage + new SimpleDateFormat("m").format(date));
                    if (text.equalsIgnoreCase("секунды"))
                        sendTextMessage(textMessage + new SimpleDateFormat("s").format(date));
            }
        }
    }
}
