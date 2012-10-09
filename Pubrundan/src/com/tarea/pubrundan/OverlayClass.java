package com.tarea.pubrundan;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import com.tarea.pubrundan.Pubs.JAPripps;
import com.tarea.pubrundan.Pubs.Gasquen;

public class OverlayClass extends ItemizedOverlay<OverlayItem> {

	private ArrayList<OverlayItem> myOverlays;
	
	private Context mContext;
	
	//@SuppressLint("UseSparseArrays")
	//private Map<Integer, String> pubs = new HashMap<Integer, String>();
	
	private int count = 0;
	
	private ArrayList<Integer> counter = new ArrayList<Integer>();
	

	public OverlayClass(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		myOverlays = new ArrayList<OverlayItem>();
		populate();
		mContext = context;
	}

	public void addOverlay(OverlayItem overlay) {
		myOverlays.add(overlay);
		populate();
		counter.add(count);
		//pubs.put(count, overlay.getTitle());
		count++;
	}

	@Override
	protected OverlayItem createItem(int i) {
		return myOverlays.get(i);
	}

	// Removes overlay item i
	public void removeItem(int i) {
		myOverlays.remove(i);
		populate();
	}

	// Handle tap events on overlay icons
	@Override
	protected boolean onTap(int i) {
			
			//String toast = "Title: " + myOverlays.get(i).getTitle();
			//toast += "\nText: " + myOverlays.get(i).getSnippet();
			//Toast.makeText(AppTest.context, toast, Toast.LENGTH_LONG).show();
			//OverlayItem item = myOverlays.get(i);
			if(counter.get(i) == 0 ){
			
				Intent toPubInfo = new Intent(mContext,JAPripps.class );
				mContext.startActivity(toPubInfo);			
				return true;
			}
			else if( counter.get(i) == 1 ){
			Intent toPubInfo2 = new Intent(mContext,Gasquen.class );
			mContext.startActivity(toPubInfo2);			
			return true;
			}
			return false;
		
	}

	// Returns present number of items in list
	@Override
	public int size() {
		return myOverlays.size();
	}
}