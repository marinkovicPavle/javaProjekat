package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;
	private Color color;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(getColor());
		g.drawOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.innerRadius*2);
		
		if (isSelected()) {
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getRadius() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getRadius() - 3, 6, 6);
		}
	}
	
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}
	
	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(x, y);
		return dFromCenter > innerRadius &&
				super.contains(x, y);
	}
	
	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return dFromCenter > innerRadius &&
				super.contains(p.getX(), p.getY());
	}
	
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut d = (Donut) obj;
			if (this.getCenter().equals(d.getCenter()) &&
					this.getRadius() == d.getRadius() &&
					this.innerRadius == d.getInnerRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		return super.toString() + ", inner radius=" + innerRadius ;
	}
	
}
