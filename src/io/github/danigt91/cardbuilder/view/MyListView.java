package io.github.danigt91.cardbuilder.view;

import io.github.danigt91.cardbuilder.listener.MyListViewListener;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MyListView extends ListView{
	
	private int indexPosition, topPosition;
	
	private MyListViewListener myListViewListener;
	
	public MyListView(Context context) {
		super(context);
		indexPosition = -1;
		topPosition = -1;
	}
	
	public MyListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		indexPosition = -1;
		topPosition = -1;
	}

	public MyListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		indexPosition = -1;
		topPosition = -1;
	}
	
	public void reposicionar(){
		if(indexPosition != -1 && topPosition != -1){
			this.setSelectionFromTop(indexPosition, topPosition);
			myListViewListener.onReposicionar(this, indexPosition, topPosition);
		}
	}	
	

	public int getIndexPosition() {
		return indexPosition;
	}

	public void setIndexPosition(int indexPosition) {
		this.indexPosition = indexPosition;
	}

	public int getTopPosition() {
		return topPosition;
	}

	public void setTopPosition(int topPosition) {
		this.topPosition = topPosition;
	}

	public void setMyListViewListener(MyListViewListener myListViewListener) {
		this.myListViewListener = myListViewListener;
	}	

}
