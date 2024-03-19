package util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author
 */
public class AvatarManager {

    private final String[] AVATARS = {"avatar01.png", "avatar02.png", "avatar03.png"};
    private final String URI = "/avatars/";
    private ImageIcon avatar;
    private int actual = 0;
    private Object parent;

    public AvatarManager() {
    }

    public AvatarManager(Object parent) {
        this.parent = parent;

    }

    public void next() {
        try {
            if (actual < this.AVATARS.length - 1) {
                actual++;
            } else {
                this.actual = 0;
            }
            this.avatar = new ImageIcon(getClass().getResource(this.URI + this.AVATARS[actual]));
            this.render();
        } catch (Exception ex) {
            Logger.getLogger(AvatarManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void render() {
        if (this.parent instanceof JLabel) {
            JLabel label = (JLabel) this.parent;
            label.setIcon(this.avatar);
        }

    }

    public void init() {

        try {
            
            this.avatar = new ImageIcon(getClass().getResource(this.URI + this.AVATARS[actual]));
            this.render();
        } catch (Exception ex) {
            System.out.println("Error");
        }

    }

    public void previous() {
        try {
            if (actual > 0) {
                actual--;
            } else {
                this.actual = this.AVATARS.length - 1;
            }
            this.avatar = new ImageIcon(getClass().getResource(this.URI + this.AVATARS[actual]));
            this.render();
        } catch (Exception ex) {
            Logger.getLogger(AvatarManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getActualUri(){
        return URI+this.AVATARS[actual];
    }
}
