package test.battle;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    @FXML
    private AnchorPane paneAccueil;
    @FXML
    private AnchorPane paneSelectPerso;
    @FXML
    private AnchorPane paneBattle;


    @FXML
    private Label lblAccueil1;
    @FXML
    private Label lblAccueil2;
    public Label lblScoreJ1;
    public Label lblScoreJ2;


    @FXML
    private TextField txtNomJoueur1;
    @FXML
    private TextField txtNomJoueur2;


    @FXML
    private ImageView imgViewSkinMaspaJ1;
    @FXML
    private ImageView imgViewSkinRichKJ1;
    @FXML
    private ImageView imgViewSkinMoustikJ1;
    @FXML
    private ImageView imgViewSkinRichKJ2;
    @FXML
    private ImageView imgViewSkinMaspaJ2;
    @FXML
    private ImageView imgViewSkinMoustikJ2;
    @FXML
    private Label lblAccueil22;
    @FXML
    private Label lblAccueil21;
    @FXML
    private ImageView joueur1SurScene;
    @FXML
    private ImageView joueur2SurScene;
    @FXML
    private ImageView gifMoustikPopping;
    @FXML
    private ImageView gifMoustikHype;
    @FXML
    private ImageView gifRichKAirPose;
    @FXML
    private ImageView gifRichKHype;
    @FXML
    private ImageView gifMaspaHype;
    @FXML
    private ImageView gifMoustikAirPose;
    @FXML
    private ImageView gif2J1;
    @FXML
    private ImageView gif1J2;
    @FXML
    private ImageView gif1J1;
    @FXML
    private ImageView gif3J2;
    @FXML
    private ImageView gif3J1;
    @FXML
    private ImageView gif2J2;
    @FXML
    private ImageView gifMaspaPopping;
    @FXML
    private ImageView gifMaspaAirPose;
    @FXML
    private ImageView gifRichKPopping;

    private ArrayList<Danseur> danseurs = new ArrayList<>();
    private Danseur maitreDuJeux;
    private Danseur joueur1;
    private Danseur joueur2;
    @FXML
    private Label lblNomJoueur2;
    @FXML
    private Label lblNomJoueur1;
    @FXML
    private AnchorPane paneResultat;
    @FXML
    private Label lblResultat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        afficherPane(paneAccueil);
        maitreDuJeux = new Danseur("Maître du jeux");
    }

    private void afficherPane(AnchorPane paneAAfficher) {
        paneAccueil.setVisible(false);
        paneSelectPerso.setVisible(false);
        paneBattle.setVisible(false);
        paneAAfficher.setVisible(true);
    }

    // Changement d'AnchorPane
    @FXML
    public void goToSelectPerso(MouseEvent event) {
        afficherPane(paneSelectPerso);
    }

    @Deprecated
    public void goToAccueil(MouseEvent event) {
        afficherPane(paneAccueil);
    }

    @Deprecated
    public void goToAccueilFromBattle(MouseEvent event) {
        afficherPane(paneAccueil);
    }

    @FXML
    public void goToBattle(MouseEvent event) {
        afficherPane(paneBattle);
        lblNomJoueur1.setText(txtNomJoueur1.getText());
        lblNomJoueur2.setText(txtNomJoueur2.getText());
        try {
            File audioFile = new File("/Users/pablomassereyes/Desktop/Dev/Java/BattleGame-master/src/main/resources/test/battle/audio/poppingSong.wav"); // WAV seulement
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // boucle
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void goToResultat(MouseEvent event) {
        afficherPane(paneResultat);
        String j1 = txtNomJoueur1.getText();
        String j2 = txtNomJoueur2.getText();
        String gagnant = gagnant(j1, j2);
        lblResultat.setText("Le gagnant est : " + gagnant + " !");

    }
    public String gagnant(String joueur1, String joueur2) {
        Random random = new Random();
        return random.nextBoolean() ? joueur1 : joueur2;
    }

    private void playClickAnimation(ImageView imageView) {
        ScaleTransition st = new ScaleTransition(Duration.millis(150), imageView);
        st.setFromX(1.0);
        st.setFromY(1.0);
        st.setToX(1.2);
        st.setToY(1.2);
        st.setCycleCount(2);
        st.setAutoReverse(true);
        st.play();
    }

    // CHOIX DES SKINS JOUEURS
    @FXML
    public void clickRichkJ1(MouseEvent event) {
        joueur1 = new Danseur(txtNomJoueur1.getText(), imgViewSkinRichKJ1);
        playClickAnimation(imgViewSkinRichKJ1);
        gif1J1.setImage(gifRichKAirPose.getImage());
        gif2J1.setImage(gifRichKHype.getImage());
        gif3J1.setImage(gifRichKPopping.getImage());
        danseurs.add(joueur1);
    }

    @FXML
    public void clickMaspaJ1(MouseEvent event) {
        joueur1 = new Danseur(txtNomJoueur1.getText(), imgViewSkinMaspaJ1);
        playClickAnimation(imgViewSkinMaspaJ1);
        gif1J1.setImage(gifMaspaAirPose.getImage());
        gif2J1.setImage(gifMaspaHype.getImage());
        gif3J1.setImage(gifMaspaPopping.getImage());
        danseurs.add(joueur1);
    }

    @FXML
    public void clickMoustikJ1(MouseEvent event) {
        joueur1 = new Danseur(txtNomJoueur1.getText(), imgViewSkinMoustikJ1);
        playClickAnimation(imgViewSkinMoustikJ1);
        gif1J1.setImage(gifMoustikAirPose.getImage());
        gif2J1.setImage(gifMoustikHype.getImage());
        gif3J1.setImage(gifMoustikPopping.getImage());
        danseurs.add(joueur1);
    }

    @FXML
    public void clickRichkJ2(MouseEvent event) {
        joueur2 = new Danseur(txtNomJoueur2.getText(), imgViewSkinRichKJ2);
        playClickAnimation(imgViewSkinRichKJ2);
        gif1J2.setImage(gifRichKAirPose.getImage());
        gif2J2.setImage(gifRichKHype.getImage());
        gif3J2.setImage(gifRichKPopping.getImage());
        danseurs.add(joueur2);
    }

    @FXML
    public void clickMaspaj2(MouseEvent event) {
        joueur2 = new Danseur(txtNomJoueur2.getText(), imgViewSkinMaspaJ2);
        playClickAnimation(imgViewSkinMaspaJ2);
        gif1J2.setImage(gifMaspaAirPose.getImage());
        gif2J2.setImage(gifMaspaHype.getImage());
        gif3J2.setImage(gifMaspaPopping.getImage());
        danseurs.add(joueur2);
    }

    @FXML
    public void clickMoustikJ2(MouseEvent event) {
        joueur2 = new Danseur(txtNomJoueur2.getText(), imgViewSkinMoustikJ2);
        playClickAnimation(imgViewSkinMoustikJ2);
        gif1J2.setImage(gifMoustikAirPose.getImage());
        gif2J2.setImage(gifMoustikHype.getImage());
        gif3J2.setImage(gifMoustikPopping.getImage());
        danseurs.add(joueur2);
    }


    @FXML
    public void clickExecuterGif1J1(MouseEvent event) {
        joueur1SurScene.setImage(gif1J1.getImage());
    }


    @FXML
    public void clickExecuterGif1J2(MouseEvent event) {
        joueur2SurScene.setImage(gif1J2.getImage());
    }

    @FXML
    public void clickExecuterGif2J1(MouseEvent event) {
        joueur1SurScene.setImage(gif2J1.getImage());
    }

    @FXML
    public void clickExecuterGif2J2(MouseEvent event) {
        joueur2SurScene.setImage(gif2J2.getImage());
    }

    @FXML
    public void clickExecuterGif3J1(MouseEvent event) {
        joueur1SurScene.setImage(gif3J1.getImage());
    }

    @FXML
    public void clickExecuterGif3J2(MouseEvent event) {
        joueur2SurScene.setImage(gif3J2.getImage());
    }
}

