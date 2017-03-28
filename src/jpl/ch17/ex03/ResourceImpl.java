package jpl.ch17.ex03;

public class ResourceImpl implements Resource {
	int keyHash;
	boolean needsRelease = false;

	public ResourceImpl(Object key) {
		keyHash = System.identityHashCode(key);
		needsRelease = true;

	}


	@Override
	public void use(Object key, Object... args) {
		if (System.identityHashCode(key) != keyHash)
			throw new IllegalArgumentException("wrong key");
	}

	@Override
	public synchronized void release() {
		if(needsRelease){
			needsRelease = false;
		}

	}

}
