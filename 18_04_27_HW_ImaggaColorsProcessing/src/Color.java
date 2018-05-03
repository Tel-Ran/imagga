
public class Color {
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closest_palette_color == null) ? 0 : closest_palette_color.hashCode());
		result = prime * result
				+ ((closest_palette_color_parent == null) ? 0 : closest_palette_color_parent.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (closest_palette_color == null) {
			if (other.closest_palette_color != null)
				return false;
		} else if (!closest_palette_color.equals(other.closest_palette_color))
			return false;
		if (closest_palette_color_parent == null) {
			if (other.closest_palette_color_parent != null)
				return false;
		} else if (!closest_palette_color_parent.equals(other.closest_palette_color_parent))
			return false;
		return true;
	}
public String closest_palette_color_parent;
public String closest_palette_color;
public float percent;
public String getClosest_palette_color_parent() {
	return closest_palette_color_parent;
}
public String getClosest_palette_color() {
	return closest_palette_color;
}
public float getPercent() {
	return percent;
}
@Override
public String toString(){
	String res=String.format("%-20s%-20s%f", closest_palette_color_parent,
			closest_palette_color,percent);
	return res;
}
}
