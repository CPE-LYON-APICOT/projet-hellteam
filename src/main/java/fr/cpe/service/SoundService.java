package fr.cpe.service;

import javax.sound.sampled.*;

import com.google.inject.Inject;
import fr.cpe.model.EventService;

import java.io.IOException;
import java.util.Objects;

public class SoundService implements IEventsObserver {

    private final Clip onShootClip;

    @Inject
    public SoundService(EventService eventService) {
        // S'abonner aux événements pertinents pour jouer les sons
        eventService.addObserver(this);


        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                    Objects.requireNonNull(getClass().getResource("/sound/shoot.wav"))
            );
            onShootClip = AudioSystem.getClip();
            onShootClip.open(audio);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
    }


    private Clip backgroundClip;

    public void start() {
        try {
            // Correction : utilise getResource au lieu de File pour l'arrière-plan
            AudioInputStream stream = AudioSystem.getAudioInputStream(
                    Objects.requireNonNull(getClass().getResource("/sound/Nebula_Navigator.wav"))
            );
            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(stream);

            // Boucle infinie
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEnemyDestroyed() {

    }

    @Override
    public void onAllyDestroyed() {

    }

    @Override
    public void onShoot() {
        if (onShootClip != null) {
            if (onShootClip.isRunning()) {
                onShootClip.stop(); // 🔥 important
            }
            onShootClip.setFramePosition(0);
            onShootClip.start();
        }
    }
}
