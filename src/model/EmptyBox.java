package model;

public class EmptyBox extends Box  {

    /**
	 * 
	 */
	private static final long serialVersionUID = -9141517191509008725L;

	@Override
    public BoxType getType() {
        return BoxType.EMPTY;
    }
}
