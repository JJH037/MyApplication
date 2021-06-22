package com.example.myapplication;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {


    public static class Pair {
        private double x;
        private double y;

        Pair(double x, double y) {
            this.x = x;            this.y = y;
        }

        public double getX(){
            return x;
        }

        public double getY(){
            return y;
        }
    }


    public static class Pair2 {
        private double x1;
        private double y1;
        private String z1;

        Pair2(double x1, double y1) {
            this.x1 = x1;
            this.y1 = y1;
            this.z1 = z1;
        }


    }

    public static List<dij.Edge2>[] adj2 = new ArrayList[42];
    static public Stack<Pair> Mapstack = new Stack<>();

    public static String startpoint = "제6공학관";
    public static String destpoint = "제1물리관";

    public static double startx = 35.23047;//시작위도
    public static double starty = 129.08252;//시작경도


    public static double destx = 35.23079;//도착위도
    public static double desty = 129.08154;//도착경도


    static public String mapsname[][];

    static public double mapsx[][];
    static public double mapsy[][];






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            PackageInfo info=getPackageManager().getPackageInfo("com.example.myapplication", PackageManager.GET_SIGNATURES);
            for(Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(35.2334, 129.0784), 2, true);





        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("Default Marker");
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(35.2334, 129.0784));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView.addPOIItem(marker);


//
        MapPolyline polyline = new MapPolyline();
        polyline.setTag(1000);

        polyline.setLineColor(Color.argb(128, 255, 51, 0)); // Polyline 컬러 지정.


        Stack<Integer> Mapstack2 = new Stack<>();





        Button imageButton = (Button) findViewById(R.id.btn1);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });











        //


        Button imageButton2 = (Button) findViewById(R.id.btn2);
        imageButton2.setOnClickListener(new View.OnClickListener() {

                                            @Override
                                            public void onClick(View view) {
                                                System.out.println("Hello, World.");
                                                // artpoly();
                                                Intent intent = new Intent(getApplicationContext(), startlist.class);
                                                startActivity(intent);

                                            }

                                        }

        );


        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                mapsname[i][j]=" ";
                mapsx[i][j]=0; mapsy[i][j]=0;
            }
        }
        mapsname[1][1]="제6공학관"; mapsx[1][1]=35.23046; mapsy[1][1]=129.08254;
        mapsname[2][1]="토조실험실";mapsx[2][1]=35.23083; mapsy[2][1]=129.08155;
        mapsname[3][1]="건설관";mapsx[3][1]=35.23100; mapsy[3][1]=129.08036;
        mapsname[4][1]="장학관";mapsx[4][1]=35.23152; mapsy[4][1]=129.07844;
        mapsname[5][1]="약학연구동";mapsx[5][1]=35.23213; mapsy[5][1]=129.07756;
        mapsname[6][1]="조형관";mapsx[6][1]=35.23242; mapsy[6][1]=129.07625;
        mapsname[7][1]="제2사범관";mapsx[7][1]=35.23272; mapsy[7][1]=129.07528;

        mapsname[1][2]="제3공학관";mapsx[1][2]=35.23126; mapsy[1][2]=129.08282;
        mapsname[2][2]="인문관";mapsx[2][2]=35.23168; mapsy[2][2]=129.08148;
        mapsname[3][2]="넉터";mapsx[3][2]=35.23166; mapsy[3][2]=129.08070;
        mapsname[4][2]="인덕관";mapsx[4][2]=35.23297; mapsy[4][2]=129.07905;
        mapsname[5][2]=" ";mapsx[5][2]=35.23314; mapsy[5][2]=129.07787;
        mapsname[6][2]="조소실";mapsx[6][2]=35.23363; mapsy[6][2]=129.07638;
        mapsname[7][2]="경암체육관";mapsx[7][2]=35.23374; mapsy[7][2]=129.07542;


        mapsname[2][3]="제11공학관";mapsx[2][3]=35.23311; mapsy[2][3]=129.08213;
        mapsname[3][3]="자연과학관";mapsx[3][3]=35.23342; mapsy[3][3]=129.08084;
        mapsname[4][3]="지구관";mapsx[4][3]=35.23378; mapsy[4][3]=129.07904;
        mapsname[5][3]="정보전산원";mapsx[5][3]=35.23398; mapsy[5][3]=129.07797;
        mapsname[6][3]="음악관";mapsx[6][3]=35.23425; mapsy[6][3]=129.07654;
        mapsname[7][3]="대운동장";mapsx[7][3]=35.23458; mapsy[7][3]=129.07570;



        mapsname[2][4]="기계기술연구동";mapsx[2][4]=35.23214; mapsy[2][4]=129.08313;
        mapsname[3][4]="제2물리관";mapsx[3][4]=35.23418; mapsy[2][4]=129.08110;
        mapsname[4][4]="테니스장";mapsx[4][4]=35.23482; mapsy[2][4]=129.07939;
        mapsname[5][4]="화학관";
        mapsname[6][4]="학생회관";
        mapsname[7][4]="기숙사";

        mapsname[2][5]="북문";
        mapsname[3][5]="정보화교육원";
        mapsname[4][5]="경제통상관";
        mapsname[5][5]="제2법학관";


        mapsname[3][6]="자유관";
        mapsname[4][6]="경영관";
        mapsname[5][6]="법학관";

        int startpointx =0;
        int startpointy =0;


        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if( mapsname[i][j]==startpoint){
                    startx = mapsx[i][j];
                    starty = mapsy[i][j];


                    startpointx =i;
                    startpointy =j;


                }
                else if( mapsname[i][j]==destpoint){
                    destx = mapsx[i][j];
                    desty = mapsy[i][j];




                }
            }
        }


        polyline.addPoint(MapPoint.mapPointWithGeoCoord(startx, starty));


        while(startx != destx && starty!=desty) {
            if (startx - destx < 0 && starty - desty < 0) {
                startpointx++;
                startpointy++;

                startx = mapsx[startpointx][startpointy];
                starty = mapsy[startpointx][startpointy];


            } else if (startx - destx > 0 && starty - desty < 0) {

                startx = mapsx[startpointx][startpointy];
                starty = mapsy[startpointx][startpointy];
            } else if (startx - destx < 0 && starty - desty > 0) {

                startx = mapsx[startpointx][startpointy];
                starty = mapsy[startpointx][startpointy];
            } else if (startx - destx > 0 && starty - desty > 0) {

                startx = mapsx[startpointx][startpointy];
                starty = mapsy[startpointx][startpointy];
            }
        }

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(destx, desty));


        mapView.addPolyline(polyline);

        // 지도뷰의 중심좌표와 줌레벨을 Polyline이 모두 나오도록 조정.
        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
        int padding = 100; // px
        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding));


        while (!Mapstack.empty()) {
            System.out.println("Hello, World~!!bbbb.");

            // polyline.addPoint(MapPoint.mapPointWithGeoCoord(35.23054, 129.08251));
            // polyline.addPoint(MapPoint.mapPointWithGeoCoord(35.23125, 129.08283));
            // polyline.addPoint(MapPoint.mapPointWithGeoCoord(35.23163, 129.08149));
            //  polyline.addPoint(MapPoint.mapPointWithGeoCoord(35.23310, 129.08214));
            //  polyline.addPoint(MapPoint.mapPointWithGeoCoord(Mapstack.peek().x, Mapstack.peek().y));
            Mapstack.pop();
        }








    }

}
