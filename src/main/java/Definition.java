public class Definition {
	private String mDefinition;
	private String mType;

	public Definition(String definition, String type) {
		mDefinition = definition;
		mType = type;
	}

	public String getDefintion() {
		return mDefinition;
	}

	public String getType() {
		return mType;
	}

	public void setType(String update) {
		mType = update;
	}

	public void setDefintion(String update) {
		mDefinition = update;
	}
}