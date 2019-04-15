package ch.ilge.ivy.config.validation.util;

/**
 * TODO
 * @author Laura Steiner
 *
 * @param <T>
 * @param <S>
 */
public class Pair<T, S> {
	
	public final T left;
	
	public final S right;
	
	/**
	 * @param left
	 * @param right
	 */
	public Pair(T left, S right) {
		super();
		this.left = left;
		this.right = right;
	}
	
}
