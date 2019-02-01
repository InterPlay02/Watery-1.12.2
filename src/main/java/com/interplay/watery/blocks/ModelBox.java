package com.interplay.watery.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Box - InterPlay
 * Created using Tabula 7.0.0
 */
public class ModelBox extends ModelBase
{
    public ModelRenderer BoxInner;
    public ModelRenderer Borda1;
    public ModelRenderer Borda2;
    public ModelRenderer Borda3;
    public ModelRenderer Borda4;
    public ModelRenderer Borda5;
    public ModelRenderer Borda6;
    public ModelRenderer Borda7;
    public ModelRenderer Borda8;
    public ModelRenderer Borda9;
    public ModelRenderer Borda10;
    public ModelRenderer Borda11;
    public ModelRenderer Borda12;
    public ModelRenderer Borda5_1;
    public ModelRenderer Borda5_2;
    public ModelRenderer Borda12_1;
    public ModelRenderer Borda12_2;
    public ModelRenderer Borda10_1;
    public ModelRenderer Borda10_2;
    public ModelRenderer Borda12_3;
    public ModelRenderer Borda12_4;
    public ModelRenderer Borda10_3;
    public ModelRenderer Borda10_4;

    public ModelBox()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        
        this.Borda6 = new ModelRenderer(this, 5, 5);
        this.Borda6.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.Borda6.addBox(0.0F, 0.0F, 0.0F, 16, 1, 1, 0.0F);
        this.Borda5_1 = new ModelRenderer(this, 65, 20);
        this.Borda5_1.setRotationPoint(7.0F, 8.0F, -7.0F);
        this.Borda5_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14, 0.0F);
        this.Borda12_1 = new ModelRenderer(this, 65, 0);
        this.Borda12_1.setRotationPoint(7.0F, 9.0F, 7.0F);
        this.Borda12_1.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.Borda2 = new ModelRenderer(this, 5, 15);
        this.Borda2.setRotationPoint(-8.0F, 23.0F, -8.0F);
        this.Borda2.addBox(0.0F, 0.0F, 0.0F, 16, 1, 1, 0.0F);
        this.Borda1 = new ModelRenderer(this, 65, 60);
        this.Borda1.setRotationPoint(7.0F, 23.0F, -7.0F);
        this.Borda1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14, 0.0F);
        this.Borda5 = new ModelRenderer(this, 35, 95);
        this.Borda5.setRotationPoint(-7.9F, 8.1F, -7.0F);
        this.Borda5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 21, 0.0F);
        this.setRotateAngle(Borda5, 0.0F, 0.7853981633974483F, 0.0F);
        this.Borda10_2 = new ModelRenderer(this, 40, 25);
        this.Borda10_2.setRotationPoint(-7.4F, 9.5F, 7.0F);
        this.Borda10_2.addBox(0.0F, 0.0F, 0.0F, 1, 20, 1, 0.0F);
        this.setRotateAngle(Borda10_2, 0.0F, 0.0F, -0.7853981633974483F);
        this.Borda10_3 = new ModelRenderer(this, 15, 25);
        this.Borda10_3.setRotationPoint(-7.4F, 9.5F, -8.0F);
        this.Borda10_3.addBox(0.0F, 0.0F, 0.0F, 1, 20, 1, 0.0F);
        this.setRotateAngle(Borda10_3, 0.0F, 0.0F, -0.7853981633974483F);
        this.Borda3 = new ModelRenderer(this, 5, 20);
        this.Borda3.setRotationPoint(-8.0F, 23.0F, 7.0F);
        this.Borda3.addBox(0.0F, 0.0F, 0.0F, 16, 1, 1, 0.0F);
        this.Borda4 = new ModelRenderer(this, 75, 0);
        this.Borda4.setRotationPoint(-8.0F, 9.0F, 7.0F);
        this.Borda4.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.Borda9 = new ModelRenderer(this, 65, 85);
        this.Borda9.setRotationPoint(-8.0F, 23.0F, -7.0F);
        this.Borda9.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14, 0.0F);
        this.BoxInner = new ModelRenderer(this, 5, 50);
        this.BoxInner.setRotationPoint(-7.0F, 9.0F, -7.0F);
        this.BoxInner.addBox(0.0F, 0.0F, 0.0F, 14, 15, 14, 0.0F);
        this.Borda10_1 = new ModelRenderer(this, 70, 0);
        this.Borda10_1.setRotationPoint(-8.0F, 9.0F, -8.0F);
        this.Borda10_1.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.Borda5_2 = new ModelRenderer(this, 5, 100);
        this.Borda5_2.setRotationPoint(6.9F, 8.0F, -7.7F);
        this.Borda5_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 21, 0.0F);
        this.setRotateAngle(Borda5_2, 0.0F, -0.7853981633974483F, 0.0F);
        this.Borda12_2 = new ModelRenderer(this, 25, 25);
        this.Borda12_2.setRotationPoint(-7.9F, 8.5F, 6.6F);
        this.Borda12_2.addBox(0.0F, 0.0F, 0.0F, 1, 20, 1, 0.0F);
        this.setRotateAngle(Borda12_2, -0.7853981633974483F, 0.0F, 0.0F);
        this.Borda10 = new ModelRenderer(this, 35, 25);
        this.Borda10.setRotationPoint(6.7F, 8.6F, 6.9F);
        this.Borda10.addBox(0.0F, 0.0F, 0.0F, 1, 20, 1, 0.0F);
        this.setRotateAngle(Borda10, 0.0F, 0.0F, 0.7853981633974483F);
        this.Borda12 = new ModelRenderer(this, 30, 25);
        this.Borda12.setRotationPoint(-8.0F, 9.3F, -7.4F);
        this.Borda12.addBox(0.0F, 0.0F, 0.0F, 1, 20, 1, 0.0F);
        this.setRotateAngle(Borda12, 0.7853981633974483F, 0.0F, 0.0F);
        this.Borda12_4 = new ModelRenderer(this, 10, 25);
        this.Borda12_4.setRotationPoint(7.0F, 8.5F, 6.6F);
        this.Borda12_4.addBox(0.0F, 0.0F, 0.0F, 1, 20, 1, 0.0F);
        this.setRotateAngle(Borda12_4, -0.7853981633974483F, 0.0F, 0.0F);
        this.Borda10_4 = new ModelRenderer(this, 20, 25);
        this.Borda10_4.setRotationPoint(6.7F, 8.6F, -7.9F);
        this.Borda10_4.addBox(0.0F, 0.0F, 0.0F, 1, 20, 1, 0.0F);
        this.setRotateAngle(Borda10_4, 0.0F, 0.0F, 0.7853981633974483F);
        this.Borda8 = new ModelRenderer(this, 65, 40);
        this.Borda8.setRotationPoint(-8.0F, 8.0F, -7.0F);
        this.Borda8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14, 0.0F);
        this.Borda12_3 = new ModelRenderer(this, 5, 25);
        this.Borda12_3.setRotationPoint(6.9F, 9.3F, -7.4F);
        this.Borda12_3.addBox(0.0F, 0.0F, 0.0F, 1, 20, 1, 0.0F);
        this.setRotateAngle(Borda12_3, 0.7853981633974483F, 0.0F, 0.0F);
        this.Borda7 = new ModelRenderer(this, 5, 10);
        this.Borda7.setRotationPoint(-8.0F, 8.0F, 7.0F);
        this.Borda7.addBox(0.0F, 0.0F, 0.0F, 16, 1, 1, 0.0F);
        this.Borda11 = new ModelRenderer(this, 60, 0);
        this.Borda11.setRotationPoint(7.0F, 9.0F, -8.0F);
        this.Borda11.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
