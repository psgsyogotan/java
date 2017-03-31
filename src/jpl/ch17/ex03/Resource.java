package jpl.ch17.ex03;

public interface Resource {
	void use(Object keym, Object...args);
	void release();

}
