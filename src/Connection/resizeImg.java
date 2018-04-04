/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Melanio
 */
public class resizeImg {

    public resizeImg() {
    }

    public byte[] ImagenFrame32 = new byte[320 * 240 * 4];

    public byte[] redimencionar(byte[] imagen_bits, int w) {
        for (int i = 0, i2 = 0, bits = 0, s = 0; i < imagen_bits.length && i2 < ImagenFrame32.length; i += 8, i2 += 4) {
            if (w * 4 == bits) // w es el ancho = width
            {
                i += w * 8 * 4;
                bits = 0;

            }

            ImagenFrame32[i2] = imagen_bits[i];
            ImagenFrame32[i2 + 1] = imagen_bits[i + 1];
            ImagenFrame32[i2 + 2] = imagen_bits[i + 2];

            bits++;
        }

        return ImagenFrame32;
    }

    public byte[] scale(byte[] fileData, int width, int height) {
        ByteArrayInputStream in = new ByteArrayInputStream(fileData);
        try {
            BufferedImage img = ImageIO.read(in);
            if (height == 0) {
                height = (width * img.getHeight()) / img.getWidth();
            }
            if (width == 0) {
                width = (height * img.getWidth()) / img.getHeight();
            }
            Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0, 0, 0), null);

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            ImageIO.write(imageBuff, "png", buffer);

            return buffer.toByteArray();
        } catch (IOException e) {

        }
        return null;
    }

    public Image ConvertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        System.out.print(iis);
        return reader.read(0, param);
    }
}
