package au.id.dbrown.example.helloworld.servlets.hellojson.simplemodel;

import java.util.HashMap;

/**
 * Quick and easy object holder :)
 * 
 * @author Damion Brown (dbrown) <the@dbrown.id.au>
 *
 */
public class ModelHolder {

	private HashMap<Integer, SimpleModel> SimpleModelHolder;

	static ModelHolder mh;

	public ModelHolder() {
		System.out.println("ModelHolder Constructed");
		this.SimpleModelHolder = new HashMap<Integer, SimpleModel>();
		ModelHolder.mh = this;
	}

	public SimpleModel getSimpleModel(int id) {
		for (Integer i : SimpleModelHolder.keySet()) {
			System.out.println(i + " : " + SimpleModelHolder.get(i).getString());
		}
		if (SimpleModelHolder.containsKey(id)) {
			return SimpleModelHolder.get(id);
		}
		return null;
	}

	public void setSimpleModel(SimpleModel simpelModel) {
		SimpleModelHolder.put(simpelModel.getId(), simpelModel);
	}

	/**
	 * Gets a ModelHolder or creates one if none exists.
	 * 
	 * @return instanceof ModelHodler.
	 */
	public static ModelHolder getHolder() {
		if (mh == null) {
			new ModelHolder();
		}
		return ModelHolder.mh;
	}

}
