package com.sentila.mobileproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

public class MovieMap extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap gMap;
    MapFragment mapFrag;
    GroundOverlayOptions videoMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moviemap);
        setTitle("Google 지도 활용 (수정)");

        mapFrag = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        gMap = map;
        gMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.1634, 129.1638), 15));
        gMap.getUiSettings().setZoomControlsEnabled(true);
        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                videoMark = new GroundOverlayOptions().image(
                                BitmapDescriptorFactory
                                        .fromResource(R.drawable.rate_star_small_on))
                        .position(point, 100f, 100f);
                gMap.addGroundOverlay(videoMark);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "위성 지도");
        menu.add(0, 2, 0, "일반 지도");
        SubMenu sMenu = menu.addSubMenu("영화관 바로가기 >>");
        sMenu.add(0, 3, 0, "영화의 전당");
        sMenu.add(0, 4, 0, "장산역 근처 영화관");
        sMenu.add(0, 5, 0, "구서동 근처 영화관");
        sMenu.add(0, 6, 0, "센텀시티 영화관");
        sMenu.add(0, 7, 0, "해운대 영화관");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                gMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case 2:
                gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 3:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        35.158680, 129.164482), 15));
                return true;
            case 4:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        35.227714, 129.157886), 15));
                return true;
            case 5:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        35.184106, 129.083682), 15));
                return true;
            case 6:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        35.168815, 129.130721), 15));
                return true;
            case 7:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        35.161201, 129.161148), 15));
                return true;
        }
        return false;
    }

}
