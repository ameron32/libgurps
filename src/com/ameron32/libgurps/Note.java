package com.ameron32.libgurps;

import java.util.Date;

import com.ameron32.libgurps.frmwk.GURPSObject;

public class Note extends GURPSObject {
    private static final long serialVersionUID = -2334734785673637653L;

    private final long timeCreated; // TODO better than Date?
    private final GURPSObject hostObject; // this is the object the note was added to
    
    private final String noteText;
    
    public Note(GURPSObject obj, String owner, String note) {
        super("random");
        timeCreated = System.currentTimeMillis();
        hostObject = obj;
        noteText = note;
    }
    
    public long getTimeCreated() {
        return timeCreated;
    }
    
    public String getNoteText() {
        return noteText;
    }
    
    public GURPSObject getHostObject() {
        return hostObject;
    }

    @Override
    public String nameString() {
        return "Note";
    }

}
