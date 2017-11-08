package com.example.viewtoanimator;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	private TypeEvaluator evaluator = new ViewTypeEvaluator();


	private View view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		view=findViewById(R.id.imageview);view.setOnClickListener(this);
	}


	public void onClick(View v) {
		
		AnimatorPath path = new AnimatorPath();
		
		path.moveTo(10f, 10f);
//		
//		path.lineTo(100f, 100f);
		
		
		path.curveTo(200f, 200f, 300f, 300f, 500f, 500f);
		path.moveTo(500f, 500f);
		
		path.lineTo(100f, 100f);
		
		ObjectAnimator ani = ObjectAnimator.ofObject(this, "hehe", evaluator, path.getPoints().toArray());
		
		ani.setDuration(5000);
		
		ani.start();
	}
	
	public void setHehe(Viewpoint point){
		
		Log.d("view", "setHehe x:"+point.mX);
		Log.d("view", "setHehe y:"+point.mY);
		
		view.setTranslationX(point.mX);
		view.setTranslationY(point.mY);
	}
	

}
