package com.ameron32.libgurps.items.world;

import java.util.ArrayList;
import java.util.List;

import com.ameron32.libgurps.damage.Damage;
import com.ameron32.libgurps.impl.GURPSLibraryObject;
import com.ameron32.libgurps.impl.GURPSWorldObject;
import com.ameron32.libgurps.impl.User;
import com.ameron32.libgurps.items.frmwk.Attachable;
import com.ameron32.libgurps.items.frmwk.AttachmentCarrier;
import com.ameron32.libgurps.items.frmwk.DamageGenerator;
import com.ameron32.libgurps.items.frmwk.DamageReceiver;
import com.ameron32.libgurps.items.frmwk.DamageReducer;
import com.ameron32.libgurps.items.frmwk.EquipmentUser;
import com.ameron32.libgurps.items.frmwk.Equippable;
import com.ameron32.libgurps.items.frmwk.LibraryDuplicate;
import com.ameron32.libgurps.items.frmwk.ThrowableItem;
import com.ameron32.libgurps.items.library.Library;

public class WorldItem extends GURPSWorldObject implements DamageGenerator, DamageReducer, Equippable, AttachmentCarrier, ThrowableItem, LibraryDuplicate {
	private static final long serialVersionUID = 1086080560858324155L;

    // TODO Notes: consider interfaces for Ownable, Personalizable/Customizable
	// TODO REVIEW EVERYTHING!!!
	
	// TODO constructor, include source
	public WorldItem(String sId) {
		super("random");
		source = findCloneSource(sId);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void requestSource(String sId) {
		//TODO finish event
	}
	
	
    // OWNERSHIP
    private User owner;
	
    /**
     * PERSONALIZE
     */
    String pName, pDescription; 
    
    public void personalize(String pName, String pDescription) {
        this.pName = pName;
        this.pDescription = pDescription;
    }
    
    
    
    /**
     * GENERATE EVENTS
     */
    
    @Override
    public void causeDamage(Damage d) {
        // TODO Auto-generated method stub
        
    }

    
    
    /**
     * RESPOND TO INCOMING EVENTS
     */
    
    private static final List<DamageReceiver> myTargets = new ArrayList<DamageReceiver>();
    @Override
    public void addReceiver(DamageReceiver dr) {
        // TODO Auto-generated method stub
        myTargets.add(dr);
    }

    @Override
    public void addReducer(DamageReducer dr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reduceDamage(Damage d) {
        // TODO Auto-generated method stub
        
    }

    // EQUIP
    EquipmentUser user;
    @Override
    public boolean equipTo(EquipmentUser eu) {
        user = eu;
        return true;
        // TODO add slot item replacement and restrictions
    }
    
    @Override
    public boolean unequip() {
        user = null;
        return true;
    }
    
    @Override
    public boolean isEquipped() {
        return (user != null);
    }
    
    @Override
    public boolean isEquippedBy(EquipmentUser eu) {
        return (user == eu);
    }

    @Override
    public EquipmentUser getEquippedBy() {
        return user;
    }
    

    
    // ATTACHMENTCARRIER
    List<Attachable> attachments;
    @Override
    public void attach(Attachable a) {
        // TODO Auto-generated method stub
        if (a == null) attachments = new ArrayList<Attachable>();
        if (a != this) attachments.add(a);
    }
    
    @Override
    public boolean remove(Attachable a) {
        // TODO Auto-generated method stub
        if (attachments.contains(a)) 
            return attachments.remove(a);
        else
            return false;
    }
    
    @Override
    public void throwItem(Throwable throwable) {
        // TODO Calculate generic thrown damage for all objects/items
        
    }
    
    public List<Attachable> getAttachments() {
        return attachments;
    }
    
    
    
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public EquipmentUser getUser() {
        return user;
    }

    public void setUser(EquipmentUser user) {
        this.user = user;
    }

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSId() {
		// TODO Auto-generated method stub
		return null;
	}

	public float getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}




}
