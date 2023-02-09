package rtg.world.biome.realistic.realworld;

import net.minecraft.world.biome.Biome;
import rtg.api.world.biome.RealisticBiomeBase;

import javax.annotation.Nonnull;


public abstract class RealisticBiomeRWBase extends RealisticBiomeBase {

    public RealisticBiomeRWBase(@Nonnull final Biome baseBiome, @Nonnull final RiverType riverType, @Nonnull final BeachType beachType) {

        super(baseBiome, riverType, beachType);
    }

    public RealisticBiomeRWBase(@Nonnull final Biome baseBiome) {
        this(baseBiome, RiverType.NORMAL, BeachType.NORMAL);
    }

    public RealisticBiomeRWBase(@Nonnull final Biome baseBiome, @Nonnull final RiverType riverType) {
        this(baseBiome, riverType, BeachType.NORMAL);
    }

    public RealisticBiomeRWBase(@Nonnull final Biome baseBiome, @Nonnull final BeachType beachType) {
        this(baseBiome, RiverType.NORMAL, beachType);
    }

    @Override
    public void initDecos() {
    }
}
