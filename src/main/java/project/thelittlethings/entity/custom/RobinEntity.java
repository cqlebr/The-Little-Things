package project.thelittlethings.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import project.thelittlethings.entity.ModEntities;
import project.thelittlethings.item.ModItems;
import net.minecraft.util.math.MathHelper;

public class RobinEntity extends AnimalEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public float flapProgress;
    public float maxWingDeviation;
    public float prevMaxWingDeviation;
    public float prevFlapProgress;
    private float flapSpeed = 1.5F;




    public RobinEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 20, false);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(20) + 40;
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
            flapWings();
        }
    }

    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
    }

    public boolean isInAir() {
        return !this.isOnGround();
    }



    // goals to give the mobs, mmb temptgoal -> ctrl+h goal for full list
    // can play with this and add/remove + modify prio
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new EscapeDangerGoal(this, (double)1.25F));
        this.goalSelector.add(0, new SwimGoal(this)); // main priority, prevents mob from drowning, priority 0
        this.goalSelector.add(1, new FlyGoal(this, 1.0D));
        this.goalSelector.add(2, new WanderAroundGoal(this, 1D));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.15D)); // allows them to mate given proper food
        this.goalSelector.add(3, new TemptGoal(this, 1.25d, Ingredient.ofItems(ModItems.MAPLE_CREME_BRULEE), false)); //
        this.goalSelector.add(4, new FollowParentGoal(this, 1.15D));





    }


    // mob attributes as it says

    public static DefaultAttributeContainer.Builder createRobinAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.9f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10) // Bird base health value
                .add(EntityAttributes.GENERIC_ARMOR, 0.1f);

    }
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(true);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    private void flapWings() {
        this.prevFlapProgress = this.flapProgress;
        this.prevMaxWingDeviation = this.maxWingDeviation;
        this.maxWingDeviation += (float)(!this.isOnGround() && !this.hasVehicle() ? 4 : -1) * 0.3F;
        this.maxWingDeviation = MathHelper.clamp(this.maxWingDeviation, 0.0F, 1.0F);
        if (!this.isOnGround() && this.flapSpeed < 1.0F) {
            this.flapSpeed = 1.0F;
        }

        this.flapSpeed *= 0.9F;
        Vec3d vec3d = this.getVelocity();
        if (!this.isOnGround() && vec3d.y < (double)0.0F) {
            this.setVelocity(vec3d.multiply((double)1.0F, 0.6, (double)1.0F));
        }

        this.flapProgress += this.flapSpeed * 2.0F;
    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.MAPLE_CREME_BRULEE);
    }



    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {

        return ModEntities.ROBIN.create(world);
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