package Core.GUI;

import Core.starCore;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * KM
 * May 18 2017
 * Stores images.
 *
 * SOURCES:
 * Internet Searches - All GFX content is NOT MY OWN CREATION. I take NO CREDIT for all of the GFX used in this program.
 * I have edited some of them to better fit the game, but none of the GFX images/gifs are originals.
 * Java API - Custom font initialization.
 *
 * Self - All of the coding here is done through my own ideas and initiatives, sans the File path, which is listed under the xmlLoader references.
 */

public class gfxRepository {

    /** UI Design **/
    //Stores all of the colour and fonts that the game uses.

    private final static File imageFolder = new File(System.getProperty("user.dir") + "/src/Core/GUI");

    static final String gameVersion = "PTB-B Build 75a";

    private static Font stylePDark;
    private static Font styleSquare;
    private static Font styleRexlia;

    public static final Color clrText = new Color(255, 255, 255, 255);
    public static final Color clrInvisible = new Color(0, 0, 0, 0);
    public static final Color clrTrueBlack = new Color(0, 0, 0, 255);
    public static final Color clrBlkTransparent = new Color(15, 35, 25, 175);
    public static final Color clrBlk = new Color(25, 35, 35, 255);
    public static final Color clrDGrey = new Color(47, 80, 68, 255);
    public static final Color clrDisableBorder = new Color(75, 5, 25, 255);
    public static final Color clrDisable = new Color(135, 15, 55, 255);
    public static final Color clrEnable = new Color(108, 255, 224, 255);
    public static final Color clrDark = new Color(0, 145, 90, 255);
    public static final Color clrButtonBackground = new Color(0, 125, 90, 255);
    public static final Color clrBGOpaque = new Color(25, 90, 60, 255);
    public static final Color clrButtonMain = new Color(0, 155, 90, 255);
    public static final Color clrBackground = new Color(54, 95, 77, 105);
    public static final Color clrForeground = new Color(0, 185, 110, 155);

    public static final Font txtStandard = new Font("Comic Sans", Font.PLAIN, 15);
    public static Font txtSubtitle;
    public static Font txtItalSubtitle;
    public static Font txtSubheader;
    public static Font txtHeader;
    public static Font txtButtonLarge;
    public static Font txtTitle;
    public static Font txtLargeTitle;
    public static Font txtTiny;

