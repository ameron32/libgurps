package com.ameron32.libgurps.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import com.ameron32.libgurps.Note;
import com.ameron32.libgurps.tools.GenTools;
import com.ameron32.libgurps.tools.StringTools;

public abstract class GURPSObject implements Serializable {
    private static final long serialVersionUID = -108925174014605476L;

    // REFERENCE
    private long objectId;
    private String name, description, sId;
    
    // TYPE OF OBJECT
    public enum ObjectType { LibraryObject, WorldObject, InterfaceObject, NoteObject };
    protected ObjectType objectType;
    
    // OBJECT NOTES
    Set<Note> myNotes;
    
    /**
     * Allows all objects to have a unique long id. If given 0l, will generate a random long id. Otherwise uses the passed long id.
     * 
     * @param Unless an id is to be generated
     */
    protected GURPSObject(long id) {
        if (id != 0l) {
            objectId = id;
        } else {
            setRandomLongId();
        }
        register();
    }
    
    /**
     * Allows all objects to have a unique long id. If given "random", will generate a random long id.
     * 
     * @param Use "random" for random. Otherwise, use constructor(long).
     */
    protected GURPSObject(String random) {
        if (random.equalsIgnoreCase("random")) {
            setRandomLongId(); 
        }
        register();
    }
    
    protected void setObjectType(ObjectType objType) {
		if (objType != null) {
			objectType = objType;
		}
	}
    
    private void setRandomLongId() {
        objectId = GenTools.genLongId(); // generate random long id
    }

    /**
     * Registers the new object with the registry. Replaces other objects with the same long id.
     * 
     * @return TRUE if new, FALSE if overwriting a previous object with the same long id
     */
    private boolean register() {
        if (objectRegistry.put(objectId, this) == null) 
            return true;
        else 
            return false;
    }
    
    /**
     * Return the unique long id generated when this object was created.
     * 
     * @return unique long id of this object
     */
    public long getObjectId() {
        return objectId;
    }
    
    /**
     * Return the object registered in the global GURPS registry with this unique long id.
     * 
     * @param id of object to find
     * @return GURPSObject associated with this long id
     */
    public static GURPSObject findGURPSObjectById(long id) {
    	return objectRegistry.get(id);
    }
    
	/**
	 * In rare cases, an objectId may need to be replaced with the objectId of
	 * another object. This is not a standard practice.
	 * 
	 * @param objectId
	 *            to overwrite onto this object
	 */
    public void overwriteObjectId(long objectId) {
        this.objectId = objectId; 
    }
    
    /**
     * Eliminate this GURPSObject from the registry, thereby removing it from existence.
     */
    public void destroy() {
        if (objectRegistry.containsKey(this.objectId))
            objectRegistry.remove(this.objectId);
    }
    
    /* REGISTRY */
    
    private static final Hashtable<Long, GURPSObject> objectRegistry = new Hashtable<Long, GURPSObject>();
    
    /**
     * TRY TO AVOID USING THIS METHOD!!!
     * 
     * @return A CLONE OF ObjectRegistry
     */
//    public static Hashtable<Long, GURPSObject> getObjectRegistry() {
//        return (Hashtable<Long, GURPSObject>) objectRegistry.clone();
//    }

    /**
	 * Returns TRUE if this long id is registered with the registry. Returns
	 * FALSE is this long id is not registered. Since all GURPSObject long ids are
	 * registered at creation, FALSE would indicate a flaw in the programming.
	 * 
	 * @param id the id to check
	 * @return boolean T/F: id is registered
	 */
    public static boolean isRegistered(long id) {
        return objectRegistry.containsKey(id);
    }
    
    /**
	 * Returns TRUE if this GURPSObject is registered with the registry. Returns
	 * FALSE is this GURPSObject is not registered. Since all GURPSObjects are
	 * registered at creation, FALSE would indicate a flaw in the programming.
	 * 
	 * @param obj GURPSObject to check
	 * @return T/F: id is registered
	 */
    public static boolean isRegistered(GURPSObject obj) {
        return objectRegistry.containsValue(obj);
    }
    
    /**
     * Scans the registry for all GURPSObjects registered of the given Class type. Returns
     * an ArrayList of those GURPSObjects.
     * 
     * @param c
     * @return
     */
	public static List<GURPSObject> getAll(Class<?> c) {
		List<GURPSObject> matchingGURPSObjects = new ArrayList<GURPSObject>();
		for (GURPSObject go : objectRegistry.values()) {
			if (c.isInstance(go)) {
				matchingGURPSObjects.add(go);
			}
		}
		return matchingGURPSObjects;
	}
    
    /* NOTES */
    
    public void addNote(Note n) {
        if (myNotes == null) myNotes = new HashSet<Note>();
        if (this instanceof Note)
            ; // refuse to add note. should not allow notes attached to notes.
        else if (!myNotes.add(n)) 
            ; // failed to add note, TODO not sure how to handle yet 
    }
    
    public Set<Note> getNotes() {
        if (myNotes == null) myNotes = new HashSet<Note>();
        return myNotes;
    }
    
    
    

    


	@Override
	public String toString() {
		return "GURPSObject: " + this.getClass().getSimpleName() + " > " + this.getName() + "\n"
//				+ " ********************************* \n"
				+ " " + StringTools.encase("name=" + name, 30)
				+ " " + StringTools.encase("objectId=" + objectId, 29) 
				+ " " + StringTools.encase("objectType=" + objectType, 24) 
//				+ "\n " + StringTools.encase("myNotes=" + myNotes, 24+28+30+10) 
				+ "\n ********** \n";
	}

	public String getName() {
    	return name;
    }
	
	protected void setName(String name) {
		this.name = name;
	}
    
    public String getDescription() {
    	return description;
    }
    
    protected void setDescription(String description) {
    	this.description = description;
    }
    
    public String getSID() {
    	return sId;
    }
    
    protected void setSID(String sId) {
    	this.sId = sId;
    }
    
}
