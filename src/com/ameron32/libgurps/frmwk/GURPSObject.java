package com.ameron32.libgurps.frmwk;

import com.ameron32.libgurps.tools.GenTools;

public abstract class GURPSObject {

    // REFERENCE
    long objectId;
    
    /**
     * Allows all objects to have a unique long id. If given 0l, will generate a random long id. Otherwise uses the passed long id.
     * 
     * @param Unless an id is to be generated
     */
    protected GURPSObject(long id) {
        if (id == 0l)
            objectId = GenTools.genLongId();
    }
    
    public long getObjectId() {
        return objectId;
    }
    
    public void overwriteObjectId(long objectId) {
        this.objectId = objectId; 
    }
    
}