    public static final Border bdrButtonEnabled = BorderFactory.createCompoundBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED, clrEnable, clrForeground), BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    public static final Border bdrButtonDisabled = BorderFactory.createCompoundBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED, clrDisableBorder, clrBlk), BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

    private static void initializeFonts() { //custom font designs
        try {
            //set up custom fonts
            stylePDark = Font.createFont(Font.TRUETYPE_FONT, new File(imageFolder + "/Resources/fonts/pdark.ttf"));
            styleSquare = Font.createFont(Font.TRUETYPE_FONT, new File(imageFolder + "/Resources/fonts/uasquare.ttf"));
            styleRexlia = Font.createFont(Font.TRUETYPE_FONT, new File(imageFolder + "/Resources/fonts/rexlia.ttf"));

            //add the new font to some presets
            txtTitle = stylePDark.deriveFont(Font.PLAIN, 32f);
            txtLargeTitle = stylePDark.deriveFont(Font.PLAIN, 60f);
            txtButtonLarge = styleRexlia.deriveFont(Font.PLAIN, 30f);

            txtSubtitle = styleSquare.deriveFont(Font.PLAIN, 14f);
            txtItalSubtitle = styleSquare.deriveFont(Font.ITALIC, 14f);
            txtHeader = styleSquare.deriveFont(Font.BOLD, 22f);
            txtSubheader = styleSquare.deriveFont(Font.BOLD, 20f);
            txtTiny = styleSquare.deriveFont(Font.PLAIN, 11f);

        } catch (Exception e) {
            e.getMessage();
        }

    }

    /** Element declarations **/

    static BufferedImage closeButton;
    static BufferedImage settingsButton;
    static BufferedImage audioButton;
    static BufferedImage muteButton;
    static BufferedImage acceptButton;
    static BufferedImage rejectButton;
    static BufferedImage wideButton;
    static BufferedImage wideButton2;
    static BufferedImage button435_80;

    static BufferedImage mainBackground;
    static BufferedImage launcherBorder;
    static BufferedImage menuPlanet;
    static BufferedImage menuGlare;

    private static ArrayList<BufferedImage> loadingScreenBGList = new ArrayList<>();

    static BufferedImage gameLogo;
    static BufferedImage gameLogoLarge;
    static BufferedImage menuSpaceport;

    static BufferedImage planetIcon;
    static BufferedImage moon1Icon;
    static BufferedImage moon2Icon;

    static BufferedImage portraitBorder;
    static BufferedImage menuBackground;
    static BufferedImage starPlanetCount;
    static BufferedImage colonyCount;
    static BufferedImage homeSystem;

    static Icon loadingIcon;

    /** Methods **/

    public static void gfxPreloader() { //preloads the GFX used by the launcher and loader

        initializeFonts();

        System.out.println("Attempting to preload GFX content...");

        try {
            mainBackground = ImageIO.read(new File(imageFolder + "/Resources/launcherBG.jpg"));
            loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG.jpg")));
            closeButton = ImageIO.read(new File(imageFolder + "/Resources/ui/button_close.png"));
            settingsButton = ImageIO.read(new File(imageFolder + "/Resources/ui/button_settings.png"));
            audioButton = ImageIO.read(new File(imageFolder + "/Resources/ui/button_sound.png"));
            muteButton = ImageIO.read(new File(imageFolder + "/Resources/ui/button_mute.png"));
            acceptButton = ImageIO.read(new File(imageFolder + "/Resources/ui/button_accept.png"));
            rejectButton = ImageIO.read(new File(imageFolder + "/Resources/ui/button_reject.png"));
            wideButton = ImageIO.read(new File(imageFolder + "/Resources/ui/button_large.png"));
            wideButton2 = ImageIO.read(new File(imageFolder + "/Resources/ui/button_large2.png"));

            Thread temp = new Thread() { //creates a temporary thread to continue loading non-essential images in the background
                public void run() {
                    try {
                        //adds other papers to the loading screen randomize
                        loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG_2.jpg")));
                        loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG_3.jpg")));
                        loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG_4.jpg")));
                        loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG_5.jpg")));
                        loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG_6.jpg")));
                        loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG_7.jpg")));
                        loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG_8.jpg")));
                        loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG_9.jpg")));
                        loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG_10.jpg")));
                        loadingScreenBGList.add(ImageIO.read(new File(imageFolder + "/Resources/background/loadingBG_11.jpg")));
                        System.out.println("GFX background images finished loading successfully.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    interrupt();
                }
            };
            temp.start();

            gameLogo = ImageIO.read(new File(imageFolder + "/Resources/ui/icon.png"));
            launcherBorder = ImageIO.read(new File(imageFolder + "/Resources/launcherBorder.png"));
            loadingIcon = new ImageIcon(imageFolder + "/Resources/ui/ok_hand.gif");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("GFX content preloaded.");

    }

    public static void randomBackground() {
        Random randBG = new Random();
        int randomBackground = randBG.nextInt(loadingScreenBGList.size());
        mainBackground = loadingScreenBGList.get(randomBackground);
        
    }

    public static void loadMainGFX() { //loads the main chunk of the GFX content

        //unloads content to dump from memory
        launcherBorder = null;

        //loads main GFX content
        System.out.println("Loading main GFX content...");

        try {
            mainBackground = ImageIO.read(new File(imageFolder + "/Resources/background/title_background_full.png"));
            gameLogoLarge = ImageIO.read(new File(imageFolder + "/Resources/ui/icon_large.png"));
            menuPlanet = ImageIO.read(new File(imageFolder + "/Resources/title_planet_full.png"));
            menuSpaceport = ImageIO.read(new File(imageFolder + "/Resources/title_spaceport_half.png"));
            moon1Icon = ImageIO.read(new File(imageFolder + "/Resources/title_moon1_half.png"));
            moon2Icon = ImageIO.read(new File(imageFolder + "/Resources/title_moon2_half.png"));
            menuGlare = ImageIO.read(new File(imageFolder + "/Resources/effects/glare.png"));
            button435_80 = ImageIO.read(new File(imageFolder + "/Resources/ui/button_435_80.png"));

            System.out.println("GFX content loaded successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadContentGFX() { //loads the GFX of stars, planets, etc
        BufferedImage temporaryImage;
        File directory;

        for (int i = 0; i < starCore.listOfStars.size(); i++) {
            try {
                directory = new File(System.getProperty("user.dir") + "/src" + starCore.listOfStars.get(i).getGfx());
                temporaryImage = ImageIO.read(directory);
                starCore.listOfStars.get(i).setGfxImage(temporaryImage);
                System.out.print(starCore.listOfStars.get(i).getName() + " GFX content loaded successfully. ");
            } catch (IOException e) {
                e.printStackTrace(); //TODO: Add a default for if it fails to load.
            }
        }

        System.out.println("\nContent GFX loaded.");
    }

    public static void loadMapGFX() {

        //removes all of the main menu GFX from the active memory
        gameLogoLarge = null;
        menuGlare = null;
        menuSpaceport = null;
        moon1Icon = null;
        moon2Icon = null;
        menuPlanet = null;

        //loads map GFX
        System.out.println("Loading map screen GFX content...");

        try {
            mainBackground = ImageIO.read(new File(imageFolder + "/Resources/mapBG.png"));
            planetIcon = ImageIO.read(new File(imageFolder + "/Resources/no_moon.png"));
            portraitBorder = ImageIO.read(new File(imageFolder + "/Resources/portraits/overlay.png"));
            menuBackground = ImageIO.read(new File(imageFolder + "/Resources/background/menutexture.png"));
            starPlanetCount = ImageIO.read(new File(imageFolder + "/Resources/ui/planet_number.png"));
            colonyCount = ImageIO.read(new File(imageFolder + "/Resources/ui/embassy.png"));
            homeSystem = ImageIO.read(new File(imageFolder + "/Resources/ui/home_system.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
