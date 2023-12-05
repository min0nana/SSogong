package com.min0.ssogong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.min0.ssogong.databinding.ActivityMain1Binding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource

class Map : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding : ActivityMain1Binding
    private lateinit var naverMap:NaverMap
    private lateinit var locationSource : FusedLocationSource
    private val mapView : MapView by lazy { findViewById(R.id.mapView)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val intent = Intent(this, MainActivity::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main1)

        binding.closingbtn.setOnClickListener {
            startActivity(intent)
        }

        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync(this)
    }

    override fun onMapReady(map:NaverMap) {
        naverMap = map

        // 확대 축소
        naverMap.maxZoom = 18.0
        naverMap.minZoom = 10.0

        // 초기 위치 설정
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.5838657,127.0587771))
        naverMap.moveCamera(cameraUpdate)

        val uiSetting = naverMap.uiSettings
        uiSetting.isLocationButtonEnabled=true

        locationSource = FusedLocationSource(this ,LOCATION_PERMISSION_REQUEST_CODE )
        naverMap.locationSource = locationSource

        // 마커 표시
        val marker = Marker()
        marker.position = LatLng(37.5855209,127.0549923)
        marker.map = naverMap
        marker.icon = OverlayImage.fromResource(R.drawable.baseline_umbrella_24)
    }

    // 현재 위치
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE){
            return
        }
        if (locationSource.onRequestPermissionsResult(requestCode,permissions,grantResults)){
            if (!locationSource.isActivated){
                naverMap.locationTrackingMode = LocationTrackingMode.None
            }
            return
        }
    }

   companion object{
       private const val LOCATION_PERMISSION_REQUEST_CODE = 1004

   }

    // 생명 주기
    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

}
