package controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import gui.Direction;

public class ImagesLoader {
    static final private int PLAYER_SEQUENCE_LENGTH = 3;
    static final String BASE_PATH = "res" + File.separator + "textures" + File.separator;
    static final String MONSTER_PATH = "res" + File.separator + "monster" + File.separator;

    final int height;
    final int width;

    private BufferedImage terrain;
    private Map<Direction, List<BufferedImage>> player = new HashMap<>();
    private Map<String, BufferedImage> monsters = new HashMap<>();

    public ImagesLoader(int height, int width) {
	super();
	this.height = height;
	this.width = width;
    }

    public BufferedImage getTerrainImage() {
	final double percWidth = 0.1;
	final double percHeight = 0.1;
	System.out.println(percWidth*width +" "+percHeight*height);
	if (terrain == null) {
	    final String imgPath = BASE_PATH + "wild_grass.png";
	    try {
		terrain = resizeImage(ImageIO.read(new File(imgPath)), (int) (percWidth*width), (int) (percHeight*height));
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return terrain;
    }

    public List<BufferedImage> getPlayerImages(Direction dir, String gender) {
	final double percWidth = 0.1;
	final double percHeight = 0.1;
	if (!player.containsKey(dir)) {
	    final String basePath = BASE_PATH + "player" + File.separator + gender + File.separator + "player_"
		    + dir.toString() + "_";
	    final String fileType = ".png";
	    List<BufferedImage> imageSequence = new ArrayList<>();
	    try {
		for (int i = 1; i <= PLAYER_SEQUENCE_LENGTH; i++) {
		    String imgPath = basePath + i + fileType;
		    imageSequence.add(resizeImage(ImageIO.read(new File(imgPath)), (int) (percWidth*width), (int) (percHeight*height)));
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    player.put(dir, imageSequence);
	}
	return player.get(dir);
    }

    public BufferedImage getMonster(String monsterName) {
	if (!monsters.containsKey(monsterName)) {
	    final String basePath = MONSTER_PATH + monsterName;
	    final String fileType = ".png";
	    BufferedImage monsterPng = null;

	    try {

		String imgPath = basePath + fileType;
		monsterPng = ImageIO.read(new File(imgPath));

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    monsters.put(monsterName, monsterPng);
	}
	return monsters.get(monsterName);

    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
	BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.BITMASK);

	Graphics2D graphics2D = resizedImage.createGraphics();
	graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
	graphics2D.dispose();
	return resizedImage;
    }

}
