package rise.city.sounds;

import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;

import static org.bukkit.Sound.ENTITY_ENDERMAN_TELEPORT;

public class SoundMain {
    public static void playCustomSound(SoundEmum sound, Player player) {
        switch(sound) {
            case SUPERRARE:
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.C));
                break;
            case ULTRARARE:
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.C));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.D));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.E));
                break;
            case LEGENDARY:
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.F));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.C));
                break;
            case MEGA:
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.D));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.D));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.sharp(1, Note.Tone.G));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.G));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.F));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.D));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.F));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.G));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.C));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.D));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.sharp(1, Note.Tone.G));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.G));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.F));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.D));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.F));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.G));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.B));
           break;
            case ERROR:
                player.playSound(player.getLocation(), ENTITY_ENDERMAN_TELEPORT, 100, 1);
        }
   }
}
