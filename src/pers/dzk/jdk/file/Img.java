package pers.dzk.jdk.file;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Img {

    public static void toString(String imgPath,String txtPath) throws IOException {
        BufferedImage binaryBufferedImage = ImageIO.read(new File(imgPath));
        int orgWidth=binaryBufferedImage.getWidth();
        int orgHeight=binaryBufferedImage.getHeight();
        int size=Math.max(orgHeight,orgWidth);
        int w = size>1000?binaryBufferedImage.getWidth()/12:orgWidth;
        int h = size>1000?binaryBufferedImage.getHeight()/12:orgHeight;
        binaryBufferedImage.getGraphics().drawImage(binaryBufferedImage, 0, 0, w, h, null);
        BufferedWriter bw = new BufferedWriter(new FileWriter(txtPath));
        final String base = "01 ";// 字符串由复杂到简单,备选 %%*o!;.
        for (int y = 0; y < h; y += 2) {
            for (int x = 0; x < w; x++) {
                final int pixel = binaryBufferedImage.getRGB(x, y);
                final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                final int index = Math.round(gray * (base.length() + 1) / 255);
                bw.write((index >= base.length() ? " " : String.valueOf(base.charAt(index))));
            }
            bw.newLine();
        }
        bw.close();
    }
}
