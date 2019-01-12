package com.interplay.watery.items.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Oxygen Tank - _InterPlay_
 * Created using Tabula 7.0.0
 */
public class ModelOxygenTank extends ModelBiped
{
    public ModelRenderer body;
    public ModelRenderer oxytube8;
    public ModelRenderer tank;
    public ModelRenderer tank_in;
    public ModelRenderer oxytube7;
    public ModelRenderer oxytube6;
    public ModelRenderer oxytube5;

    public ModelOxygenTank()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        
        this.oxytube5 = new ModelRenderer(this, 76, 52);
        this.oxytube5.setRotationPoint(-3.0F, -8.0F, -4.0F);
        this.oxytube5.addBox(-4.0F, 6.0F, 1.0F, 2, 2, 6, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.tank = new ModelRenderer(this, 75, 35);
        this.tank.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.tank.addBox(2.0F, 3.0F, 4.0F, 4, 8, 4, 0.0F);
        this.tank_in = new ModelRenderer(this, 100, 64);
        this.tank_in.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.tank_in.addBox(3.0F, 2.0F, 5.0F, 2, 1, 2, 0.0F);
        this.oxytube8 = new ModelRenderer(this, 100, 48);
        this.oxytube8.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.oxytube8.addBox(3.0F, 1.0F, 5.0F, 2, 1, 2, 0.0F);
        this.oxytube7 = new ModelRenderer(this, 100, 60);
        this.oxytube7.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.oxytube7.addBox(-2.0F, 0.0F, 5.0F, 6, 2, 2, 0.0F);
        this.oxytube6 = new ModelRenderer(this, 100, 56);
        this.oxytube6.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.oxytube6.addBox(-3.0F, -1.0F, 4.0F, 2, 2, 2, 0.0F);
        
      //para grudar no corpo
        this.bipedBody.addChild(body);
        this.bipedBody.addChild(oxytube5);
        this.bipedBody.addChild(oxytube6);
        this.bipedBody.addChild(oxytube7);
        this.bipedBody.addChild(tank_in);
        this.bipedBody.addChild(tank);
        this.bipedBody.addChild(oxytube8);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
