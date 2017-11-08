package com.example.viewtoanimator;

import android.animation.TypeEvaluator;
import android.util.Log;

public class ViewTypeEvaluator implements TypeEvaluator<Viewpoint>{

	public Viewpoint evaluate(float fraction, Viewpoint startValue, Viewpoint endValue) {
		
		float x=0 , y=0 ;
		Log.d("view", "float:"+fraction);
		
		Log.d("view", "startValue:"+startValue.mX);
		Log.d("view", "startValue:"+startValue.mY);
		Log.d("view", "endValue:"+endValue.mX);
		Log.d("view", "endValue:"+endValue.mY);
		/**
		 * move
		 */
		if(endValue.type==Viewpoint.MOVE){
			
			x=endValue.mX;
			y=endValue.mY;
			
		}else if(endValue.type==Viewpoint.LINE){
			
			x= (endValue.mX - startValue.mX)*(1+fraction);
			y= (endValue.mY - startValue.mY)*(1+fraction);
			
		}else if(endValue.type==Viewpoint.CRUVE){
			
			x=startValue.mX*(1-fraction)*(1-fraction)*(1-fraction)+
					3*endValue.c1x*fraction*(1-fraction)*(1-fraction)+
					3*endValue.c2x*fraction*fraction*(1-fraction)+
					endValue.ex*fraction*fraction*fraction;
			
			y=startValue.mY*(1-fraction)*(1-fraction)*(1-fraction)+
					3*endValue.c1y*fraction*(1-fraction)*(1-fraction)+
					3*endValue.c2y*fraction*fraction*(1-fraction)+
					endValue.ey*fraction*fraction*fraction;
		}
		Log.d("view", "x:"+x);
		Log.d("view", "y:"+y);
//		endValue.mX=x;
//		endValue.mY=y;
		
		return Viewpoint.lineTo(x, y);
	}

}
