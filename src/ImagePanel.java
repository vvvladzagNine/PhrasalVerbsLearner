import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    public int getImageHeight() {
        return image.getHeight();
    }

    public int getImageWidth() {
        return image.getHeight();
    }

    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(ImagePanel.class.getResource("default.jpg"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    public void setImage(String path) {
        try {
            image = ImageIO.read(ImagePanel.class.getResource(path));
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }

}
