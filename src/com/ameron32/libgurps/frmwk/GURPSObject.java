package com.ameron32.libgurps.frmwk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import com.ameron32.libgurps.Note;
import com.ameron32.libgurps.tools.GenTools;

public abstract class GURPSObject implements Serializable {
    private static final long serialVersionUID = -108925174014605476L;

    // REFERENCE
    private long objectId;
    
    // TYPE OF OBJECT
    public enum ObjectType { LibraryObject, WorldObject, NoteObject };
    protected ObjectType objectType;
    
    // OWNERSHIP
    private User owner;
    
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
        }
        else {
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
        } else {
            if (this instanceof Note) {
                objectType = ObjectType.NoteObject;
            }
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
    
    public long getObjectId() {
        return objectId;
    }
    
    public void overwriteObjectId(long objectId) {
        this.objectId = objectId; 
    }
    
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
    public static Hashtable<Long, GURPSObject> getObjectRegistry() {
        return (Hashtable<Long, GURPSObject>) objectRegistry.clone();
    }

    public static boolean isRegistered(long id) {
        return objectRegistry.containsKey(id);
    }
    
    public static boolean isRegistered(GURPSObject obj) {
        return objectRegistry.containsValue(obj);
    }
    
    public static List<Object> getAll(Class<?> c, List<Object> list) {
    	List<Object> matchingObjects = new ArrayList<Object>();
    	for (Object o : list) {
    		if (o.getClass().isInstance(c)) {
    			matchingObjects.add(o);
    		}
    	}
    	return matchingObjects;
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
    
    public abstract String nameString();
    
    public abstract String detailString();
    
}
