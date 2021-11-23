package ru.vsu.vadim.foxAndGeese.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeese.game.GameStates;
import ru.vsu.vadim.foxAndGeese.gameworld.GameField;

import java.io.File;
import java.io.IOException;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GameContext {
    private static final Logger log = LoggerFactory.getLogger(GameContext.class);

    private GameStates gameState;
    private GameFieldContext gameField;
    private boolean priority = true;
    private  boolean jump = false;

    public boolean isJump() {
        return jump;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public GameStates getGameState() {
        return gameState;
    }

    public GameFieldContext getGameField() {
        return gameField;
    }


    public GameContext(GameStates gameState, GameField gameField, boolean priority, boolean isJump) {
        this.gameState = gameState;
        this.gameField = gameField.context();
        this.priority = priority;
        this.jump = isJump;
    }

    public GameContext() {

    }

    public static void save(File file, GameContext gc) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.writeValue(file, gc);
    }

    public static GameContext read(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(file, GameContext.class);
    }

}

