package fuzs.betteranimationscollection;

import fuzs.betteranimationscollection.client.element.*;
import fuzs.puzzleslib.PuzzlesLib;
import fuzs.puzzleslib.element.AbstractElement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"WeakerAccess", "unused"})
@Mod(BetterAnimationsCollection.MODID)
public class BetterAnimationsCollection {

    public static final String MODID = "betteranimationscollection";
    public static final String NAME = "Better Animations Collection";
    public static final Logger LOGGER = LogManager.getLogger(NAME);

    public static final AbstractElement SOUND_DETECTION = PuzzlesLib.register(MODID, "sound_detection", SoundDetectionElement::new, Dist.CLIENT);
    public static final AbstractElement OINKY_PIG = PuzzlesLib.register(MODID, "oinky_pig", OinkyPigElement::new, Dist.CLIENT);
    public static final AbstractElement BUCKA_CHICKEN = PuzzlesLib.register(MODID, "bucka_chicken", BuckaChickenElement::new, Dist.CLIENT);
    public static final AbstractElement GHAST_TENTACLES = PuzzlesLib.register(MODID, "ghast_tentacles", GhastTentaclesElement::new, Dist.CLIENT);
    public static final AbstractElement SQUID_TENTACLES = PuzzlesLib.register(MODID, "squid_tentacles", SquidTentaclesElement::new, Dist.CLIENT);
    public static final AbstractElement KNEELING_SHEEP = PuzzlesLib.register(MODID, "kneeling_sheep", KneelingSheepElement::new, Dist.CLIENT);
    public static final AbstractElement SPIDER_KNEES = PuzzlesLib.register(MODID, "spider_knees", SpiderKneesElement::new, Dist.CLIENT);
    public static final AbstractElement ANIMATED_SNOWMAN_STICK = PuzzlesLib.register(MODID, "animated_snowman_stick", AnimatedSnowManStickElement::new, Dist.CLIENT);
    public static final AbstractElement COW_UDDER = PuzzlesLib.register(MODID, "cow_udder", CowUdderElement::new, Dist.CLIENT);

    public BetterAnimationsCollection() {

        PuzzlesLib.setup(true);
        PuzzlesLib.setSideSideOnly();
    }

}
