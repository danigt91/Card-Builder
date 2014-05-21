package io.github.danigt91.cardbuilder.view;

import io.github.danigt91.cardbuilder.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.widget.Button;

public class MyButton extends Button {
	
	public MyButton(Context context) {
		super(context);
		this.setBackgroundResource(R.drawable.button_selector);
		try {
		    XmlResourceParser parser = getResources().getXml(R.color.button_selector_color);
		    ColorStateList colors = ColorStateList.createFromXml(getResources(), parser);
		    this.setTextColor(colors);
		} catch (Exception e) {
		    // handle exceptions
		}
	}

	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setBackgroundResource(R.drawable.button_selector);
		try {
		    XmlResourceParser parser = getResources().getXml(R.color.button_selector_color);
		    ColorStateList colors = ColorStateList.createFromXml(getResources(), parser);
		    this.setTextColor(colors);
		} catch (Exception e) {
		    // handle exceptions
		}
	}

	public MyButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.setBackgroundResource(R.drawable.button_selector);
		try {
		    XmlResourceParser parser = getResources().getXml(R.color.button_selector_color);
		    ColorStateList colors = ColorStateList.createFromXml(getResources(), parser);
		    this.setTextColor(colors);
		} catch (Exception e) {
		    // handle exceptions
		}
	}	

}
