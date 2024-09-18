package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "JoscarMenar_bot";
    public static final String TOKEN = "6971662562:AAH5qNoDqob4Wrb6HmKFWqJxXBrfl7IbREo";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        

        if (getMessageText().equals("hola")) {
            setUserGlory(0);

            sendPhotoMessageAsync("foto_1");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Postularme", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            sendTextMessageAsync("Por favor, completa el formulario electrónico en el siguiente enlace:https://forms.office.com/pages/responsepage.aspx?id=FE0oNsETY02crM1gOfBLA3CzmEiN9X1Djwy4yQJPbfRUQ1RLNFo5MkU3NFg4QzhaSTJWWDdGTDRXRy4u&route=shorturl");
            setUserGlory(20);
            sendPhotoMessageAsync("foto_1");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Ver carreras?", "step_2_btn",
                            "Visitar sitio Web de Hamilo", "step_3_btn",
                            "Contactar con Hamilo", "step_4_btn"));
        }
            if (getCallbackQueryButtonKey().equals("step_2_btn")) {
                // Redirigir automáticamente al usuario a una página web
                String url = "https://www.hamiloes.cool/";
                sendTextMessageAsync("Redirigiendo... Haga clic en el siguiente enlace:  " + url);
                setUserGlory(20);
                //sendPhotoMessageAsync("step_3_pic");
                sendTextMessageAsync(STEP_3_TEXT,
                        Map.of("Ver carreras?", "step_2_btn",
                                "Visitar sitio Web de Hamilo", "step_3_btn",
                                "Contactar con Hamilo", "step_4_btn"));

            }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            String url = "https://www.hamiloes.cool/full-sack-developer/";
            sendTextMessageAsync("Redirigiendo... Haga clic en el siguiente enlace:  " + url);
            setUserGlory(30);
           // sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Contactar con Hamilo", "step_4_btn",
                            "Dar un paseo en el robot aspirador! +30 de fama", "step_4_btn",
                            "Huir del robot aspiradora! + 30 de fama", "step_4_btn"));
        }


        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            String url = "https://www.hamiloes.cool/contacto/";
            sendTextMessageAsync("Redirigiendo... Haga clic en el siguiente enlace:  " + url);
            setUserGlory(30);
            //sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Ver galeria de talentos?","step_5_btn"));


        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Postularme ya!","step_1_btn",
                            "Visitar sitio Web de Hamilo","step_2_btn"));


        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackea la contraseña de la pc, prueba con la fecha de nacimiento de Karen + 20 de fama", "step_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Salir al patio","step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            setUserGlory(50);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    };
}