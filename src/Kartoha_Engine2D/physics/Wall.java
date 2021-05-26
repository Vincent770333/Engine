package Kartoha_Engine2D.physics;

import Kartoha_Engine2D.drawing.ArbitraryFigure;
import Kartoha_Engine2D.limiters.Collisional;
import Kartoha_Engine2D.limiters.Intersectional;
import Kartoha_Engine2D.utils.JsonAble;
import Kartoha_Engine2D.utils.Tools;
import Kartoha_Engine2D.geometry.Line;
import Kartoha_Engine2D.geometry.Point2;
import Kartoha_Engine2D.geometry.Vector2;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;

public class Wall extends Line implements Collisional, Intersectional, JsonAble {

    private final Material material;
    private transient Space space;
    @Getter @Setter
    private DrawingParam drawingParam;


    {
        drawingParam = DrawingParam.DOWN;
    }


    public Wall(float x1, float y1, float x2, float y2, Material material, Space space) {
        super(x1, y1, x2, y2);
        this.material = material;
        this.space = space;
        drawingParam = DrawingParam.DOWN;
    }

    public Wall(Point2 point1, Point2 point2, Material material, Space space) {
        super(point1, point2);
        this.material = material;
        this.space = space;
    }

    public Wall(Point2 point, Vector2 vector, Material material, Space space) {
        super(point, vector);
        this.material = material;
        this.space = space;
    }

    public Wall(Line line, Material material, Space space){
        super(line.x1, line.y1, line.x2, line.y2);
        this.material = material;
        this.space = space;
    }

    public Material getMaterial() {
        return material;
    }

    public Line toLine(){
        return new Line(x1, y1, x2, y2);
    }

    public void setSpace(Space space) {
        if (this.space == null) {
            this.space = space;
        }
    }

    public Point2 getPoint1(){
        return new Point2(x1, y1);
    }

    public Point2 getPoint2(){
        return new Point2(x2, y2);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(material.outlineColor);
        g.drawLine(Tools.transformFloat(x1 - space.getCamera().getXMovement()), Tools.transformFloat(y1- space.getCamera().getYMovement()),
                Tools.transformFloat(x2 - space.getCamera().getXMovement()), Tools.transformFloat(y2- space.getCamera().getYMovement()));
//        if (true){
//            Polygon polygon = new Polygon(new int[] {Tools.transformFloat(x1 - space.getCamera().getXMovement()), Tools.transformFloat(x2 - space.getCamera().getXMovement()),
//                    Tools.transformFloat(x2 - space.getCamera().getXMovement()),
//                    Tools.transformFloat(x1 - space.getCamera().getXMovement())}, new int[]{Tools.transformFloat(y1- space.getCamera().getYMovement()),
//                    Tools.transformFloat(y2- space.getCamera().getYMovement()), 3000, 3000}, 4);
//            g.setColor(material.fillColor);
//            g.drawPolygon(polygon);
//            g.fillPolygon(polygon);
//        }
    }

}

enum DrawingParam{

    UP, DOWN

}
