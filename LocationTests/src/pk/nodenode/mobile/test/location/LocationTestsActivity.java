package pk.nodenode.mobile.test.location;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LocationTestsActivity extends Activity  {

	Location currentLocation ;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


		LocationListener mlocListener = new MyLocationListener();

		mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
		
		TextView tv = new TextView(this);
		
		Criteria crit = new Criteria();
		
		
		tv.setText("Hello, Android"+ mlocManager.getBestProvider(crit, true));
		
		setContentView(tv);

	}


	public class MyLocationListener implements LocationListener {
		@Override

		public void onLocationChanged(Location loc)

		{

			
			loc.getLatitude();

			loc.getLongitude();

			String Text = "My current location is: " + "Latitud = " + loc.getLatitude() + "Longitud = " + loc.getLongitude();


			Toast.makeText( getApplicationContext(),

					Text,

					Toast.LENGTH_SHORT).show();

		}


		@Override

		public void onProviderDisabled(String provider)

		{

			Toast.makeText( getApplicationContext(),"Gps Disabled",	Toast.LENGTH_SHORT ).show();

		}


		@Override

		public void onProviderEnabled(String provider)

		{

			Toast.makeText( getApplicationContext(),"Gps Enabled", Toast.LENGTH_SHORT).show();

		}


		@Override

		public void onStatusChanged(String provider, int status, Bundle extras)

		{


		}

	}

}
