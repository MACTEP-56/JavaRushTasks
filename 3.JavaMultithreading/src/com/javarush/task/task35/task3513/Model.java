package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pbunegin on 09.11.2017.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile [][] gameTiles;
    public int score;
    public int maxTile;
    boolean isSaveNeeded = true;

    public Model(){
        resetGameTiles();
        maxTile = 2;
        score = 0;
    }

    //инициализируем список пустыми клетками
    public void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++){
            for (int j = 0; j < FIELD_WIDTH; j++){
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }
    //Меняет вес одной из пустых клеток
    private void addTile(){
        List<Tile> list = getEmptyTiles();
        if(list.isEmpty()) return;
        int index = (int)(list.size() * Math.random());
        int value = (int) (Math.random() < 0.9 ? 2 : 4);
        list.get(index).value = value;
    }

    //возвращает список пустых плиток
    private List<Tile> getEmptyTiles (){
        List<Tile> list = new ArrayList<>();
        for(int i = 0; i < FIELD_WIDTH; i++){
            for(int j = 0; j < FIELD_WIDTH; j++){
                if(gameTiles[i][j].isEmpty()){
                    list.add(gameTiles[i][j]);
                }
            }
        }
        return list;
    }

    //Сжимает не нулевые значения
    private boolean compressTiles(Tile[] tiles){
        boolean change = false;
        for(int i = 0; i < tiles.length-1; i++){
            for(int j = 0; j < tiles.length-1; j++){
                if(tiles[j].isEmpty() && !tiles[j+1].isEmpty()){
                    change = true;
                    tiles[j] = tiles[j+1];
                    tiles[j+1] = new Tile();
                }
            }
        }
        return change;
    }

    //Сливает клетки с одинаковыми значниями
    private boolean mergeTiles(Tile [] tiles){
        boolean ch = false;
        for(int i = 0; i < tiles.length-1; i++){
            if(tiles[i].value == tiles[i+1].value && !tiles[i].isEmpty() && !tiles[i+1].isEmpty()){
                ch = true;
                tiles[i].value *= 2;
                tiles[i+1] = new Tile();
                maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;
                score += tiles[i].value;
                compressTiles(tiles);
            }
        }
        return ch;
    }

    void left(){
        boolean change = false;
        for(int i = 0; i < gameTiles.length; i++){
            if(compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])){
                change = true;
            }
        }
        if(change) addTile();
        isSaveNeeded = true;
    }

    void right() {
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    void up() {
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    void down() {
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    private void rotate() {
        Tile tile;
        for(int i = 0; i < FIELD_WIDTH/2; i++){
            for (int j = i; j < FIELD_WIDTH-1-i; j++){
                tile = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - 1 - j][i];
                gameTiles[FIELD_WIDTH - 1 - j][i] = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j];
                gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j] = gameTiles[j][FIELD_WIDTH - 1 - i];
                gameTiles[j][FIELD_WIDTH - 1 - i] = tile;
            }
        }
    }
}
