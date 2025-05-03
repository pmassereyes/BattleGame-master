package test.battle;

import javafx.scene.image.ImageView;

public class Danseur {
    private String nom;
    private ImageView skin;

    public Danseur(String nom, ImageView skin) {
        this.nom = nom;
        this.skin = skin;
    }

    public Danseur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public ImageView getSkin() {
        return skin;
    }
}
