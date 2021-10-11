
public class Practice {
	
	public static <T> boolean isomorphic(BTNode<T> T1, BTNode<T> T2) {
		if (T1 == null && T2 == null) {
			return true;
		} else if ((T1 == null && T2 != null) || (T1 != null && T2 == null)) {
			return false;
		} else if (isomorphic(T1.left, T1.right) &&
				isomorphic(T2.left, T2.right)) {
			return true;
		} else {
			return false;
		}
	}
	
}
