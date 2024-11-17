package project.thelittlethings.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import project.thelittlethings.entity.ModEntities;

public class SquirrelEntity extends AnimalEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;



    public SquirrelEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }




    // goals to give the mobs, mmb temptgoal -> ctrl+h goal for full list
    // can play with this and add/remove + modify prio
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this)); // main priority, prevents mob from drowning, priority 0
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D)); // allows them to mate given proper food
        this.goalSelector.add(2, new TemptGoal(this, 1.25d, Ingredient.ofItems(Items.BEETROOT), false)); //
        this.goalSelector.add(3, new FollowParentGoal(this, 1.15D));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }


    // mob attributes as it says

    public static DefaultAttributeContainer.Builder createSquirrelAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15) // squirrel base health value
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f) // move speed
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f);

    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.BEETROOT);
    }




    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {

        return ModEntities.SQUIRREL.create(world);
    }

    // custom sounds ambient, hurt, death etc.. can add own as long as registered
    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }


    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CAT_HURT;
    }


    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DOLPHIN_DEATH;
    }
}
