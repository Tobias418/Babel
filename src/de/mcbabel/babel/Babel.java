package de.mcbabel.babel;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

import java.util.Random;

public class Babel extends SimpleApplication {

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Babel 0.1");
        settings.setResizable(true);
        Babel babel = new Babel();
        babel.setShowSettings(false);
        babel.setSettings(settings);
        babel.start();
    }

    Box b = new Box(1, 1, 1);
    Geometry geom = new Geometry("Box", b);

    @Override
    public void simpleInitApp() {
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Pink);
        geom.setMaterial(mat);
        geom.setUserData("gey", true);
        rootNode.attachChild(geom);
    }

    Random rand = new Random();
    float time = 0f;
    float cooldown = 2f;

    @Override
    public void simpleUpdate(float tpf) {
        time += tpf;
        geom.rotate(0, tpf, 0);
        if (time >= cooldown) {
            time -= cooldown;
            geom.getMaterial().setColor("Color", new ColorRGBA(rand.nextFloat(1f), rand.nextFloat(1f), rand.nextFloat(1f), 1f));
        }
    }
}
