package ghosti.babycreeper.client;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;



public class BabyCreeperModel extends EntityModel<BabyCreeperRenderState> {
    private final ModelPart baby;
    private final ModelPart lowers;
    private final ModelPart bodybone;
    private final ModelPart feet;
    private final ModelPart feetfront;
    private final ModelPart footflbone;
    private final ModelPart footfrbone;
    private final ModelPart feetback;
    private final ModelPart footblbone;
    private final ModelPart footbrbone;
    private final ModelPart headbone;

    private final KeyframeAnimation idle;
    private final KeyframeAnimation walk;
    private final KeyframeAnimation attack;
    private final KeyframeAnimation death;

    public BabyCreeperModel(ModelPart root) {
        // Passing the root directly to super handles basic 26.2 rendering automatically
        super(root);
        this.baby = root.getChild("baby");
        this.lowers = this.baby.getChild("lowers");
        this.bodybone = this.lowers.getChild("bodybone");
        this.feet = this.lowers.getChild("feet");
        this.feetfront = this.feet.getChild("feetfront");
        this.footflbone = this.feetfront.getChild("footflbone");
        this.footfrbone = this.feetfront.getChild("footfrbone");
        this.feetback = this.feet.getChild("feetback");
        this.footblbone = this.feetback.getChild("footblbone");
        this.footbrbone = this.feetback.getChild("footbrbone");
        this.headbone = this.baby.getChild("headbone");

        this.idle = BabyCreeperAnimation.Idle.bake(root);
        this.walk = BabyCreeperAnimation.Walk.bake(root);
        this.attack = BabyCreeperAnimation.Attack.bake(root);
        this.death = BabyCreeperAnimation.Death.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();

        PartDefinition baby = root.addOrReplaceChild("baby", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.0F));

        PartDefinition lowers = baby.addOrReplaceChild("lowers", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 0.0F));

        PartDefinition bodybone = lowers.addOrReplaceChild("bodybone", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition feet = lowers.addOrReplaceChild("feet", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition feetfront = feet.addOrReplaceChild("feetfront", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition footflbone = feetfront.addOrReplaceChild("footflbone", CubeListBuilder.create().texOffs(12, 16).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

        PartDefinition footfrbone = feetfront.addOrReplaceChild("footfrbone", CubeListBuilder.create().texOffs(12, 20).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

        PartDefinition feetback = feet.addOrReplaceChild("feetback", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition footblbone = feetback.addOrReplaceChild("footblbone", CubeListBuilder.create().texOffs(20, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

        PartDefinition footbrbone = feetback.addOrReplaceChild("footbrbone", CubeListBuilder.create().texOffs(20, 20).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

        PartDefinition headbone = baby.addOrReplaceChild("headbone", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 32, 32);
    }

    @Override
    public void setupAnim(final BabyCreeperRenderState state) {
        super.setupAnim(state);
    
        this.idle.apply(state.idle, state.ageInTicks);
        this.walk.apply(state.walk, state.ageInTicks);
        this.attack.apply(state.attack, state.ageInTicks);
        this.death.apply(state.death, state.ageInTicks);
    }
}
